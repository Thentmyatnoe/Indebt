package com.example.indebt.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.indebt.database.dao.CategoryDAO;
import com.example.indebt.database.dao.CustomerDAO;
import com.example.indebt.database.dao.LoanDAO;
import com.example.indebt.database.dao.UsersDAO;
import com.example.indebt.database.model.Category;
import com.example.indebt.database.model.Customer;
import com.example.indebt.database.model.Loan;
import com.example.indebt.database.model.Users;

@Database(entities = {Users.class, Category.class, Customer.class, Loan.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UsersDAO getUsersDAO();
    public abstract CategoryDAO getCategoryDAO();
    public abstract CustomerDAO getCustomerDAO();
    public abstract LoanDAO getLoanDAO();
}
