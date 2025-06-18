package com.mtcatalog.models

import com.mtcatalog.enums.ItemStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "tb_announced_items")
data class ItemModel(

    @Id
    val id: UUID = UUID.randomUUID(),

    val globalItemId: UUID,

    val sellerEmail : String,

    val title: String,

    val price: BigDecimal,

    val gameBelong: String,

    @Enumerated(EnumType.STRING)
    val itemStatus: ItemStatus,

    val publicationDate: LocalDateTime
)
