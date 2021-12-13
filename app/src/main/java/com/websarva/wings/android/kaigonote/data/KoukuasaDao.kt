package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface KoukuasaDao {
    @Query("SELECT * FROM koukuasa LIMIT 100 OFFSET :offset")
    fun getkoukuasaAll(offset: Long): List<Koukuasa>

    @Query("SELECT * FROM koukuasa WHERE hiduke =:hiduke LIMIT 100 OFFSET :offset")
    fun getkoukuasaByhiduke(hiduke: Date, offset: Long): List<Koukuasa>

    @Insert
    fun insert(koukuasa: Koukuasa)

    @Delete
    fun delete(koukuasa: Koukuasa)

    @Query("DELETE FROM koukuasa")
    fun deleteAll()


}