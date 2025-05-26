package umc.spring.global.apipayload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.global.apipayload.code.BaseErrorCode;
import umc.spring.global.apipayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

	private BaseErrorCode code;

	public ErrorReasonDTO getErrorReason() {
		return this.code.getReason();
	}

	public ErrorReasonDTO getErrorReasonHttpStatus(){
		return this.code.getReasonHttpStatus();
	}
}