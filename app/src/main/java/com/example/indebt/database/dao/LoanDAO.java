package com.example.indebt.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.indebt.database.model.Loan;

import java.util.List;
@Dao
public interface LoanDAO {
    @Insert
    void add(Loan loan);

    @Query("Select * from Loan")
    List<Loan> getAllLoan();
}
