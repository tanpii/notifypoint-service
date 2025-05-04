package ru.tanpii.notifypoint.domain.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import ru.tanpii.notifypoint.domain.model.type.NotificationType

@Table("email_templates")
data class EmailTemplateEntity(
    val notificationEvent: NotificationType,
    val subject: String,
    val htmlTemplate: String
) {
    @Id
    var templateId: Int? = null
}
