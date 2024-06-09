package com.web.model.service;

import java.util.List;
import java.util.Map;

import com.web.model.dto.Board;

public interface BoardService {
	List<Board> searchAll(Map<String, Integer> page);
}
