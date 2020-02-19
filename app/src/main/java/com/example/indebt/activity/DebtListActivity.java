package com.example.indebt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indebt.MainActivity;
import com.example.indebt.R;
import com.example.indebt.adapter.DebtListAdapter;
import com.example.indebt.database.AppDatabase;
import com.example.indebt.database.AppDatabaseUtility;
import com.example.indebt.database.dao.CustomerDAO;
import com.example.indebt.database.model.Customer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DebtListActivity extends AppCompatActivity {

    @BindView(R.id.fb_add_debt)
    FloatingActionButton fbAddDebt;

    @BindView(R.id.debt_list_recycler)
    RecyclerView debtListRecycler;

    AppDatabase appDatabase;
    CustomerDAO customerDAO;

    private List<Customer> customerList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt_list);
        getSupportActionBar().setTitle("အကြွေးစာရင်း");
        ButterKnife.bind(this);

        appDatabase= AppDatabaseUtility.getAppDatabase(this);
        customerDAO=appDatabase.getCustomerDAO();
        customerList=customerDAO.getAllCustomer();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        debtListRecycler.setLayoutManager(linearLayoutManager);

        DebtListAdapter adapter = new DebtListAdapter(DebtListActivity.this, customerList);
        debtListRecycler.setAdapter(adapter);

        fbAddDebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DebtListActivity.this, AddDebtActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        gotoMainActivity();
    }

    private void gotoMainActivity(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
