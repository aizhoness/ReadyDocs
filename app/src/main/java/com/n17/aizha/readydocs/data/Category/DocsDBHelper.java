package com.n17.aizha.readydocs.data.Category;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.n17.aizha.readydocs.data.Category.DocsContract;

/**
 * Created by aizha on 21.07.2017.
 */

public class DocsDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "project.db";
    private static final int DATABASE_VERSION = 1;

    public DocsDBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_CATEGORY_TABLE = "CREATE TABLE " + DocsContract.DocsEntry.Category_Table_Name + " (" +
                DocsContract.DocsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DocsContract.DocsEntry.COLUMN_Category_Image + " TEXT NOT NULL, " +
                DocsContract.DocsEntry.COLUMN_Category_Name + " TEXT NOT NULL, " +
                DocsContract.DocsEntry.COLUMN_Timestamp + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP); ";
        db.execSQL(SQL_CREATE_CATEGORY_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DocsContract.DocsEntry.Category_Table_Name);
        onCreate(db);


    }
}
