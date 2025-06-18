package com.mtcatalog.consumers

import com.mtcatalog.dtos.EventUpdateItemStatusDto
import com.mtcatalog.services.ItemService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class SoldItemListener(private val itemService: ItemService) {

    @KafkaListener(topics = ["updateItemStatus"], groupId = "catalog-group", containerFactory = "purchaseUpdateItemStatus")
    fun soldItemListener(eventUpdateItemStatusDto: EventUpdateItemStatusDto){
        println("Deu bom!!")
    }
}