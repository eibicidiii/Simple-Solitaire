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

package com.patience.solitaire.handler;

import android.os.Handler;
import android.os.Message;

import com.patience.solitaire.ui.GameManager;

import static com.patience.solitaire.SharedData.*;

/**
 * Handler to show the menu after the win animation
 */

public class HandlerAfterWon extends Handler {

    GameManager gm;
    int phase = 2;

    public HandlerAfterWon(GameManager gm) {
        this.gm = gm;
    }

    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        if (animate.cardIsAnimating() || gm.isActivityPaused())
            animate.handlerAfterWon.sendEmptyMessageDelayed(0, 100);
        else {
            if (phase == 2) {
                animate.wonAnimationPhase2();
                phase = 3;
                animate.handlerAfterWon.sendEmptyMessageDelayed(0, 100);
            } else {
                phase = 2;
                gm.showWonDialog();
            }
        }
    }
}
