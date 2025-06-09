// Оголошення пакету, в якому знаходиться клас OrderService 
package uu.app.order_service.controller;
// Імпортує: 
// -- JPA-сутність для зберігання замовлень у базі даних. 
import uu.app.order_service.entity.OrderEntity;
// -- сервіс, який містить бізнес-логіку для створення замовлень. 
import uu.app.order_service.service.OrderService;
// -- Анотації Spring Web для створення REST API. 
import org.springframework.web.bind.annotation.*;
// Позначає клас як REST-контролер — всі методи будуть повертати JSON-відповіді.
// Spring автоматично обробляє HTTP-запити до цього класу.
import jakarta.servlet.http.HttpServletRequest;
@RestController
// Встановлює базовий шлях для всіх запитів до цього контролера: /orders. 
@RequestMapping("/orders")
// Оголошення публічного класу OrderController, який обробляє запити, 
// пов'язані з замовленнями. 
public class OrderController {
    // Залежність для сервісу замовлень, який містить основну бізнес-логіку.
    private final OrderService orderService;
    // Конструктор з ін’єкцією залежності OrderService, яку Spring
    // автоматично передає.
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    // Позначає метод як такий, що обробляє HTTP POST-запити на шлях /orders.
    @PostMapping
    // Метод createOrder приймає JSON з тіла запиту, який автоматично
    // перетворюється у OrderEntity за допомогою анотації @RequestBody.
    public OrderEntity createOrder(@RequestBody OrderEntity order, HttpServletRequest request) {
        // Передає об’єкт замовлення до OrderService для обробки.
        // Повертає результат — створене замовлення.
        return orderService.createOrder(order, request);
    }
}