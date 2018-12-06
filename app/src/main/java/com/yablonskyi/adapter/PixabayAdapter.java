package com.yablonskyi.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yablonskyi.R;
import com.yablonskyi.model.Hit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PixabayAdapter  extends RecyclerView.Adapter<PixabayAdapter.PixabayViewHolder> {
    ArrayList<Hit> photos;
    public PixabayAdapter(ArrayList<Hit> photos) {
        this .photos = photos;
    }

    @Override
    public PixabayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_list_item, parent, false);
        return new PixabayViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PixabayViewHolder holder, int position) {
        holder.tags.setText(photos.get(position).getTags());
        holder.user.setText(photos.get(position).getUser());
        Picasso.get().load(photos.get(position).getLargeImageURL()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void clear() {
        photos.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(ArrayList<Hit> list) {
        photos.addAll(list);
        notifyDataSetChanged();
    }

    public class PixabayViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.cv) CardView cardView;
        @BindView(R.id.tags) TextView tags;
        @BindView(R.id.user) TextView user;
        @BindView(R.id.image) ImageView image;
        public PixabayViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
