package com.example.fotoalbum.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fotoalbum.model.Users
import retrofit2.Response

@Dao
interface UsersDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun getUser(user: Users)

    @Query("SELECT * FROM users_table ORDER BY id")
    fun readAllData(): LiveData<List<Users>>

}