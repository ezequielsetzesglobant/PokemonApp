package com.example.data.mapper

import com.example.data.database.entity.TypeEntity
import com.example.domain.entity.TypeData
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MapperTypeEntityToTypeDataTest {

    @Test
    fun `TypeEntity transform to TypeData`() {
        val typeData: TypeData = typeResponse.transformEntityToData()
        Assert.assertEquals(STRING_TYPE, typeData.data.first())
    }

    companion object {
        private const val STRING_TYPE = "Type"
        private val typeResponse: TypeEntity = TypeEntity(
            data = listOf(STRING_TYPE)
        )
    }
}
