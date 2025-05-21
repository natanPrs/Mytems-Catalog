package com.mtcatalog.repositories

import com.mtcatalog.models.ItemModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ItemRepository : JpaRepository<ItemModel, UUID>{
}