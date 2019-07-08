package com.venancio.testcystera.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.venancio.testcystera.entity.LogUsr;
import com.venancio.testcystera.entity.User;

import java.util.List;

@Dao
public interface LogDao {


    @Query("SELECT * FROM log")
    List<LogUsr> getAll();


    @Query("SELECT * FROM user where email LIKE  :email")
    User findbyusr(String email);


    @Insert
    void insertAll(List<LogUsr>... users);

    @Delete
    void delete(LogUsr user);
}
