package com.css.aimstar.aimstar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.css.aimstar.aimstar.R;
import com.css.aimstar.aimstar.model.Tweet;
import com.css.aimstar.aimstar.utils.CircleTransform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sirajm on 14/06/18.
 */

public class TweetListAdapter extends RecyclerView.Adapter<TweetListAdapter.TweetHolder> {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<Tweet> mTweetList;

    public TweetListAdapter(ArrayList<Tweet> tweets, Context context) {
        this.mTweetList =tweets;
        this.mContext =context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public TweetHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_card_tweet,parent,false);
        TweetHolder tweetHolder = new TweetHolder(view);
     //   setupClickableViews(view,tweetHolder);
        return tweetHolder;
    }

    @Override
    public void onBindViewHolder(TweetHolder holder, int position) {
        Tweet tweet = mTweetList.get(position);
        holder.profilename.setText(tweet.getName());
        holder.tweets.setText(tweet.getTweet());
        Glide.with(holder.profilepic.getContext()).load(tweet.getProfilePic())
                .centerCrop().transform(new CircleTransform(mContext))
                .into(holder.profilepic);
//        Glide.with(holder.profilepic.getContext()).load(tweet.getProfilePic()).into(holder.profilepic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mTweetList.size();
    }

    public class TweetHolder extends RecyclerView.ViewHolder {
        private TextView profilename, tweets;
        private ImageView profilepic;
        public TweetHolder(View itemView) {
            super(itemView);
            profilename =(TextView) itemView.findViewById(R.id.profilename);
            tweets =(TextView) itemView.findViewById(R.id.tweetText);
            profilepic =(ImageView) itemView.findViewById(R.id.profileImageView);
        }
    }
}
