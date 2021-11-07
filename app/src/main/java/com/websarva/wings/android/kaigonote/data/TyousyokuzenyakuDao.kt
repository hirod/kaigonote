package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TyousyokuzenyakuDao {
    @Query("SELECT * FROM tyousyokuzenyaku")
    fun gettyousyokuzenyakuAll(): List<Tyousyokuzenyaku>

    @Insert
    fun insert(tyousyokuzenyaku: Tyousyokuzenyaku)

    @Delete
    fun delete(tyousyokuzenyaku: Tyousyokuzenyaku)

}