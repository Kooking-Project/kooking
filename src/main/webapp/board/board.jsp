<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../common/header.jsp" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>커뮤니티 | KOOKING</title>



<style type="text/css">

/* 링크 색상 (중요하지 않음) */
a {
	text-decoration: none;
	color: #333;
}

a:hover {
	color: #F2594B;
}

/* 테이블 색상 (중요하지 않음) */
table {
	width: 80%;
	margin: 40px auto 10px;
	border-collapse: collapse;
}

th {
	background: #77ACF2;
	color: #ffffff;
}

td, th {
	border: 1px solid #dbdbdb;
	padding: 5px 20px;
	font-size: 12px;
	text-align: center;
	color: #592918;
}

tr {
	background: #F2DDD5;
}

/* 컬럼의 너비 */
.select {
	width: 3%;
}

.no {
	width: 6%;
}

.title { /* 나머지가 자동으로 맞춰집니다. */
	
}

.writer {
	width: 20%;
}

.date {
	width: 15%;
}

/* 컬럼의 정렬 */
tr td:nth-child(1) {
	text-align: center;
}

tr td:nth-child(2) {
	text-align: center;
}

tr td:nth-child(3) {
	text-align: left;
}

tr td:nth-child(4) {
	text-align: center;
}

tr td:nth-child(5) {
	text-align: center;
}

/* 페이징 버튼 */
.page-box {
	width: 80%;
	margin: 5px auto;
	height: 30px;
	text-align: center;
}

.page-box a.btn {
	display: inline-block;
	padding: 3px 5px;
	font-size: 15px;
	border: 1px solid #dbdbdb;
	color: #333;
	font-weight: bold;
}

.page-box a.btn.on {
	background-color: #dbdbdb;
}

.search-container {
	width: 490px;
	display: block;
	margin: 0 auto;
}

input#search-bar {
	margin: 0 auto;
	width: 100%;
	height: 45px;
	padding: 0 20px;
	font-size: 1rem;
	border: 1px solid #D0CFCE;
	outline: none; &: focus { border : 1px solid #008ABF;
	transition: 0.35s ease;
	color: #008ABF; &:: -webkit-input-placeholder { transition : opacity
	0.45s ease;
	opacity: 0;
}

&
::-moz-placeholder {
	transition: opacity 0.45s ease;
	opacity: 0;
}

&
:-ms-placeholder {
	transition: opacity 0.45s ease;
	opacity: 0;
}

}
}
.search-icon {
	position: relative;
	float: right;
	width: 43px;
	height: 44px;
	top: -44px;
	background-color: #592918;
}

.wrapper {
	max-width: 1500px;
	width: 100%;
	margin: 50px auto;
	padding: 30px;
}

.boardWrite {
	max-width: 1275px;
	/*  width : 100%; */
}

.pagination-container {
	margin: 100px auto;
	text-align: center;
}

.pagination {
	position: relative;
}

.pagination a {
	position: relative;
	display: inline-block;
	color: #2c3e50;
	text-decoration: none;
	font-size: 1.2rem;
	padding: 8px 16px 10px;
}

.pagination a:before {
	z-index: -1;
	position: absolute;
	height: 100%;
	width: 100%;
	content: "";
	top: 0;
	left: 0;
	background-color: #2c3e50;
	border-radius: 24px;
	-webkit-transform: scale(0);
	transform: scale(0);
	transition: all 0.2s;
}

.pagination a:hover, .pagination a .pagination-active {
	color: #fff;
}

.pagination a:hover:before, .pagination a .pagination-active:before {
	-webkit-transform: scale(1);
	transform: scale(1);
}

.pagination .pagination-active {
	color: #fff;
}

.pagination .pagination-active:before {
	-webkit-transform: scale(1);
	transform: scale(1);
}

.pagination-newer {
	margin-right: 50px;
}

.pagination-older {
	margin-left: 50px;
}
</style>

<script type="text/javascript">
	function checkValid() {
		var f = window.document.search - container;

		if (f.search - bar.value == "") {
			alert("제목을 입력해 주세요.");
			f.content.focus();
			return false;
		}

		return true;
	}
</script>

</head>

<body>
	<!-- Preloader -->
	<div id="preloader">
		<i class="circle-preloader"></i> <img
			src="${pageContext.request.contextPath}/img/core-img/salad.png"
			alt="">
	</div>
	<!--  Preloader End -->

	<!-- ##### Breadcumb Area Start ##### -->
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(${pageContext.request.contextPath}/img/bg-img/breadcumb5.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-text text-center">
						<h2 style="font-style: italic">함께 유용한 요리 정보를 나누어 봐요!</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Breadcumb Area End ##### -->

	<div class="wrapper">

		<div class="category" align="left">
			<div class="col-lg-6">
				<a href="board.jsp" class="btn delicious-small-btn btn-3">전체</a>
				<!-- "${pageContext.request.contextPath}/front?key=user&methodName=logout" 필터 메소드 -->
				<a href="board.jsp" class="btn delicious-small-btn btn-3">TIP</a> <a
					href="board.jsp" class="btn delicious-small-btn btn-3">Q&A</a> <a
					href="board.jsp" class="btn delicious-small-btn btn-3">후기</a>
			</div>
		</div>

		<table>
			<colgroup>
				<col class="no">
				<col class="category">
				<col class="title">
				<col class="writer">
				<col class="date">
				<col class="views">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>카테고리</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty requestScope.postList}">
						<tr>
							<td colspan="6">등록된 게시글이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${requestScope.postList}" var="board">
							<c:if test="${board.postTypeNo != 1}">
								<tr>
									<td>${board.no}</td>
									<c:choose>
										<c:when test="${board.postTypeNo == 2}">
											<td><a href="#">TIP</a></td>
										</c:when>
										<c:when test="${board.postTypeNo == 3}">
											<td><a href="#">후기</a></td>
										</c:when>
										<c:otherwise>
											<td><a href="#">QNA</a></td>
										</c:otherwise>
									</c:choose>
									<td><a
										href="${pageContext.request.contextPath}/front?key=post&methodName=selectPostDetail&postNo=${board.no}">${board.title}</a></td>
									<td><a
										href="${pageContext.request.contextPath}/front?key=user&methodName=userInfoByNo&userNo=${userDTO.no}">${board.userNicname}</a></td>
									<td>${board.date}</td>
									<td>${board.counts}</td>
								</tr>
							</c:if>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<div class="boardWrite" align="right">
			<div class="col-lg-6">
				<c:if test="${userDTO != null}">
					<a href="${pageContext.request.contextPath}/board/boardWrite.jsp"
						class="btn delicious-small-btn btn-3">글쓰기</a>
				</c:if>
			</div>
		</div>

		<form class = "search-container" name="search-container" method="post"
			action="${pageContext.request.contextPath}/front?key=post&methodName=searchPostName"
			onSubmit='return checkValid()'>
			<input type="text" id="search-bar" name="search-bar"
				placeholder="제목을 입력해 주세요."><a href="#"><img class="search-icon"
				src="http://www.endlessicons.com/wp-content/uploads/2012/12/search-icon.png"></a>
		</form>

	</div>
	
	  <jsp:useBean class="com.kooking.paging.Pagenation" id="p"/> 
    
 <!--  블럭당  -->
 <nav class="pagination-container">
		<div class="pagination">
		<c:set var="doneLoop" value="false"/>	
		<c:set var="temp" value="${(pageNo-1) % 10}"/> 
		<c:set var="startPage" value="${pageNo - temp}"/> 				
		  <c:if test="${(startPage-p.pageSize) > 0}"> 
		      <a class="pagination-newer" href="${path}/front?key=postc&methodName=selectPost&pageNo=${startPage-1}">PREV</a>
		  </c:if>		  		 		
		<span class="pagination-inner"> 
			  <c:forEach var='i' begin='${startPage}' end='${(startPage-1)+ 10}'> 
				  <c:if test="${(i-1)>=p.pageCnt}">
				       <c:set var="doneLoop" value="true"/>
				    </c:if> 
				  <c:if test="${not doneLoop}" >
				         <a class="${i==pageNo?'pagination-active':page}" href="${path}/front?key=postmethodName=selectPost&pageNo=${i}">${i}</a> 
				  </c:if>	  
			</c:forEach>
		</span> 
			 <c:if test="${(startPage+p.pageSize)<=p.pageCnt}">
			     <a class="pagination-older" href="${path}/front?key=post&methodName=selectPost&pageNo=${startPage+p.pageSize}">NEXT</a>
			 </c:if>		
		</div>
	</nav>
 
<jsp:include page="../common/footer.jsp"/>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>

</html>
<jsp:include page="../common/footer.jsp" />