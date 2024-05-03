<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param value="음식점 상세 정보" name="title"/>
</jsp:include>
<style>
	#restaurantInfo th{
		color:grey;
	}
	#subTitle span{
		color:grey;
		font-size:12px;
	}
</style>
<jsp:include page="/WEB-INF/views/kakaoMap/mapCSS.jsp"/>

<!-- TODO if 문으로 만약 STANBY 음식점이 없으면 '없습니다' 라는 IMG 출력 -->
<c:set var="info" value="${rstDetailInfo }"/>
<div class="text-center row">
	<div class="col-1"></div>
	<div class="col-10">
		<img class="rounded p-2" style="width:50%;height:50vh;" src="${pageContext.request.contextPath }/Source/Restaurant_images/${info.fileName}" alt="${info.fileName }"/>
	</div>
	<div class="col-1"></div>

<div class="row">
	<div class="col-1"></div>
	<div class="row col-7 text-start">
		<div class="col-4 ms-5"></div>
		<div class="col-7">
			<h2 id="rstName">${info.restaurantName }</h2>
			<div>${info.intro }</div>
			<div class="mb-3" id="subTitle">
			<span class="me-3">${info.hits }</span>
			<span class="me-3">${info.category }</span>
		</div>
		<div class="col-1"></div>
		</div>
	</div>
	<div class="col-4"></div>
</div>
<div class="row">
	<div class="col-3"></div>
		<div class="col-6 card py-3">
			<table id="restaurantInfo">
				<tr>
					<th>메뉴</th>
					<td>${info.menuName }</td>
				</tr>
				<tr>
					<th>가격</th>
					<td class="price">${info.price }</td>
				</tr>
				<tr>
					<th>영업 시간</th>
					<td>${info.open }</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${info.tel }</td>
				</tr>
				<tr>
					<th>편의</th>
					<td>${info.details }</td>
				</tr>
				<tr hidden>
					<th>주소</th>
					<td id="addr">${info.addr }</td>
				</tr>
				
			</table>
		</div>
		<div class="col-3"></div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/kakaoMap/kakaoMap.jsp"/>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>