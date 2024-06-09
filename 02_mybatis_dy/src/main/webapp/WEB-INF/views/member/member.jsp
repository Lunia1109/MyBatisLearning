<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:if test="${members != null }">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>가입일</th>
			</tr>
			<c:forEach items="${members }" var="m">
				<tr>
					<td>${m.userId }</td>
					<td>${m.password }</td>
					<td>${m.userName }</td>
					<td>${m.gender }</td>
					<td>${m.age }</td>
					<td>${m.email }</td>
					<td>${m.phone }</td>
					<td>${m.address }</td>
					<td>
					 <c:if test="${m.hobby != null }">
						<ul>
							<c:forEach items="${m.hobby }" var="h">
								<li>${h }</li>
							</c:forEach>
						</ul>
					</c:if>
					</td>
					<td><fmt:formatDate value="${m.enrollDate}" dateStyle="short"/></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${boards !=null }">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>내용</th>
				<th>원본파일명</th>
				<th>수정파일명</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>댓글</th>
			</tr>
			<c:forEach items="${boards }" var="b">
				<tr>
					<td>${b.boardNo }</td>
					<td>${b.boardTitle }</td>
					<td>${b.boardWriter }</td>
					<td>${b.boardContent }</td>
					<td>${b.boardOriginalFileName }</td>
					<td>${b.boardRenamedFileName }</td>
					<td>${b.boardDate }</td>
					<td>${b.boardReadCount }</td>
					<td>
						<ul>
							<c:forEach items="${b.comments }" var="c">
								<li>
									${c.boardCommentContent }
								</li>
							</c:forEach>
						</ul>
					</td>
					<td><fmt:formatDate value="${m.enrollDate}" dateStyle="short"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div>
		<%= request.getAttribute("pageBar") %>
	</div>
</body>
</html>