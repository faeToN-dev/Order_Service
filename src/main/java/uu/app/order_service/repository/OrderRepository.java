// Оголошення пакету repository в сервісі замовлень
package uu.app.order_service.repository;
// Імпортує: 
// -- OrderEntity — JPA-сутність, яка відповідає таблиці orders. 
import uu.app.order_service.entity.OrderEntity;
// -- JpaRepository — інтерфейс Spring Data JPA, який забезпечує стандартні 
// CRUD-операції (Create, Read, Update, Delete). 
import org.springframework.data.jpa.repository.JpaRepository;
// Оголошення інтерфейсу репозиторію для роботи з таблицею замовлень. 
// extends JpaRepository<OrderEntity, Long>: 
// -- Вказує, що репозиторій працює з об'єктами типу OrderEntity. 
// -- Long — тип первинного ключа (id) у OrderEntity. 
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}