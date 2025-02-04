package cont.com.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
// metadata annotation
// La anotación personalizada se incluirá en la documentación generada por JavaDoc
@Documented
// CityFormatValidator es la clase que implementa la lógica de validación
@Constraint(validatedBy = CityFormatValidator.class)
// La anotación personalizada se puede aplicar a métodos y campos
@Target({ElementType.METHOD, ElementType.FIELD})
// La anotación personalizada se conservará en tiempo de ejecución
@Retention(RetentionPolicy.RUNTIME)
public @interface CityFormatConstraint {
    String message() default "Invalid format of the city";

    Class<?>[] groups () default {};
    // Groups es un atributo que se utiliza para asignar restricciones de validación a un grupo específico
    // de restricciones de validación

    Class<? extends Payload>[] payload() default {};
    // Paylod es un tipo de interfaz que se utiliza para adjuntar metadatos a una restricción de validación
}
