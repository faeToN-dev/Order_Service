// Оголошення пакету, в якому знаходиться клас UserDTO 
// dto (Data Transfer Object) — це об'єкти, що використовуються 
// для передачі даних між сервісами, не пов'язані напряму з базою даних. 
package uu.app.order_service.dto;
// Імпортується анотація @Data з бібліотеки Lombok, яка автоматично генерує 
// гетери і сетери для всіх полів, метод toString(), методи equals() і hashCode().
import lombok.Data;
// Анотація @Data замінює ручне написання гетерів та сетерів, toString,equals, hashCode.
@Data
// Оголошення публічного класу UserDTO, який використовується 
// для представлення даних користувача (DTO-модель). 
public class UserDTO {
    // Ідентифікатор користувача
    private Long id;
    // Ім’я користувача.
    private String name;
    // Електронна пошта користувача.
    private String email;
}