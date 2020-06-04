package com.sixgroup.appsinaamin.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.sixgroup.appsinaamin.user.User;

//creating a User Data Object
@Dao
public interface UserDao {

    //writing query for getting specific user
    @Query("SELECT * FROM user WHERE email = :email LIMIT 1")
    User getByEmail(String email);

    //writing query for inserting all users
    @Insert
    void insertUser(User user);
}