<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="회원가입" name="title" />
	<jsp:param value="코딩하기 좋은 날씨네" name="center" />
	<jsp:param value="- 강성구 -" name="content" />
</jsp:include>
<style>
	label{
		display:block;
		margin-bottom:3%;
	}
</style>

<div class="row my-5">
	<div class="col-4"></div>
	<div class="col-4 border py-3 text-center">
		<form action="/signUp" method="post" id="signUpForm">
		<h3>넥스트 욘두 가입 신청서</h3>
		<label>
			<div>ID</div>
			<input type="text" name="id">
		</label>
		<label>
			<div>비번</div>
			<input type="password" name="pw">
		</label>
		<label>
			<div>EMAIL</div>
			<input type="email" name="email">
		</label>
		<label>
			<div>닉네임</div>
			<input type="text" name="nickName">
		</label>
		<input type="hidden" value="${msg }" id="msg">
		<div class="text-center mt-2">
			<button type="submit" id="submitBtn" class="btn btn-dark me-5">완료</button>
			<button type="button" id="backBtn" class="btn btn-dark">취소</button>
		</div>
		</form>
	</div>
	<div class="col-4"></div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/Bootstrap/js/scripts.js"></script>

<script>
	const msgEl = document.querySelector("#msg");
	if(msgEl.value != ""){
		alert(msgEl.value);
	}
	
	const submitBtn = document.querySelector("#submitBtn");
	const backBtn = document.querySelector("#backBtn");
	
	submitBtn.addEventListener("click", function(e) {
		e.preventDefault();
		
		const idEl = document.querySelector("[name='id']");
		const pwEl = document.querySelector("[name='pw']");
		const emailEl = document.querySelector("[name='email']");
		const nickNameEl = document.querySelector("[name='nickName']");
		
		if(idEl.value == "" || pwEl.value == "" || emailEl.value == "" || nickNameEl.value == "") {
			alert("누락된 정보가 있습니다.");
		}else{
			const form = document.querySelector("#signUpForm");
			form.submit();
		}
	})
	
	backBtn.addEventListener("click", function() {
		history.back();
	});
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>