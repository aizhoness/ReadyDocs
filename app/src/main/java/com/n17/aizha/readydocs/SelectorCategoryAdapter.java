package com.n17.aizha.readydocs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.n17.aizha.readydocs.data.Category.DocsContract;

/**
 * Created by aizha on 21.07.2017.
 */

public class SelectorCategoryAdapter extends RecyclerView.Adapter<SelectorCategoryAdapter.ArticleViewHolder> {

    private static final String TAG = SelectorCategoryAdapter.class.getSimpleName();

    final private ListItemClickListener mOnClickListener;
    private Cursor mCursor;
    private Context mContext;



    public SelectorCategoryAdapter(Context context, Cursor cursor, ListItemClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
        this.mContext = context;
        this.mCursor = cursor;

        if (this.mCursor != null)
            Log.e("SelectCategoryAd", String.valueOf(this.mCursor.getCount()));
        else
            Log.e("SelectCategoryAd", "mCursor is null");
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // Context context = parent.getContext();
        int layoutIdForListItem = R.layout.selector_list_category;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        ArticleViewHolder viewHolder =  new ArticleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        if(!mCursor.moveToPosition(position))
            return;
        String category_image = mCursor.getString(mCursor.getColumnIndex(DocsContract.DocsEntry.COLUMN_Category_Image));
        String category_name = mCursor.getString(mCursor.getColumnIndex(DocsContract.DocsEntry.COLUMN_Category_Name));

        long id = mCursor.getLong(mCursor.getColumnIndex(DocsContract.DocsEntry._ID));


        holder.categoryName.setText(category_name);
        holder.itemView.setTag(id);

        ///////VERNUT"SIA********************************************
        if(category_image.equals("taxation_icon")){
            holder.categoryImage.setImageResource(R.drawable.taxation_icon);
        }
        if(category_image.equals("energy_station_icon")){
            holder.categoryImage.setImageResource(R.drawable.energy_station_icon);
        }
        if(category_image.equals("doki_icon")){
            holder.categoryImage.setImageResource(R.drawable.doki_icon);
        }
        if(category_image.equals("police_car_icon")){
            holder.categoryImage.setImageResource(R.drawable.police_car_icon);
        }
        if(category_image.equals("water_station_icon")){
            holder.categoryImage.setImageResource(R.drawable.water_station_icon);
        }
        if(category_image.equals("embassy_icon")){
            holder.categoryImage.setImageResource(R.drawable.embassy_icon);
        }
        if(category_image.equals("home_icon")){
            holder.categoryImage.setImageResource(R.drawable.home_icon);
        }
        if(category_image.equals("marriage_icon")){
            holder.categoryImage.setImageResource(R.drawable.marriage_icon);
        }



    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor new_cursor){
        if (mCursor != null) mCursor.close();
        mCursor = new_cursor;
        if (new_cursor != null){
            this.notifyDataSetChanged();
        }
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView categoryImage;
        TextView categoryName;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            categoryImage = (ImageView) itemView.findViewById(R.id.category_icon);
            categoryName = (TextView) itemView.findViewById(R.id.categoryNameTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);


        }
    }
}
