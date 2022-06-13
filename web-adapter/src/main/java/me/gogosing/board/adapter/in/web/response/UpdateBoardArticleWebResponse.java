package me.gogosing.board.adapter.in.web.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import me.gogosing.support.code.board.BoardCategory;

@Schema(description = "특정 게시물 수정 응답 모델")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateBoardArticleWebResponse {

	@Schema(description = "식별자", example = "1", required = true)
	private final Long id;

	@Schema(description = "제목", example = "게시물 제목", required = true)
	private final String title;

	@Schema(description = "카테고리", example = "NORMAL", required = true)
	private final BoardCategory category;

	@Schema(description = "내용", example = "게시물 내용", required = true)
	private final String contents;

	@Schema(description = "생성일", example = "yyyy-MM-dd", required = true)
	private final LocalDateTime createDate;

	@Schema(description = "수정일", example = "yyyy-MM-dd", required = true)
	private final LocalDateTime updateDate;

	@Schema(description = "첨부파일 목록")
	private final List<UpdateBoardAttachmentWebResponse> attachments;
}