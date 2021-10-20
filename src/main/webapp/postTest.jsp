<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="${path }/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${path }/js/jquery.form.min.js"></script>
<style>

</style>
<script type="text/javascript">

</script>
</head>
<body>
	<form name="boardForm" method="post" action="${path}/front">
		<input type="hidden" name="key" value="board" /><!-- controller -->
		<input type="hidden" name="methodName" value="" /><!-- method -->
		<input type="hidden" name="userNo" value="" />
		<button type="button" class="btn-all-list">전체 목록조회</button>
		<button type="button" class="btn-user-list">사용자 목록조회</button>
	</form>
	
	<table>
		<tr>
			<td>POST_NO</td>
			<td>POST_TYPE_NO</td>
			<td>USER_NO</td>
			<td>POST_TITLE</td>
			<td>POST_CONTENTS</td>
			<td>POST_VIEW_COUNTS</td>
			<td>POST_DATE</td>
		</tr>
		<c:forEach items="${requestScope.postList}" var="board" varStatus="loop">
			<tr>
				<td>${board.no }</td>
				<td>${board.postTypeNo }</td>
				<td>${board.userNo }</td>
				<td>${board.title }</td>
				<td>${board.contents }</td>
				<td>${board.counts }</td>
				<td>${board.date }</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
<script type="text/javascript">
$(function(){
	$('.btn-all-list').on('click', function (e) {
		$('input[name="methodName"]').val("postList");
		$('form').submit();
	});
	
	$('.btn-user-list').on('click', function (e) {
		$('input[name="methodName"]').val("postList");
		$('input[name="userNo"]').val("2");
		$('form').submit();
	});
});
</script>
</html>