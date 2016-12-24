package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by tonynguyen on 12/9/16.
 */

public final class HabitContract {

    //An empty private constructor makes sure that the class is not going to be initialised.
    private HabitContract() {
    }

    public static final class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "habit";

        public final static String COLUMN_HABIT_ACTIVITY = "activity";
        public final static String COLUMN_HABIT_DAYS = "days";

    }


}

