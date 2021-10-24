package com.websarva.wings.android.kaigonote.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.*

class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}

@Database(entities = arrayOf(Resident::class), version = 1)
@TypeConverters(DateConverter::class)
abstract class KaigoDatabase : RoomDatabase() {
    abstract fun dao(): KaigoDao
}

class KaigoDB {
    companion object {
        private const val DB_FILE = "kaigo.db"
        private var db: KaigoDatabase? = null
        fun getInstance(application: Application): KaigoDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    application,
                    KaigoDatabase::class.java, DB_FILE).build()
            }
            return db!!
        }
    }
}
