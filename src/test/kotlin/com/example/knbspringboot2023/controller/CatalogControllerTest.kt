package com.example.knbspringboot2023.controller

import com.example.knbspringboot2023.model.Catalog
import com.example.knbspringboot2023.service.CatalogService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CatalogControllerTest {

    private var catalogService: CatalogService = mockk()
    private var catalogController: CatalogController = CatalogController(catalogService)

    @Test
    fun `should return empty list of catalog when catalog doesn't exits`() {

        every { catalogService.listAllCatalog() } returns emptyList()

        val listAllCatalog = catalogController.listCatalogAll()

        Assertions.assertEquals(listAllCatalog.size, 0)
    }

    @Test
    fun `should return list of catalog when catalog exits`() {

        every { catalogService.listAllCatalog() } returns listOf(
            Catalog("c1", "n1"),
            Catalog("c2", "n2"),
        )

        val listAllCatalog = catalogController.listCatalogAll()

        Assertions.assertEquals(listAllCatalog.size, 2)
    }
}