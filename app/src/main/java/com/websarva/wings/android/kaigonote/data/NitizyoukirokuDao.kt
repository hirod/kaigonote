package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NitizyoukirokuDao {
    @Query("SELECT * FROM nitizyoukiroku")
    fun getnitizyoukirokuAll(): List<Nitizyoukiroku>

    @Insert
    fun insert(nitizyoukiroku: Nitizyoukiroku)

    @Delete
    fun delete(nitizyoukiroku: Nitizyoukiroku)


}