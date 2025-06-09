// Оголошення пакету, в якому знаходиться клас OrderEntity 
package uu.app.order_service.entity;
// імпортує JPA-анотації, які використовуються для визначення сутностей, 
// таблиць, колонок тощо. 
import jakarta.persistence.*;
// імпортує анотації Lombok, які генерують код автоматично 
// (гетери, сетери, конструктори тощо). 
import lombok.*;
// Позначає клас як JPA-сутність, яка буде відображена у таблицю бази даних. 
@Entity
// Визначає назву таблиці в базі даних як "orders". 
@Table(name = "orders")
// Lombok-анотації, які автоматично створюють: 
// -- гетери, сетери, toString(), equals(), hashCode(). 
@Data
// -- конструктор без параметрів. 
@NoArgsConstructor
// -- конструктор з усіма полями. 
@AllArgsConstructor
// -- дозволяє створювати об'єкти через шаблон Builder. 
@Builder
// Оголошення класу OrderEntity, який описує структуру запису замовлення у таблиці orders.
        public class OrderEntity {
            // @Id — позначає поле як первинний ключ.
            // @GeneratedValue(...) — значення id генерується автоматично базою (стратегія IDENTITY означає автоінкремент).
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            // Ідентифікатор користувача, який зробив замовлення.
            private Long userId;
            // Назва продукту, який замовляється.
            private String product;
            // Кількість одиниць продукту в цьому замовленні.
            private int quantity;
        }