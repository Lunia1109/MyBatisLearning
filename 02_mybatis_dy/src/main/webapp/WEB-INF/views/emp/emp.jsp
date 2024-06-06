<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사원조회</h2>
	<div id="search-container">
		<form action="${path}/emp/searchEmp.do">
			<table>
				<tr>
					<td>
						<select name="type">
							<option value="emp_id">사원번호</option>
							<option value="emp_name">사원이름</option>
							<option value="email">이메일</option>
							<option value="phone">전화번호</option>
						</select>
					</td>
					<td>
						<input type="text" name="keyword">
					</td>
				</tr>
				<tr>
					<td>
						성별
					</td>
					<td>
						<label><input type="radio" name="gender" value="M">남</label>
						<label><input type="radio" name="gender" value="F">여</label>
					</td>
				</tr>
				<tr>
					<td>급여</td>
					<td>
						<input type="number" name="salary" step="500000" min="1200000">
						<label><input type="radio" name="salFlag" value="ge"/>이상</label>
						<label><input type="radio" name="salFlag" value="le"/>이하</label>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="조회">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<table>
      <tr>
         <th>사원아이디</th>
         <th>사원명</th>
         <th>주민번호</th>
         <th>이메일</th>
         <th>전화번호</th>
         <th>부서코드</th>
         <th>직책코드</th>
         <th>급여레벨</th>
         <th>급여</th>
         <th>보너스</th>
         <th>매니저아이디</th>
         <th>고용일</th>
         <th>퇴사일</th>
         <th>성별</th>
      </tr>
      <tbody>
         <c:if test="${not empty employee }">
            <c:forEach var="e" items="${employee }">
               <tr>
                  <td>${e.empId }</td>
                  <td>${e.empName }</td>
                  <td>${e.empNo }</td>
                  <td>${e.email }</td>
                  <td>${e.phone }</td>
                  <td>${e.deptCode }</td>
                  <td>${e.jobCode }</td>
                  <td>${e.salLevel }</td>
                  <td>
                     <fmt:formatNumber value="${e.salary }" 
                     type="currency"/>
                  </td>
                  <td>
                     <fmt:formatNumber value="${e.bonus }"
                     type="percent"/>
                  </td>
                  <td>${e.managerId }</td>
                  <td>
                     <fmt:formatDate value="${e.hireDate }"
                     dateStyle="short"/>
                  </td>
                  <td>
                     <fmt:formatDate value="${e.entDate }"
                     dateStyle="full"/>
                  </td>
                  <td>
                  	${e.gender=="M"?"남":"여"  }
                  </td>
               </tr>
            </c:forEach>
         </c:if>
      </tbody>
   </table>
</body>
</html>