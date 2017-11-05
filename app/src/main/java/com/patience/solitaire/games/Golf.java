/*
 * Copyright (C) 2016  Tobias Bielefeld
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * If you want to contact me, send me an e-mail at tobias.bielefeld@gmail.com
 */

package com.patience.solitaire.games;

import android.content.Context;
import android.content.res.Resources;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import com.patience.solitaire.R;
import com.patience.solitaire.classes.Card;
import com.patience.solitaire.classes.CardAndStack;
import com.patience.solitaire.classes.Stack;
import com.patience.solitaire.helper.RecordList;
import com.patience.solitaire.ui.GameManager;

import static com.patience.solitaire.SharedData.*;

/**
 * Golf Game! Very easy but a lot of dealt games can't be won.
 * It has 7 tableau stacks, one discard and one main stack
 * The discard stack is special: It's stapling direction is to the left and not to the bottom like
 * the tableau stacks
 */

public class Golf extends Game {

    public String getLogName() {
        return "Golf";
    }

    static int MAX_SAVED_RUN_RECORDS = RecordList.MAX_RECORDS;

    int runCounter; //to count how many cards are moved in one "run"
    ArrayList<Integer> savedRunRecords = new ArrayList<>();                                         //need to save the scores of recorded movements, because the class RecordList can't do that

    public Golf() {
        setNumberOfDecks(1);
        setNumberOfStacks(9);
        setMainStackIDs(8);
        setDiscardStackIDs(7);
        setLastTableauID(6);
        setDirections(1, 1, 1, 1, 1, 1, 1, 3);
        setSingleTapeEnabled(true);
    }

    @Override
    public void reset(GameManager gm) {
        super.reset(gm);
        runCounter = 0;
    }

    @Override
    public void save() {
        prefs.saveRunCounter(runCounter);
    }

    @Override
    public void load() {
        runCounter = prefs.getSavedRunCounter();

    }

    public void setStacks(RelativeLayout layoutGame, boolean isLandscape, Context context) {
        //initialize the dimensions
        setUpCardWidth(layoutGame, isLandscape, 8, 9);

        //order stacks on the screen
        int spacing = setUpHorizontalSpacing(layoutGame, 7, 8);
        int startPos = layoutGame.getWidth() / 2 - 3 * spacing - (int) (3.5 * Card.width);
        //main stack
        stacks[8].setX(layoutGame.getWidth() - startPos - Card.width);
        stacks[8].view.setY((isLandscape ? Card.width / 4 : Card.width / 2) + 1);
        //discard stack
        stacks[7].setX(layoutGame.getWidth() - 2 * startPos - 2 * Card.width);
        stacks[7].setY(stacks[8].getY());
        //tableau stacks
        for (int i = 0; i < 7; i++) {
            stacks[i].setX(startPos + spacing * i + Card.width * i);
            stacks[i].setY(stacks[8].getY() + Card.height + (isLandscape ? Card.width / 4 : Card.width / 2) + 1);
        }
    }

    public boolean winTest() {
        //game is won if tableau is empty
        for (int i = 0; i <= getLastTableauId(); i++) {
            if (!stacks[i].isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public void dealCards() {

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                moveToStack(getMainStack().getTopCard(), stacks[i], OPTION_NO_RECORD);
                stacks[i].getTopCard().flipUp();
            }
        }

        moveToStack(getMainStack().getTopCard(), getDiscardStack(), OPTION_NO_RECORD);
    }

    public boolean cardTest(Stack stack, Card card) {
        /*
         * only allowed stack is the discard stack.
         * then check the settings: if cyclic moves are set to true, check if the cards are an ace and a king, if so return true
         * or the cards values difference is 1 or -1
         */
        return stack == getDiscardStack() && ((prefs.getSavedGoldCyclic()
                && (card.getValue() == 13 && stack.getTopCard().getValue() == 1 || card.getValue() == 1 && stack.getTopCard().getValue() == 13))
                || (card.getValue() == stack.getTopCard().getValue() + 1 || card.getValue() == stack.getTopCard().getValue() - 1));
    }

    public boolean addCardToMovementTest(Card card) {
        return card.getStackId() < 7 && card.isTopCard();
    }

    public CardAndStack hintTest() {
        for (int i = 0; i < 7; i++) {
            if (stacks[i].isEmpty()) {
                continue;
            }

            if (!hint.hasVisited(stacks[i].getTopCard()) && stacks[i].getTopCard().test(getDiscardStack())) {
                return new CardAndStack(stacks[i].getTopCard(), getDiscardStack());
            }
        }

        return null;
    }

    @Override
    public Stack doubleTapTest(Card card) {
        return card.test(getDiscardStack()) ? getDiscardStack() : null;
    }

    public int addPointsToScore(ArrayList<Card> cards, int[] originIDs, int[] destinationIDs, boolean isUndoMovement) {
        int points = 0;

        if (destinationIDs[0] == getDiscardStack().getId() && originIDs[0] < 7) {

            if (!isUndoMovement) {
                runCounter++;
                updateLongestRun(runCounter);

                if (savedRunRecords.size() == MAX_SAVED_RUN_RECORDS) {
                    savedRunRecords.remove(0);
                }

                savedRunRecords.add(runCounter * 50);
                points += runCounter * 50;
            } else {
                points += savedRunRecords.get(savedRunRecords.size() - 1);                            //get last entry
                savedRunRecords.remove(savedRunRecords.size() - 1);                                   //and remove it

                if (runCounter > 0) {
                    runCounter--;
                }
            }
        }

        return points;
    }

    public int onMainStackTouch() {
        if (getMainStack().getSize() > 0) {
            moveToStack(getMainStack().getTopCard(), getDiscardStack());
            runCounter = 0;
            return 1;
        }

        return 0;
    }

    @Override
    public String getAdditionalStatisticsData(Resources res) {
        return res.getString(R.string.game_longest_run) + " " + prefs.getSavedLongestRun();
    }

    @Override
    public void deleteAdditionalStatisticsData() {
        prefs.saveLongestRun(0);
    }

    private void updateLongestRun(int currentRunCount) {
        if (currentRunCount > prefs.getSavedLongestRun()) {
            prefs.saveLongestRun(currentRunCount);
        }
    }
}
