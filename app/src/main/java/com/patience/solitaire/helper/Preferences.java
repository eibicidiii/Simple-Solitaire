package com.patience.solitaire.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.patience.solitaire.R;

import static android.content.Context.MODE_PRIVATE;
import static com.patience.solitaire.SharedData.lg;
import static com.patience.solitaire.helper.Scores.MAX_SAVED_SCORES;

/**
 * Handles all the preference stuff
 */

public class Preferences {

    private SharedPreferences savedSharedData;
    private SharedPreferences savedGameData;

    //Strings
    public static String PREF_KEY_NEXT_CARD_VALUES;
    public static String PREF_KEY_HIDE_STATUS_BAR;
    public static String PREF_KEY_LONGEST_RUN;
    public static String PREF_KEY_RUN_COUNTER;
    public static String PREF_KEY_ORDER;
    public static String PREF_KEY_SCORE;
    public static String PREF_KEY_SAVED_SCORES;
    public static String OLD;

    public static String PREF_KEY_VEGAS_OLD_SCORE;
    public static String PREF_KEY_VEGAS_TIME;
    public static String PREF_KEY_GAME_REDEAL_COUNT;
    public static String PREF_KEY_GAME_WON;
    public static String PREF_KEY_GAME_WON_AND_RELOADED;
    public static String PREF_KEY_GAME_NUMBER_OF_WON_GAMES;
    public static String PREF_KEY_GAME_NUMBER_OF_PLAYED_GAMES;
    public static String PREF_KEY_GAME_RANDOM_CARDS;
    public static String PREF_KEY_GAME_FIRST_RUN;
    public static String PREF_KEY_GAME_MOVED_FIRST_CARD;
    public static String PREF_KEY_RECORD_LIST_ENTRY;
    public static String PREF_KEY_RECORD_LIST_ENTRIES_SIZE;
    public static String PREF_KEY_FLIP_CARD;
    public static String PREF_KEY_ORIGIN;
    public static String PREF_KEY_CARD;
    public static String PREF_KEY_CARDS;
    public static String PREF_KEY_STACK;
    public static String PREF_KEY_TIMER_END_TIME;
    public static String PREF_KEY_TIMER_START_TIME;
    public static String PREF_KEY_TIMER_WINNING_TIME;
    public static String PREF_KEY_CARD_DRAWABLES;
    public static String PREF_KEY_CARD_BACKGROUND;
    public static String PREF_KEY_CARD_BACKGROUND_COLOR;
    public static String PREF_KEY_MENU_COLUMNS_PORTRAIT;
    public static String PREF_KEY_MENU_COLUMNS_LANDSCAPE;
    public static String PREF_KEY_CANFIELD_START_CARD_VALUE;
    public static String PREF_KEY_START_WITH_MENU;
    public static String PREF_KEY_YUKON_RULES;
    public static String PREF_KEY_YUKON_RULES_OLD;
    public static String PREF_KEY_KLONDIKE_DRAW;
    public static String PREF_KEY_KLONDIKE_DRAW_OLD;
    public static String PREF_KEY_VEGAS_DRAW;
    public static String PREF_KEY_VEGAS_DRAW_OLD;
    public static String PREF_KEY_GOLF_CYCLIC;
    public static String PREF_KEY_CANFIELD_DRAW;
    public static String PREF_KEY_CANFIELD_DRAW_OLD;
    public static String PREF_KEY_PYRAMID_DIFFICULTY;
    public static String PREF_KEY_SPIDER_DIFFICULTY;
    public static String PREF_KEY_SPIDER_DIFFICULTY_OLD;
    public static String PREF_KEY_LANGUAGE;
    public static String PREF_KEY_CURRENT_GAME;
    public static String PREF_KEY_ORIENTATION;
    public static String PREF_KEY_MENU_GAMES;
    public static String PREF_KEY_4_COLOR_MODE;
    public static String PREF_KEY_LEFT_HANDED_MODE;
    public static String PREF_KEY_MENU_BAR_POS_PORTRAIT;
    public static String PREF_KEY_MENU_BAR_POS_LANDSCAPE;
    public static String PREF_KEY_DOUBLE_TAP_ENABLED;
    public static String PREF_KEY_DOUBLE_TAP_ALL_CARDS;
    public static String PREF_KEY_DOUBLE_TAP_FOUNDATION_FIRST;
    public static String PREF_KEY_TAP_TO_SELECT_ENABLED;
    public static String PREF_KEY_SINGLE_TAP_ENABLE;
    public static String PREF_KEY_BACKGROUND_COLOR_TYPE;
    public static String PREF_KEY_BACKGROUND_COLOR;
    public static String PREF_KEY_BACKGROUND_COLOR_CUSTOM;
    public static String PREF_KEY_MOVEMENT_SPEED;
    public static String PREF_KEY_SOUND_ENABLED;
    public static String PREF_KEY_WIN_SOUND;
    public static String PREF_KEY_BACKGROUND_MUSIC;
    public static String PREF_KEY_BACKGROUND_VOLUME;
    public static String PREF_KEY_PYRAMID_LIMITED_RECYCLES;
    public static String PREF_KEY_FORTYEIGHT_LIMITED_RECYCLES;
    public static String PREF_KEY_PYRAMID_NUMBER_OF_RECYCLES;
    public static String PREF_KEY_FORTYEIGHT_NUMBER_OF_RECYCLES;
    public static String PREF_KEY_KLONDIKE_LIMITED_RECYCLES;
    public static String PREF_KEY_KLONDIKE_NUMBER_OF_RECYCLES;
    public static String PREF_KEY_VEGAS_NUMBER_OF_RECYCLES;
    public static String PREF_KEY_VEGAS_BET_AMOUNT;
    public static String PREF_KEY_VEGAS_BET_AMOUNT_OLD;
    public static String PREF_KEY_MENU_ORDER;
    public static String PREF_KEY_AUTO_START_NEW_GAME;
    public static String PREF_KEY_FORCE_TABLET_LAYOUT;
    public static String PREF_KEY_CALCULATION_ALTERNATIVE;
    public static String PREF_KEY_CALCULATION_ALTERNATIVE_OLD;
    public static String PREF_KEY_HIDE_TIME;
    public static String PREF_KEY_HIDE_SCORE;
    public static String PREF_KEY_VEGAS_MONEY;
    public static String PREF_KEY_VEGAS_MONEY_ENABLED;
    public static String PREF_KEY_VEGAS_RESET_MONEY;
    public static String PREF_KEY_MOD3_AUTO_MOVE;
    public static String PREF_KEY_PYRAMID_AUTO_MOVE;
    public static String DEFAULT_CANFIELD_DRAW;
    public static String DEFAULT_KLONDIKE_DRAW;
    public static String DEFAULT_VEGAS_DRAW;
    public static String DEFAULT_YUKON_RULES;
    public static String DEFAULT_MENU_BAR_POSITION_LANDSCAPE;
    public static String DEFAULT_MENU_BAR_POSITION_PORTRAIT;
    public static String DEFAULT_PYRAMID_DIFFICULTY;
    public static String DEFAULT_SPIDER_DIFFICULTY;
    public static String DEFAULT_LANGUAGE;
    public static String DEFAULT_MENU_COLUMNS_LANDSCAPE;
    public static String DEFAULT_MENU_COLUMNS_PORTRAIT;
    public static String DEFAULT_ORIENTATION;
    public static String DEFAULT_BACKGROUND_COLOR;
    public static String DEFAULT_BACKGROUND_MUSIC;
    public static String DEFAULT_PYRAMID_NUMBER_OF_RECYCLES;
    public static String DEFAULT_FORTYEIGHT_NUMBER_OF_RECYCLES;
    public static String DEFAULT_VEGAS_NUMBER_OF_RECYCLES;
    public static String DEFAULT_KLONDIKE_NUMBER_OF_RECYCLES;
    public static String DEFAULT_WIN_SOUND;
    public static String DEFAULT_MOVEMENT_SPEED;
    public static int DEFAULT_CURRENT_GAME;
    public static int DEFAULT_CARD_BACKGROUND;
    public static int DEFAULT_CARD_BACKGROUND_COLOR;
    public static int DEFAULT_WINNING_TIME;
    public static int DEFAULT_BACKGROUND_COLOR_TYPE;
    public static int DEFAULT_BACKGROUND_VOLUME;
    public static int DEFAULT_BACKGROUND_COLOR_CUSTOM;
    public static int DEFAULT_VEGAS_BET_AMOUNT;
    public static int DEFAULT_VEGAS_MONEY;
    public static boolean DEFAULT_GOLF_CYCLIC;
    public static boolean DEFAULT_LEFT_HANDED_MODE;
    public static boolean DEFAULT_DOUBLE_TAP_ENABLE;
    public static boolean DEFAULT_DOUBLE_TAP_ALL_CARDS;
    public static boolean DEFAULT_DOUBLE_TAP_FOUNDATION_FIRST;
    public static boolean DEFAULT_WON;
    public static boolean DEFAULT_WON_AND_RELOADED;
    public static boolean DEFAULT_FIRST_RUN;
    public static boolean DEFAULT_MOVED_FIRST_CARD;
    public static boolean DEFAULT_4_COLOR_MODE;
    public static boolean DEFAULT_TAP_TO_SELECT_ENABLED;
    public static boolean DEFAULT_SINGLE_TAP_ENABLED;
    public static boolean DEFAULT_SOUND_ENABLED;
    public static boolean DEFAULT_AUTO_START_NEW_GAME;
    public static boolean DEFAULT_FORCE_TABLET_LAYOUT;
    public static boolean DEFAULT_HIDE_TIME;
    public static boolean DEFAULT_HIDE_SCORE;
    public static boolean DEFAULT_VEGAS_MONEY_ENABLED;
    public static boolean DEFAULT_VEGAS_RESET_MONEY;

    public static boolean DEFAULT_PYRAMID_LIMITED_RECYCLES;
    public static boolean DEFAULT_FORTYEIGHT_LIMITED_RECYCLES;
    public static boolean DEFAULT_KLONDIKE_LIMITED_RECYCLES;
    public static boolean DEFAULT_CALCULATION_ALTERNATIVE;
    public static boolean DEFAULT_MOD3_AUTO_MOVE;
    public static boolean DEFAULT_PYRAMID_AUTO_MOVE;

    public Preferences(Context context){
        loadStrings(context.getResources());

        savedSharedData = PreferenceManager.getDefaultSharedPreferences(context);
        setGamePreferences(context);
    }

    public void setGamePreferences(Context context){
        savedGameData = context.getSharedPreferences(lg.getSharedPrefName(), MODE_PRIVATE);
    }

    public void registerListener(SharedPreferences.OnSharedPreferenceChangeListener listener){
        savedSharedData.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterListener(SharedPreferences.OnSharedPreferenceChangeListener listener){
        savedSharedData.unregisterOnSharedPreferenceChangeListener(listener);
    }

    /**
     * Load the static strings, so i can use them in every file instead of writing the string itself,
     * which would be susceptible for errors. TODO manage this in a better way.
     *
     * @param res Used to load the strings
     */
    private void loadStrings(Resources res) {

        OLD = "_old";

        PREF_KEY_VEGAS_TIME = "pref_key_vegas_time";
        PREF_KEY_VEGAS_OLD_SCORE = "pref_key_vegas_old_score";
        PREF_KEY_ORDER = "order";
        PREF_KEY_LONGEST_RUN = "longest_run";
        PREF_KEY_RUN_COUNTER = "run_counter";
        PREF_KEY_NEXT_CARD_VALUES = "pref_key_next_card_values";
        PREF_KEY_START_WITH_MENU = res.getString(R.string.pref_key_start_menu);
        PREF_KEY_HIDE_STATUS_BAR = res.getString(R.string.pref_key_hide_status_bar);
        PREF_KEY_YUKON_RULES = res.getString(R.string.pref_key_yukon_rules);
        PREF_KEY_KLONDIKE_DRAW = res.getString(R.string.pref_key_klondike_draw);
        PREF_KEY_VEGAS_DRAW = res.getString(R.string.pref_key_vegas_draw);
        PREF_KEY_CANFIELD_DRAW = res.getString(R.string.pref_key_canfield_draw);
        PREF_KEY_YUKON_RULES_OLD = PREF_KEY_YUKON_RULES + OLD;
        PREF_KEY_KLONDIKE_DRAW_OLD = PREF_KEY_KLONDIKE_DRAW + OLD;
        PREF_KEY_VEGAS_DRAW_OLD = PREF_KEY_VEGAS_DRAW + OLD;
        PREF_KEY_CANFIELD_DRAW_OLD = PREF_KEY_CANFIELD_DRAW + OLD;
        PREF_KEY_GOLF_CYCLIC = res.getString(R.string.pref_key_golf_cyclic);
        PREF_KEY_PYRAMID_DIFFICULTY = res.getString(R.string.pref_key_pyramid_difficulty);
        PREF_KEY_SPIDER_DIFFICULTY = res.getString(R.string.pref_key_spider_difficulty);
        PREF_KEY_SPIDER_DIFFICULTY_OLD = PREF_KEY_SPIDER_DIFFICULTY + OLD;
        PREF_KEY_LANGUAGE = res.getString(R.string.pref_key_language);
        PREF_KEY_CURRENT_GAME = res.getString(R.string.pref_key_current_game);
        PREF_KEY_MENU_GAMES = res.getString(R.string.pref_key_menu_games);
        PREF_KEY_ORIENTATION = res.getString(R.string.pref_key_orientation);
        PREF_KEY_4_COLOR_MODE = res.getString(R.string.pref_key_4_color_mode);
        PREF_KEY_LEFT_HANDED_MODE = res.getString(R.string.pref_key_left_handed_mode);
        PREF_KEY_MENU_BAR_POS_PORTRAIT = res.getString(R.string.pref_key_menu_bar_position_portrait);
        PREF_KEY_MENU_BAR_POS_LANDSCAPE = res.getString(R.string.pref_key_menu_bar_position_landscape);
        PREF_KEY_DOUBLE_TAP_ENABLED = res.getString(R.string.pref_key_double_tap_enable);
        PREF_KEY_DOUBLE_TAP_ALL_CARDS = res.getString(R.string.pref_key_double_tap_all_cards);
        PREF_KEY_DOUBLE_TAP_FOUNDATION_FIRST = res.getString(R.string.pref_key_double_tap_foundation_first);
        PREF_KEY_TAP_TO_SELECT_ENABLED = res.getString(R.string.pref_key_tap_to_select_enable);
        PREF_KEY_SINGLE_TAP_ENABLE = res.getString(R.string.pref_key_single_tap_enable);
        PREF_KEY_BACKGROUND_COLOR_TYPE = res.getString(R.string.pref_key_background_color_type);
        PREF_KEY_BACKGROUND_COLOR = res.getString(R.string.pref_key_background_color);
        PREF_KEY_BACKGROUND_COLOR_CUSTOM = res.getString(R.string.pref_key_background_color_custom);
        PREF_KEY_MOVEMENT_SPEED = res.getString(R.string.pref_key_movement_speed);
        PREF_KEY_SOUND_ENABLED = res.getString(R.string.pref_key_sound_enabled);
        PREF_KEY_WIN_SOUND = res.getString(R.string.pref_key_win_sound);
        PREF_KEY_BACKGROUND_MUSIC = res.getString(R.string.pref_key_background_music);
        PREF_KEY_BACKGROUND_VOLUME = res.getString(R.string.pref_key_background_volume);
        PREF_KEY_PYRAMID_LIMITED_RECYCLES = res.getString(R.string.pref_key_pyramid_limit_recycles);
        PREF_KEY_FORTYEIGHT_LIMITED_RECYCLES = res.getString(R.string.pref_key_fortyeight_limit_recycles);
        PREF_KEY_PYRAMID_NUMBER_OF_RECYCLES = res.getString(R.string.pref_key_pyramid_number_of_recycles);
        PREF_KEY_FORTYEIGHT_NUMBER_OF_RECYCLES = res.getString(R.string.pref_key_fortyeight_number_of_recycles);
        PREF_KEY_VEGAS_NUMBER_OF_RECYCLES = res.getString(R.string.pref_key_vegas_number_of_recycles);
        PREF_KEY_VEGAS_BET_AMOUNT = res.getString(R.string.pref_key_vegas_bet_amount);
        PREF_KEY_MENU_ORDER = res.getString(R.string.pref_key_menu_order);
        PREF_KEY_VEGAS_BET_AMOUNT_OLD = PREF_KEY_VEGAS_BET_AMOUNT + OLD;
        PREF_KEY_AUTO_START_NEW_GAME = res.getString(R.string.pref_key_auto_start_new_game);
        PREF_KEY_FORCE_TABLET_LAYOUT = res.getString(R.string.pref_key_force_tablet_layout);
        PREF_KEY_KLONDIKE_LIMITED_RECYCLES = res.getString(R.string.pref_key_klondike_limit_recycles);
        PREF_KEY_KLONDIKE_NUMBER_OF_RECYCLES = res.getString(R.string.pref_key_klondike_number_of_recycles);
        PREF_KEY_CALCULATION_ALTERNATIVE = res.getString(R.string.pref_key_calculation_alternative);
        PREF_KEY_CALCULATION_ALTERNATIVE_OLD = PREF_KEY_CALCULATION_ALTERNATIVE + OLD;
        PREF_KEY_HIDE_TIME = res.getString(R.string.pref_key_hide_time);
        PREF_KEY_HIDE_SCORE = res.getString(R.string.pref_key_hide_score);
        PREF_KEY_VEGAS_MONEY = res.getString(R.string.pref_key_vegas_money);
        PREF_KEY_VEGAS_MONEY_ENABLED = res.getString(R.string.pref_key_vegas_money_enabled);
        PREF_KEY_VEGAS_RESET_MONEY = res.getString(R.string.pref_key_vegas_reset_money);
        PREF_KEY_MOD3_AUTO_MOVE = res.getString(R.string.pref_key_mod3_auto_move);
        PREF_KEY_PYRAMID_AUTO_MOVE = res.getString(R.string.pref_key_pyramid_auto_move);

        PREF_KEY_GAME_REDEAL_COUNT = res.getString(R.string.game_recycle_count);
        PREF_KEY_GAME_WON = res.getString(R.string.game_won);
        PREF_KEY_GAME_WON_AND_RELOADED = res.getString(R.string.game_won_and_reloaded);
        PREF_KEY_GAME_NUMBER_OF_WON_GAMES = res.getString(R.string.game_number_of_won_games);
        PREF_KEY_GAME_NUMBER_OF_PLAYED_GAMES = res.getString(R.string.game_number_of_played_games);
        PREF_KEY_GAME_RANDOM_CARDS = res.getString(R.string.game_random_cards);
        PREF_KEY_GAME_FIRST_RUN = res.getString(R.string.game_first_run);
        PREF_KEY_GAME_MOVED_FIRST_CARD = res.getString(R.string.game_moved_first_card);

        PREF_KEY_CANFIELD_START_CARD_VALUE = res.getString(R.string.canfield_start_value);
        PREF_KEY_SCORE = res.getString(R.string.score);
        PREF_KEY_SAVED_SCORES = res.getString(R.string.saved_scores);

        PREF_KEY_RECORD_LIST_ENTRY = res.getString(R.string.record_list_entry);
        PREF_KEY_RECORD_LIST_ENTRIES_SIZE = res.getString(R.string.record_list_entries_size);
        PREF_KEY_FLIP_CARD = res.getString(R.string.flip_card);
        PREF_KEY_ORIGIN = res.getString(R.string.origin);
        PREF_KEY_CARD = res.getString(R.string.card);
        PREF_KEY_CARDS = res.getString(R.string.cards);
        PREF_KEY_STACK = res.getString(R.string.stack);

        PREF_KEY_TIMER_END_TIME = res.getString(R.string.saved_current_time);
        PREF_KEY_TIMER_START_TIME = res.getString(R.string.saved_start_time);
        PREF_KEY_TIMER_WINNING_TIME = res.getString(R.string.saved_shown_time);

        PREF_KEY_CARD_DRAWABLES = res.getString(R.string.pref_key_card_drawables);
        PREF_KEY_CARD_BACKGROUND = res.getString(R.string.pref_key_cards_background);
        PREF_KEY_CARD_BACKGROUND_COLOR = res.getString(R.string.pref_key_cards_background_color);
        PREF_KEY_MENU_COLUMNS_PORTRAIT = res.getString(R.string.pref_key_menu_columns_portrait);
        PREF_KEY_MENU_COLUMNS_LANDSCAPE = res.getString(R.string.pref_key_menu_columns_landscape);//*/

        DEFAULT_PYRAMID_DIFFICULTY = res.getStringArray(R.array.pref_pyramid_difficulty_values)[0];
        DEFAULT_LANGUAGE = res.getStringArray(R.array.pref_language_values)[0];
        DEFAULT_SPIDER_DIFFICULTY = res.getStringArray(R.array.pref_spider_difficulty_values)[0];
        DEFAULT_ORIENTATION = res.getStringArray(R.array.pref_orientation_values)[0];
        DEFAULT_DOUBLE_TAP_ALL_CARDS = res.getBoolean(R.bool.default_double_tap_all_cards);
        DEFAULT_DOUBLE_TAP_ENABLE = res.getBoolean(R.bool.default_double_tap_enable);
        DEFAULT_DOUBLE_TAP_FOUNDATION_FIRST = res.getBoolean(R.bool.default_double_tap_foundation_first);
        DEFAULT_LEFT_HANDED_MODE = res.getBoolean(R.bool.default_left_handed_mode);
        DEFAULT_GOLF_CYCLIC = res.getBoolean(R.bool.default_golf_cyclic);
        DEFAULT_TAP_TO_SELECT_ENABLED = res.getBoolean(R.bool.default_tap_to_select_enable);
        DEFAULT_SINGLE_TAP_ENABLED = res.getBoolean(R.bool.default_single_tap_enable);
        DEFAULT_AUTO_START_NEW_GAME = res.getBoolean(R.bool.default_auto_start_new_game);
        DEFAULT_KLONDIKE_LIMITED_RECYCLES = res.getBoolean(R.bool.default_klondike_limited_recycles);
        DEFAULT_CALCULATION_ALTERNATIVE = res.getBoolean(R.bool.default_calculation_alternative);
        DEFAULT_HIDE_TIME = res.getBoolean(R.bool.default_hide_time);
        DEFAULT_HIDE_SCORE = res.getBoolean(R.bool.default_hide_score);
        DEFAULT_VEGAS_MONEY_ENABLED = res.getBoolean(R.bool.default_vegas_money_enabled);
        DEFAULT_VEGAS_RESET_MONEY = res.getBoolean(R.bool.default_vegas_reset_money);
        DEFAULT_MOD3_AUTO_MOVE = res.getBoolean(R.bool.default_mod3_auto_move);
        DEFAULT_PYRAMID_AUTO_MOVE = res.getBoolean(R.bool.default_pyramid_auto_move);
        DEFAULT_CURRENT_GAME = res.getInteger(R.integer.default_current_game);
        DEFAULT_MENU_COLUMNS_LANDSCAPE = res.getString(R.string.default_menu_columns_landscape);
        DEFAULT_MENU_COLUMNS_PORTRAIT = res.getString(R.string.default_menu_columns_portrait);
        DEFAULT_MENU_BAR_POSITION_LANDSCAPE = res.getString(R.string.default_menu_bar_position_landscape);
        DEFAULT_MENU_BAR_POSITION_PORTRAIT = res.getString(R.string.default_menu_bar_position_portrait);
        DEFAULT_FIRST_RUN = res.getBoolean(R.bool.default_first_run);
        DEFAULT_WON = res.getBoolean(R.bool.default_won);
        DEFAULT_WON_AND_RELOADED = res.getBoolean(R.bool.default_won_and_reloaded);
        DEFAULT_MOVED_FIRST_CARD = res.getBoolean(R.bool.default_moved_first_card);
        DEFAULT_4_COLOR_MODE = res.getBoolean(R.bool.default_4_color_mode);
        DEFAULT_CARD_BACKGROUND = res.getInteger(R.integer.default_card_background);
        DEFAULT_CARD_BACKGROUND_COLOR = res.getInteger(R.integer.default_card_background_color);
        DEFAULT_WINNING_TIME = res.getInteger(R.integer.default_winning_time);
        DEFAULT_BACKGROUND_COLOR_TYPE = res.getInteger(R.integer.default_background_color_type);
        DEFAULT_BACKGROUND_COLOR = res.getString(R.string.default_background_color);
        DEFAULT_BACKGROUND_COLOR_CUSTOM = res.getInteger(R.integer.default_background_color_custom);
        DEFAULT_MOVEMENT_SPEED = res.getString(R.string.default_movement_speed);
        DEFAULT_SOUND_ENABLED = res.getBoolean(R.bool.default_sound_enabled);
        DEFAULT_FORCE_TABLET_LAYOUT = res.getBoolean(R.bool.default_force_tablet_layout);
        DEFAULT_WIN_SOUND = res.getString(R.string.default_win_sound);
        DEFAULT_BACKGROUND_MUSIC = res.getString(R.string.default_background_music);
        DEFAULT_BACKGROUND_VOLUME = res.getInteger(R.integer.default_background_volume);
        DEFAULT_VEGAS_BET_AMOUNT = res.getInteger(R.integer.default_vegas_bet_amount);
        DEFAULT_VEGAS_MONEY = res.getInteger(R.integer.default_vegas_money);
        DEFAULT_PYRAMID_NUMBER_OF_RECYCLES = res.getString(R.string.default_pyramid_number_of_recycles);
        DEFAULT_FORTYEIGHT_NUMBER_OF_RECYCLES = res.getString(R.string.default_fortyeight_number_of_recycles);
        DEFAULT_VEGAS_NUMBER_OF_RECYCLES = res.getString(R.string.default_vegas_number_of_recycles);
        DEFAULT_KLONDIKE_NUMBER_OF_RECYCLES = res.getString(R.string.default_klondike_number_of_recycles);
        DEFAULT_PYRAMID_LIMITED_RECYCLES = res.getBoolean(R.bool.default_pyramid_limited_recycles);
        DEFAULT_FORTYEIGHT_LIMITED_RECYCLES = res.getBoolean(R.bool.default_fortyeight_limited_recycles);
        DEFAULT_YUKON_RULES = res.getStringArray(R.array.pref_yukon_rules_values)[0];
        DEFAULT_KLONDIKE_DRAW = res.getStringArray(R.array.pref_draw_values)[0];
        DEFAULT_VEGAS_DRAW = res.getStringArray(R.array.pref_draw_values)[1];
        DEFAULT_CANFIELD_DRAW = res.getStringArray(R.array.pref_draw_values)[1];
    }

    private void putIntList(String name, List<Integer> list) {
        //Thanks to this answer for this idea http://stackoverflow.com/a/11201225/7016229

        String s = "";
        for (int i : list) {
            s += i + ",";
        }

        savedGameData.edit().putString(name, s).apply();
    }

    private void putLongList(String name, List<Long> list) {
        //Thanks to this answer for this idea http://stackoverflow.com/a/11201225/7016229

        String s = "";
        for (long i : list) {
            s += i + ",";
        }
        savedGameData.edit().putString(name, s).apply();
    }

    private void putSharedIntList(String name, List<Integer> list) {
        //
        String s = "";
        for (int i : list) {
            s += i + ",";
        }
        savedSharedData.edit().putString(name, s).apply();
    }

    private void putSharedStringList(String name, List<String> list) {
        //
        String s = "";
        for (String i : list) {
            s += i + ",";
        }
        savedSharedData.edit().putString(name, s).apply();
    }

    private ArrayList<Integer> getIntList(String name) {
        //Thanks to this answer for this idea http://stackoverflow.com/a/11201225/7016229

        String s = savedGameData.getString(name, "");
        StringTokenizer st = new StringTokenizer(s, ",");
        ArrayList<Integer> result = new ArrayList<>();

        while (st.hasMoreTokens()) {
            result.add(Integer.parseInt(st.nextToken()));
        }

        return result;
    }

    private ArrayList<Long> getLongList(String name) {
        //Thanks to this answer for this idea http://stackoverflow.com/a/11201225/7016229

        String s = savedGameData.getString(name, "");
        StringTokenizer st = new StringTokenizer(s, ",");
        ArrayList<Long> result = new ArrayList<>();

        while (st.hasMoreTokens()) {
            result.add(Long.parseLong(st.nextToken()));
        }

        return result;
    }

    private ArrayList<Integer> getSharedIntList(String name) {
        String s = savedSharedData.getString(name, "");
        StringTokenizer st = new StringTokenizer(s, ",");
        ArrayList<Integer> result = new ArrayList<>();

        while (st.hasMoreTokens()) {
            result.add(Integer.parseInt(st.nextToken()));
        }

        return result;
    }

    private ArrayList<String> getSharedStringList(String name) {
        String s = savedSharedData.getString(name, "");
        StringTokenizer st = new StringTokenizer(s, ",");
        ArrayList<String> result = new ArrayList<>();

        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }

        return result;
    }

    /**
     * need to ensure these settings already exist in the shared pref, or otherwise they get created
     * by the settings headers and this activity would do stuff, because it thinks the user changed
     * the values
     */
    public void setCriticalSettings(){
        saveLocale(getSavedLocale());
        saveForcedTabletLayout(getSavedForcedTabletLayout());
    }

    /**
     * see description of setCriticalSettings()
     */
    public void setCriticalGameSettings(){
        saveCanfieldDrawMode(getSavedCanfieldDrawMode());
        saveKlondikeDrawMode(getSavedKlondikeDrawMode());
        saveVegasDrawMode(getSavedVegasDrawMode());
        saveSpiderDifficulty(getSavedSpiderDifficulty());
        saveYukonRules(getSavedYukonRules());
    }

    /* getters for individual game data */

    public long getSavedEndTime(){
        return savedGameData.getLong(PREF_KEY_TIMER_END_TIME,System.currentTimeMillis());
    }

    public long getSavedScore(){
        return savedGameData.getLong(PREF_KEY_SCORE,0);
    }

    public long getSavedStartTime(){
        return savedGameData.getLong(PREF_KEY_TIMER_START_TIME, System.currentTimeMillis());
    }

    public long getSavedWinningTime(){
        return savedGameData.getLong(PREF_KEY_TIMER_WINNING_TIME,DEFAULT_WINNING_TIME);
    }

    public long getSavedVegasMoney(){
        return savedGameData.getLong(PREF_KEY_VEGAS_MONEY,DEFAULT_VEGAS_MONEY);
    }

    public long getSavedVegasOldScore(){
        return savedGameData.getLong(PREF_KEY_VEGAS_OLD_SCORE,0);
    }

    public long getSavedVegasTime(){
        return savedGameData.getLong(PREF_KEY_VEGAS_TIME,0);
    }

    public long[][] getSavedHighScores(){
        long savedScores[][] = new long[MAX_SAVED_SCORES][3];

        ArrayList<Long> listScores = getLongList(PREF_KEY_SAVED_SCORES + 0);
        ArrayList<Long> listTimes = getLongList(PREF_KEY_SAVED_SCORES + 1);
        ArrayList<Long> listDates = getLongList(PREF_KEY_SAVED_SCORES + 2);

        //for compatibility for older app versions, check the size of the saved data
        for (int i = 0; i < MAX_SAVED_SCORES; i++) {
            savedScores[i][0] = listScores.size() > i ? listScores.get(i) : 0;
            savedScores[i][1] = listTimes.size() > i ? listTimes.get(i) : 0;
            savedScores[i][2] = listDates.size() > i ? listDates.get(i) : 0;
        }

        return savedScores;
    }

    public int getSavedStartCardValueCanfield(){
        return savedGameData.getInt(PREF_KEY_CANFIELD_START_CARD_VALUE,0);
    }

    public int getSavedRecycleCounter(int total){
        return savedGameData.getInt(PREF_KEY_GAME_REDEAL_COUNT,total);
    }

    public int getSavedLongestRun(){
        return savedGameData.getInt(PREF_KEY_LONGEST_RUN,0);
    }

    public int getSavedRunCounter(){
        return savedGameData.getInt(PREF_KEY_RUN_COUNTER,0);
    }

    public int getSavedNumberOfPlayedGames(){
        return savedGameData.getInt(PREF_KEY_GAME_NUMBER_OF_PLAYED_GAMES,getSavedNumberOfWonGames());
    }

    public int getSavedNumberOfWonGames(){
        return savedGameData.getInt(PREF_KEY_GAME_NUMBER_OF_WON_GAMES,0);
    }

    public int getSavedRecordListEntriesSize(){
        return savedGameData.getInt(PREF_KEY_RECORD_LIST_ENTRIES_SIZE, -1);
    }

    public int getSavedFlipCardId(String pos){
        return savedGameData.getInt(PREF_KEY_RECORD_LIST_ENTRY + pos + PREF_KEY_FLIP_CARD, -1);
    }

    public boolean isFirstRun(){
        return savedGameData.getBoolean(PREF_KEY_GAME_FIRST_RUN,DEFAULT_FIRST_RUN);
    }

    public boolean isWon(){
        return savedGameData.getBoolean(PREF_KEY_GAME_WON,DEFAULT_WON);
    }

    public boolean isWonAndReloaded(){
        return savedGameData.getBoolean(PREF_KEY_GAME_WON_AND_RELOADED,DEFAULT_WON_AND_RELOADED);
    }

    public boolean hasMovedFirstCard(){
        return savedGameData.getBoolean(PREF_KEY_GAME_MOVED_FIRST_CARD, DEFAULT_MOVED_FIRST_CARD);
    }

    public ArrayList<Integer> getSavedCards(){
        return getIntList(PREF_KEY_CARDS);
    }

    public ArrayList<Integer> getSavedStacks(int id){
        return getIntList(PREF_KEY_STACK + id);
    }

    public ArrayList<Integer> getSavedRandomCards(){
        return getIntList(PREF_KEY_GAME_RANDOM_CARDS);
    }

    public ArrayList<Integer> getSavedRecordListCards(String pos){
        return getIntList(PREF_KEY_RECORD_LIST_ENTRY + pos + PREF_KEY_CARD);
    }

    public ArrayList<Integer> getSavedRecordListOrigins(String pos){
        return getIntList(PREF_KEY_RECORD_LIST_ENTRY + pos + PREF_KEY_ORIGIN);
    }

    public ArrayList<Integer> getSavedRecordListOrders(String pos){
        return getIntList(PREF_KEY_RECORD_LIST_ENTRY + pos + PREF_KEY_ORDER);
    }

    public ArrayList<Integer> getSavedRecordListFlipCards(String pos){
        return getIntList(PREF_KEY_RECORD_LIST_ENTRY + pos + PREF_KEY_FLIP_CARD);
    }

    /* setters for individual game data */

    public void saveScore(long value){
        savedGameData.edit().putLong(PREF_KEY_SCORE,value).apply();
    }

    public void saveStartTime(long value){
        savedGameData.edit().putLong(PREF_KEY_TIMER_START_TIME,value).apply();
    }

    public void saveEndTime(long value){
        savedGameData.edit().putLong(PREF_KEY_TIMER_END_TIME,value).apply();
    }

    public void saveWinningTime(long value){
        savedGameData.edit().putLong(PREF_KEY_TIMER_WINNING_TIME,value).apply();
    }

    public void saveVegasMoney(long value){
        savedGameData.edit().putLong(PREF_KEY_VEGAS_MONEY,value).apply();
    }

    public void saveVegasOldScore(long value){
        savedGameData.edit().putLong(PREF_KEY_VEGAS_OLD_SCORE,value).apply();
    }

    public void saveVegasTime(long value){
        savedGameData.edit().putLong(PREF_KEY_VEGAS_TIME,value).apply();
    }

    public void saveHighScores(long savedScores[][]){
        ArrayList<Long> listScores = new ArrayList<>();
        ArrayList<Long> listTimes = new ArrayList<>();
        ArrayList<Long> listDates = new ArrayList<>();

        for (int i = 0; i < MAX_SAVED_SCORES; i++) {
            listScores.add(savedScores[i][0]);
            listTimes.add(savedScores[i][1]);
            listDates.add(savedScores[i][2]);
        }

        putLongList(PREF_KEY_SAVED_SCORES + 0, listScores);
        putLongList(PREF_KEY_SAVED_SCORES + 1, listTimes);
        putLongList(PREF_KEY_SAVED_SCORES + 2, listDates);
    }

    public void saveStartCardValueCanfield(int value){
        savedGameData.edit().putInt(PREF_KEY_CANFIELD_START_CARD_VALUE,value).apply();
    }

    public void saveRedealCount(int value){
        savedGameData.edit().putInt(PREF_KEY_GAME_REDEAL_COUNT,value).apply();
    }

    public void saveLongestRun(int value){
        savedGameData.edit().putInt(PREF_KEY_LONGEST_RUN,value).apply();
    }

    public void saveRunCounter(int value){
        savedGameData.edit().putInt(PREF_KEY_RUN_COUNTER,value).apply();
    }

    public void saveNumberOfWonGames(int value){
        savedGameData.edit().putInt(PREF_KEY_GAME_NUMBER_OF_WON_GAMES,value).apply();
    }

    public void saveNumberOfPlayedGames(int value){
        savedGameData.edit().putInt(PREF_KEY_GAME_NUMBER_OF_PLAYED_GAMES,value).apply();
    }

    public void saveRecordListEntriesSize(int value){
        savedGameData.edit().putInt(PREF_KEY_RECORD_LIST_ENTRIES_SIZE,value).apply();
    }

    public void saveFirstRun(boolean value){
        savedGameData.edit().putBoolean(PREF_KEY_GAME_FIRST_RUN,value).apply();
    }

    public void saveWon(boolean value){
        savedGameData.edit().putBoolean(PREF_KEY_GAME_WON,value).apply();
    }

    public void saveWonAndReloaded(boolean value){
        savedGameData.edit().putBoolean(PREF_KEY_GAME_WON_AND_RELOADED,value).apply();
    }

    public void saveMovedFirstCard(boolean value){
        savedGameData.edit().putBoolean(PREF_KEY_GAME_MOVED_FIRST_CARD,value).apply();
    }

    public void saveCards(ArrayList<Integer> list){
        putIntList(PREF_KEY_CARDS,list);
    }

    public void saveStacks(ArrayList<Integer> list, int id){
        putIntList(PREF_KEY_STACK + id,list);
    }

    public void saveRandomCards(ArrayList<Integer> list){
        putIntList(PREF_KEY_GAME_RANDOM_CARDS,list);
    }

    public void saveRecordListCards(ArrayList<Integer> list, String pos){
        putIntList(PREF_KEY_RECORD_LIST_ENTRY + pos + PREF_KEY_CARD,list);
    }

    public void saveRecordListOrigins(ArrayList<Integer> list, String pos){
        putIntList(PREF_KEY_RECORD_LIST_ENTRY + pos + PREF_KEY_ORIGIN,list);
    }

    public void saveRecordListOrders(ArrayList<Integer> list, String pos){
        putIntList(PREF_KEY_RECORD_LIST_ENTRY + pos + PREF_KEY_ORDER,list);
    }

    public void saveRecordListFlipCards(ArrayList<Integer> list, String pos){
        putIntList(PREF_KEY_RECORD_LIST_ENTRY + pos + PREF_KEY_FLIP_CARD,list);
    }

    /* getters for shared data */

    public int getSavedCardBackground(){
        return savedSharedData.getInt(PREF_KEY_CARD_BACKGROUND,DEFAULT_CARD_BACKGROUND);
    }

    public int getSavedCardBackgroundColor(){
        return savedSharedData.getInt(PREF_KEY_CARD_BACKGROUND_COLOR,DEFAULT_CARD_BACKGROUND_COLOR);
    }

    public int getSavedBackgroundColorType(){
        return savedSharedData.getInt(PREF_KEY_BACKGROUND_COLOR_TYPE,DEFAULT_BACKGROUND_COLOR_TYPE);
    }

    public int getSavedBackgroundCustomColor(){
        return savedSharedData.getInt(PREF_KEY_BACKGROUND_COLOR_CUSTOM,DEFAULT_BACKGROUND_COLOR_CUSTOM);
    }

    public int getSavedCardTheme(){
        return savedSharedData.getInt(PREF_KEY_CARD_DRAWABLES,1);
    }

    public int getSavedBackgroundVolume(){
        return savedSharedData.getInt(PREF_KEY_BACKGROUND_VOLUME,DEFAULT_BACKGROUND_VOLUME);
    }

    public int getSavedVegasBetAmount(){
        return savedSharedData.getInt(PREF_KEY_VEGAS_BET_AMOUNT,DEFAULT_VEGAS_BET_AMOUNT);
    }

    public int getSavedVegasBetAmountOld(){
        return savedSharedData.getInt(PREF_KEY_VEGAS_BET_AMOUNT_OLD,DEFAULT_VEGAS_BET_AMOUNT);
    }

    public int getSavedCurrentGame(){
        return savedSharedData.getInt(PREF_KEY_CURRENT_GAME,DEFAULT_CURRENT_GAME);
    }

    public int getSavedOrientation(){
        return Integer.parseInt(savedSharedData.getString(PREF_KEY_ORIENTATION,DEFAULT_ORIENTATION));
    }

    public int getSavedBackgroundColor(){
        return Integer.parseInt(savedSharedData.getString(PREF_KEY_BACKGROUND_COLOR,DEFAULT_BACKGROUND_COLOR));
    }

    public int getSavedMenuColumnsPortrait(){
        return Integer.parseInt(savedSharedData.getString(PREF_KEY_MENU_COLUMNS_PORTRAIT,DEFAULT_MENU_COLUMNS_PORTRAIT));
    }

    public int getSavedMenuColumnsLandscape(){
        return Integer.parseInt(savedSharedData.getString(PREF_KEY_MENU_COLUMNS_LANDSCAPE,DEFAULT_MENU_COLUMNS_LANDSCAPE));
    }

    public int getSavedNumberOfRecycles(String Key, String defaulValue){
        return Integer.parseInt(savedSharedData.getString(Key,defaulValue));
    }

    public float getSavedMovementSpeed(){
        return Float.parseFloat(savedSharedData.getString(PREF_KEY_MOVEMENT_SPEED,DEFAULT_MOVEMENT_SPEED));
    }

    public String getSavedBackgroundMusic(){
        return savedSharedData.getString(PREF_KEY_BACKGROUND_MUSIC,DEFAULT_BACKGROUND_MUSIC);
    }

    public String getSavedLocale(){
        return savedSharedData.getString(PREF_KEY_LANGUAGE,DEFAULT_LANGUAGE);
    }

    public String getSavedCanfieldDrawMode(){
        return savedSharedData.getString(PREF_KEY_CANFIELD_DRAW,DEFAULT_CANFIELD_DRAW);
    }

    public String getSavedCanfieldDrawModeOld(){
        return savedSharedData.getString(PREF_KEY_CANFIELD_DRAW_OLD,DEFAULT_CANFIELD_DRAW);
    }

    public String getSavedKlondikeDrawMode(){
        return savedSharedData.getString(PREF_KEY_KLONDIKE_DRAW,DEFAULT_KLONDIKE_DRAW);
    }

    public String getSavedVegasDrawMode(){
        return savedSharedData.getString(PREF_KEY_VEGAS_DRAW,DEFAULT_VEGAS_DRAW);
    }

    public String getSavedKlondikeVegasDrawModeOld(int which){
        if (which==1) {
            return savedSharedData.getString(PREF_KEY_KLONDIKE_DRAW_OLD, DEFAULT_KLONDIKE_DRAW);
        } else {
            return savedSharedData.getString(PREF_KEY_VEGAS_DRAW_OLD, DEFAULT_VEGAS_DRAW);
        }
    }

    public String getSavedSpiderDifficulty(){
        return savedSharedData.getString(PREF_KEY_SPIDER_DIFFICULTY,DEFAULT_SPIDER_DIFFICULTY);
    }

    public String getSavedSpiderDifficultyOld(){
        return savedSharedData.getString(PREF_KEY_SPIDER_DIFFICULTY_OLD,DEFAULT_SPIDER_DIFFICULTY);
    }

    public String getSavedYukonRules(){
        return savedSharedData.getString(PREF_KEY_YUKON_RULES,DEFAULT_YUKON_RULES);
    }

    public String getSavedYukonRulesOld(){
        return savedSharedData.getString(PREF_KEY_YUKON_RULES_OLD,DEFAULT_YUKON_RULES);
    }

    public String getSavedMenuBarPosPortrait(){
        return savedSharedData.getString(PREF_KEY_MENU_BAR_POS_PORTRAIT,DEFAULT_MENU_BAR_POSITION_PORTRAIT);
    }

    public String getSavedMenuBarPosLandscape(){
        return savedSharedData.getString(PREF_KEY_MENU_BAR_POS_LANDSCAPE,DEFAULT_MENU_BAR_POSITION_LANDSCAPE);
    }

    public String getSavedPyramidDifficulty(){
        return savedSharedData.getString(PREF_KEY_PYRAMID_DIFFICULTY,DEFAULT_PYRAMID_DIFFICULTY);
    }

    public String getSavedWinSound(){
        return savedSharedData.getString(PREF_KEY_WIN_SOUND, DEFAULT_WIN_SOUND);
    }

    public boolean getSavedForcedTabletLayout(){
        return savedSharedData.getBoolean(PREF_KEY_FORCE_TABLET_LAYOUT,DEFAULT_FORCE_TABLET_LAYOUT);
    }

    public boolean getSavedLeftHandedMode(){
        return savedSharedData.getBoolean(PREF_KEY_LEFT_HANDED_MODE,DEFAULT_LEFT_HANDED_MODE);
    }

    public boolean getSavedFourColorMode(){
        return savedSharedData.getBoolean(PREF_KEY_4_COLOR_MODE,DEFAULT_4_COLOR_MODE);
    }

    public boolean getSavedHideStatusBar(){
        return savedSharedData.getBoolean(PREF_KEY_HIDE_STATUS_BAR,false);
    }

    public boolean getSavedCalculationAlternativeMode(){
        return savedSharedData.getBoolean(PREF_KEY_CALCULATION_ALTERNATIVE,DEFAULT_CALCULATION_ALTERNATIVE);
    }

    public boolean getSavedCalculationAlternativeModeOld(){
        return savedSharedData.getBoolean(PREF_KEY_CALCULATION_ALTERNATIVE_OLD,DEFAULT_CALCULATION_ALTERNATIVE);
    }

    public boolean getSavedFortyEightLimitedRecycles(){
        return savedSharedData.getBoolean(PREF_KEY_FORTYEIGHT_LIMITED_RECYCLES, DEFAULT_FORTYEIGHT_LIMITED_RECYCLES);
    }

    public boolean getSavedGoldCyclic(){
        return savedSharedData.getBoolean(PREF_KEY_GOLF_CYCLIC,DEFAULT_GOLF_CYCLIC);
    }

    public boolean getSavedKlondikeLimitedRecycles(){
        return savedSharedData.getBoolean(PREF_KEY_KLONDIKE_LIMITED_RECYCLES, DEFAULT_KLONDIKE_LIMITED_RECYCLES);
    }

    public boolean getSavedMod3AutoMove(){
        return savedSharedData.getBoolean(PREF_KEY_MOD3_AUTO_MOVE,DEFAULT_MOD3_AUTO_MOVE);
    }

    public boolean getSavedPyramidLimitedRecycles(){
        return savedSharedData.getBoolean(PREF_KEY_PYRAMID_LIMITED_RECYCLES, DEFAULT_PYRAMID_LIMITED_RECYCLES);
    }

    public boolean getSavedPyramidAutoMove(){
        return savedSharedData.getBoolean(PREF_KEY_PYRAMID_AUTO_MOVE,DEFAULT_PYRAMID_AUTO_MOVE);
    }

    public boolean getSavedVegasSaveMoneyEnabled(){
        return savedSharedData.getBoolean(PREF_KEY_VEGAS_MONEY_ENABLED,DEFAULT_VEGAS_MONEY_ENABLED);
    }

    public boolean getSavedVegasResetMoney(){
        return savedSharedData.getBoolean(PREF_KEY_VEGAS_RESET_MONEY,DEFAULT_VEGAS_RESET_MONEY);
    }

    public boolean getSavedHideTime(){
        return savedSharedData.getBoolean(PREF_KEY_HIDE_TIME,DEFAULT_HIDE_TIME);
    }

    public boolean getSavedHideScore(){
        return savedSharedData.getBoolean(PREF_KEY_HIDE_SCORE,DEFAULT_HIDE_SCORE);
    }

    public boolean getSavedAutoStartNewGame(){
        return savedSharedData.getBoolean(PREF_KEY_AUTO_START_NEW_GAME,DEFAULT_AUTO_START_NEW_GAME);
    }

    public boolean getSavedTapToSelectEnabled(){
        return savedSharedData.getBoolean(PREF_KEY_TAP_TO_SELECT_ENABLED,DEFAULT_TAP_TO_SELECT_ENABLED);
    }

    public boolean getSavedDoubleTapEnabled(){
        return savedSharedData.getBoolean(PREF_KEY_DOUBLE_TAP_ENABLED,DEFAULT_DOUBLE_TAP_ENABLE);
    }

    public boolean getSavedDoubleTapAllCards(){
        return savedSharedData.getBoolean(PREF_KEY_DOUBLE_TAP_ALL_CARDS,DEFAULT_DOUBLE_TAP_ALL_CARDS);
    }

    public boolean getSavedDoubleTapFoundationFirst(){
        return savedSharedData.getBoolean(PREF_KEY_DOUBLE_TAP_FOUNDATION_FIRST,DEFAULT_DOUBLE_TAP_FOUNDATION_FIRST);
    }

    public boolean getSavedSingleTapEnabled(){
        return savedSharedData.getBoolean(PREF_KEY_SINGLE_TAP_ENABLE,DEFAULT_SINGLE_TAP_ENABLED);
    }

    public boolean getSavedStartWithMenu(){
        return savedSharedData.getBoolean(PREF_KEY_START_WITH_MENU,false);
    }

    public boolean getSavedSoundEnabled(){
        return savedSharedData.getBoolean(PREF_KEY_SOUND_ENABLED, DEFAULT_SOUND_ENABLED);
    }

    public ArrayList<String> getSavedCalculationNextCardsList(){
        return getSharedStringList(PREF_KEY_NEXT_CARD_VALUES);
    }

    public ArrayList<Integer> getSavedMenuGamesList(){
        return getSharedIntList(PREF_KEY_MENU_GAMES);
    }

    public ArrayList<Integer> getSavedMenuOrderList(){
        return getSharedIntList(PREF_KEY_MENU_ORDER);
    }

    /* setters for shared data */

    public void saveYukonRulesOld(){
        savedSharedData.edit().putString(PREF_KEY_YUKON_RULES_OLD, getSavedYukonRules()).apply();
    }

    public void saveBackgroundColorType(int value){
        savedSharedData.edit().putInt(PREF_KEY_BACKGROUND_COLOR_TYPE,value).apply();
    }

    public void saveBackgroundCustomColor(int value){
        savedSharedData.edit().putInt(PREF_KEY_BACKGROUND_COLOR_CUSTOM,value).apply();
    }

    public void saveCardBackground(int value){
        savedSharedData.edit().putInt(PREF_KEY_CARD_BACKGROUND,value).apply();
    }

    public void saveCardBackgroundColor(int value){
        savedSharedData.edit().putInt(PREF_KEY_CARD_BACKGROUND_COLOR,value).apply();
    }

    public void saveCardTheme(int value){
        savedSharedData.edit().putInt(PREF_KEY_CARD_DRAWABLES,value).apply();
    }

    public void saveBackgroundVolume(int value){
        savedSharedData.edit().putInt(PREF_KEY_BACKGROUND_VOLUME,value).apply();
    }

    public void saveVegasBetAmount(int value){
        savedSharedData.edit().putInt(PREF_KEY_VEGAS_BET_AMOUNT,value).apply();
    }

    public void saveVegasBetAmountOld(){
        savedSharedData.edit().putInt(PREF_KEY_VEGAS_BET_AMOUNT_OLD,getSavedVegasBetAmount()).apply();
    }

    public void saveCurrentGame(int value){
        savedSharedData.edit().putInt(PREF_KEY_CURRENT_GAME,value).apply();
    }

    public void saveLocale(String locale){
        savedSharedData.edit().putString(PREF_KEY_LANGUAGE,locale).apply();
    }

    public void saveCanfieldDrawMode(String value){
        savedSharedData.edit().putString(PREF_KEY_CANFIELD_DRAW,value).apply();
    }

    public void saveCanfieldDrawModeOld(){
        savedSharedData.edit().putString(PREF_KEY_CANFIELD_DRAW_OLD,getSavedCanfieldDrawMode()).apply();
    }

    public void saveKlondikeDrawMode(String value){
        savedSharedData.edit().putString(PREF_KEY_KLONDIKE_DRAW,value).apply();
    }

    public void saveKlondikeVegasDrawModeOld(int which){
        if (which==1) {
            savedSharedData.edit().putString(PREF_KEY_KLONDIKE_DRAW_OLD, getSavedKlondikeDrawMode()).apply();
        } else{
            savedSharedData.edit().putString(PREF_KEY_VEGAS_DRAW_OLD,getSavedVegasDrawMode()).apply();
        }
    }

    public void saveVegasDrawMode(String value){
        savedSharedData.edit().putString(PREF_KEY_VEGAS_DRAW,value).apply();
    }

    public void saveSpiderDifficulty(String value){
        savedSharedData.edit().putString(PREF_KEY_SPIDER_DIFFICULTY,value).apply();
    }

    public void saveSpiderDifficultyOld(){
        savedSharedData.edit().putString(PREF_KEY_SPIDER_DIFFICULTY_OLD,getSavedSpiderDifficulty()).apply();
    }

    public void saveYukonRules(String value){
        savedSharedData.edit().putString(PREF_KEY_YUKON_RULES,value).apply();
    }

    public void saveCalculationAlternativeModeOld(){
        savedSharedData.edit().putBoolean(PREF_KEY_CALCULATION_ALTERNATIVE_OLD,getSavedCalculationAlternativeMode()).apply();
    }

    public void saveForcedTabletLayout(boolean value){
        savedSharedData.edit().putBoolean(PREF_KEY_FORCE_TABLET_LAYOUT,value).apply();
    }

    public void saveBackgroundColor(int value){
        savedSharedData.edit().putString(PREF_KEY_BACKGROUND_COLOR,Integer.toString(value)).apply();
    }

    public void saveMenuBarPosPortrait(String value){
        savedSharedData.edit().putString(PREF_KEY_MENU_BAR_POS_PORTRAIT,value).apply();
    }

    public void saveMenuBarPosLandscape(String value){
        savedSharedData.edit().putString(PREF_KEY_MENU_BAR_POS_LANDSCAPE,value).apply();
    }

    public void saveMenuColumnsPortrait(String value){
        savedSharedData.edit().putString(PREF_KEY_MENU_COLUMNS_PORTRAIT,value).apply();
    }

    public void saveMenuColumnsLandscape(String value){
        savedSharedData.edit().putString(PREF_KEY_MENU_COLUMNS_LANDSCAPE,value).apply();
    }

    public void saveVegasResetMoney(boolean value){
        savedSharedData.edit().putBoolean(PREF_KEY_VEGAS_RESET_MONEY,value).apply();
    }

    public void saveCalculationNextCardsList(ArrayList<String> list){
        putSharedStringList(PREF_KEY_NEXT_CARD_VALUES, list);
    }

    public void saveMenuGamesList(ArrayList<Integer> list){
        putSharedIntList(PREF_KEY_MENU_GAMES,list);
    }

    public void saveMenuOrderList(ArrayList<Integer> list){
        putSharedIntList(PREF_KEY_MENU_ORDER,list);
    }
}
