// Оголошення пакету, до якого належить клас UserClient. 
package uu.app.order_service.service;
// Імпортує: 
// -- DTO-об’єкт, що представляє користувача. 
import uu.app.order_service.dto.UserDTO;
// -- анотація, яка позначає цей клас як сервісний компонент у Spring. 
import org.springframework.stereotype.Service;
// -- HTTP-клієнт, який використовується для звернення до інших REST-сервісів.
import org.springframework.web.client.RestTemplate;
// Позначає Клас UserClient як Spring-сервіс. 
// Це означає, що Spring автоматично створить об'єкт цього класу і помістить його в контекст застосунку.
// Цей клас реалізує клієнта для запиту інформації про користувача з іншого мікросервісу.
        @Service
        public class UserClient {
            // Оголошення змінної restTemplate, яка буде використовуватись для HTTP-запитів.
            // Вона final, бо ініціалізується один раз через конструктор.
            private final RestTemplate restTemplate;
            // Конструктор з ін’єкцією залежності RestTemplate.
            // Spring автоматично передасть об'єкт RestTemplate, якщо він оголошений як @Bean
            public UserClient(RestTemplate restTemplate) {
                this.restTemplate = restTemplate;
            }
            // Метод getUser(Long userId) виконує HTTP GET-запит за адресою http://localhost:8081/users/{id}.
            public UserDTO getUser(Long userId) {
                // restTemplate.getForObject(...):
                // -- надсилає запит,
                // -- очікує об'єкт типу UserDTO у відповіді,
                // -- автоматично десеріалізує JSON у Java-об'єкт UserDTO.
                return restTemplate.getForObject("http://localhost:8081/users/" +
                        userId, UserDTO.class);
            }
        }