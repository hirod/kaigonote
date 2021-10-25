package com.websarva.wings.android.kaigonote.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "resident")
data class Resident(
        @PrimaryKey(autoGenerate = true)
        val uid: Long,
        @ColumnInfo(name = "name")
        val name: String?,
        @ColumnInfo(name = "date")
        val birthday: Date
)

@Entity(tableName = "Kaigo")//追加
data class Kaigo(
        var hiduke: Date,
        var roomNumber: Int,
        var riyousyaID: Int,
        var hinyou: String,
        var naibenn: String,
        var nyuyoku: String,
        var tyousyokuSyusyoku: Int,
        var tyousyokuFukusyoku: Int,
        var tyousyokuInsui: Int,
        var tyusyokuSyusyoku: Int,
        var tyusyokuFukusyoku: Int,
        var tyusyokuInsui: Int,
        var yusyokuSyusyoku: Int,
        var yusyokuFukusyoku: Int,
        var yusyokuInsui: Int,
        var kansyoku: Int,
        var kansyokuInsui: Int,
        var tyousyokuGoyaku: String,
        var tyusyokuGoyaku: String,
        var yusyokuGoyaku: String,
        var kisyouziyaku: String,
        var syusinnyaku: String,
        var tonpuku: String,
        var tyousyokuZenyaku: String,
        var tyusyokuZenyaku: String,
        var yusyokuZenyaku: String,
        var koukuAsa: String,
        var koukuHiru: String,
        var koukuYoru: String,
        var nitizyoukiroku: String,
        var nyuyokukiroku: String,
        var mousiokuri: String,
        var hiyari: String,
        var zikohoukokusyo: String,
        var kirokuitirann: String,

        )
