package com.csci448.alchu.criminalintent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alex on 3/19/18.
 */

public class CrimeBaseHelper extends SQLiteOpenHelper{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";
    public CrimeBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + CrimeDbSchema.CrimeTable.NAME+ "(" +
                    " _id integer primary key autoincrement, " +
                    CrimeDbSchema.CrimeTable.Cols.UUID + ", "
                    + CrimeDbSchema.CrimeTable.Cols.TITLE + ", "
                    + CrimeDbSchema.CrimeTable.Cols.DATE + ", "
                    + CrimeDbSchema.CrimeTable.Cols.SOLVED+ ", " +
                    CrimeDbSchema.CrimeTable.Cols.SUSPECT + ", " +
                    CrimeDbSchema.CrimeTable.Cols.PHONE_NUMBER +
                    ")"
            );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
