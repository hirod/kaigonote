package com.websarva.wings.android.kaigonote.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "riyousya")
data class Riyousya(
        @PrimaryKey(autoGenerate = true)
        var uid: Long,
        var name: String,
        var nennrei: String,
)