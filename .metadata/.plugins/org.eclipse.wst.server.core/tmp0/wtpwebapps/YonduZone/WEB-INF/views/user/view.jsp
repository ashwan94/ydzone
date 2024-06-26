<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="마이페이지" name="title" />
</jsp:include>
<style>
	.userInfo div{
		margin:20px;
	}
</style>

<c:set var="user" value="${userInfo }" />
<div class="row my-5">
	<div class="col-4"></div>
	<div class="col-4 text-center border p-3 userInfo">
		<div>아이디 <br> ${user.id }</div>
		<div>
			비번 <br> <input type="password" value="${user.pw }" readonly disabled>
		</div>
		<div>닉네임 <br> ${user.nickName }</div>
		<div>이메일 <br> ${user.email }</div>
		<div>가입 일자<br> ${user.createDate }</div>		
		<div class="col-4"></div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />