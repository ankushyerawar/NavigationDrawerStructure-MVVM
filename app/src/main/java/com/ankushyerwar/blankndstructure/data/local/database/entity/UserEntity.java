package com.ankushyerwar.blankndstructure.data.local.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class UserEntity {

    @ColumnInfo(name = "user_id")
    @PrimaryKey()
    @NonNull
    private Long mUserId;

    @ColumnInfo(name = "user_name")
    private String mUserName;

    @ColumnInfo(name = "user_surname")
    private String mUserSurname;

    @ColumnInfo(name = "user_dob")
    private String mUserDOB;

    @Ignore
    public UserEntity() {
    }

    public UserEntity(@NonNull Long mUserId, String mUserName, String mUserSurname, String mUserDOB) {
        this.mUserId = mUserId;
        this.mUserName = mUserName;
        this.mUserSurname = mUserSurname;
        this.mUserDOB = mUserDOB;
    }

    @NonNull
    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(@NonNull Long userId) {
        this.mUserId = userId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        this.mUserName = userName;
    }

    public String getUserSurname() {
        return mUserSurname;
    }

    public void setUserSurname(String userSurname) {
        this.mUserSurname = userSurname;
    }

    public String getUserDOB() {
        return mUserDOB;
    }

    public void setUserDOB(String userDob) {
        this.mUserDOB = userDob;
    }
}