package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TonpukuDao {
    @Query("SELECT * FROM tonpuku")
    fun gettonpukuAll(): List<Tonpuku>

    @Insert
    fun insert(tonpuku: Tonpuku)

    @Delete
    fun delete(tonpuku: Tonpuku)
}