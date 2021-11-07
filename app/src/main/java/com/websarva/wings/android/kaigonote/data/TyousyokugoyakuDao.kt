package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TyousyokugoyakuDao {
    @Query("SELECT * FROM tyousyokugoyaku")
    fun gettyousyokugoyakuAll(): List<Tyousyokugoyaku>

    @Insert
    fun insert(tyousyokugoyaku: Tyousyokugoyaku)

    @Delete
    fun delete(tyousyokugoyaku: Tyousyokugoyaku)
}