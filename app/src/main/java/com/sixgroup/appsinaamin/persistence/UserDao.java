package com.sixgroup.appsinaamin.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import com.sixgroup.appsinaamin.user.User;

//creating a User Data Object
@Dao
public interface UserDao {

    //writing Query for getting all users
    @Query("SELECT * FROM user")
    List<User> getAll();

    //writing query for deleting all users
    @Query("DELETE FROM user")
    void deleteAll();

    //writing query for getting specific user
    @Query("SELECT * FROM user WHERE firstname LIKE :vorname AND " +  "lastname LIKE :nachname LIMIT 1")
    User findByName(String vorname, String nachname);

    //writing query for inserting all users
    @Insert
    void insertAll(List<User> users);
}
