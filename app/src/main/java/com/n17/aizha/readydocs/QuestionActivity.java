package com.n17.aizha.readydocs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.n17.aizha.readydocs.data.Question.DocsQtnContract;
import com.n17.aizha.readydocs.data.Question.QtnTestUtil;
import com.n17.aizha.readydocs.data.Question.DocsQtnDBHelper;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity  implements SelectorQtnAdapter.ListItemClickListener{

    private static final String TAG = QuestionActivity.class.getSimpleName();
    
    private  SelectorQtnAdapter mAdapter;
    private SQLiteDatabase mDb;
    private String extra_ln;
    private String qtn_name;
    ArrayList<String> qtn_description = new ArrayList<String>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        RecyclerView mRecyclerView;
        
        mRecyclerView = (RecyclerView) this.findViewById(R.id.middleRecyclerView);

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


        String id = getIntent().getStringExtra("id");

        Cursor cursor = getAllQtn(id);
        if (cursor.moveToFirst()){
            do{
                qtn_name = cursor.getString(cursor.getColumnIndex(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description));
                qtn_description.add(qtn_name);

            }while (cursor.moveToNext());
        }

        mAdapter = new SelectorQtnAdapter(this, cursor, this);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("id", String.valueOf(clickedItemIndex));
        intent.putExtra("category_id", getIntent().getStringExtra("cat_id"));
        intent.putExtra("language", extra_ln);


        intent.putExtra("qtn_description_name", qtn_description.get(clickedItemIndex));

        startActivity(intent);
        //Toast.makeText(this, "You clicked " + clickedItemIndex, Toast.LENGTH_LONG).show();
        
    }

;
    public Cursor getAllQtn(String id) {
        return mDb.rawQuery("SELECT * FROM " + DocsQtnContract.DocsQtnEntry.Questions_Table_Name+
                " WHERE " + DocsQtnContract.DocsQtnEntry.COLUMN_Category_ID + " = '" + id + "' ;", null);
    }
    public Cursor getQtnDescription(String qtn_id){
        return mDb.rawQuery("SELECT * FROM " + DocsQtnContract.DocsQtnEntry.Questions_Table_Name+
                " WHERE " + DocsQtnContract.DocsQtnEntry.COLUMN_QTN_ID + " = '" + qtn_id + "' ;", null);
    }
}
