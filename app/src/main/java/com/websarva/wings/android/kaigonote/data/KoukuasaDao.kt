package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KoukuasaDao {
    @Query("SELECT * FROM koukuasa")
    fun getkoukuasaAll(): List<Koukuasa>

    @Insert
    fun insert(koukuasa: Koukuasa)

    @Delete
    fun delete(koukuasa: Koukuasa)


}