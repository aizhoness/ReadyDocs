package com.n17.aizha.readydocs.data.Question;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.n17.aizha.readydocs.data.Question.DocsQtnContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aizha on 24.07.2017.
 */

public class QtnTestUtil {
    public static void insertQtnData(SQLiteDatabase db){
        if (db == null){
            return;
        }

        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Легализация имущества");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Возврат документов,  представленных на легализацию");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "1");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Регистрационный учет");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "2");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Представление сведений об отсутствии (наличии) задолженности");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "3");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Выдача справки о суммах полученных доходов");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "4");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Подтверждение резидентства ");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "5");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Приостановление (продление, возобновление)");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "6");
        list.add(cv);


        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "1");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Заключение договора энергоснабжения");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "1");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Заключение договора энергоснабжения для бытового потребителя");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "1");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "2");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Процедура выдачи техпаспорта");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "2");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Перепланировка квартиры");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "1");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "2");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Документы для БТИ");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "2");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "3");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Получить водительские права");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "4");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Получение технических условии на подключения к водопроводу и канализации");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "4");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Получение технических условий");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "1");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "4");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Продление технических условий");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "2");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "5");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Шенгенская виза");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "6");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Программа Акбулак");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "6");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Доступное жилье 2020");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "1");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "6");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Доступное жилье от «HAPPY-DOM»");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "2");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "7");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Вступление в брак");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "7");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Развод в судебном порядке");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "1");
        list.add(cv);



        try
        {
            db.beginTransaction();
            db.delete(DocsQtnContract.DocsQtnEntry.Questions_Table_Name, null, null);

            for (ContentValues c:list){
                db.insert(DocsQtnContract.DocsQtnEntry.Questions_Table_Name, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e){

        }finally {
            db.endTransaction();
        }
    }
    public static void insertQtnDataKZ(SQLiteDatabase db){
        if (db == null){
            return;
        }

        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Мүлікті заңдастыру");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Заңдастыруға берілген құжаттарды қайтару");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "1");

        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Тіркеуге алу есебі");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "2");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Қарыздар жоқтығы (бары) жайында мәлімет алу");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "3");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Кірістер сомасы жайында мәлімет алу");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "4");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Резидентура растамасы");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "5");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "0");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Салық есептілігін табыс етуді тоқтата тұру (ұзарту, қайта бастау)");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "6");
        list.add(cv);


        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "1");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Электр қуатымен қамту шартын жасау");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "1");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Тұрмыстық тұтынушыға электр қуатымен қамту шартын жасау");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "1");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "2");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Техпаспорт алу тәртібі");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "2");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Пәтерді қайта жоспарлау");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "1");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "2");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Мүлікті түгендеу бюросына керек құжаттар");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "2");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "3");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Жүргізуші куәлігін алу");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "4");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Су мен канализация құбырларына қосылу үшін техникалық жағдайлармен қамтылу");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "4");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Техникалық жағдайлармен қамтылу");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "1");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "4");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Техникалық жағдайларды ұзарту");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "2");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "5");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Шенгендік виза алу");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "6");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Ақбұлақ бағдарламасы");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "6");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Қолжетімді тұрғын үй - 2020");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "1");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "6");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "HAPPY-DOM бағдарламасы");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "2");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "7");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Неке қию");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "0");
        list.add(cv);

        cv = new ContentValues();
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID, "7");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description, "Сот арқылы ажырасу");
        cv.put(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID, "1");
        list.add(cv);



        try
        {
            db.beginTransaction();
            db.delete(DocsQtnContract.DocsQtnEntry.Questions_Table_Name, null, null);

            for (ContentValues c:list){
                db.insert(DocsQtnContract.DocsQtnEntry.Questions_Table_Name, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e){

        }finally {
            db.endTransaction();
        }
    }
}
