package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface TyousyokuDao {
    @Query("SELECT * FROM tyousyoku LIMIT 100 OFFSET :offset")
    fun gettyousyokuAll(offset: Long): List<Tyousyoku>

    @Query("SELECT * FROM tyousyoku WHERE hiduke =:hiduke LIMIT 100 OFFSET :offset ")
    fun gettyousyokuByhiduke(hiduke: Date, offset: Long): List<Tyousyoku>


    @Insert
    fun insert(tyousyoku: Tyousyoku)

    @Delete
    fun delete(tyousyoku: Tyousyoku)

    @Query("DELETE FROM tyousyoku")
    fun deleteAll()

}