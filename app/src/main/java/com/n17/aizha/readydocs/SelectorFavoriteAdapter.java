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

import com.n17.aizha.readydocs.data.Description.DocsDsctnContract;

/**
 * Created by aizha on 16.08.2017.
 */

public class SelectorFavoriteAdapter extends RecyclerView.Adapter<SelectorFavoriteAdapter.ArticleViewHolder>{
    private static final String TAG = SelectorFavoriteAdapter.class.getSimpleName();

    final private SelectorFavoriteAdapter.ListItemClickListener mOnClickListener;
    private Cursor mCursor;
    private Context mContext;

    public SelectorFavoriteAdapter(Context context, Cursor cursor, ListItemClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
        this.mContext = context;
        this.mCursor = cursor;

        if (this.mCursor != null){
            Log.e("SelectFavoriteAdapter", String.valueOf(this.mCursor.getCount()));
        }else{
            Log.e("SelectFavoriteAdapter", "mCursor is null");
        }
    }
    public interface ListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutIDForListItem = R.layout.selector_list_question;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIDForListItem, parent, shouldAttachToParentImmediately);
        ArticleViewHolder viewHolder = new ArticleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)){
            return;
        }
        String qtn_id = mCursor.getString(mCursor.getColumnIndex(DocsDsctnContract.DocsDsctnEntry.COLUMN_Question_ID));
        String cat_id = mCursor.getString(mCursor.getColumnIndex(DocsDsctnContract.DocsDsctnEntry.COLUMN_Category_ID));
        String qtn_description = mCursor.getString(mCursor.getColumnIndex(DocsDsctnContract.DocsDsctnEntry.COLUMN_Question_Name));


        holder.questionDesc.setText(qtn_description);
        holder.importantiIcon.setImageResource(R.drawable.ic_important);
        holder.itemView.setTag(qtn_id);


    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor){
        if (mCursor!=null) mCursor.close();
        mCursor = newCursor;
        if (newCursor != null){
            this.notifyDataSetChanged();
        }
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView questionDesc;
        ImageView importantiIcon;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            questionDesc = (TextView) itemView.findViewById(R.id.questionTextView);
            importantiIcon = (ImageView) itemView.findViewById(R.id.questionIcon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);

        }
    }


}
