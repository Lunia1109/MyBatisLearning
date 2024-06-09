package com.emp.common;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class StringToArrayTypeHandler implements TypeHandler<String[]> {
	
	// ResultSet 에서 String을 가져와서 해당 String으로 String[]을 가져오기 위한 메소드
	@Override
	public String[] getResult(ResultSet rs, String columnName) throws SQLException {
		// 해당 컬럼(cloumnName)에 있는 값(value)이 null아니면 ","를 기준으로 잘라서 String[]로 return
		return rs.getString(columnName)!=null?rs.getString(columnName).split(","):null;
	}

	// 인덱스 번호로 사용자가 String을 가져올 때 사용할 메소드
	@Override
	public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
		// 해당 컬럼(cloumnIndex)에 있는 값(value)이 null아니면 ","를 기준으로 잘라서 String[]로 return
		return rs.getString(columnIndex)!=null?rs.getString(columnIndex).split(","):null;
	}
	
	
	@Override
	public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// CallableStatement ? Procedure를 실행해서 결과를 가져온 값을 담는 타입으로 ResultSet이라고 생각해도된다.
		return cs.getString(columnIndex) != null? cs.getString(columnIndex).split(",") : null;
	}
	
	// 저장할 때 사용할 메소드 → 외부에서 받은 String[]을 DB에 저장할 때 몇 번째 컬럼의 인덱스에 해당 배열을 넣을지 정해주는 메소드
	@Override
	public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
		if(parameter!=null) {
			ps.setString(i, String.join(",", parameter));
		} else {
			ps.setString(i, null);
		}

	}

}
