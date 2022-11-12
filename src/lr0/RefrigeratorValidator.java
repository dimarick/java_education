package lr0;

import java.util.ArrayList;
import java.util.Collection;

public class RefrigeratorValidator {
    public Collection<ValidationError> validate(Refrigerator refrigerator) {
        var errors = new ArrayList<ValidationError>();

        if (refrigerator.isOpen()) {
            errors.add(new ValidationError("Холодильник не закрыт"));
        }

        return errors;
    }
}
