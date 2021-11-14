package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface HainyouDao {
    @Query("SELECT * FROM hainyou LIMIT 100 OFFSET :offset")
    fun gethainyouAll(offset: Long): List<Hainyou>

    @Query("SELECT * FROM hainyou WHERE hiduke =:hiduke LIMIT 100 OFFSET :offset ")
    fun gethainyouByhiduke(hiduke: Date, offset: Long): List<Hainyou>

    @Query("SELECT * FROM hainyou WHERE name = :name LIMIT 100 OFFSET :offset;")
    fun gethainyouByname(name: String, offset: Long): List<Hainyou>

    @Query("SELECT * FROM hainyou WHERE hainyou= :hainyou LIMIT 100 OFFSET :offset;")
    fun gethainyouByhainyou(hainyou: String, offset: Long): List<Hainyou>//開始地点

    @Insert
    fun insert(hainyou: Hainyou)

    @Delete
    fun delete(hainyou: Hainyou)
}
