package com.mtcatalog.services

import com.mtcatalog.dtos.PurchaseDto
import com.mtcatalog.enums.ItemStatus
import com.mtcatalog.repositories.ItemRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class PurchaseService(private val itemRepository: ItemRepository) {

    fun validateItem(purchaseDto: PurchaseDto): BigDecimal? {
        val itemValue = itemRepository.findByGlobalItemId(purchaseDto.globalItemId) ?: return null

        if (itemValue.itemStatus != ItemStatus.ANNOUNCED){
            return null
        }

        return itemValue.price
    }
}