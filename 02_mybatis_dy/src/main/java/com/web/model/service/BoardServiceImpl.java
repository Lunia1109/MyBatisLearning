package com.web.model.service;

import static com.emp.common.SessionTemplate.getSessionWeb;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.model.dao.BoardDao;
import com.web.model.dao.BoardDaoImpl;
import com.web.model.dto.Board;

public class BoardServiceImpl implements BoardService {

	private BoardDao dao = new BoardDaoImpl();
	@Override
	public List<Board> searchAll(Map<String, Integer> page) {
		SqlSession session = getSessionWeb();
		List<Board> boards = dao.searchAllBoard(session, page);
		session.close();
		return boards;
	}
	
}
