<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="넥스트 우돈타 인증" name="title"/>
	<jsp:param value="욘두동 Log - In" name="center"/>
	<jsp:param value="알고 계셨나요? 사람은 밥을 먹어야 살 수 있습니다" name="content"/>
</jsp:include>
<style>
label {
	display: block;
}

#log {
	color: red;
}
</style>
</head>
<body>
	<div class="row">
		<div class="col-4"></div>
		<div class="col-4 my-5 p-3 border rounded">
			<h2 class="text-center">로그인</h2>
			<form action="/login" method="post">
				<label class="my-3 ms-5">
					<h5 class="ms-3">ID</h5>
					<input type="text" name="id" value="${cookie.savedId.value }" placeholder="아 이 디" size="40" class="mb-1">
				</label>
				<label class="ms-5">
					<h5 class="ms-3">비번</h5>
					<input type="password" name="password" placeholder="P W" size="40" class="mb-1">
				</label>
				<label class="ms-5 mb-3">
					<input type="checkbox" name="saveId" value="true" class="text-start ms-3"> ID 기억
				</label>
					<div id="log">${msg }</div>
					<div class="text-center">
						<button type="submit" class="btn btn-dark me-5">로그인</button>
						<button type="button" class="btn btn-dark" onclick="history.back()">취소</button>
					</div>
			</form>
		</div>
		<div class="mb-5 text-center">
			<a href="/signUp" class="text-secondary" style="font-size:12px; margin-top:0px auto;">우리는 당신을 기다립니다</a>
		</div>
	<div class="col-4"></div>
</div>
</body>
</html>
<script>
	const idEl = document.querySelector("[name='id']");
	idEl.select();
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
