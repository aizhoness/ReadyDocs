package com.n17.aizha.readydocs;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.n17.aizha.readydocs.data.Description.DocsDsctnContract;
import com.n17.aizha.readydocs.data.Description.DocsDsctnDBHelper;
import com.n17.aizha.readydocs.data.Question.DocsQtnContract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DescriptionActivity extends AppCompatActivity implements SelectorFavoriteAdapter.ListItemClickListener{

    String organization_name;
    String extra_ln;
    String result;
    String cat_id;
    String qtn_name;
    private android.support.v7.widget.ShareActionProvider shareActionProvider;
    String file_name;
    String id;
    Toast mToast;
    private SQLiteDatabase mDB;
    private SelectorFavoriteAdapter mAdapter;
    private final static String LOG_TAG = DescriptionActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        DocsDsctnDBHelper dbHelper = new DocsDsctnDBHelper(this);//*DATABASE
        mDB = dbHelper.getWritableDatabase();
        Cursor cursor = getAllFavorites();

        mAdapter = new SelectorFavoriteAdapter(this, cursor, this);


        TextView organizationName = (TextView) findViewById(R.id.organizationTextView);
        ImageView organizationLogo = (ImageView) findViewById(R.id.logoImageView);
        TextView documentsTextView = (TextView) findViewById(R.id.documents_tv);

        ArrayList<String> qtn_id_array = new ArrayList<>();
        ArrayList<String> qtn_description = new ArrayList<String>();
        ArrayList<String> cat_id_array = new ArrayList<>();


        String clickedItemIndex = getIntent().getStringExtra("clickedIndex");
        qtn_id_array = getIntent().getStringArrayListExtra("id_array");
        cat_id_array = getIntent().getStringArrayListExtra("cat_id_array");
        qtn_description = getIntent().getStringArrayListExtra("qtn_description");
        extra_ln = getIntent().getStringExtra("language");


        if (qtn_id_array!=null && cat_id_array!=null && qtn_description!=null){
            cat_id = cat_id_array.get(Integer.parseInt(clickedItemIndex));
            id = qtn_id_array.get(Integer.parseInt(clickedItemIndex));
            qtn_name = qtn_description.get(Integer.parseInt(clickedItemIndex));


        }else{
            cat_id = getIntent().getStringExtra("category_id");
            Log.e("CAT_ID", cat_id);
            id = getIntent().getStringExtra("id");
            Log.e("ID", id);
            qtn_name = getIntent().getStringExtra("qtn_description_name");

        }







        if (cat_id.equals("0")){
            organizationLogo.setImageResource(R.drawable.taxation_logo);

            if (extra_ln.equals("ru")){
                organization_name = "Департамент Государственных Доходов";
                file_name = "taxation" + id+".txt";
            }else{
                organization_name = "Ішкі кірістер департаменті";
                file_name = "taxation" + id+"kz.txt";
            }

        }
        if (cat_id.equals("1")){
            organizationLogo.setImageResource(R.drawable.energy_station_logo);

            if (extra_ln.equals("ru")){
                organization_name = "Энергосбыт";
                file_name = "energy_station" + id+".txt";}
            else {
                organization_name = "Энергосбыт";
                file_name = "energy_station" + id+"kz.txt";
            }
        }
        if (cat_id.equals("2")){
            organizationLogo.setImageResource(R.drawable.doki_logo);

            if (extra_ln.equals("ru")){
                organization_name = "Бюро Технической Инвентаризации";
                file_name = "doki" + id+".txt";}
            else {
                organization_name = "Мүлікті түгендеу бюросы";
                file_name = "doki" + id+"kz.txt";
            }

        }
        if (cat_id.equals("3")){
            organizationLogo.setImageResource(R.drawable.spec_con_logo);

            if (extra_ln.equals("ru")){
                organization_name = "Специализированный ЦОН";
                file_name = "police_car" + id+".txt";}
            else {
                organization_name = "Мамандандырылған ХҚКО";
                file_name = "police_car" + id+"kz.txt";
            }

        }
        if (cat_id.equals("4")){
            organizationLogo.setImageResource(R.drawable.water_station_logo);

            if (extra_ln.equals("ru")){
                organization_name = "Горводоканал";
                file_name = "water_station" + id+".txt";}
            else {
                organization_name = "Қалалық су құбыры";
                file_name = "water_station" + id+"kz.txt";
            }

        }
        if (cat_id.equals("5")){
            organizationLogo.setImageResource(R.drawable.embassy_logo);

            if (extra_ln.equals("ru")){
                organization_name = "Посольство";
                file_name = "embassy" + id+".txt";}
            else {
                organization_name = "Елшілік үйі";
                file_name = "embassy" + id+"kz.txt";
            }
        }
        if (cat_id.equals("6")){
            organizationLogo.setImageResource(R.drawable.home_logo);

            if (extra_ln.equals("ru")){
                organization_name = "Доступное жилье";
                file_name = "home" + id+".txt";}
            else {
                organization_name = "Қолжетімді тұрғын үй";
                file_name = "home" + id+"kz.txt";
            }
        }
        if (cat_id.equals("7")){
            organizationLogo.setImageResource(R.drawable.marriage_logo);

            if (extra_ln.equals("ru")){
                organization_name = "ЗАГС";
                file_name = "marriage" + id+".txt";}
            else {
                organization_name = "АХАЖ";
                file_name = "marriage" + id+"kz.txt";
            }
        }
        //////TXT FILE READ

        AssetManager assetManager = getAssets();


        // To load text file
        InputStream input = null;
        result = "";
        try {

            input = assetManager.open(file_name);
            InputStreamReader inputreader = new InputStreamReader(input);
            BufferedReader buffreader = new BufferedReader(inputreader);
            String line;
            do {
                line = buffreader.readLine();
                if (line!=null){
                    result = result + line + "\n";

                }


                // do something with the line
            } while (line != null);

        }catch (Exception e){

        }finally {
            try {
                input.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        documentsTextView.setText(result);
        organizationName.setText(organization_name);


    }

    private long addToFavorites(String id, String category_id, String question_name){
        ContentValues cv = new ContentValues();
        cv.put(DocsDsctnContract.DocsDsctnEntry.COLUMN_Category_ID, category_id);
        cv.put(DocsDsctnContract.DocsDsctnEntry.COLUMN_Question_ID, id);
        cv.put(DocsDsctnContract.DocsDsctnEntry.COLUMN_Question_Name, question_name);
        cv.put(DocsDsctnContract.DocsDsctnEntry.COLUMN_LN, extra_ln);

        return mDB.insert(DocsDsctnContract.DocsDsctnEntry.Description_Table_Name, null, cv);

    }
    public boolean removeFavorites(String qtn_desc){
        return mDB.delete(DocsDsctnContract.DocsDsctnEntry.Description_Table_Name, DocsDsctnContract.DocsDsctnEntry.COLUMN_Question_Name+" = '" + qtn_desc + "' ", null)>0;
    }
    private Cursor getAllFavorites(){
        return mDB.query(DocsDsctnContract.DocsDsctnEntry.Description_Table_Name,
                null,
                null,
                null,
                null,
                null,
                DocsDsctnContract.DocsDsctnEntry.COLUMN_Timest);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        MenuItem menuItem = menu.findItem(R.id.share_action);
//        shareActionProvider = (android.support.v7.widget.ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
//        setIntent("This is example text");
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    private void setIntent(String text) {
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        intent.putExtra(Intent.EXTRA_TEXT, text);
//        shareActionProvider.setShareIntent(intent);
//    }
@Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_description, menu);
            Cursor mCursor = mDB.rawQuery("SELECT * FROM " + DocsDsctnContract.DocsDsctnEntry.Description_Table_Name+
                " WHERE " + DocsDsctnContract.DocsDsctnEntry.COLUMN_Question_Name+ " = '" + qtn_name + "' ;", null);
        MenuItem favorite_icon = menu.getItem(0);


        if(mCursor.getCount()==0){

            favorite_icon.setIcon(getResources().getDrawable(R.drawable.ic_empty_like));




        }else {
            favorite_icon.setIcon(getResources().getDrawable(R.drawable.ic_like));


        }






        return super.onCreateOptionsMenu(menu);

    }
    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_share:


                Intent  i = new Intent(android.content.Intent.ACTION_SEND);

                i.setType("text/plain");

                i.putExtra(android.content.Intent.EXTRA_TEXT, result);

                startActivity(Intent.createChooser(i, qtn_name));

                break;
            case R.id.action_favorite:

                Cursor mCursor = mDB.rawQuery("SELECT * FROM " + DocsDsctnContract.DocsDsctnEntry.Description_Table_Name+
                        " WHERE " + DocsDsctnContract.DocsDsctnEntry.COLUMN_Question_Name+ " = '" + qtn_name + "' ;", null);


                if(mCursor.getCount()==0){
                    item.setIcon(getResources().getDrawable(R.drawable.ic_like));
                    addToFavorites(id, cat_id, qtn_name);
                    mAdapter.swapCursor(getAllFavorites());
                    Log.e("HAHA EGO TAM NET", String.valueOf(mCursor.getCount()));


                    //////////////********************TOAST!!!
                    Context context = getApplicationContext();
                    CharSequence text = "Добавлено в список избранных!";
                    int duration = Toast.LENGTH_SHORT;

                    if (extra_ln.equals("kz")){
                        text = "Маңыздыларға қосылды!";

                    }
                    if (mToast != null) {
                        mToast.cancel();
                    }



                    mToast = Toast.makeText(context, text, duration);
                    mToast.show();



                }else {
                    item.setIcon(getResources().getDrawable(R.drawable.ic_empty_like));
                    Log.e("HAHA UJE EST", String.valueOf(mCursor.getCount()));
                    removeFavorites(qtn_name);
                    mAdapter.swapCursor(getAllFavorites());
                    ////////**********************TOAST!!!
                    Context context = getApplicationContext();
                    CharSequence text = "Удалено из списка избранных!";
                    int duration = Toast.LENGTH_SHORT;

                    if (extra_ln.equals("kz")){
                        text = "Маңыздылардан жойылды!";

                    }
                    if (mToast != null) {
                        mToast.cancel();
                    }



                    mToast = Toast.makeText(context, text, duration);
                    mToast.show();



                }





        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
