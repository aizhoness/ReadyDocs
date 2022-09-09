package com.n17.aizha.readydocs;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.n17.aizha.readydocs.data.Question.DocsQtnContract;

/**
 * Created by aizha on 26.07.2017.
 */

public class SelectorQtnAdapter extends RecyclerView.Adapter<SelectorQtnAdapter.ArticViewHolder>{
    private static final  String TAG = SelectorQtnAdapter.class.getSimpleName();

    final private SelectorQtnAdapter.ListItemClickListener mOnClickListener;
    private Cursor mCursor;
    private Context mContext;

    public SelectorQtnAdapter(Context context, Cursor cursor, ListItemClickListener mOnClickListener){
        this.mOnClickListener = mOnClickListener;
        this.mContext = context;
        this.mCursor = cursor;

        if (this.mCursor != null)
            Log.e("SelectQtnAdapter ", String.valueOf(this.mCursor.getCount()));
        else
            Log.e("SelectQtnAdapter ", "mCursor is null");
    }

    public interface ListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }

    @Override
    public ArticViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutIDForListItem = R.layout.selector_list_question;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIDForListItem, parent, shouldAttachToParentImmediately);

        ArticViewHolder viewHolder = new ArticViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ArticViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)){
            return;
        }

            String question_description = mCursor.getString(mCursor.getColumnIndex(DocsQtnContract.DocsQtnEntry.COLUMN_Question_Description));
            long id = mCursor.getLong(mCursor.getColumnIndex(DocsQtnContract.DocsQtnEntry._ID));
            Log.e("ID", String.valueOf(id));
            Log.e("Description", question_description);

            holder.questionDescription.setText(question_description);
            holder.itemView.setTag(id);}




    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
    public void swapCursor(Cursor newCursor){
        if(mCursor != null) mCursor.close();
        mCursor = newCursor;
        if (newCursor != null){
            notifyDataSetChanged();
        }
    }


    class ArticViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView questionDescription;

        public ArticViewHolder(View itemView) {
            super(itemView);
            questionDescription = (TextView) itemView.findViewById(R.id.questionTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);

        }
    }


}
