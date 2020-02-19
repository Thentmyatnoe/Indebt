package com.example.indebt.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.indebt.database.model.Customer;

import java.util.List;

@Dao
public interface CustomerDAO {
    @Insert
    void add(Customer customer);

    @Query("Select * from Customer")
    List<Customer> getAllCustomer();
}
