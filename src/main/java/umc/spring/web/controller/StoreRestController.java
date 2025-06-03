package umc.spring.web.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.dto.StoreResponseDTO;
import umc.spring.global.ApiResponse;
import umc.spring.service.StoreQueryService;
import umc.spring.validation.annotation.ExistStore;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

	private final StoreQueryService storeQueryService;

	@GetMapping("/{storeId}/reviews")
	@Operation(summary = "가게 리뷰 조회 API",description = "가게 리뷰를 조회합니다. 페이징을 포함합니다. query String으로 page 번호를 주세요")
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
	})
	@Parameters({
		@Parameter(name = "storeId",description = "가게 아이디, path variable",required = true)
	})
	public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page) {
		storeQueryService.getReviewList(storeId, page);
		return null;
	}
}
