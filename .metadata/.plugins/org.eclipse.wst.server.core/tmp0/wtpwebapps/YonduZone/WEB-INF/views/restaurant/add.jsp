<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="신규 음식점 입점 신청" name="title" />
	<jsp:param value="신규 음식점 등록" name="center" />
</jsp:include>
<jsp:include page="/WEB-INF/views/kakaoMap/mapCSS.jsp" />
<style>
	label{
		display:block;
		margin:3%;
	}
	label div{
		margin:1%;
	}
</style>
<div class="row mt-2">
	<div class="col-8">
	<jsp:include page="/WEB-INF/views/kakaoMap/kakaoMap.jsp" />
	</div>
	<div class="col-4">
		<form action="/restaurant/add" method="post" id="addInfo" enctype="multipart/form-data" class="text-center border rounded pb-3">
			<label>
			<div>상호명 (*)</div>
			<input type="text" name="restaurantName"
				placeholder="아라치 치킨">
			</label>
			<label><div>한 줄 소개</div><textarea rows="5" cols="30" name="intro"
					placeholder="200 글자 이내"></textarea>
			</label>
			<label>
				<div>이미지 (*)</div>
				<div><input type="file" name="img" accept="image/*" multiple></div>
			</label>
			<label><div>영업 시간</div><input type="text" name="open"
				placeholder="09:00 ~ 17:00">
			</label> <label><div>주소</div><input type="text" name="addr"
				placeholder="맵 주소를 복붙하세요">
			</label>
			<label><div>연락처</div><input type="tel" name="tel"
				placeholder="042-719-8850">
			</label> <label><div>편의</div><input type="text" name="details">
			</label>
			<button class="btn btn-outline-dark" id="submitBtn">완료</button>
			<button type="button" class="btn btn-outline-dark">취소</button>
		</form>
	</div>
</div>

<script>
	const btn = document.querySelector("#submitBtn");
	const rstName = document.querySelector("[name='restaurantName']");
	const imgEl = document.querySelector("[name='img']");
	btn.addEventListener("click", function(e) {
		e.preventDefault();
		
		if(rstName.value == "") {
			alert("상호명을 입력하세요.");
			rstName.focus();
			
		}else{
			if(imgEl.value == "") {
				alert("이미지를 최소 1개 이상 업로드하세요");
				imgEl.focus();
			}else{
				const form = document.querySelector("#addInfo");
				form.submit();
			}
		}
	})
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />