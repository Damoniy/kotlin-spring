package net.damoniy.spring.resources.exceptions

import net.damoniy.spring.services.exceptions.ObjectNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException::class)
    fun objectNotFound(par0: ObjectNotFoundException, par1: HttpServletRequest): ResponseEntity<StandardError> {
        val se = StandardError(HttpStatus.NOT_FOUND.value(), par0.message, System.currentTimeMillis())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se)
    }
}