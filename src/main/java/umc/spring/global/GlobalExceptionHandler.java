package umc.spring.global;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@Value("${webhook.url:}")
	private String webhookUrl;

	@Value("${spring.profiles.active:local}")
	private String activeProfile;

	private final RestTemplate restTemplate = new RestTemplate();

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handle500(Exception e, HttpServletRequest request) {
		log.error("500 Error: ", e);

		// 프로파일 확인해서 local이면 무시
		if (!"prod".equals(activeProfile) && !"dev".equals(activeProfile)) {
			return ResponseEntity.status(500).body("error");
		}

		// 메시지 포맷 정의
		String content = """
                *500 ERROR 발생*
                -  요청 URL: %s
                -️  시각: %s
                -  예외 메시지: `%s`
                """.formatted(
			request.getRequestURI(),
			LocalDateTime.now(),
			e.getMessage()
		);

		// Webhook 전송
		sendToWebhook(content);

		return ResponseEntity.status(500).body("error");
	}

	private void sendToWebhook(String message) {
		if (webhookUrl == null || webhookUrl.isBlank()) return;

		Map<String, String> body = Map.of("content", message);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);
		try {
			restTemplate.postForEntity(webhookUrl, request, String.class);
		} catch (Exception e) {
			log.warn("웹훅 전송 실패: " + e.getMessage());
		}
	}
}