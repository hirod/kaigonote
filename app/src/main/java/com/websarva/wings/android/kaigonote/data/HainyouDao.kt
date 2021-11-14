package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface HainyouDao {
    @Query("SELECT * FROM hainyou LIMIT 100 OFFSET 0")
    fun gethainyouAll(): List<Hainyou>

    @Query("SELECT * FROM hainyou WHERE hiduke =:hiduke LIMIT 100 OFFSET 0 ")
    fun gethainyouByhiduke(hiduke: Date): List<Hainyou>

    @Query("SELECT * FROM hainyou WHERE name = :name LIMIT 100 OFFSET 0;")
    fun gethainyouByname(name: String): List<Hainyou>

    @Query("SELECT * FROM hainyou WHERE hainyou= :hainyou LIMIT 100 OFFSET 0;")
    fun gethainyouByhainyou(hainyou: String): List<Hainyou>

    @Insert
    fun insert(hainyou: Hainyou)

    @Delete
    fun delete(hainyou: Hainyou)
}
