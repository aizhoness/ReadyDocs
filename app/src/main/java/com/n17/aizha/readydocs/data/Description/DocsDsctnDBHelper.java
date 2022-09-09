package com.n17.aizha.readydocs.data.Description;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.n17.aizha.readydocs.data.Description.DocsDsctnContract;

/**
 * Created by aizha on 24.07.2017.
 */

public class DocsDsctnDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "projectDsctn.db";
    private static final int DATABASE_VERSION = 1;

    public DocsDsctnDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        ////
        final String SQL_CREATE_DESCRIPTION_TABLE = "CREATE TABLE " + DocsDsctnContract.DocsDsctnEntry.Description_Table_Name + " (" +
                DocsDsctnContract.DocsDsctnEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DocsDsctnContract.DocsDsctnEntry.COLUMN_Question_ID+ " TEXT NOT NULL, " +
                DocsDsctnContract.DocsDsctnEntry.COLUMN_Category_ID + " TEXT NOT NULL, " +
                DocsDsctnContract.DocsDsctnEntry.COLUMN_Question_Name+ " TEXT NOT NULL, " +
                DocsDsctnContract.DocsDsctnEntry.COLUMN_LN + " TEXT NOT NULL, " +
                DocsDsctnContract.DocsDsctnEntry.COLUMN_Timest + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP); ";
        db.execSQL(SQL_CREATE_DESCRIPTION_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS " + DocsDsctnContract.DocsDsctnEntry.Description_Table_Name);
        onCreate(db);

    }
}

