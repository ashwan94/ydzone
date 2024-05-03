<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시글 목록" name="title" />
</jsp:include>
<h2>게시판</h2>
<table>
	<tr>
		<th>글 번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>조회 수</th>
	</tr>
	<c:forEach var="qna" items="${qnas }">
		<tr>
			<td>${qna.no }</td>
			<td><a href="/qna/view?no=${qna.no }">${qna.title }</a></td>
			<td>${qna.writer }</td>
			<td>${qna.createDate }</td>
			<td>${qna.hits }</td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />