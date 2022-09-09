package com.n17.aizha.readydocs.data.Category;

import android.provider.BaseColumns;

/**
 * Created by aizha on 21.07.2017.
 */

public class DocsContract {
    public static final class DocsEntry implements BaseColumns{
        public static final String Category_Table_Name = "Category";
        public static final String COLUMN_Category_Image = "categoryImage";
        public static final String COLUMN_Category_Name = "categoryName";
        public static final String COLUMN_Timestamp = "timestamp";


    }
}
