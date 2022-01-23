package com.hakanyilmazz.rickandmorty.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter

@Dao
interface CartoonCharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCartoonCharacters(cartoonCharacters: List<CartoonCharacter>)

    @Query("DELETE FROM cartoon_character")
    suspend fun deleteAllCartoonCharacters()

    @Query("SELECT * FROM cartoon_character")
    suspend fun getCartoonCharacters(): List<CartoonCharacter>
}