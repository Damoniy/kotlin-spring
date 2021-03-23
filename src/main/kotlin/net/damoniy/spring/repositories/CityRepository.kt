package net.damoniy.spring.repositories

import java.io.Serializable
import net.damoniy.spring.domain.City
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface CityRepository: JpaRepository<City, Serializable> {
}
