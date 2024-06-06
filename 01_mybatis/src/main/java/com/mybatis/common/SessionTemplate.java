package com.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionTemplate {
	
	// MyBatis를 이용해서 DB에 접근하는 객체를 제공해주는 메소드
	public static SqlSession getSession() {
		// SqlSession 객체를 생성하는 방법
		// 1) SqlSessionFactoryBuilder 클래스를 기본생성자를 이용하여 생성
		//    - build() 메소드를 이용하여 SqlSessionFactory 클래스를 가져온다.
		//	  - 단, build() 메소드의 매개변수로는 mybatis-config.xml(DB에 접근할 수 있는 정보를 갖고있다.)을 전달한다
		//		(= 파일을 매개변수로 전달해줘야한다. 따라서 InputStream필요)
		// 2) 생성된 SqlSessionFactory 클래스가 제공하는 openSession() 메소드를 이용
		// 	  - 해당 메소드는 SqlSession 객체를 return한다.
		//    - openSession()의 매개변수로는 true/false 를 전달한다. → autoCommit에 대한 설정
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSession session = null;
		// mybatis-config.xml 파일 가져오기
		String fileName = "mybatis-config.xml";
		try(InputStream is = Resources.getResourceAsStream(fileName);){
			// org.apache.ibatis.io.Resources; 에서 InputStream을 가져옴
			// 가져온 파일(is)를 매개변수로 전달하여 SqlSessionFactory 객체를 생성
			SqlSessionFactory sf = sfb.build(is);
			session = sf.openSession(false);	// autoCommit이 false인 SqlSEssion 객체 생성
		} catch(IOException e) {
			e.printStackTrace();
		} return session;
		// 현재 return 해주는 session의 경우에는 close, commit, rollback 등의 모든 기능이 있다.
	}
	
}
