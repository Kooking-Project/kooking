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


<SCRIPT language=javascript>
function sendUpdate(){
	document.requestForm.methodName.value ="updateForm";
	document.requestForm.submit();
}


function sendDelete(){	
	document.requestForm.methodName.value ="delete";
	document.requestForm.submit();
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
							<td>${board.no}</td>
							<th class="success">조회수</th>
							<td>${requestScope.board.no}</td>
						</tr>
						<tr>
							<th class="success">카테고리</th> 	<!--  -->
							<td>${requestScope.board.category}</td>
							<th class="success">작성자</th>
							<td>${requestScope.board.writer}</td>
							<th class="success">작성일</th>
							<td>${requestScope.board.writeday}</td>
						</tr>

						<tr>
							<th class="success">제목</th>
							<td colspan="6">${requestScope.board.title}</td>
						</tr>

						<tr>
							<th class="success">글 내용</th>
							<td colspan="6">${requestScope.board.description}</td>
						</tr>

						<!-- 댓글 -->
						<tr>
							<td colspan="6" class="text-center"><c:choose>
									<c:when test="${requestScope.board.writer} == ${loginUser.nickName} or  ">
										<input type="button" class="btn btn-warning" value="수정하기"
											onclick="sendUpdate()">
										<input type="button" class="btn btn-danger" value="삭제하기"
											onclick="sendDelete()">
										<input type="button" class="btn btn-primary" value="목록보기"
											onclick="location.href='board.jsp'">
									</c:when>
									<c:otherwise>
										<input type="button" class="btn btn-primary" value="목록보기"
											onclick="location.href='board.jsp'">
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
   	<c:when test="${empty board.repliesList}"> <!-- 댓글 없으면 댓글이 없습니다. 멘트 -->		
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
													2021년 10월 15일 <a href="#">거북쓰</a> 님 :
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

			<div class="container bootstrap snippets bootdey">
				<div class="row">
					<div class="col-md-12">
						<div class="blog-comment">
							<hr>
							<div class="comments">
								<div class="clearfix"  style="text-align:center">
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
													<a href="#">${loginUser}</a> 님 :
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
			<c:forEach items = "${board.repliesList}" var = "reply">
				<!-- 돌려서 댓글을 꺼낸다. -->
				<c:if test="${reply.userNickname} == ${userNickname}">
				<li class="clearfix">
					<div class="post-comments">
						<p class="meta">
							날짜 : ${reply.date} <a href="#">${reply.userNickname}</a> 님 : <i
								class="pull-right"><a href="#"><small>Reply</small></a></i>
						</p>
						<p>${reply.content}</p>
						<a href="#"><small>수정</small></a></i>
						<a href="#"><small>삭제</small></a></i>
					</div>
				</li>
				</c:if>
				<c:otherwise>
					<li class="clearfix">
					<div class="post-comments">
						<p class="meta">
							날짜 : ${reply.date} <a href="#">${reply.userNickname}</a> 님 : <i
								class="pull-right"><a href="#"><small>Reply</small></a></i>
						</p>
						<p>${reply.content}</p>
					</div>
				</li>
				</c:otherwise>
			</c:forEach>
		</c:otherwise>
	</c:choose>


	<div class="container bootstrap snippets bootdey">
		<div class="row">
			<div class="col-md-12">
				<div class="blog-comment">
					<hr>
					<ul class="comments">
						<li class="clearfix">
							<div class="post-comments">
								<p class="meta">
									2021년 10월 14일 <a href="#">담배피는호랭이</a> 님 : <i class="pull-right"><a
										href="#"><small>Reply</small></a></i>
								</p>
								<p>뻐금뻐금...한 줄만 써도 되겠지...?</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="post-comments">
								<p class="meta">
									2021년 10월 14일 <a href="#">제여친을소개합니다람쥐</a> 님 : <i
										class="pull-right"><a href="#"><small>Reply</small></a></i>
								</p>
								<p>넥슨은 다람쥐를 뿌려라!</p>
							</div>

							<ul class="comments">
								<li class="clearfix">
									<div class="post-comments">
										<p class="meta">
											2021년 10월 15일 <a href="#">이제그만하란말이야옹이</a> 님 : <i
												class="pull-right"><a href="#"><small>Reply</small></a></i>
										</p>
										<p>이 편지는 영국에서 최초로 시작되어 일년에 한 바퀴 돌면서 받는 사람에게 행운을 주었고 지금
											당신에게로 옮겨진 이 편지는 4일 안에 당신 곁을 떠나야 합니다. 이 편지를 포함해서 7통을 행운이 필요한
											사람에게 보내 주셔야 합니다. 복사를 해도 좋습니다. 혹 미신이라 하실지 모르지만 사실입니다. 영국에서
											HGXWCH이라는 사람은 1930년에 이 편지를 받았습니다. 그는 비서에게 복사해서 보내라고 했습니다. 며칠
											뒤에 복권에 당첨되어 20억을 받았습니다. 어떤 이는 이 편지를 받았으나 96시간 이내 자신의 손에서 떠나야
											한다는 사실을 잊었습니다. 그는 곧 사직되었습니다. 나중에야 이 사실을 알고 7통의 편지를 보냈는데 다시 좋은
											직장을 얻었습니다. 미국의 케네디 대통령은 이 편지를 받았지만 그냥 버렸습니다. 결국 9일 후 그는 암살
											당했습니다. 기억해 주세요. 이 편지를 보내면 7년의 행운이 있을 것이고 그렇지 않으면 3년의 불행이 있을
											것입니다. 그리고 이 편지를 버리거나 낙서를 해서는 절대로 안됩니다. 7통입니다. 이 편지를 받은 사람은
											행운이 깃들 것입니다. 힘들겠지만 좋은게 좋다고 생각하세요. 7년의 행운을 빌면서..</p>
									</div>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- Reply End -->

</body>

</html>
<jsp:include page="../common/footer.jsp" />
