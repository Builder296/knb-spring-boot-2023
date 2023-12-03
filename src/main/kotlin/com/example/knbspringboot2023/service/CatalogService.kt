package com.example.knbspringboot2023.service

import com.example.knbspringboot2023.model.Catalog
import com.example.knbspringboot2023.repository.CatalogRepository
import org.springframework.stereotype.Service

@Service
class CatalogService(
    val catalogRepository: CatalogRepository
) {

    fun listAllCatalog(): List<Catalog> {
        return catalogRepository.findAll().map { Catalog(
            it.code,
            it.name,
        ) }
    }
}