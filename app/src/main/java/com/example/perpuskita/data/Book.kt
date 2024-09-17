package com.example.perpuskita.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.DeleteColumn
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "transaction_table")
data class Book(

    @PrimaryKey(autoGenerate=true) val targetId:Int=0,
    @ColumnInfo(name="targetBuku") var targetBuku: String,
    @ColumnInfo(name="targetJudul")var targetJudul: String,
    @ColumnInfo(name="targetPengarang")var targetPengarang: String,
    @ColumnInfo(name="targetPinjam")var targetPinjam: String,
    @ColumnInfo(name="targetKembali")var targetKembali: String
):Parcelable
