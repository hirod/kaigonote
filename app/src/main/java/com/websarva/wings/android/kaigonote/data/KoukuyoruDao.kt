package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KoukuyoruDao {
    @Query("SELECT * FROM koukuyoru")
    fun getkoukuyoruAll(): List<Koukuyoru>

    @Insert
    fun insert(koukuyoru: Koukuyoru)

    @Delete
    fun delete(koukuyoru: Koukuyoru)
}