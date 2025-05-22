package com.mtcatalog.dtos

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class AnnouncedItemDto(
    val title: String,
    val localStamp: LocalDateTime,
    val sellerEmail: String,
    val amount: BigDecimal,
    val gameBelong: String)
