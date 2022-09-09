package com.n17.aizha.readydocs.data.Category;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aizha on 24.07.2017.
 */

public class CategoryTestUtil {
    public static void insertToCategory(SQLiteDatabase db){
        if(db == null){
            return;
        }
        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "taxation_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Налоговая");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "energy_station_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Энергосбыт");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "doki_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "БТИ");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "police_car_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "СпецЦОН");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "water_station_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Горводоканал");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "embassy_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Посольство");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "home_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Программа жилья");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "marriage_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Загс");
        list.add(cv);


        try{
            db.beginTransaction();
            db.delete(DocsContract.DocsEntry.Category_Table_Name, null, null);
            for(ContentValues c:list){
                db.insert(DocsContract.DocsEntry.Category_Table_Name, null, c);
            }
            db.setTransactionSuccessful();
        }catch (SQLException e){}
        finally {
            db.endTransaction();
        }
    }



    //////////////******************************************
    public static void insertToCategoryKZ(SQLiteDatabase db){
        if(db == null){
            return;
        }
        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "taxation_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Салық әкімшілігі");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "energy_station_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Электр тұтыну жүйесі");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "doki_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Мүлікті түгендеу техникалық бюросы");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "police_car_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Арнайы ХҚКО");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "water_station_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Су тұтыну жүйесі");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "embassy_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Елшілік үйі");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "home_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "Тұрғын үй бағдарламасы");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Image, "marriage_icon");
        cv.put(DocsContract.DocsEntry.COLUMN_Category_Name, "АХАЖ");
        list.add(cv);


        try{
            db.beginTransaction();
            db.delete(DocsContract.DocsEntry.Category_Table_Name, null, null);
            for(ContentValues c:list){
                db.insert(DocsContract.DocsEntry.Category_Table_Name, null, c);
            }
            db.setTransactionSuccessful();
        }catch (SQLException e){}
        finally {
            db.endTransaction();
        }
    }
}
