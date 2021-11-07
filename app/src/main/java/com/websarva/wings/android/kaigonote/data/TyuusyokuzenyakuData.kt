package com.websarva.wings.android.kaigonote.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tyuusyokuzenyaku")
data class Tyuusyokuzenyaku(
        @PrimaryKey(autoGenerate = true)
        var uid: Long,
        var hiduke: Date,
        var name: String,
        var tyuusyokuzenyaku: String,
        var suibunnryou: Int,
)