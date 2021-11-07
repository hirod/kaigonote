package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RiyousyaDao {
    @Query("SELECT * FROM riyousya")
    fun getriyousyaAll(): List<Riyousya>

    @Insert
    fun insert(riyousya: Riyousya)
    
    @Delete
    fun delete(riyousya: Riyousya)


}