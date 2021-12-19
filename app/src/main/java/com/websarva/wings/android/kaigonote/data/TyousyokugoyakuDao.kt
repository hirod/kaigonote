package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface TyousyokugoyakuDao {
    @Query("SELECT * FROM tyousyokugoyaku LIMIT 100 OFFSET :offset")
    fun gettyousyokugoyakuAll(offset: Long): List<Tyousyokugoyaku>

    @Query("SELECT * FROM tyousyokugoyaku WHERE hiduke =:hiduke LIMIT 100 OFFSET :offset")
    fun gettyousyokugoyakuByhiduke(hiduke: Date, offset: Long): List<Tyousyokugoyaku>

    @Insert
    fun insert(tyousyokugoyaku: Tyousyokugoyaku)

    @Delete
    fun delete(tyousyokugoyaku: Tyousyokugoyaku)

    @Query("DELETE FROM tyousyokugoyaku")
    fun deleteAll()
}