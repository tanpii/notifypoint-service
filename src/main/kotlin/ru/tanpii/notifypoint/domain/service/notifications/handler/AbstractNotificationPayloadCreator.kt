import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ClassPathResource
import ru.tanpii.notifypoint.domain.service.notifications.Event
import ru.tanpii.notifypoint.domain.service.notifications.handler.NotificationCreator
import ru.tanpii.notifypoint.domain.service.templates.TemplatesService
import ru.tanpii.notifypoint.support.dsl.EmailMessage
import ru.tanpii.notifypoint.support.dsl.email
import ru.tanpii.notifypoint.support.json.JsonUtils
import java.io.File

private val logger = KotlinLogging.logger { }

private const val IMAGE_PATH = "static/logo.png"
private const val IMAGE_NAME = "logo"

abstract class AbstractNotificationPayloadCreator<T : Event>(
    private val templateService: TemplatesService,
    @Value("\${spring.mail.username}")
    private val sender: String
) : NotificationCreator<T> {

    private lateinit var tempFile: File

    init {
        val imageResource = ClassPathResource(IMAGE_PATH)
        tempFile = File.createTempFile(IMAGE_NAME, ".png").apply {
            deleteOnExit()
        }
        imageResource.inputStream.use { input ->
            tempFile.outputStream().use { output ->
                input.copyTo(output)
            }
        }
    }

    override fun parseEvent(payload: String): T {
        return JsonUtils.fromJson(payload, eventClass)
    }

    override fun createNotification(payload: String): EmailMessage {
        val event = parseEvent(payload)

        val template = templateService.findTemplate(event.eventType)

        val email = email {
            from(sender)
            to(event.email)
            subject(template.subject)
            html(replaceData(template.htmlTemplate, event))
            image(IMAGE_NAME, tempFile)
        }

        logger.info {
            "Created notification for client=${event.email}, email=${email}, notificationType=${notificationType}"
        }

        return email
    }

    abstract fun replaceData(email: String, event: T): String
}
