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

package com.patience.solitaire.dialogs;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import com.patience.solitaire.R;
import com.patience.solitaire.classes.DynamicListView;
import com.patience.solitaire.classes.StableArrayAdapter;

import static com.patience.solitaire.SharedData.*;

/**
 * dialog for changing the rows shown in the menu. It uses different values for portrait and landscape
 */

public class DialogPreferenceMenuOrder extends DialogPreference{

    private ArrayList<String> gameList;
    StableArrayAdapter adapter;

    public DialogPreferenceMenuOrder(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDialogLayoutResource(R.layout.dialog_settings_menu_order);
        setDialogIcon(null);
    }

    @Override
    protected void onBindDialogView(View view) {
        gameList = new ArrayList<>();
        ArrayList<String> sortedGameList = lg.getOrderedGameNameList(getContext().getResources());

        for (String game: sortedGameList){
            gameList.add(game);
        }

        adapter = new StableArrayAdapter(getContext(), R.layout.text_view, gameList);
        DynamicListView listView = (DynamicListView) view.findViewById(R.id.listview);

        listView.setList(gameList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        super.onBindDialogView(view);
    }


    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);

        if (positiveResult) {
            ArrayList<Integer> list = new ArrayList<>();
            String[] defaultList = lg.getDefaultGameNameList(getContext().getResources());

            for (String game: defaultList) {
                list.add(gameList.indexOf(game));
            }

            prefs.saveMenuOrderList(list);
        }
    }
}
