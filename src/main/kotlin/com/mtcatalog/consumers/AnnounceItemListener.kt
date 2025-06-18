//package com.mtcatalog.consumers
//
//import com.mtcatalog.dtos.AnnouncedItemDto
//import com.mtcatalog.services.ItemService
//import org.springframework.kafka.annotation.KafkaListener
//import org.springframework.stereotype.Service
//
//@Service
//class AnnounceItemListener(private val itemService: ItemService) {
//
//    fun announceItemListener(announcedItemDto: AnnouncedItemDto){
//        itemService.announceItem(announcedItemDto)
//        }
//}