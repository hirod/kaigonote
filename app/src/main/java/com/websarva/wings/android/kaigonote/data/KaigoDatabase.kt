package com.websarva.wings.android.kaigonote.data

import android.app.Application
import androidx.room.*
import java.util.*

class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}

@Database(
    entities = arrayOf(
        Resident::class,
        Kaigo::class,
        Hainyou::class,
        Haiben::class,
        Tyousyoku::class,
        Tyuusyoku::class,
        Yuusyoku::class,
        Kannsyoku::class,
        Tyousyokugoyaku::class,
        Tyuusyokugoyaku::class,
        Yuusyokugoyaku::class,
        Syuusinyaku::class,
        Tonpuku::class,
        Tyousyokuzenyaku::class,
        Tyuusyokuzenyaku::class,
        Yuusyokuzenyaku::class,
        Koukuasa::class,
        Koukuhiru::class,
        Koukuyoru::class,
        Hiyarihat::class,
        Mousiokuri::class,
        Nitizyoukiroku::class,
        Nyuuyoku::class,
        Nyuuyokukiroku::class,
        Riyousya::class,
        Zikohoukokusyo::class
    ), version = 1
)

@TypeConverters(DateConverter::class)
abstract class KaigoDatabase : RoomDatabase() {
    abstract fun dao(): ResidentDao
    abstract fun kaigo(): KaigoDao
    abstract fun hainyou(): HainyouDao
    abstract fun haiben(): HaibenDao
    abstract fun tyousyoku(): TyousyokuDao
    abstract fun tyuusyoku(): TyuusyokuDao
    abstract fun yuusyoku(): YuusyokuDao
    abstract fun kannsyoku(): KannsyokuDao
    abstract fun tyousyokugoyaku(): TyousyokugoyakuDao
    abstract fun tyuusyokugoyaku(): TyuusyokugoyakuDao
    abstract fun yuusyokugoyaku(): YuusyokugoyakuDao
    abstract fun syuusinyaku(): SyuusinyakuDao
    abstract fun tonpuku(): TonpukuDao
    abstract fun tyousyokuzenyaku(): TyousyokuzenyakuDao
    abstract fun tyuusyokuzenyaku(): TyuusyokuzenyakuDao
    abstract fun yuusyokuzenyaku(): YuusyokuzenyakuDao
    abstract fun koukuasa(): KoukuasaDao
    abstract fun koukuhiru(): KoukuhiruDao
    abstract fun koukuyoru(): KoukuyoruDao
    abstract fun hiyarihat(): HiyarihatDao
    abstract fun mousiokuri(): MousiokuriDao
    abstract fun nitizyoukiroku(): NitizyoukirokuDao
    abstract fun nyuuyoku(): NyuuyokuDao
    abstract fun nyuuyokukiroku(): NyuuyokukirokuDao
    abstract fun riyousya(): RiyousyaDao
    abstract fun zikohoukokusyo(): ZikohoukokusyoDao


}

class KaigoDB {
    companion object {
        private const val DB_FILE = "kaigo.db"
        private var db: KaigoDatabase? = null
        fun getInstance(application: Application): KaigoDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    application,
                    KaigoDatabase::class.java, DB_FILE
                ).build()
            }
            return db!!
        }
    }
}
