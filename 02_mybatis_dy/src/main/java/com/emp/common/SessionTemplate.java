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
			session=new SqlSessionFactoryBuilder().build(is)
					.openSession(false);//default설정된 환경으로 접속
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	public static SqlSession getSessionWeb() {
		SqlSession session=null;
		String configName="mybatis-config.xml";
		try(InputStream is=Resources.getResourceAsStream(configName)){
			session=new SqlSessionFactoryBuilder().build(is,"web")
					.openSession(false);//default설정된 환경으로 접속
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	
}
