package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface YuusyokuDao {
    @Query("SELECT * FROM yuusyoku LIMIT 100 OFFSET :offset")
    fun gettyuusyokuAll(offset: Long): List<Yuusyoku>

    @Query("SELECT * FROM yuusyoku WHERE hiduke =:hiduke LIMIT 100 OFFSET :offset")
    fun getyuusyokuByhiduke(hiduke: Date, offset: Long): List<Yuusyoku>

    @Insert
    fun insert(yuusyoku: Yuusyoku)

    @Delete
    fun delete(yuusyoku: Yuusyoku)

    @Query("DELETE FROM yuusyoku")
    fun deleteAll()
}