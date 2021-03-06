package com.websarva.wings.android.kaigonote.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tyousyoku")
data class Tyousyoku(
    @PrimaryKey(autoGenerate = true)
    var uid: Long,
    var hiduke: Date,
    var name: String,
    var tyousyoku: String,
    var fukusyoku: String,
    var tyousyokuInsui: String,
) : BaseSyokujiData()