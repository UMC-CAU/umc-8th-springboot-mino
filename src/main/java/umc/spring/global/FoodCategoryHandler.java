package umc.spring.global;

import lombok.Getter;
import umc.spring.global.apipayload.GeneralException;
import umc.spring.global.apipayload.code.BaseErrorCode;
import umc.spring.global.apipayload.code.status.ErrorStatus;

@Getter
public class FoodCategoryHandler extends GeneralException {

	public FoodCategoryHandler(ErrorStatus errorStatus) {
		super(errorStatus);
	}

}
