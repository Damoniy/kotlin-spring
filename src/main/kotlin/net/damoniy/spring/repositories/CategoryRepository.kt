package net.damoniy.spring.repositories

import java.io.Serializable
import net.damoniy.spring.domain.Category
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.yaml.snakeyaml.events.Event
import java.util.*

@Repository
interface CategoryRepository: JpaRepository<Category, Serializable> {
}
