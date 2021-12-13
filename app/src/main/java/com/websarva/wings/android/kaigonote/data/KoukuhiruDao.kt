package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface KoukuhiruDao {
    @Query("SELECT * FROM koukuhiru LIMIT 100 OFFSET :offset")
    fun getkoukuhiruAll(offset: Long): List<Koukuhiru>

    @Query("SELECT * FROM koukuhiru WHERE hiduke =:hiduke LIMIT 100 OFFSET :offset")
    fun getkoukuhiruByhiduke(hiduke: Date, offset: Long): List<Koukuhiru>

    @Insert
    fun insert(koukuhiru: Koukuhiru)

    @Delete
    fun delete(koukuhiru: Koukuhiru)

    @Query("DELETE FROM koukuhiru")
    fun deleteAll()
}