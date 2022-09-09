package com.n17.aizha.readydocs.data.Question;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.n17.aizha.readydocs.data.Question.DocsQtnContract;

/**
 * Created by aizha on 24.07.2017.
 */

public class DocsQtnDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "projectQtn.db";
    private static final int DATABASE_VERSION = 1;

    public DocsQtnDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " + DocsQtnContract.DocsQtnEntry.Questions_Table_Name + " (" +
                DocsQtnContract.DocsQtnEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID + " TEXT NOT NULL, " +
                DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description + " TEXT NOT NULL, " +
                DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID + " TEXT NOT NULL, " +
                DocsQtnContract.DocsQtnEntry.COLUMN_TimeStamp + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP); ";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS " + DocsQtnContract.DocsQtnEntry.Questions_Table_Name);
        onCreate(db);


    }
}
