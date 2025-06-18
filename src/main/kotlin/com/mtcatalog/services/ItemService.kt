package com.mtcatalog.services

import com.mtcatalog.dtos.AnnouncedItemDto
import com.mtcatalog.dtos.PurchaseDto
import com.mtcatalog.enums.ItemStatus
import com.mtcatalog.mappers.toEntity
import com.mtcatalog.repositories.ItemRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRepository: ItemRepository) {

    @KafkaListener(topics = ["announceItem"], groupId = "catalog-group", containerFactory = "announceItemKafkaListenerContainerFactory")
    fun announceItem(announcedItemDto: AnnouncedItemDto){
        runCatching {
            val newAnnouncedItem = announcedItemDto.toEntity()
            itemRepository.save(newAnnouncedItem)
        }
    }
}