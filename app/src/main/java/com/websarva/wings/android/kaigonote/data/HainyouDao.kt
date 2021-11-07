package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HainyouDao {
    @Query("SELECT * FROM hainyou")
    fun gethainyouAll(): List<Hainyou>

    @Insert
    fun insert(hainyou: Hainyou)

    @Delete
    fun delete(hainyou: Hainyou)
}