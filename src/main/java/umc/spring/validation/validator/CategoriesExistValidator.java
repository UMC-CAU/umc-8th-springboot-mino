package umc.spring.validation.validator;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.global.apipayload.code.status.ErrorStatus;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.validation.annotation.ExistCategories;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

	private final FoodCategoryRepository foodCategoryRepository;

	@Override
	public void initialize(ExistCategories constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
		boolean isValid=values.stream()
			.allMatch(foodCategoryRepository::existsById);

		if(!isValid){
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.getMessage()).addConstraintViolation();
		}
		return isValid;
	}
}
