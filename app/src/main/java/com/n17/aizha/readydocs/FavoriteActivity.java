package com.n17.aizha.readydocs;

import android.app.DownloadManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.n17.aizha.readydocs.data.Description.DocsDsctnContract;
import com.n17.aizha.readydocs.data.Description.DocsDsctnDBHelper;
import com.n17.aizha.readydocs.data.Question.DocsQtnContract;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity implements SelectorFavoriteAdapter.ListItemClickListener{

    private static final String TAG = FavoriteActivity.class.getSimpleName();

    private SelectorFavoriteAdapter mAdapter;
    private SQLiteDatabase mDb;
    private String extra_ln;
    private Cursor mCursor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        RecyclerView mRecyclerView;

        extra_ln = getIntent().getStringExtra("language");

        mRecyclerView = (RecyclerView) this.findViewById(R.id.favoriteRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        DocsDsctnDBHelper dbHelper = new DocsDsctnDBHelper(this);
        mDb = dbHelper.getWritableDatabase();
        Cursor cursor = getALL(extra_ln);
        mAdapter = new SelectorFavoriteAdapter(this, cursor, this);
        mRecyclerView.setAdapter(mAdapter);



    }




    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent = new Intent(this, DescriptionActivity.class);
        ArrayList<String> id = new ArrayList<String>();
        ArrayList<String> qtn_description = new ArrayList<String>();
        ArrayList<String> cat_id = new ArrayList<String>();
        Cursor mCursor = getALL(extra_ln);
        if (mCursor.moveToFirst()) {
            do {

                String qtn_id = mCursor.getString(mCursor.getColumnIndex(DocsDsctnContract.DocsDsctnEntry.COLUMN_Question_ID));
                String category_id = mCursor.getString(mCursor.getColumnIndex(DocsDsctnContract.DocsDsctnEntry.COLUMN_Category_ID));
                String qtn_name = mCursor.getString(mCursor.getColumnIndex(DocsDsctnContract.DocsDsctnEntry.COLUMN_Question_Name));
                id.add(qtn_id);
                cat_id.add(category_id);
                qtn_description.add(qtn_name);



            }while (mCursor.moveToNext());
            intent.putExtra("id", id.get(clickedItemIndex));
            intent.putExtra("category_id", cat_id.get(clickedItemIndex));
            intent.putExtra("qtn_description_name", qtn_description.get(clickedItemIndex));
            intent.putExtra("language", extra_ln);
            startActivity(intent);
        }



    }
    private Cursor getAllFavorites() {
        return mDb.query(DocsDsctnContract.DocsDsctnEntry.Description_Table_Name,
                null,
                null,
                null,
                null,
                null,
                DocsDsctnContract.DocsDsctnEntry.COLUMN_Timest);
    }
    private Cursor getALL(String ln){
        return mDb.rawQuery("SELECT * FROM " + DocsDsctnContract.DocsDsctnEntry.Description_Table_Name+
                " WHERE " + DocsDsctnContract.DocsDsctnEntry.COLUMN_LN+ " = '" + ln + "' ;", null);
    }
    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        mAdapter.swapCursor(getALL(extra_ln));
        mAdapter.notifyDataSetChanged();

    }

    public void swapCursor(Cursor newCursor){
        if (mCursor!=null) mCursor.close();
        mCursor = newCursor;
        if (newCursor != null){
            mAdapter.notifyDataSetChanged();
        }
    }



}
