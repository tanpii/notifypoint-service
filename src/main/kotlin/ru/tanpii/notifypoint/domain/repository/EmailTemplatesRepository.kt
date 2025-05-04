package ru.tanpii.notifypoint.domain.repository

import org.springframework.data.repository.CrudRepository
import ru.tanpii.notifypoint.domain.model.dto.EmailTemplate
import ru.tanpii.notifypoint.domain.model.entity.EmailTemplateEntity
import ru.tanpii.notifypoint.domain.model.type.NotificationType

interface EmailTemplatesRepository : CrudRepository<EmailTemplateEntity, Long> {
    fun findTemplateByNotificationEvent(notificationEvent: NotificationType): EmailTemplate?
}
