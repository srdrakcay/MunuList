package com.serdar.mnlist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shoppingList")
data class Shopping(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int=0 ,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "size") val size: String,
    @ColumnInfo(name = "store") val store: String



)
