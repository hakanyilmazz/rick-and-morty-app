package com.hakanyilmazz.rickandmorty.data.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "character_origin")
data class Origin(
    @ColumnInfo(name = "origin_name")
    @SerializedName("name")
    val name: String
) : Serializable {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}