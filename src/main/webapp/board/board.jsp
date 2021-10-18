<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/common/header.jsp" />
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
<title> 커뮤니티 | KOOKING</title>



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

.search-container{
  width: 490px;
  display: block;
  margin: 0 auto;
}

input#search-bar{
  margin: 0 auto;
  width: 100%;
  height: 45px;
  padding: 0 20px;
  font-size: 1rem;
  border: 1px solid #D0CFCE;
  outline: none;
  &:focus{
    border: 1px solid #008ABF;
    transition: 0.35s ease;
    color: #008ABF;
    &::-webkit-input-placeholder{
      transition: opacity 0.45s ease; 
  	  opacity: 0;
     }
    &::-moz-placeholder {
      transition: opacity 0.45s ease; 
  	  opacity: 0;
     }
    &:-ms-placeholder {
     transition: opacity 0.45s ease; 
  	 opacity: 0;
     }    
   }
 }

.search-icon{
  position: relative;
  float: right;
  width: 43px;
  height: 44px;
  top: -44px;
  background-color: #592918;

}


.wrapper{
  max-width: 1500px;
  width: 100%;
  margin: 50px auto;
  padding: 30px;
 
 } 
 .boardWrite{
  max-width: 1275px;
 /*  width : 100%; */
  }
}

</style>

<script type="text/javascript">
	
	$('.check.all').on('change', function(){
		  $('.check').prop('checked', $(this).prop('checked'));
		});

		$(document).on('click', '.page-box .btn.number', function(){
		  $('.page-box .btn.number').removeClass('on');
		  $(this).addClass('on');
		  return false;
		})
	
	</script>

</head>

<body>
	<!-- Preloader -->
	<div id="preloader">
		<i class="circle-preloader"></i> <img src="img/core-img/salad.png"
			alt="">
	</div>
	<!--  Preloader End -->

	<!-- ##### Breadcumb Area Start ##### -->
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(img/bg-img/breadcumb5.jpg);">
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
			<a href="board.jsp"class="btn delicious-small-btn btn-3">전체</a> <!-- "${pageContext.request.contextPath}/front?key=user&methodName=logout" 필터 메소드 -->
			<a href="board.jsp"class="btn delicious-small-btn btn-3">TIP</a>
			<a href="board.jsp"class="btn delicious-small-btn btn-3">Q&A</a>
			<a href="board.jsp"class="btn delicious-small-btn btn-3">후기</a>
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
		
<%-- 		<!-- 들어갈 choose문 -->
		
		<c:choose>
			<c:when test="${empty requestScope.boardList}">
				<tr>
					<td>
					<span>등록된 게시글이 없습니다.</span>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.boardList}" var="board">
					<tr>
						<td>${board.no}</td>
						<td><a href="#">${board.category}</a></td>
						<td><a href="#">${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.regDate}</td>
						<td>${board.count}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
	<!-- 들어갈 choose문 --> --%>
				
			<tr>
				<td>1</td>
				<td><a href="#">Q&A</a></td>
				<td><a href="#">고라니탕을 만들려고 직접 고라니를 잡으러가는대여...</a></td>
				<td>담배피는호랑이</td>
				<td>2019.10.14</td>
				<td>11</td>
			</tr>
			<tr>
				<td>2</td>
				<td><a href="#">TIP</a></td>
				<td><a href="#">선생님 잠자고 싶어요...ㅠㅠ</a></td>
				<td>거북쓰</td>
				<td>2019.10.14</td>
				<td>152</td>
			</tr>
			<tr>
				<td>33333</td>
				<td><a href="#">후기</a></td>
				<td><a href="#">으악 살려줘!!!</a></td>
				<td>토끼</td>
				<td>2019.10.14</td>
				<td>7777</td>
			</tr>
						<tr>
				<td>33333</td>
				<td><a href="#">후기</a></td>
				<td><a href="#">점심 나가서 먹을것 가태!!!!!!!!!!</a></td>
				<td>토끼</td>
				<td>2019.10.14</td>
				<td>7777</td>
			</tr>
		</tbody>		
	</table>
		<div class="boardWrite" align="right">
			<div class="col-lg-6">
				<a href="boardWrite.jsp"class="btn delicious-small-btn btn-3">글쓰기</a>
			</div>
		</div>	

  	<form class="search-container">
    	<input type="text" id="search-bar" placeholder="제목을 입력해 주세요." >
    	<a href="#"><img class="search-icon" src="http://www.endlessicons.com/wp-content/uploads/2012/12/search-icon.png"></a> <!-- "${pageContext.request.contextPath}/front?key=user&methodName=logout" 검색 메소드 -->
 	 </form>

	</div>
	
		<div class="page-box">
		<a class="btn" href="#">&lt;&lt;</a> <a class="btn" href="#">&lt;</a>
		
		<!--  숫자 버튼  -->
		<a class="btn number" href="#">1</a> 
		<a class="btn number" href="#">2</a>
		<a class="btn number on" href="#">3</a> 
		<a class="btn number" href="#">4</a>
		<a class="btn number" href="#">5</a> 
		<a class="btn" href="#">&gt;</a>
		
		<a class="btn" href="#">&gt;&gt;</a>
	</div>



</body>

</html>
<jsp:include page="/common/footer.jsp" />