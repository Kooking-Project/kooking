<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<!DOCTYPE html>
<html lang="ko">

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
hr {
	margin-top: 20px;
	margin-bottom: 20px;
	border: 0;
	border-top: 1px solid #FFFFFF;
}

a {
	color: #82b440;
	text-decoration: none;
}

.blog-comment::before, .blog-comment::after, .blog-comment-form::before,
	.blog-comment-form::after {
	content: "";
	display: table;
	clear: both;
}

.blog-comment {
	padding-left: 15%;
	padding-right: 15%;
}

.blog-comment ul {
	list-style-type: none;
	padding: 0;
}

.blog-comment img {
	opacity: 1;
	filter: Alpha(opacity = 100);
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	-o-border-radius: 4px;
	border-radius: 4px;
}

.blog-comment img.avatar {
	position: relative;
	float: left;
	margin-left: 0;
	margin-top: 0;
	width: 65px;
	height: 65px;
}

.blog-comment .post-comments {
	border: 1px solid #eee;
	margin-bottom: 20px;
	margin-left: 85px;
	margin-right: 0px;
	padding: 10px 20px;
	position: relative;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	-o-border-radius: 4px;
	border-radius: 4px;
	background: #fff;
	color: #6b6e80;
	position: relative;
}

.blog-comment .meta {
	font-size: 13px;
	color: #aaaaaa;
	padding-bottom: 8px;
	margin-bottom: 10px !important;
	border-bottom: 1px solid #eee;
}

.blog-comment ul.comments ul {
	list-style-type: none;
	padding: 0;
	margin-left: 85px;
}

.blog-comment-form {
	padding-left: 15%;
	padding-right: 15%;
	padding-top: 40px;
}

.blog-comment h3, .blog-comment-form h3 {
	margin-bottom: 40px;
	font-size: 26px;
	line-height: 30px;
	font-weight: 800;
}

#boardContent {
	text-align: center;
}

.success {
	width: 100px;
}

#messageTitle {
	height: 50px;
}

#messageContent {
	height: 500px;
}

.nice-select {
	border: none;
	background-color: #f3f5f8;
	border-radius: 0;
	width: 100%;
	height: 50%;
	line-height: 30px;
	color: #2f2f2f;
}

.nice-select span {
	color: #2f2f2f;
}

.nice-select::after {
	right: 20px;
}

.nice-select .list {
	background-color: #ffffff;
	border: none;
	border-radius: 0;
	box-shadow: 0 0 4px 0 rgba(0, 0, 0, 0.1);
	margin-top: 0;
	width: 100%;
}
</style>


<script type="text/javascript">

var f = window.document.boardForm;

function checkValid() {
if ( f.type.value == "") {
    alert( "카테고리를 선택해 주세요!" );
	return false;
}

if ( f.title.value == "") {
    alert( "제목을 입력해 주세요!" );
    f.title.focus();
	return false;
}

if ( f.contents.value == "") {
    alert( "내용을 입력해 주세요!" );
    f.contents.focus();
	return false;
}

	return true;
}

</script>

</head>

<body>

	<!-- ##### Breadcumb Area Start ##### -->
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(img/bg-img/breadcumb5.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-text text-center">
						<h2>게시글 수정</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Breadcumb Area End ##### -->

	<!-- BoardContent Start -->
    <form class="form-horizontal" name="boardForm" method="post" action="${pageContext.request.contextPath}/front?key=post&methodName=updatePost" 
  onSubmit='return checkValid()' enctype="multipart/form-data">
  <input type="hidden" name="postNo" value="${beforePostDTO.no}" />
  <input type="hidden" name="user" value="${beforePostDTO.userNo}" />
   <input type="hidden" name="nickName" value="${beforePostDTO.userNicname}" />
	<p>
	<div class="wrapper" style="text-align: center">
		<div class="row" id="boardContent">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="table table-responsive">
					<table class="table">
						<tr>
							<th class="success">글번호</th>
							<td>${beforePostDTO.no}</td>
							<th class="success">조회수</th>
							<td>${beforePostDTO.counts}</td>
						</tr>
						<tr>
							<th class="success">카테고리</th>
							<!--  -->
							<td><select class="select" name="type" id="type">
									<option value="" disabled selected>선택</option>
									<option value="2">TIP</option>
									<option value="3">후기</option>
									<option value="4">Q&A</option>
							</select></td>
							<th class="success">작성자</th>
							<td>${beforePostDTO.userNicname}</td>
							<th class="success">작성일</th>
							<td>${beforePostDTO.date}</td>
						</tr>
						<tr>
							<th class="success">제목</th>
							<td colspan="6"><textarea class="form-control"
									name="title" id="title" placeholder="제목을 입력해주세요.">${beforePostDTO.title}</textarea></td>
						</tr>

						<tr>
							<th class="success">글 내용</th>
							<td colspan="6"><textarea class="form-control"
									name="contents" id="contents" placeholder="내용을 입력해주세요.">${beforePostDTO.contents}</textarea></td>
						</tr>

						<tr>
							<td>
							<td colspan="6" class="text-center">
								<input type="submit" class="btn btn-danger" value="수정">
							</td>
							<td>
								<a href="javascript:history.back()" class="btn btn-danger">돌아가기</a>
							</td>
						</tr>

					</table>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</form>

	<!-- BoardContent End -->

</body>

</html>
<jsp:include page="../common/footer.jsp" />
