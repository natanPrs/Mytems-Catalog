package com.mtcatalog.services

import com.mtcatalog.dtos.AnnouncedItemDto
import com.mtcatalog.mappers.toEntity
import com.mtcatalog.models.ItemModel
import com.mtcatalog.repositories.ItemRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ItemService(private val itemRepository: ItemRepository) {

    @KafkaListener(topics = ["announceItem"], groupId = "catalog-group")
    fun announceItem(announcedItemDto: AnnouncedItemDto){
        runCatching {
            val newAnnouncedItem = announcedItemDto.toEntity()
            itemRepository.save(newAnnouncedItem)
        }
    }
}