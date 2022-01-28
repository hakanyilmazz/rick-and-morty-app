package com.hakanyilmazz.rickandmorty.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickAndMortyServiceTest {
    private lateinit var service: RickAndMortyService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()

        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    private fun enqueueMockResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getCartoonCharacters_sentRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("rick_and_morty_example_response.json")

            val responseBody = service.getCartoonCharacters(1).body()
            val request = server.takeRequest()

            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/character?page=1")
        }
    }

    @Test
    fun getCartoonCharacters_receivedResponse_correctPageSize() {
        runBlocking {
            enqueueMockResponse("rick_and_morty_example_response.json")

            val responseBody = service.getCartoonCharacters(1).body()
            val cartoonCharactersList = responseBody!!.cartoonCharacters

            assertThat(cartoonCharactersList.size).isEqualTo(20)
        }
    }

    @Test
    fun getCartoonCharacters_receivedResponse_correctContent() {
        runBlocking {
            enqueueMockResponse("rick_and_morty_example_response.json")

            val responseBody = service.getCartoonCharacters(1).body()
            val cartoonCharactersList = responseBody!!.cartoonCharacters
            val cartoonCharacter = cartoonCharactersList[0]

            assertThat(cartoonCharacter.name).isEqualTo("Rick Sanchez")
            assertThat(cartoonCharacter.image).isEqualTo("https://rickandmortyapi.com/api/character/avatar/1.jpeg")
            assertThat(cartoonCharacter.origin.name).isEqualTo("Earth (C-137)")
        }
    }
}