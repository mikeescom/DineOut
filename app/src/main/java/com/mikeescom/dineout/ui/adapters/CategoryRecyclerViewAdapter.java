package com.mikeescom.dineout.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikeescom.dineout.R;
import com.mikeescom.dineout.repo.dto.Category;

import java.util.List;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryViewHolder>{
    private final Context context;
    private List<Category> items;

    public CategoryRecyclerViewAdapter(Context context, List<Category> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Category item = items.get(position);
        holder.set(context,item);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCategoryId;
        TextView textViewCategoryName;

        public CategoryViewHolder(View itemView) {
            super(itemView);

            textViewCategoryId = itemView.findViewById(R.id.text_view_category_id);
            textViewCategoryName  = itemView.findViewById(R.id.text_view_category_name);
        }

        public void set(Context context, Category item) {
            //UI setting code
            textViewCategoryId.setText(context.getString(R.string.placeholder_category_id, item.getId()));
            textViewCategoryName.setText(context.getString(R.string.placeholder_category_name, item.getName()));
        }
    }
}
