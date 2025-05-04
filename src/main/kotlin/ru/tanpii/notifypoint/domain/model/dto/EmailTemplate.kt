package ru.tanpii.notifypoint.domain.model.dto

import ru.tanpii.notifypoint.domain.model.type.NotificationType

data class EmailTemplate(
    val notificationEvent: NotificationType,
    val subject: String,
    val htmlTemplate: String,
)
