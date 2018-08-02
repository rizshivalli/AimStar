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
import com.css.aimstar.aimstar.model.CourseDetails;

import java.util.List;

public class CourseDetailsAdapter extends RecyclerView.Adapter {
    private List<CourseDetails> eventList;
    private Context context;
    public CourseDetailsAdapter(Context context, List<CourseDetails> eventList){
        this.eventList=eventList;
        this.context=context;
    }

    public ViewHolder onCreateViewHolder(ViewGroup Parent, int ViewType){
        View itemView= LayoutInflater.from(Parent.getContext()).inflate(R.layout.college_details_card,Parent,false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        ViewHolder inHolder=(ViewHolder)holder;
        CourseDetails schedule=(CourseDetails) eventList.get(position);
        inHolder.setScheduleData(schedule);

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
    {
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private String vartitle,VarDesc;
        public ImageView image;
        public TextView title,description;
        public ViewHolder(View view)
        {
            super(view);
            image=(ImageView)view.findViewById(R.id.imageId);
            title=(TextView)view.findViewById(R.id.titleId1);
            description=(TextView)view.findViewById(R.id.descriptionId);
            view.setOnClickListener(this);
        }
        public void setScheduleData(CourseDetails schedule)
        {
            this.title.setText(schedule.getTitle());
            vartitle=schedule.getTitle();
            this.description.setText(schedule.getDescription());
            VarDesc=schedule.getDescription();
            // Picasso.with(context).load(schedule.getImage()).into(image);
            Glide.with(context).load(schedule.getImage()).into(image);
        }

        @Override
        public void onClick(View view) {
            //  Intent intent=new Intent(context,Redirect_Activity.class);
            // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // intent.putExtra("title",vartitle);
            //  intent.putExtra("Desc",VarDesc);
            // context.startActivity(intent);

        }
    }
}
