package com.emp.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionTemplate {
	public static SqlSession getSession() {
		SqlSession session=null;
		String configName="mybatis-config.xml";
		try(InputStream is=Resources.getResourceAsStream(configName)){
			session=new SqlSessionFactoryBuilder().build(is).openSession(false);	
		// build(is) ? is가 읽어오는 config.xml의 environments에서 설정된 Default 환경("BS")으로 접속
		// 			   따라서, build(is, "BS") 라고 메소드를 사용해도 동일한 결과이다.
		// SqlSessionFactoryBuilder → (build) → SqlSessionFactory → (openSession) → SqlSession 
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	public static SqlSession getSessionWeb() {
		SqlSession session=null;
		String configName="mybatis-config.xml";
		try(InputStream is=Resources.getResourceAsStream(configName)){
			session=new SqlSessionFactoryBuilder().build(is,"web").openSession(false);	
		// build(is,"web") ? is가 읽어오는 config.xml의 environments에서 id가 web인 환경으로 접속
		// 위와 같은 설정으로 인하여 응용하여 Test용 DB와 실배포용 DB를 따로 접근하여 SqlSession 객체를 사용할 수 있다.
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	
}
