package com.n17.aizha.readydocs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.text.method.ArrowKeyMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.n17.aizha.readydocs.data.Category.CategoryTestUtil;
import com.n17.aizha.readydocs.data.Category.DocsContract;
import com.n17.aizha.readydocs.data.Category.DocsDBHelper;
import com.n17.aizha.readydocs.data.Question.DocsQtnContract;
import com.n17.aizha.readydocs.data.Question.DocsQtnDBHelper;
import com.n17.aizha.readydocs.data.Question.QtnTestUtil;

public class MainActivity extends AppCompatActivity implements SelectorCategoryAdapter.ListItemClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private ShareActionProvider shareActionProvider;


    private SelectorCategoryAdapter mAdapter;
    private SQLiteDatabase mDb;
    private String extra_ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView mRecyclerView;


        mRecyclerView = (RecyclerView) this.findViewById(R.id.mainRecyclerView);


//
//        ////////
//        final int inType = search_edit.getInputType(); // backup the input type
//        search_edit.setInputType(InputType.TYPE_NULL);
//        /////


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);



        final DocsDBHelper dbHelper = new DocsDBHelper(this);

        mDb = dbHelper.getWritableDatabase();
        ///
        extra_ln = getIntent().getStringExtra("language");
        if (extra_ln.equals("kz")){
            CategoryTestUtil.insertToCategoryKZ(mDb);
        }else {
            CategoryTestUtil.insertToCategory(mDb);
        }
        ///////



        Cursor cursor = getAllCategory();


        mAdapter = new SelectorCategoryAdapter(this, cursor, this);
        mRecyclerView.setAdapter(mAdapter);
//        search_edit.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                final int DRAWABLE_LEFT = 0;
//                final int DRAWABLE_TOP = 1;
//                final int DRAWABLE_RIGHT = 2;
//                final int DRAWABLE_BOTTOM = 3;
//
//                if(event.getAction() == MotionEvent.ACTION_UP) {
//                    if (event.getRawX() <= (search_edit.getLeft() + search_edit.getCompoundDrawables()[DRAWABLE_LEFT].getBounds().width())) {
//                        Log.e("EEE", search_edit.getText().toString());
//                        search_edit.clearFocus();
//
//
//                        return true;
//                    }else if(event.getRawX() >= search_edit.getRight() - search_edit.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width()){
//                        Log.e("CLEAR", "NULL");
//                        search_edit.setText("");
//                        search_edit.clearFocus();
//                    }else{
//
//                        search_edit.onTouchEvent(event); // call native handler
//                        search_edit.setInputType(inType); // restore input type
//                        Log.e("ELSE", "NULO");
//                        return true;
//
//
//                    }
//                }
//                return false;
//            }
//        });
    }


    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("id", String.valueOf(clickedItemIndex));
        intent.putExtra("cat_id", String.valueOf(clickedItemIndex));
        intent.putExtra("language", extra_ln);
        startActivity(intent);
        //Toast.makeText(this, "You clicked" + clickedItemIndex, Toast.LENGTH_LONG).show();

    }


    private Cursor getAllCategory() {
        return mDb.query(DocsContract.DocsEntry.Category_Table_Name,
                null,
                null,
                null,
                null,
                null,
                DocsContract.DocsEntry.COLUMN_Timestamp);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_search:

                //Code to run when the Create Order item is clicked
                Intent intent = new Intent(this, SearchActivity.class);
                intent.putExtra("language", extra_ln);
                startActivity(intent);
                return true;

            case R.id.action_favorites:
                Intent intentFavorites = new Intent(this, FavoriteActivity.class);
                intentFavorites.putExtra("language", extra_ln);
                startActivity(intentFavorites);

                return true;
            case R.id.action_settings:
                //Code to run when the settings item is clicked
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
