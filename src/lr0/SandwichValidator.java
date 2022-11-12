package lr0;

import lr0.food.Bread;
import lr0.food.Eatable;

import java.util.ArrayList;
import java.util.Collection;

public class SandwichValidator {
    public Collection<ValidationError> validate(Sandwich sandwich) {
        var errors = new ArrayList<ValidationError>();

        if (sandwich.getRecipe().size() == 0) {
            errors.add(new ValidationError("Бутерброд не содержит никаких ингридиентов"));
            return errors;
        }

        Eatable firstSlice = sandwich.getRecipe().getFirst();
        Eatable lastSlice = sandwich.getRecipe().getLast();
        int size = sandwich.getRecipe().size();
        switch (size) {
            case 1:
                errors.add(new ValidationError("Бутерброд не может состоять из одного куска хлеба"));
                break;
            case 2:
                if (firstSlice instanceof Bread && lastSlice instanceof Bread) {
                    errors.add(new ValidationError("Бутерброд не может быть без начинки"));
                } else {
                    errors.add(new ValidationError("Бутерброд должен быть закрыт хлебом с двух сторон"));
                }
                break;
            case 3:
                if (!(firstSlice instanceof Bread)) {
                    errors.add(new ValidationError("Бутерброд должен начинаться с хлеба, даже если вы Матроскин, потому что такое ТЗ"));
                }

                if (!(lastSlice instanceof Bread)) {
                    errors.add(new ValidationError("Бутерброд должен быть закрыт куском хлеба"));
                }
                break;
        }

        return errors;
    }
}
