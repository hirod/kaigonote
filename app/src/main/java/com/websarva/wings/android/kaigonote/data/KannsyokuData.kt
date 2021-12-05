package com.websarva.wings.android.kaigonote.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "kannsyoku")
data class Kannsyoku(
    @PrimaryKey(autoGenerate = true)
    var uid: Long,
    var hiduke: Date,
    var name: String,
    var kannsyoku: String,
    var kannsyokuInsui: String,
) : BaseSyokujiData()