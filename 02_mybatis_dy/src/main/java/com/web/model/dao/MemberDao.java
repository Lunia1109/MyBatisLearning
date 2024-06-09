package com.web.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.model.dto.Member;

public interface MemberDao {
	List<Member> searchAll(SqlSession session, Map<String, Integer> page);
}
