package com.example.android.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by tonynguyen on 12/9/16.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    // Database constant
    private static final int DATABASE_VERSION = 1;

    // Database name constant
    private static final String DATABASE_NAME = "habit.db";

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_ACTIVITY + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_DAYS + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_HABIT_TABLE);

    }

    // Not upgrading database so leave blank
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){}

    /**
     * Insert Method
     */
    public void insertHabit(String activity, int days) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_ACTIVITY, activity);
        values.put(HabitEntry.COLUMN_HABIT_DAYS, days);

        db.insert(HabitEntry.TABLE_NAME,null,values);

    }

    /**
     *
     * @return Read all habit entries
     */
    public Cursor readAllHabits(){

        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_ACTIVITY,
                HabitEntry.COLUMN_HABIT_DAYS
        };

        Cursor cursor = db.query(
                HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null
        );

        return cursor;
    }
}
