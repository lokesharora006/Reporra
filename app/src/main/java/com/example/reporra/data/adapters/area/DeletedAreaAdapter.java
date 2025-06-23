package com.example.reporra.data.adapters.area;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reporra.data.model.AreaModel;

import java.util.ArrayList;
import java.util.List;

public class DeletedAreaAdapter extends RecyclerView.Adapter<DeletedAreaAdapter.AreaViewHolder> implements Filterable {

    private List<AreaModel> areaList;
    private List<AreaModel> areaListFull;

    public DeletedAreaAdapter(List<AreaModel> areaList) {
        this.areaList = areaList;
        this.areaListFull = new ArrayList<>(areaList); // for filtering
    }

    @NonNull
    @Override
    public AreaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_deleted_area, parent, false);
        return new AreaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AreaViewHolder holder, int position) {
        AreaModel area = areaList.get(position);
        holder.txtAreaName.setText(area.getAreaName());
    }

    @Override
    public int getItemCount() {
        return areaList.size();
    }

    public static class AreaViewHolder extends RecyclerView.ViewHolder {
        TextView txtAreaName;

        public AreaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAreaName = itemView.findViewById(R.id.txtAreaName);
        }
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private final Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<AreaModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(areaListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (AreaModel item : areaListFull) {
                    if (item.getAreaName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            areaList.clear();
            areaList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}