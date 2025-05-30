package com.mtcatalog.controllers

import com.mtcatalog.dtos.PurchaseDto
import com.mtcatalog.services.ItemService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/catalog")
class CatalogController(private val itemService: ItemService) {

    @PostMapping("/purchase-validate-item")
    fun validateItem(@RequestBody purchaseDto: PurchaseDto): Boolean =
        itemService.validateItem(purchaseDto)
}