package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SyuusinyakuDao {
    @Query("SELECT * FROM syuusinyaku")
    fun getsyuusinyakuAll(): List<Syuusinyaku>

    @Insert
    fun insert(syuusinyaku: Syuusinyaku)

    @Delete
    fun delete(syuusinyaku: Syuusinyaku)
}