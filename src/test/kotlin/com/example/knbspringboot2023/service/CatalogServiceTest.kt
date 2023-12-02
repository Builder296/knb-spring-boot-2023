package com.example.knbspringboot2023.service

import com.example.knbspringboot2023.document.CatalogDocument
import com.example.knbspringboot2023.repository.CatalogRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CatalogServiceTest {

    private var catalogRepository: CatalogRepository = mockk()
    private val catalogService: CatalogService = CatalogService(catalogRepository)

    @Test
    fun `should return empty list of catalog when catalog doesn't exits`() {

        every { catalogRepository.findAll() } returns emptyList()

        val listAllCatalog = catalogService.ListAllCatalog()

        Assertions.assertEquals(listAllCatalog.size, 0)
    }

    @Test
    fun `should return list of catalog when catalog exits`() {

        every { catalogRepository.findAll() } returns listOf(
            CatalogDocument("c1", "n1"),
            CatalogDocument("c1", "n1"),
        )

        val listAllCatalog = catalogService.ListAllCatalog()

        Assertions.assertEquals(listAllCatalog.size, 2)
    }
}