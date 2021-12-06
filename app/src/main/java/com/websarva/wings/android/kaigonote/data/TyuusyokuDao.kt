package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface TyuusyokuDao {
    @Query("SELECT * FROM tyuusyoku LIMIT 100 OFFSET :offset")
    fun gettyuusyokuAll(offset: Long): List<Tyuusyoku>

    @Query("SELECT * FROM tyuusyoku WHERE hiduke =:hiduke LIMIT 100 OFFSET :offset ")
    fun gettyuusyokuByhiduke(hiduke: Date, offset: Long): List<Tyuusyoku>

    @Insert
    fun insert(tyuusyoku: Tyuusyoku)

    @Delete
    fun delete(tyuusyoku: Tyuusyoku)

    @Query("DELETE FROM tyuusyoku")
    fun deleteAll()
}