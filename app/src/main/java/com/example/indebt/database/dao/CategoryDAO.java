package com.example.indebt.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.indebt.database.model.Category;

import java.util.List;
@Dao
public interface CategoryDAO {
    @Insert
    void add(Category category);

    @Query("Select * from Category")
    List<Category> getAllCategory();

}
