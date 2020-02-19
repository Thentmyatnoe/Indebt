package com.example.indebt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.indebt.activity.BorrowerListActivity;
import com.example.indebt.activity.DebtListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_debt)
    TextView tvDebt;

    @BindView(R.id.tv_borrower)
    TextView tvBorrower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        tvDebt.setOnClickListener(this);
        tvBorrower.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_debt:
                Intent intent=new Intent(this, DebtListActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_borrower:
                Intent intent1=new Intent(this, BorrowerListActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }
}
