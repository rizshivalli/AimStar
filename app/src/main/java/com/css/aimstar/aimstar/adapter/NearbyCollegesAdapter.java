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
import com.css.aimstar.aimstar.model.NearbyColleges;

import java.util.List;

public class NearbyCollegesAdapter extends RecyclerView.Adapter<NearbyCollegesAdapter.ViewHolder> {
    private List<NearbyColleges> nearbyColleges;
    private Context context;

    private String titlevar,imagevar;
    private String descriptionvar,path;

    public NearbyCollegesAdapter(Context applicationContext, List<NearbyColleges> nearbyCollegesList) {
        this.context = applicationContext;
        this.nearbyColleges = nearbyCollegesList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //public TextView title,description;
        public TextView title,description,path;
        public ImageView image;


        public ViewHolder(final View parent) {
            super(parent);

            title = (TextView) parent.findViewById(R.id.name);
            description = (TextView) parent.findViewById(R.id.description);
            image=(ImageView) parent.findViewById(R.id.image);

        }


       /* @Override
        public void onClick(View view) {
            Fragment2 descriptionFragment = new Fragment2();
            Bundle args = new Bundle();
            args.putString("title", titlevar);
            args.putString("description", descriptionvar);

            descriptionFragment.setArguments(args);
            MainActivity.fragmentManager.beginTransaction().replace(R.id.mainf, descriptionFragment, "null").addToBackStack(null).commit();

        }*/

        public void setScheduleData(NearbyColleges schedule) {
            this.title.setText(schedule.getTitle());
            titlevar = schedule.getTitle();
            this.description.setText(schedule.getDescription());
            descriptionvar = schedule.getDescription();
            //this.path.setText(schedule.getImage());
            //imagevar=schedule.getImage();
            // Glide.with(context).load(schedule.getImage()).into(image);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nearby_colleges_card, parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NearbyColleges row = nearbyColleges.get(position);
        holder.title.setText(row.getTitle());
        holder.description.setText(row.getDescription());

        // holder.path.setText(row.getImage());
        //String imageurl = row.getImage();
        // Log.i(TAG, "onBindViewHolder:" + imageurl);

        Glide.with(holder.image.getContext()).load(row.getImage()).into(holder.image);
        ViewHolder inHolder = (ViewHolder) holder;
        NearbyColleges schedule = (NearbyColleges) nearbyColleges.get(position);
        // Picasso.with(context).load(row.getImage()).into(holder.image);

        inHolder.setScheduleData(schedule);

    }

    @Override
    public int getItemCount() {
        return nearbyColleges.size();
    }
}
