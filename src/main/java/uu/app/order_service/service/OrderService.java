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
import org.springframework.web.client.RestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserClient userClient;
    private final RestTemplate restTemplate;
    public OrderService(RestTemplate restTemplate, OrderRepository orderRepository, UserClient userClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
        this.restTemplate = restTemplate;
    }
    public OrderEntity createOrder(OrderEntity order, HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authHeader);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<UserDTO> userResponse = restTemplate.exchange(
                "http://localhost:8081/users/" + order.getUserId(),
                HttpMethod.GET,
                entity,
                UserDTO.class
        );
        return orderRepository.save(order);
    }
}