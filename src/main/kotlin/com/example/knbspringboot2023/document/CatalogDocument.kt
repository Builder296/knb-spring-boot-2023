package com.example.knbspringboot2023.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("catalog")
data class CatalogDocument(
    val code: String,
    val name: String,
) {
    @Id
    val id: String = ""
}