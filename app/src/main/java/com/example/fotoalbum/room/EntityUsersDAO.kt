package com.example.fotoalbum.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EntityUsersDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(entityUsers: EntityUsers)

    @Query("SELECT * FROM user_table ORDER BY id")
    fun readAllData(): LiveData<List<EntityUsers>>



}