package umc.spring.global.apipayload.code.status;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.global.apipayload.code.BaseErrorCode;
import umc.spring.global.apipayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
	FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD4001", "해당 카테고리를 찾을 수 없습니다."),
	STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4001", "해당 가게를 찾을 수 없습니다."),
	_INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "SERVER5000", "서버 내부 오류가 발생했습니다."),
	_BAD_REQUEST(HttpStatus.BAD_REQUEST, "BAD4000", "파라미터가 잘못됐어요.");

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;

	@Override
	public ErrorReasonDTO getReason() {
		return ErrorReasonDTO.builder()
			.message(message)
			.code(code)
			.isSuccess(false)
			.build();
	}

	@Override
	public ErrorReasonDTO getReasonHttpStatus() {
		return ErrorReasonDTO.builder()
			.message(message)
			.code(code)
			.isSuccess(false)
			.httpStatus(httpStatus)
			.build();
	}
}
