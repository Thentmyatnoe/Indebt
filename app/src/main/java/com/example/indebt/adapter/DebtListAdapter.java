package com.example.indebt.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.indebt.R;
import com.example.indebt.database.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DebtListAdapter extends RecyclerView.Adapter<DebtListAdapter.TasksViewHolder> {
    private Context mCtx;
    private List<Customer> myList;
    private ArrayList<String> myOrderList;
    public DebtListAdapter(Context mCtx, List<Customer> myList) {
        this.mCtx = mCtx;
        this.myList = myList;
    }

    @Override
    public DebtListAdapter.TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.debt_item_list, parent, false);

        return new DebtListAdapter.TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DebtListAdapter.TasksViewHolder holder, int position) {
        Customer tech = myList.get(position);

        holder.tvname.setText(tech.getCustomerName());
        holder.phone.setText(tech.getPhoneNo());

    }

    @Override
    public int getItemCount() {

        //return student.size();
        if (myList.size() > 0) {
            return myList.size();
        }
        else return 0;
    }


    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvname,amount,phone;

        public TasksViewHolder(View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.tv_cus_name_info);
            amount=itemView.findViewById(R.id.tv_amount);
            phone = itemView.findViewById(R.id.tv_phone);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }

    }
}
