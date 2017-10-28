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

package com.patience.solitaire;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import java.util.ArrayList;
import java.util.Locale;

import com.patience.solitaire.handler.HandlerRecordListUndo;
import com.patience.solitaire.helper.BackgroundMusic;
import com.patience.solitaire.classes.Card;
import com.patience.solitaire.classes.Stack;
import com.patience.solitaire.games.Game;
import com.patience.solitaire.handler.HandlerTestAfterMove;
import com.patience.solitaire.handler.HandlerTestIfWon;
import com.patience.solitaire.helper.Animate;
import com.patience.solitaire.helper.AutoComplete;
import com.patience.solitaire.helper.Bitmaps;
import com.patience.solitaire.helper.CardHighlight;
import com.patience.solitaire.helper.GameLogic;
import com.patience.solitaire.helper.Hint;
import com.patience.solitaire.helper.MovingCards;
import com.patience.solitaire.helper.Preferences;
import com.patience.solitaire.helper.RecordList;
import com.patience.solitaire.helper.Scores;
import com.patience.solitaire.helper.Sounds;
import com.patience.solitaire.helper.Timer;

/**
 * static data which is shared across the whole project, i like this more than passing stuff around
 */

public class SharedData {

    public final static int OPTION_UNDO = 1, OPTION_NO_RECORD = 2, OPTION_REVERSED_RECORD = 3;

    //Strings
    public static String GAME = "game";
    public static String RESTART_DIALOG = "dialogRestart";
    public static String WON_DIALOG = "dialogWon";

    public static Card[] cards;
    public static Stack[] stacks;

    public static Scores scores;

    public static GameLogic gameLogic;
    public static Animate animate;

    public static AutoComplete autoComplete;
    public static Timer timer;
    public static Sounds sounds;
    public static Hint hint = new Hint();
    public static MovingCards movingCards = new MovingCards();
    public static RecordList recordList = new RecordList();
    public static LoadGame lg = new LoadGame();
    public static Bitmaps bitmaps = new Bitmaps();
    public static CardHighlight cardHighlight = new CardHighlight();
    public static Preferences prefs;

    public static Game currentGame;

    public static HandlerTestAfterMove handlerTestAfterMove = new HandlerTestAfterMove();
    public static HandlerTestIfWon handlerTestIfWon = new HandlerTestIfWon();
    public static HandlerRecordListUndo handlerRecordListUndo = new HandlerRecordListUndo();
    public static BackgroundMusic backgroundSound = new BackgroundMusic();
    public static int activityCounter = 0;

    /**
     * Reload the needed data. Because if the android device runs out of memory, the app gets
     * killed. If the user restarts the app and it loads  for example the settings activity, all
     * the strings and the shared preferences need to be reinitialized.
     *
     * @param context Used to get the resources
     */
    public static void reinitializeData(Context context) {
        //Bitmaps
        if (!bitmaps.checkResources()) {
            bitmaps.setResources(context.getResources());
        }

        if (lg.getGameCount()==0){
            lg.loadAllGames();
        }

        //SharedPrefs
        if (prefs == null){
            prefs = new Preferences(context);
        }
    }

    /**
     * Moves a card to a stack.
     *
     * @param card        The card to move
     * @param destination The destination of the movement
     */
    public static void moveToStack(Card card, Stack destination) {
        moveToStack(card, destination, 0);
    }

    /**
     * Moves a card to a stack. but with an additional option
     *
     * @param card        The card to move
     * @param destination The destination of the movement
     * @param option      The option to apply
     */
    public static void moveToStack(Card card, Stack destination, int option) {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(card);

        ArrayList<Stack> destinations = new ArrayList<>();
        destinations.add(destination);

        moveToStack(cards, destinations, option);
    }

    /**
     * Moves multiple cards to a destination
     *
     * @param cards       The cards to move
     * @param destination The destination of the movement
     */
    public static void moveToStack(ArrayList<Card> cards, Stack destination) {
        moveToStack(cards, destination, 0);
    }

    /**
     * Moves multiple cards to a destination, with an additional option
     *
     * @param cards       The cards to move
     * @param destination The destination of the movement
     * @param option      The option to apply
     */
    public static void moveToStack(ArrayList<Card> cards, Stack destination, int option) {
        ArrayList<Stack> destinations = new ArrayList<>();

        for (int i = 0; i < cards.size(); i++)
            destinations.add(destination);

        moveToStack(cards, destinations, option);
    }

    public static void moveToStack(ArrayList<Card> cards, ArrayList<Stack> destinations) {
        moveToStack(cards, destinations, 0);
    }

    /**
     * Moves multiple cards to multiple destinations, with an additional option
     * <p>
     * moves a card to a stack by doing this:
     * - change the score according to the cards
     * - add the cards to the record list
     * - move every card one by one
     * - bring the moving cards to front
     * - and start handlers to call some methods
     *
     * @param cards        The cards to move
     * @param destinations The destinations of the movements
     * @param option       The option to apply
     */
    public static void moveToStack(ArrayList<Card> cards, ArrayList<Stack> destinations, int option) {

        if (option == OPTION_UNDO) {
            scores.undo(cards, destinations);
        } else if (option == 0) {
            scores.move(cards, destinations);
            recordList.add(cards);
        } else if (option == OPTION_REVERSED_RECORD) {
            //reverse the cards and add the reversed list to the record
            ArrayList<Card> cardsReversed = new ArrayList<>();

            for (int i = 0; i < cards.size(); i++) {
                cardsReversed.add(cards.get(cards.size() - 1 - i));
            }

            recordList.add(cardsReversed);
            scores.move(cards, destinations);
        } else if (option == OPTION_NO_RECORD){
            //nothing
        }

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getStack() == destinations.get(i)) {                                     //this means to flip a card
                cards.get(i).flip();
            }
        }

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getStack() != destinations.get(i)) {
                cards.get(i).removeFromCurrentStack();
                destinations.get(i).addCard(cards.get(i));
            }
        }

        for (Card card : cards) {
            card.view.bringToFront();
        }

        //following stuff in handlers, because they should wait until possible card movements are over.
        if (option == 0) {
            handlerTestAfterMove.sendEmptyMessageDelayed(0, 100);
            handlerTestIfWon.sendEmptyMessageDelayed(0, 200);
        }
    }

    /**
     * Little method I use to test if my code reaches some point
     *
     * @param text The text to show
     */
    public static void logText(String text) {
        Log.e("hey", text);
    }

    public static int min(int value1, int value2) {
        return value1 < value2 ? value1 : value2;
    }

    public static float min(float value1, float value2) {
        return value1 < value2 ? value1 : value2;
    }

    public static int max(int value1, int value2) {
        return value1 > value2 ? value1 : value2;
    }

    public static float max(float value1, float value2) {
        return value1 > value2 ? value1 : value2;
    }

    public static boolean leftHandedModeEnabled() {
        return prefs.getSavedLeftHandedMode();
    }

    public static boolean isXLargeTablet(Context context) {
        return prefs.getSavedForcedTabletLayout() || ((context.getResources().getConfiguration().screenLayout
                        & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE);
    }

    public static String stringFormat(String text){
        return String.format(Locale.getDefault(),"%s", text);
    }

    public static int max(ArrayList<Integer> list ){
        int max = 0;

        for (int value : list){
            if (value > max){
                max = value;
            }
        }

        return max;
    }

    public static int min(ArrayList<Integer> list ){
        int min = list.get(0);

        for (int value : list){
            if (value < min){
                min = value;
            }
        }

        return min;
    }
}