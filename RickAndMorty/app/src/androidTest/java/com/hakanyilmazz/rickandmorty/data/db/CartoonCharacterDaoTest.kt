package com.hakanyilmazz.rickandmorty.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.hakanyilmazz.rickandmorty.data.db.dao.CartoonCharacterDao
import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter
import com.hakanyilmazz.rickandmorty.data.model.Origin
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CartoonCharacterDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: RickAndMortyDatabase
    private lateinit var dao: CartoonCharacterDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            RickAndMortyDatabase::class.java
        ).build()

        dao = database.cartoonCharacterDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveCartoonCharactersTest() = runBlocking {
        val list = listOf(
            CartoonCharacter(
                "created1",
                "gender1",
                1,
                "image1",
                "name1",
                Origin("origin1"),
                "species1",
                "status1"
            ),
            CartoonCharacter(
                "created2",
                "gender2",
                2,
                "image2",
                "name2",
                Origin("origin2"),
                "species2",
                "status2"
            )
        )

        dao.saveCartoonCharacters(list)

        val dbList = dao.getCartoonCharacters()

        Truth.assertThat(dbList).isEqualTo(list)
    }

    @Test
    fun deleteCartoonCharactersTest() = runBlocking {
        val list = listOf(
            CartoonCharacter(
                "created3",
                "gender3",
                3,
                "image3",
                "name3",
                Origin("origin3"),
                "species3",
                "status3"
            ),
            CartoonCharacter(
                "created4",
                "gender4",
                4,
                "image4",
                "name4",
                Origin("origin4"),
                "species4",
                "status4"
            )
        )

        dao.saveCartoonCharacters(list)
        dao.deleteAllCartoonCharacters()

        val dbList = dao.getCartoonCharacters()

        Truth.assertThat(dbList).isEmpty()
    }
}