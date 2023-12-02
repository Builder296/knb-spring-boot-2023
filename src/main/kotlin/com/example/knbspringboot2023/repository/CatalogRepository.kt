package com.example.knbspringboot2023.repository

import com.example.knbspringboot2023.document.CatalogDocument
import org.springframework.data.mongodb.repository.MongoRepository


interface CatalogRepository: MongoRepository<CatalogDocument, String>