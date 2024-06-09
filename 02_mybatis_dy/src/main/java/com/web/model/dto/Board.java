package com.web.model.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private int boardNo;
	private String boardTitle;
	// private String boardWriter;
	private Member boardWriter;	// Board에서 작성자(Member)를 조회하는 방향성 주입(1:1)
	private String boardContent;
	private String boardOriginalFileName;
	private String boardRenamedFileName;
	private Date boardDate;
	private int boardReadCount;
	private List<BoardComment> comments; // Board에서 댓글(List<BoardComment>)을 조회하는 방향성 주입(1:多)
}
