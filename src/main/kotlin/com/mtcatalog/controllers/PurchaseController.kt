package com.mtcatalog.controllers

import com.mtcatalog.dtos.PurchaseDto
import com.mtcatalog.services.ItemService
import com.mtcatalog.services.PurchaseService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/validate-items")
class PurchaseController(private val purchaseService: PurchaseService) {

    @PostMapping("/purchase-validate-item")
    fun validateItem(@RequestBody purchaseDto: PurchaseDto): BigDecimal? =
        purchaseService.validateItem(purchaseDto)
}