package com.web.model.service;

import static com.emp.common.SessionTemplate.getSessionWeb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.model.dao.MemberDao;
import com.web.model.dao.MemberDaoImpl;
import com.web.model.dto.Member;

public class MemberServiceImpl implements MemberService {

	private MemberDao dao = new MemberDaoImpl();
	
	@Override
	public List<Member> searchAll(Map<String, Integer> page) {
			SqlSession session = getSessionWeb();
			List<Member> members = dao.searchAll(session, page);
			session.close();
			return members;
	}


	@Override
	public List<Member> searchMemberList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

}
