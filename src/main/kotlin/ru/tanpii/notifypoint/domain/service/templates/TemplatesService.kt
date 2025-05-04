package ru.tanpii.notifypoint.domain.service.templates

import org.springframework.stereotype.Service
import ru.tanpii.notifypoint.domain.model.type.NotificationType
import ru.tanpii.notifypoint.domain.repository.EmailTemplatesRepository

@Service
class TemplatesService(
    private val templatesRepository: EmailTemplatesRepository,
) {

    fun findTemplate(event: NotificationType) = templatesRepository.findTemplateByNotificationEvent(event) ?: throw RuntimeException("Template not found")
}
