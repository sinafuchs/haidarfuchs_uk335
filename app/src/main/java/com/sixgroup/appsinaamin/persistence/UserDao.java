package com.sixgroup.appsinaamin.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import com.sixgroup.appsinaamin.user.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("DELETE FROM user")
    void deleteAll();

    @Query("SELECT * FROM user WHERE firstname LIKE :vorname AND " +  "lastname LIKE :nachname LIMIT 1")
    User findByName(String vorname, String nachname);

    @Insert
    void insertAll(List<User> users);
}
