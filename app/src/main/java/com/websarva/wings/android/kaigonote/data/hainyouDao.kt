package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface hainyouDao {
    @Query("SELECT * FROM hainyou")
    fun gethainyouAll(): List<hainyou>

    @Insert
    fun insert(hainyou: hainyou)

    @Delete
    fun delete(hainyou: hainyou)
}