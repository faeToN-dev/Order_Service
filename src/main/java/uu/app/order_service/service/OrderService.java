// Оголошення пакету, в якому знаходиться клас OrderService 
package uu.app.order_service.service;
// Імпортує: 
// -- DTO-об’єкт, що представляє користувача. 
import uu.app.order_service.dto.UserDTO;
// -- JPA-сутність для зберігання замовлень у базі даних. 
import uu.app.order_service.entity.OrderEntity;
// -- інтерфейс для взаємодії з таблицею замовлень. 
import uu.app.order_service.repository.OrderRepository;
// -- анотація, яка позначає цей клас як сервісний компонент у Spring. 
import org.springframework.stereotype.Service;
// Робить цей клас сервісним компонентом Spring, який можна інжектити в інші класи.
// Цей відповідає за бізнес-логіку, пов’язану із замовленнями. 
@Service
public class OrderService {
    // Оголошення залежностей:
    // -- для збереження замовлень у БД.
    private final OrderRepository orderRepository;
    // -- для отримання даних користувача з іншого мікросервісу
    private final UserClient userClient;
    // Конструктор з ін’єкцією залежностей.
    // Spring автоматично передає реалізації під час створення цього сервісу.
    public OrderService(OrderRepository orderRepository, UserClient
            userClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
    }
    // Метод createOrder приймає об'єкт замовлення (OrderEntity)
    // і створює новий запис у базі даних.
    public OrderEntity createOrder(OrderEntity order) {
        // Через UserClient виконується HTTP-запит до мікросервісу користувачів
        // для перевірки, чи існує користувач з переданим userId.
        UserDTO user = userClient.getUser(order.getUserId());
        // Якщо користувач не знайдений — генерується виняток, і замовлення не буде створено.
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        // Якщо користувач знайдений — замовлення зберігається в базі через orderRepository.
        return orderRepository.save(order);
    }
}