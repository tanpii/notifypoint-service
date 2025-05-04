package ru.tanpii.notifypoint.domain.service.notifications.handler

import ru.tanpii.notifypoint.domain.model.type.NotificationType
import ru.tanpii.notifypoint.domain.service.notifications.Event
import ru.tanpii.notifypoint.support.dsl.EmailMessage
import kotlin.reflect.KClass

interface NotificationCreator<T : Event> {

    val notificationType: NotificationType

    val eventClass: KClass<T>

    fun createNotification(payload: String): EmailMessage

    fun parseEvent(payload: String): T
}
