<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

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
</style>

<script type="text/javascript">
	
</script>


</head>

<body>
	<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
	%>
	<!-- ##### Breadcumb Area Start ##### -->
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(img/bg-img/breadcumb5.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-text text-center">
						<h2>게시글 조회</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Breadcumb Area End ##### -->

	<!-- BoardContent Start -->
	<p>
	<div class="wrapper" style="text-align: center">
		<div class="row" id="boardContent">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="table table-responsive">
					<table class="table">
						<tr>
							<th class="success">글번호</th>
							<td>${postDTO.no}</td>
							<th class="success">조회수</th>
							<td>${postDTO.counts}</td>
						</tr>
						<tr>
							<th class="success">카테고리</th>
							<!--  -->
							<td>${postDTO.postTypeNo}</td>
							<th class="success">작성자</th>
							<td>${postDTO.userNicname}</td>
							<th class="success">작성일</th>
							<td>${postDTO.date}</td>
						</tr>

						<tr>
							<th class="success">제목</th>
							<td colspan="6" style="text-align:left">${postDTO.title}</td>
						</tr>

						<tr>
							<th class="success">글 내용</th>
							<td colspan="6"  style="text-align:left">${postDTO.contents}</td>
						</tr>

						<!-- 댓글 -->
						<tr>
							<td colspan="6" class="text-center">
							<c:choose>
									<c:when
										test="${(postDTO.userNicname == userDTO.nickName) or (userDTO.status == 10)}">
										<a
											href="${pageContext.request.contextPath}/front?key=post&methodName=selectBeforePost&postNo=${postDTO.no}"
											class="btn btn-danger">수정하기</a>
										<a
											href="${pageContext.request.contextPath}/front?key=post&methodName=deletePost&postNo=${postDTO.no}"
											class="btn btn-danger">삭제하기</a>
										<a
											href="${pageContext.request.contextPath}/front?key=post&methodName=selectPost"
											class="btn btn-danger">목록보기</a>
									</c:when>
									<c:otherwise>
										<a
											href="${pageContext.request.contextPath}/front?key=post&methodName=selectPost"
											class="btn btn-danger">목록보기</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
						<!-- 댓글 -->

					</table>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>

	<!-- BoardContent End -->

	<!-- Reply Start -->




	<c:choose>
		<c:when test="${empty commentDTO}">
			<!-- 댓글 없으면 댓글이 없습니다. 멘트 -->
			<form class="replyForm" name="replyForm" method="post" action="${pageContext.request.contextPath}/front" onSubmit='return checkValid()'>
				<input type="hidden" name="key" value="post" /> 
				<input type="hidden" name="methodName" value="insertComment"/>
				<input type="hidden" name="top" value="null"/>
				<fieldset>
					<div class="container bootstrap snippets bootdey">
						<div class="row">
							<div class="col-md-12">
								<div class="blog-comment">
									<hr>
									<div class="comments">
										<div class="clearfix">
											<div class="post-comments">
												<p class="meta">
													<%=sf.format(nowTime)%>&nbsp;&nbsp;&nbsp;<a href="#">${userDTO.nickName}</a>
													님 :
												</p>
												<textarea class="form-control" name="content"
													placeholder="메세지를 입력해주세요."></textarea>
											</div>
										</div>
									</div>
									<div class="replyButton" style="text-align: right">
										<button type="submit" class="btn delicious-small-btn btn-3">등록</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</fieldset>
			</form>
			<div class="container bootstrap snippets bootdey">
				<div class="row">
					<div class="col-md-12">
						<div class="blog-comment">
							<hr>
							<div class="comments">
								<div class="clearfix" style="text-align: center">
									<span>댓글이 없습니다! 댓글을 달아 아이디어를 공유 해보는 것은 어떨까요?</span>
									<hr>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		
		
		
		
		<c:otherwise>
			<form>
				<fieldset>
					<div class="container bootstrap snippets bootdey">
						<div class="row">
							<div class="col-md-12">
								<div class="blog-comment">
									<hr>
									<div class="comments">
										<div class="clearfix">
											<div class="post-comments">
												<p class="meta">
													<a href="#">${userDTO.nickName}</a> 님 : 
												</p>
												<textarea class="form-control" id="message"
													placeholder="메세지를 입력해주세요."></textarea>
											</div>
										</div>
									</div>
									<div class="replyButton" style="text-align: right">
										<button type="submit" class="btn delicious-small-btn btn-3">등록</button>
									</div>
								</div>
							</div>
						</div>
					</div>

				</fieldset>
			</form>
			<c:forEach items="${commentDTO}" var="reply">
				<!-- 돌려서 댓글을 꺼낸다. -->
				<c:if test="${(reply.userNickName == userDTO.nickName) or (userDTO.status == 10)}">
					<li class="clearfix">
						<div class="post-comments">
							<p class="meta">
								${reply.date}
								<a href="#">${reply.userNickName}</a> 님 : <i class="pull-right"><a
									href="#"><small>댓글 추가</small></a></i>
							</p>
							<p>${reply.content}</p>
							<a href="#"><small>수정</small></a> <a href="#"><small>삭제</small></a>
						</div>
					</li>
				</c:if>
				
				<c:if test="${(reply.userNickName != userDTO.nickName) or (userDTO.status != 10)}">
					<li class="clearfix">
						<div class="post-comments">
							<p class="meta">
								날짜 : ${reply.date} <a href="#">${reply.userNickName}</a> 님 : <i class="pull-right"><a href="#"><small>댓글 추가</small></a></i>
							</p>
							<p>${reply.content}</p>
						</div>
					</li>
				</c:if>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>

</html>
<jsp:include page="../common/footer.jsp" />
