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
<title>유저 페이지 | KOOKING</title>



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


<script type="text/javascript">
	
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
						<h2>로그인</h2>
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
							<span style="text-align: left">유저 정보</span>
							<c:if test="${userDTO.no} == ${user.no}">
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
									<h4>${user.nickName}</h4>
									<!-- 마이 페이지로 들어갔으면 내 닉네임 아니면 다른 사람 닉네임  -->
									<p class="text-secondary mb-1">성별</p>
									<c:choose>
										<c:when test="${user.gender == 1}">
											<p class="text-muted font-size-sm">남자</p>
										</c:when>
										<c:when test="${user.gender == 2}">
											<p class="text-muted font-size-sm">여자</p>
										</c:when>
										<c:otherwise>
											<p class="text-muted font-size-sm">비공개</p>
										</c:otherwise>
									</c:choose>
									<p class="text-muted font-size-sm"></p>
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
							<!--  여기에 -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="main-body">

			<!-- 어드민이면 정지 기능 보여라 -->

			<c:if test="${userDTO.status} == 10">

				<div aria-label="breadcrumb" class="main-breadcrumb">
					<div class="breadcrumb">
						<span style="text-align: left">유저 Status 메뉴</span>

						<form name=Form method=post action="/front">
							<c:choose>
								<c:when test="${user.status == 0 }">
									<input type="hidden" name="key" value="admin">
									<input type="hidden" name="methodName" value="changeUserStatus">
									<input type='hidden' name='userNo' value="${user.no}">
									<input type='hidden' name='adminNo' value="${userDTO.no}">
									<input type='hidden' name='userStatus' value="1">
									<button type="submit" class="btn btn-info" style="background-color: red">정지</button>
								</c:when>
								<c:when test="${user.status == 1}">
									<input type="hidden" name="key" value="admin">
									<input type="hidden" name="methodName" value="changeUserStatus">
									<input type='hidden' name='userNo' value="${user.no}">
									<input type='hidden' name='adminNo' value="${userDTO.no}">
									<input type='hidden' name='userStatus' value="0">
									<button type="submit" class="btn btn-info" style="background-color: green">해제</button>
								</c:when>
							</c:choose>

						</form>
					</div>
				</div>
			</c:if>
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
							<!--  여기에 -->

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
							<!-- 여기에 -->

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
						<div class="card-body"
							style="text-align: center; position: relative;">
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
										<th>날짜</th>
										<th>조회수</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty postList}">
											<tr>
												<td colspan="6">등록된 게시글이 없습니다.</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${postList}" var="board">
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
														<td>${board.date}</td>
														<td>${board.counts}</td>
													</tr>
												</c:if>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
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
