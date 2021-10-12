package com.example.data.mapper

import com.example.data.database.entity.TypeEntity
import com.example.data.response.TypeResponse
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MapperTypeResponseToTypeEntityTest {

    @Test
    fun `TypeResponse transform to TypeEntity`() {
        val typeEntity: TypeEntity = typeResponse.transformResponseToEntity()
        assertEquals(STRING_TYPE, typeEntity.data.first())
    }

    companion object {
        private const val STRING_TYPE = "Type"
        private val typeResponse: TypeResponse = TypeResponse(
            data = listOf(STRING_TYPE)
        )
    }
}
