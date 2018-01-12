package com.example.shivam.recycle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Shivam on 12-01-2018.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.CustomViewHolder> {

    private List<FeedItem> feedItemList;
    private Context mContext;

    public MyRecyclerViewAdapter(Context context, List<FeedItem> feedItemList){
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        protected ImageView imageView;
        protected TextView textView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.thumbnail);
            this.textView = (TextView) itemView.findViewById(R.id.title);
        }
    }

    @Override
    public MyRecyclerViewAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.CustomViewHolder holder, int position) {

        FeedItem feedItem = feedItemList.get(position);
        //Render image using Picasso library
        if (!TextUtils.isEmpty(feedItem.getThumbnail())) {
            Picasso.with(mContext).load(feedItem.getThumbnail())
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(holder.imageView);
        }

        //Setting text view title
        holder.textView.setText(Html.fromHtml(feedItem.getTitle()));

    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }
}
