package com.hakanyilmazz.rickandmorty.data.model


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "cartoon_character")
data class CartoonCharacter(
    @ColumnInfo(name = "created_time")
    @SerializedName("created")
    val created: String,

    @ColumnInfo(name = "gender")
    @SerializedName("gender")
    val gender: String,

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "image_url")
    @SerializedName("image")
    val image: String,

    @ColumnInfo(name = "character_name")
    @SerializedName("name")
    val name: String,

    @Embedded(prefix = "character_origin")
    @SerializedName("origin")
    val origin: Origin,

    @ColumnInfo(name = "species")
    @SerializedName("species")
    val species: String,

    @ColumnInfo(name = "status")
    @SerializedName("status")
    val status: String,
) : Serializable {

    fun getLifeStatus(): Int {
        return when (status) {
            "Alive" -> {
                1
            }
            "Dead" -> {
                -1
            }
            else -> {
                0
            }
        }
    }
}