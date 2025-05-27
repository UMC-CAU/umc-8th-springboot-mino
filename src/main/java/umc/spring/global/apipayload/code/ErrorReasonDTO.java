package umc.spring.global.apipayload.code;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorReasonDTO {
    private HttpStatus httpStatus;

    private final boolean isSuccess;
    private final String code;
    private final String message;
    private final String detail;

    public static class ErrorReasonDTOBuilder {
        public ErrorReasonDTOBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }
    }

    public boolean getIsSuccess(){return isSuccess;}

}