package com.example.indebt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.indebt.R;
import com.example.indebt.database.AppDatabase;
import com.example.indebt.database.AppDatabaseUtility;
import com.example.indebt.database.dao.CustomerDAO;
import com.example.indebt.database.dao.LoanDAO;
import com.example.indebt.database.model.Customer;
import com.example.indebt.database.model.Loan;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddDebtActivity extends AppCompatActivity {

    @BindView(R.id.edt_userName_info)
    EditText edtName;

    @BindView(R.id.edt_phone_info)
    EditText edtPhone;

    @BindView(R.id.edt_address_info)
    EditText edtAddress;

    @BindView(R.id.edt_nrc_no_info)
    EditText edtNRC;

    @BindView(R.id.sp_category)
    Spinner spCategory;

    @BindView(R.id.tv_interest_info)
    TextView tvInterestInfo;

    @BindView(R.id.edt_open_balance)
    EditText edtOpenBalance;

    @BindView(R.id.edt_agreement)
    EditText edtAgreement;

    @BindView(R.id.btn_cancel)
    Button btnCancel;

    @BindView(R.id.btn_save_debt)
    Button btnSaveDebt;

    @BindView(R.id.tv_deadline_date)
    TextView tvDeadlineDate;

    AppDatabase appDatabase;
    CustomerDAO customerDAO;
    LoanDAO loanDAO;

    private String strName,strPhone,strAddress,strNRC,strCategory,strIntrest,strOpenBalance,strAggrement,strCustID,strDeadlineDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_debt);
        getSupportActionBar().setTitle("စာရင်းသစ်သွင်းရန်");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        ButterKnife.bind(this);

        appDatabase= AppDatabaseUtility.getAppDatabase(this);
        customerDAO=appDatabase.getCustomerDAO();
        loanDAO=appDatabase.getLoanDAO();

        strCustID= UUID.randomUUID().toString();
    }

    private void getText(){
        strName=edtName.getText().toString().trim();
        strPhone=edtPhone.getText().toString().trim();
        strAddress=edtAddress.getText().toString().trim();
        strNRC=edtNRC.getText().toString().trim();
//        strCategory=spCategory.getSelectedItem().toString();
        strIntrest=tvInterestInfo.getText().toString().trim();
        strOpenBalance=edtOpenBalance.getText().toString().trim();
        strAggrement=edtAgreement.getText().toString().trim();
        strDeadlineDate=tvDeadlineDate.getText().toString().trim();
    }

    @OnClick(R.id.btn_save_debt)
    public void onTapSaveDebt(){
        getText();
        Customer customer=new Customer();
        customer.setCustomerID(strCustID);
        customer.setCustomerName(strName);
        customer.setPhoneNo(strPhone);
        customer.setAddress(strAddress);
        customer.setNRCNo(strNRC);
        customerDAO.add(customer);

        Loan loan=new Loan();
        String strloanID=UUID.randomUUID().toString();
        loan.setLoanID(strloanID);
        loan.setCustomerID(strCustID);
        loan.setOpenBalance(strOpenBalance);
        loan.setAgreement(strAggrement);
        loan.setDeadLineDate(strDeadlineDate);
        loanDAO.add(loan);

        Toast.makeText(this, "Save Success", Toast.LENGTH_SHORT).show();
        gotoPrevious();
    }

    @OnClick(R.id.btn_cancel)
    public void onTapCancel(){
        gotoPrevious();
    }

    @Override
    public void onBackPressed() {
        gotoPrevious();
    }

    private void gotoPrevious(){
        Intent intent=new Intent(this,DebtListActivity.class);
        startActivity(intent);
        finish();
    }
}
