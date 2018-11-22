package com.saif.flickertask.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.saif.flickertask.R;
import com.saif.flickertask.models.Photo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlickerAdapter extends RecyclerView.Adapter{
    private final Context mContext;
    private final ArrayList<Photo> photos;


    public FlickerAdapter(Context mContext, ArrayList<Photo> photos) {
        this.mContext = mContext;
        this.photos = photos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_flicker,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            Photo photo = photos.get(position);
        ((viewHolder) holder).txtFlickerTitle.setText(photo.getTitle());
        String image = photo.getImage();
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.image_loader);
        if (image!=null){
            Glide.with(mContext)
                    .load(image).apply(requestOptions).into(((viewHolder) holder).imgFlicker);
        }

    }

    @Override
    public int getItemCount() {
        return   photos.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_flicker_title)TextView txtFlickerTitle;
        @BindView(R.id.img_flicker)
        ImageView imgFlicker;
        public viewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }

}

