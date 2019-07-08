package com.venancio.testcystera.dao;


import androidx.room.*;
import com.venancio.testcystera.entity.User;

@Dao
public interface UserDao {


    @Query("SELECT * FROM user where email LIKE  :email AND password LIKE :password")
    User findByName(String email, String password);


    @Query("SELECT * FROM user where email LIKE  :email")
    User findbyusr(String email);


    @Query("SELECT COUNT(*) from User")
    int countUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
