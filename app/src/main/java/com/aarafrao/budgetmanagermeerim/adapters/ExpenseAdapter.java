package com.aarafrao.budgetmanagermeerim.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aarafrao.budgetmanagermeerim.R;
import com.aarafrao.budgetmanagermeerim.models.ExpenseModel;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private List<ExpenseModel> incomeList;
    private Context context;

    public ExpenseAdapter(List<ExpenseModel> incomeList, Context context) {
        this.incomeList = incomeList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expense, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExpenseModel incomeModel = incomeList.get(position);
        holder.descriptionTextView.setText(incomeModel.getDescription());
        holder.amountTextView.setText("$" + String.valueOf(incomeModel.getAmount()));
        holder.dateTextView.setText(incomeModel.getDate());
        holder.catTextView.setText(incomeModel.getCat());
    }

    @Override
    public int getItemCount() {
        return incomeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView descriptionTextView;
        TextView amountTextView;
        TextView dateTextView;
        TextView catTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            amountTextView = itemView.findViewById(R.id.amountTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            catTextView = itemView.findViewById(R.id.catTextView);
        }
    }
}
