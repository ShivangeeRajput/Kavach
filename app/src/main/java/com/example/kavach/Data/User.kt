package com.Data

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="user_table")
data class User (
    @PrimaryKey(autoGenerate = true)

    val id:Int,
    val name:String,
    val relation:String,
    val phoneNumber:String,
    val email: String
    )