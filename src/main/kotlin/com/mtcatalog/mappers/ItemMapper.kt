package com.mtcatalog.mappers

import com.mtcatalog.dtos.AnnouncedItemDto
import com.mtcatalog.enums.ItemStatus
import com.mtcatalog.models.ItemModel

fun AnnouncedItemDto.toEntity(): ItemModel =
    ItemModel(
        sellerEmail = this.sellerEmail,
        title = this.title,
        price = this.amount,
        gameBelong = this.gameBelong,
        itemStatus = ItemStatus.ANNOUNCED,
        publicationDate = this.localStamp
    )