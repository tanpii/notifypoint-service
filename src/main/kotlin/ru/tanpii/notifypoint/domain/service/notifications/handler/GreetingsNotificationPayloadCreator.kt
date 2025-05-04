package ru.tanpii.notifypoint.domain.service.notifications.handler

import AbstractNotificationPayloadCreator
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.tanpii.notifypoint.domain.model.type.NotificationType
import ru.tanpii.notifypoint.domain.service.notifications.Event
import ru.tanpii.notifypoint.domain.service.templates.TemplatesService

@Component
class GreetingsNotificationPayloadCreator(
    templateService: TemplatesService,
    @Value("\${spring.mail.username}")
    sender: String
) : AbstractNotificationPayloadCreator<GreetingsNotificationEvent>(templateService, sender) {

    override val notificationType = NotificationType.GREETING

    override val eventClass = GreetingsNotificationEvent::class

    override fun replaceData(email: String, event: GreetingsNotificationEvent) =
        email.replace("{{firstName}}", event.firstName)
}

data class GreetingsNotificationEvent(
    override val email: String,
    override val eventType: NotificationType,
    val firstName: String
) : Event
