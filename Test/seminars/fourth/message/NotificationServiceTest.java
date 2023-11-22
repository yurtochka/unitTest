package seminars.fourth.message;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class NotificationServiceTest {

    @Test
    void testNotificationService(){
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);

        notificationService.sendNotification("Privet", " krasotka");

        // вызов
        verify(messageService, times(1)).sendMessage("Privet", " krasotka");
    }

}