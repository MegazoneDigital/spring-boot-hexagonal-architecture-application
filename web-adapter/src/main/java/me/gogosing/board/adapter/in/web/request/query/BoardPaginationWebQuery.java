package me.gogosing.board.adapter.in.web.request.query;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.gogosing.board.application.port.in.request.query.BoardArticlePaginationInQuery;
import me.gogosing.support.code.board.BoardCategory;
import me.gogosing.support.dto.LocalDateRangeQuery;
import me.gogosing.support.validation.BetweenDate;
import org.springdoc.api.annotations.ParameterObject;

@Schema(description = "게시판 목록 조회 조건 정보 모델")
@ParameterObject
@Getter
@Setter
@NoArgsConstructor
public class BoardPaginationWebQuery {

	private static final int DEFAULT_DATE_RANGE_LIMIT = 6;

	private static final int MAXIMUM_DATE_RANGE_LIMIT = 14;

	@Parameter(description = "검색 제목 (like)")
	private String title;

	@Parameter(description = "검색 카테고리 (eq)")
	private BoardCategory category;

	@Parameter(description = "검색 내용 (like)")
	private String contents;

	@Valid
	@Parameter(description = "검색 등록기간 (between)", required = true)
	@BetweenDate(maximumDateRangeLimit = MAXIMUM_DATE_RANGE_LIMIT)
	private LocalDateRangeQuery registeredPeriod = new LocalDateRangeQuery(DEFAULT_DATE_RANGE_LIMIT);

	public BoardArticlePaginationInQuery toInQuery() {
		return BoardArticlePaginationInQuery.builder()
			.title(title)
			.category(category)
			.contents(contents)
			.registeredPeriod(registeredPeriod)
			.build();
	}
}
