package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface KannsyokuDao {
    @Query("SELECT * FROM kannsyoku LIMIT 100 OFFSET :offset")
    fun getkannsyokuAll(offset: Long): List<Kannsyoku>

    @Query("SELECT * FROM kannsyoku WHERE hiduke =:hiduke LIMIT 100 OFFSET :offset")
    fun getkannsyokuByhiduke(hiduke: Date, offset: Long): List<Kannsyoku>

    @Insert
    fun insert(kannsyoku: Kannsyoku)

    @Delete
    fun delete(kannsyoku: Kannsyoku)

    @Query("DELETE FROM kannsyoku")
    fun deleteAll()
}