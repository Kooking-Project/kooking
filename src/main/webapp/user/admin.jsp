<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>어드민 페이지 | KOOKING</title>



<style type="text/css">
.main-body {
	padding: 15px;
}

.card {
	box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .1), 0 1px 2px 0
		rgba(0, 0, 0, .06);
}

.card {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 0 solid rgba(0, 0, 0, .125);
	border-radius: .25rem;
}

.card-body {
	flex: 1 1 auto;
	min-height: 1px;
	padding: 1rem;
	height: 351.63px;
}

.gutters-sm {
	margin-right: -8px;
	margin-left: -8px;
}

.gutters-sm>.col, .gutters-sm>[class*=col-] {
	padding-right: 8px;
	padding-left: 8px;
}

.mb-3, .my-3 {
	margin-bottom: 1rem !important;
}

.bg-gray-300 {
	background-color: #e2e8f0;
}

.h-100 {
	height: 100% !important;
}

.shadow-none {
	box-shadow: none !important;
}

span {
	font-weight: bold;
}

/* 게시판 */

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
	width: 100%;
	/* 	margin: 40px auto 10px; */
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
</style>


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
						<h2>관리자님 환영합니다!</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Breadcumb Area End ##### -->

	<!--  마이 페이지 / 유저 페이지를 나눌까? -->

	<!-- user Start -->

	<div class="container">
		<div class="main-body">

			<div class="row gutters-sm">
				<div class="col-md-4 mb-3">
					<!-- Breadcrumb -->
					<div aria-label="breadcrumb" class="main-breadcrumb">
						<div class="breadcrumb">
							<span style="text-align: left">관리자 정보</span>
							<c:if test="${userDTO.nickName} == ${user.nickName}">
								<a href="userUpdate.jsp" class="btn delicious-Xsmall-btn btn-3">프로필
									수정</a>
							</c:if>
						</div>
					</div>
					<!-- /Breadcrumb -->
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
									alt="Admin" class="rounded-circle" width="150">
								<div class="mt-3">
									<h4>닉네임</h4>
									<!-- 마이 페이지로 들어갔으면 내 닉네임 아니면 다른 사람 닉네임  -->
									<p class="text-secondary mb-1">성별</p>
									<p class="text-muted font-size-sm">성별이 들어갈 부분입니다.</p>
									<h5>어서오세요!</h5>
								</div>
							</div>
						</div>
					</div>
					<div class="card mt-3"></div>
				</div>

				<div class="col-md-8">
					<!-- Breadcrumb -->
					<div aria-label="breadcrumb" class="main-breadcrumb">
						<div class="breadcrumb">
							<span style="text-align: right">작성한 댓글 리스트</span>
						</div>
					</div>
					<!-- /Breadcrumb -->
					<div class="card mb-3">
						<div class="card-body">
							<table>
								<tr>
									<th>게시글번호</th>
									<th>댓글내용</th>
									<th>댓글작성날짜</th>
								</tr>
								<tr>
									<td>1</td>
									<td><a href="#">아이가 너무 좋아해요!</a></td>
									<td>1302.12.21</td>
								</tr>
								<tr>
									<td>2</td>
									<td><a href="#">먹어도 먹어도 감자튀김이 안 줄어!!!!</a></td>
									<td>1899.03.01</td>
								</tr>
								<tr>
									<td>3</td>
									<td><a href="#">악 달고나 부러졌어!!! 선생님 살려주세요!!!</a></td>
									<td>2018.10.03</td>
								</tr>
								<tr>
									<td>4</td>
									<td><a href="#">Fry loves you.</a></td>
									<td>2021.07.02</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="main-body">
			<!-- Breadcrumb -->
			<div aria-label="breadcrumb" class="main-breadcrumb">
				<div class="breadcrumb">
					<span style="text-align: left">유저 리스트</span>
				</div>
			</div>
			<!-- /Breadcrumb -->

			<div class="row gutters-sm">
				<div class="col-md-12">
					<div class="card mb-3">
						<div class="card-body">
							<table>
								<tr>
									<th>유저번호</th>
									<th>아이디</th>
									<th>닉네임</th>
									<th>성별</th>
									<th>가입일</th>
								</tr>
								<c:choose>
								<c:when test="${empty requestScope.userList}">
									<tr>
										<td colspan="5">
											<p align="center">
												<b><span style="font-size: 9pt;">등록된 유저가 없습니다.</span></b>
											</p>
										</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${requestScope.userList}" var="user">
										<tr>
											<td>${user.no}</td>
											<td><a
												href="${path}/front?key=user&methodName=selectByModelNum&modelNum=${user.no}">${user.id}</a></td>
											<td>${user.nickName}</td>
											<td>${user.gender}</td>
											<td>${user.date}</td>
										</tr>
									</c:forEach>
									</c:otherwise>	
									</c:choose>
									
									
									
									
									
									
									
									<tr>
										<td>1</td>
										<td><a
											href="${path}/front?key=user&methodName=selectByModelNum&modelNum=${elecDto.modelNum}">${elecDto.modelName}</a></td>
										<td>김찬원</td>
										<td>남자</td>
										<td>1302.12.21</td>
									</tr>
									
									<tr>
										<td>2</td>
										<td><a href="#">ninjaturtle0301</a></td>
										<td>거북쓰</td>
										<td>비공개</td>
										<td>1899.03.01</td>
									</tr>
									<tr>
										<td>3</td>
										<td><a href="#">smokingTiger</a></td>
										<td>담배피는호랑이</td>
										<td>남자</td>
										<td>2018.10.03</td>
									</tr>
									<tr>
										<td>4</td>
										<td><a href="#">bunny</a></td>
										<td>토끼</td>
										<td>여자</td>
										<td>2021.07.02</td>
									</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="main-body">
			<!-- Breadcrumb -->
			<div aria-label="breadcrumb" class="main-breadcrumb">
				<div class="breadcrumb">
					<span style="text-align: left">즐겨찾기 한 레시피 리스트</span>
				</div>
			</div>
			<!-- /Breadcrumb -->

			<div class="row gutters-sm">
				<div class="col-md-12">
					<div class="card mb-3">
						<div class="card-body">
							<table>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>날짜</th>
									<th>조회수</th>
								</tr>
								<tr>
									<td>1</td>
									<td><a href="#">강원도에서 직접 공수해온 고라니 고기를 가지고 만든 고라니탕</a></td>
									<td>2019.10.14</td>
									<td>131</td>
								</tr>
								<tr>
									<td>2</td>
									<td><a href="#">이베리아 반도의 탱고의 여인이 친숙하게 느껴지는 느낌을 주는 와인</a></td>
									<td>2019.10.14</td>
									<td>1522</td>
								</tr>
								<tr>
									<td>3</td>
									<td><a href="#">겐스케군의 스고이 한 니혼제 돈까스</a></td>
									<td>2019.10.14</td>
									<td>7777</td>
								</tr>
								<tr>
									<td>33333</td>
									<td><a href="#">영국식 정어리 머리 파이</a></td>
									<td>2019.10.14</td>
									<td>0</td>
								</tr>
							</table>


						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="main-body">
			<!-- Breadcrumb -->
			<div aria-label="breadcrumb" class="main-breadcrumb">
				<div class="breadcrumb">
					<span style="text-align: left">작성한 레시피 리스트</span>
				</div>
			</div>
			<!-- /Breadcrumb -->

			<div class="row gutters-sm">

				<div class="col-md-12">
					<div class="card mb-3">
						<div class="card-body">
							<table>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>날짜</th>
									<th>조회수</th>
								</tr>
								<tr>
									<td>1</td>
									<td><a href="#">강원도에서 직접 공수해온 고라니 고기를 가지고 만든 고라니탕</a></td>
									<td>2019.10.14</td>
									<td>131</td>
								</tr>
								<tr>
									<td>2</td>
									<td><a href="#">이베리아 반도의 탱고의 여인이 친숙하게 느껴지는 느낌을 주는 와인</a></td>
									<td>2019.10.14</td>
									<td>1522</td>
								</tr>
								<tr>
									<td>3</td>
									<td><a href="#">겐스케군의 스고이 한 니혼제 돈까스</a></td>
									<td>2019.10.14</td>
									<td>7777</td>
								</tr>
								<tr>
									<td>33333</td>
									<td><a href="#">영국식 정어리 머리 파이</a></td>
									<td>2019.10.14</td>
									<td>0</td>
								</tr>
							</table>

						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="main-body">
			<!-- Breadcrumb -->
			<div aria-label="breadcrumb" class="main-breadcrumb">
				<div class="breadcrumb">
					<span style="text-align: left">작성한 커뮤니티 글 리스트</span>
				</div>
			</div>
			<!-- /Breadcrumb -->

			<div class="row gutters-sm">

				<div class="col-md-12">
					<div class="card mb-3">
						<div class="card-body">
							<table>
								<tr>
									<th>번호</th>
									<th>카테고리</th>
									<th>제목</th>
									<th>날짜</th>
									<th>조회수</th>
								</tr>
								<tr>
									<td>1</td>
									<td><a href="#">Q&A</a></td>
									<td><a href="#">고라니탕을 만들려고 직접 고라니를 잡으러가는대여...</a></td>
									<td>2019.10.14</td>
									<td>11</td>
								</tr>
								<tr>
									<td>2</td>
									<td><a href="#">TIP</a></td>
									<td><a href="#">선생님 잠자고 싶어요...ㅠㅠ</a></td>
									<td>2019.10.14</td>
									<td>152</td>
								</tr>
								<tr>
									<td>33333</td>
									<td><a href="#">후기</a></td>
									<td><a href="#">으악 살려줘!!!</a></td>
									<td>2019.10.14</td>
									<td>7777</td>
								</tr>
								<tr>
									<td>33333</td>
									<td><a href="#">후기</a></td>
									<td><a href="#">점심 나가서 먹을것 가태!!!!!!!!!!</a></td>
									<td>2019.10.14</td>
									<td>7777</td>
								</tr>
							</table>
							<a class="btn" href="#">&lt;&lt;</a> <a class="btn" href="#">&lt;</a>
							<a class="btn number" href="#">1</a> <a class="btn number"
								href="#">2</a> <a class="btn number on" href="#">3</a> <a
								class="btn number" href="#">4</a> <a class="btn number" href="#">5</a>
							<a class="btn" href="#">&gt;</a> <a class="btn" href="#">&gt;&gt;</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
<jsp:include page="../common/footer.jsp" />
