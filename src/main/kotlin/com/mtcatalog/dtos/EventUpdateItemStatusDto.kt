package com.mtcatalog.dtos

import java.util.UUID

data class EventUpdateItemStatusDto(
    val globalItemId: UUID,
    val newStatus: String,
)
