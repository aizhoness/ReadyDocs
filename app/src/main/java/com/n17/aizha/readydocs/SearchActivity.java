package com.n17.aizha.readydocs;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.n17.aizha.readydocs.data.Question.DocsQtnContract;
import com.n17.aizha.readydocs.data.Question.DocsQtnDBHelper;
import com.n17.aizha.readydocs.data.Question.QtnTestUtil;

import java.util.ArrayList;

import static android.R.attr.id;
import static android.R.attr.text;

public class SearchActivity extends AppCompatActivity implements SelectorQtnAdapter.ListItemClickListener,
        SearchView.OnQueryTextListener{
    private static final String TAG = SearchActivity.class.getSimpleName();

    private  SelectorQtnAdapter mAdapter;
    private SQLiteDatabase mDb;
    private String extra_ln;
    private TextView textView;
    private android.support.v7.widget.SearchView searchView;
    RecyclerView mRecyclerView;
    private String text_search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



        textView = (TextView) findViewById(R.id.search_hint);
        searchView = (SearchView) findViewById(R.id.searchView);

        searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) this);


    }




    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        text_search = newText;
        Log.e("TEXTSEARCh", text_search);

        mRecyclerView = (RecyclerView) this.findViewById(R.id.searchRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        DocsQtnDBHelper dbHelper = new DocsQtnDBHelper(this);
        mDb = dbHelper.getWritableDatabase();

        extra_ln = getIntent().getStringExtra("language");
        if (extra_ln.equals("kz")){
            QtnTestUtil.insertQtnDataKZ(mDb);
        }else{
            QtnTestUtil.insertQtnData(mDb);
        }
        Cursor cursor = searchQtn(newText);///********************************************************METHOD



        mAdapter = new SelectorQtnAdapter(this, cursor, this);
        mRecyclerView.setAdapter(mAdapter);



        textView.setText(newText);
        return false;
    }
    @Override
    public void onListItemClick(int clickedItemIndex) {
        Log.e("Clicked id wait", String.valueOf(clickedItemIndex));

        ArrayList<String> id = new ArrayList<String>();
        ArrayList<String> qtn_description = new ArrayList<String>();
        ArrayList<String> cat_id = new ArrayList<String>();
        Cursor cursor = searchQtn(text_search);
        Log.e("CURSOR", String.valueOf(cursor.getCount()));
        if (cursor.moveToFirst()){
            do

            {
                String qtn_id = cursor.getString(cursor.getColumnIndex(DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID));
                Log.e("ID_ARRAY", String.valueOf(qtn_id));
                String qtn_cat_id = cursor.getString(cursor.getColumnIndex(DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID));
                Log.e("CAT_ARRAY", String.valueOf(qtn_cat_id));
                String qtn_name = cursor.getString(cursor.getColumnIndex(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description));
                qtn_description.add(qtn_name);
                id.add(qtn_id);
                cat_id.add(qtn_cat_id);
            }while(cursor.moveToNext());}
        Intent intent = new Intent(this, DescriptionActivity.class);

        intent.putStringArrayListExtra("cat_id_array", cat_id);
        intent.putStringArrayListExtra("id_array", id);
        intent.putStringArrayListExtra("qtn_description", qtn_description);
        intent.putExtra("language", extra_ln);


        intent.putExtra("clickedIndex", String.valueOf(clickedItemIndex));
        startActivity(intent);
    }



    public Cursor searchQtn(String id) {
        return mDb.rawQuery("SELECT * FROM " + DocsQtnContract.DocsQtnEntry.Questions_Table_Name+
               " WHERE " + DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description + " LIKE '%" + id + "%' ;", null);
    }
}
