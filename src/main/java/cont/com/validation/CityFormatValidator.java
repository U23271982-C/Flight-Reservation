package cont.com.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
// Validamos que el formato de la ciudad sea correcto, aquí se aplica la lógica de la anotación
public class CityFormatValidator implements ConstraintValidator<CityFormatConstraint, String> {
    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return field != null &&
                field.length() == 3 &&
                field.matches("^[A-Z]+$");
    } // Método que se ejecuta para validar el campo

    @Override
    public void initialize(CityFormatConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    } // Método que se ejecuta antes de la validación
}
