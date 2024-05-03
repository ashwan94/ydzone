<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="욘두존에 오신 것을 환영합니다." name="title" />
	<jsp:param value="훈련지원금 매달 11일" name="center" />
	<jsp:param value="" name="content" />
</jsp:include>
<style>
	.imgContainer{
		overflow:hidden;
	}
</style>

<section class="py-2">
	<div class="container px-4 px-lg-5 mt-3">
		<div class="row gx-4 gx-lg-4 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<c:forEach var="rst" items="${restaurants}">
				<a href="/restaurant/view?no=${rst.no }&restaurantName=${rst.restaurantName}&intro=${rst.intro }&open=${rst.open }&addr=${rst.addr }&tel=${rst.tel }&details=${rst.details }&hits=${rst.hits }&createDate=${rst.createDate }&fileName=${rst.fileName }&menuName=${rst.menuName}&price=${rst.price}&category=${rst.category}">
					<div class="col mb-4">
						<div class="card">
							<div class="card border-0 text-center">${rst.no }</div>
								<div class="imgContainer">
								<!-- Product image-->
								<img class="card-img-top rounded" src="${pageContext.request.contextPath }/Source/Restaurant_images/${rst.fileName}" style="width:95%; height:35vh; margin-left:2.5%;" alt="${rst.fileName }"/>
								</div>
							<!-- Product details-->
							<div class="card-body pb-0">
								<div class="text-center pb-2">
									<!-- Product name-->
									<h5 class="fw-bolder m-1">${rst.restaurantName }</h5>
									<h6 class="fw-bolder m-1">${rst.menuName }</h6>
									<!-- Product price--> 
									<span class="price">${rst.price }</span>
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer pt-0 mb-1 border-top-0 bg-transparent">
								<div class="text-center">
									<div class="btn btn-outline-dark my-1">${rst.intro }</div>
									<div class="btn btn-outline-dark my-1">${rst.details }</div>
								</div>
							</div>
						</div>
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />