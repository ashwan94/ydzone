<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer class="py-5 bg-dark">
<div class="container">
	<p class="m-0 text-center text-white">Copyright &copy; In memory of Yondu Udonta... Since 2024</p>
</div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="/Bootstrap/js/scripts.js"></script>
<script>
	const priceEl = document.querySelectorAll(".price");
	
	priceEl.forEach(el => {
		if(el == null) {
			console.log("There are no any price elements");
		} else{			
			el.innerText = parseInt(el.innerText).toLocaleString() + "원";
		}
	})
	
	/* const searchBar = document.querySelector("#searchBar");
	searchBar.select(); */
	
	const loginCheck = document.querySelector("#loginCheck");
	const stanbyRestaurant = document.querySelector("#stanbyRestaurant");
	
	stanbyRestaurant.addEventListener("click", function(e) {
		e.preventDefault();
		
		if(loginCheck) {
			alert("로그인 이후 이용 가능합니다.");
			location.href = "/login";
		}else{
			location.href = "/restaurant/stanby?userNo=" + stanbyRestaurant.getAttribute("data-value");
		}
	})
</script>
</body>
</html>