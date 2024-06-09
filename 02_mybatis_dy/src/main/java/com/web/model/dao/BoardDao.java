package com.web.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.model.dto.Board;

public interface BoardDao {
	List<Board> searchAllBoard(SqlSession session, Map<String, Integer> page);
}
