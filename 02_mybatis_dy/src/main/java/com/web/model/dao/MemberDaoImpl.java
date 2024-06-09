package com.web.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.web.model.dto.Member;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<Member> searchAll(SqlSession session, Map<String, Integer> page) {
		if(page.get("total")==null || page.get("total")!=10) {
			RowBounds rb = new RowBounds((page.get("cPage")-1)*page.get("numPerpage"), page.get("numPerpage"));
			return session.selectList("member.searchAll", null, rb);
		} else {
			return session.selectList("member.searchAll");
		}
	}

}
