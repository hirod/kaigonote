package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface KoukuyoruDao {
    @Query("SELECT * FROM koukuyoru LIMIT 100 OFFSET :offset")
    fun getkoukuyoruAll(offset: Long): List<Koukuyoru>

    @Query("SELECT * FROM koukuyoru WHERE hiduke =:hiduke LIMIT 100 OFFSET :offset")
    fun getkoukuyoruByhiduke(hiduke: Date, offset: Long): List<Koukuyoru>

    @Insert
    fun insert(koukuyoru: Koukuyoru)

    @Delete
    fun delete(koukuyoru: Koukuyoru)

    @Query("DELETE FROM koukuyoru")
    fun deleteAll()
}