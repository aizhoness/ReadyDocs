package com.n17.aizha.readydocs.data.Question;

import android.provider.BaseColumns;

/**
 * Created by aizha on 24.07.2017.
 */

public class DocsQtnContract {

    public static final class DocsQtnEntry implements BaseColumns {

        public static final String Questions_Table_Name = "Questions";
        public static final String COLUMN_Category_ID = "category_id";
        public static final String COLUMN_Question_Description = "question_description";
        public static final String COLUMN_QTN_ID = "question_in_id";
        public static final String COLUMN_TimeStamp = "timestamp";



    }
}
