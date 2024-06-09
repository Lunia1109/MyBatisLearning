package com.web.model.service;

import java.util.List;
import java.util.Map;

import com.web.model.dto.Member;

public interface MemberService {
	List<Member> searchAll(Map<String, Integer> page);	// 페이징 처리를 위한 매개변수의 처리 방법
	// 멤버 항목별 조회 구현하기 숙제
	List<Member> searchMemberList(Map<String, Object> param);
}
