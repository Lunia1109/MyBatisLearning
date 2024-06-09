package com.web.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.web.model.dto.Board;

public class BoardDaoImpl implements BoardDao {

	@Override
	public List<Board> searchAllBoard(SqlSession session, Map<String, Integer> page) {
		int cPage= page.get("cPage");
		int numPerpage = page.get("numPerpage");
		RowBounds rb = new RowBounds((cPage-1)*numPerpage+1, numPerpage);
		// 잊지말자, RowBounds의 매개변수는 몇번 째 ((cPage-1)*numPerpage+1) 부터 몇 개(numPerpage) 가지고 올것인가? 를 설정해준다.
		return session.selectList("board.searchAllBoard", null, rb);
	}

}
