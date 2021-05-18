package com.codingcrew.audify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingcrew.audify.R;
import com.codingcrew.audify.model.Audio;

import java.util.ArrayList;

public class AudioRecyclerViewAdapter extends RecyclerView.Adapter<AudioRecyclerViewAdapter.VIewHolder> {

    private Context mContext;
    private ArrayList<Audio> mAudios;

    public AudioRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
        mAudios = new ArrayList<>();
    }

    public void setAudios(ArrayList<Audio> mAudios) {
        this.mAudios = mAudios;
    }

    @NonNull
    @Override
    public VIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new VIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VIewHolder holder, int position) {
        holder.title.setText(mAudios.get(position).getName());
        holder.artist.setText(mAudios.get(position).getArtist());
        holder.playCount.setText(String.valueOf(mAudios.get(position).getPlayCount()));
    }

    @Override
    public int getItemCount() {
        return mAudios.size();
    }

    public class VIewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView artist;
        TextView playCount;
        ImageView playImage;
        RelativeLayout relativeParent;

        public VIewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            artist = itemView.findViewById(R.id.artist);
            playCount = itemView.findViewById(R.id.play_count);

            playImage = itemView.findViewById(R.id.play);

            relativeParent = itemView.findViewById(R.id.relative_parent);

        }
    }
}
