package com.mikeescom.dineout.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikeescom.dineout.R;
import com.mikeescom.dineout.repo.dto.Collection;

import java.util.List;

public class CollectionRecyclerViewAdapter extends RecyclerView.Adapter<CollectionRecyclerViewAdapter.CollectionViewHolder> {
    private final Context context;
    private List<Collection> items;

    public CollectionRecyclerViewAdapter(Context context, List<Collection> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public CollectionViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_collection, parent, false);
        return new CollectionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CollectionViewHolder holder, int position) {
        Collection item = items.get(position);
        holder.set(context,item);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public static class CollectionViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCollectionTitle;
        TextView textViewCollectionDesc;

        public CollectionViewHolder(View itemView) {
            super(itemView);

            textViewCollectionTitle = itemView.findViewById(R.id.text_view_collection_title);
            textViewCollectionDesc  = itemView.findViewById(R.id.text_view_collection_desc);
        }

        public void set(Context context, Collection item) {
            //UI setting code
            textViewCollectionTitle.setText(context.getString(R.string.placeholder_collection_title, item.getTitle()));
            textViewCollectionDesc.setText(context.getString(R.string.placeholder_collection_desc, item.getDescription()));
        }
    }
}
