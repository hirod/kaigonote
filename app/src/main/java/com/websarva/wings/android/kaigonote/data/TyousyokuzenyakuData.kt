package com.websarva.wings.android.kaigonote.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tyousyokuzenyaku")
data class Tyousyokuzenyaku(
        @PrimaryKey(autoGenerate = true)
        var uid: Long,
        var hiduke: Date,
        var name: String,
        var tyousyokuzenyaku: String,
        var suibunnryou: Int,
)