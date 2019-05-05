package com.mikeescom.dineout.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mikeescom.dineout.R;
import com.mikeescom.dineout.repo.dto.Collection;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CollectionRecyclerViewAdapter extends RecyclerView.Adapter<CollectionRecyclerViewAdapter.CollectionViewHolder> {
    private final Context context;
    private List<Collection> items;
    private final OnItemClickListener listener;

    public CollectionRecyclerViewAdapter(Context context, List<Collection> items, OnItemClickListener listener) {
        this.items = items;
        this.context = context;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @Override
    public CollectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collection, parent, false);
        return new CollectionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CollectionViewHolder holder, int position) {
        Collection item = items.get(position);
        holder.set(context,item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public static class CollectionViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewCollectionBanner;
        TextView textViewCollectionTitle;
        TextView textViewCollectionDesc;

        public CollectionViewHolder(View itemView) {
            super(itemView);
            imageViewCollectionBanner = itemView.findViewById(R.id.image_view_collection_banner);
            textViewCollectionTitle = itemView.findViewById(R.id.text_view_collection_title);
            textViewCollectionDesc  = itemView.findViewById(R.id.text_view_collection_desc);
        }

        public void set(Context context, Collection item) {
            //UI setting code
            Picasso.get().load(item.getImageUrl()).into(imageViewCollectionBanner);
            textViewCollectionTitle.setText(context.getString(R.string.placeholder_collection_title, item.getTitle()));
            textViewCollectionDesc.setText(context.getString(R.string.placeholder_collection_desc, item.getDescription()));
        }
    }
}
