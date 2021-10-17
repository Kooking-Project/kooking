<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
<script type="text/javascript" src="${path }/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${path }/js/jquery.form.min.js"></script>
<script type="text/javascript">
function sendUpdate(){
	document.requestForm1.submit();
}
function commentDelete(){
	document.requestForm2.submit();
}
function postDelete(){
	document.requestForm3.submit();
}
function sendUserUpdate(){
	document.requestForm4.submit();
}
function postSelect(){
	document.requestForm5.submit();
}
$(function() {
	$("#upload").on("click", function() {
		$("#upLoadForm").ajaxForm({
			url : "${path}/front", // 서버요청주소
			type : "post", //get or post요청방식
			dataType : "json", //서버가보내오는 데이터타입(text,html,json,xml)
			data:$("#upLoadForm").serialize(), //서버에게 보내는 parameter정보
			success : function(result) {//중복, 사용가능
				alert(result +"성공");
				var str = "";
				$.each(result, function(index, item) {
					str += "작성자 : " + item.name + "<br>";
					str += "제목 : " + item.subject + "<br>";
					str += "filesystemName : " + item.filesystemName + "<br>";
					str += "originalName : " + item.originalName + "<br>";
					str += "fileSize : " + item.fileSize + "<br>";
					str += "path : " + item.path + "<br>";
				});
				$("div").html(str);
			},
			error : function(err) {
				alert(err + "=> 예외발생...");
			}
		});
		$("#upLoadForm").submit(); //전송
	});//  clickEnd

})//ready끝
</script>
</head>
<body>
<h1>회원 상태 변경</h1>
<table>
	<tr bgcolor="pink" >
	    <th>관리자 번호</th>
		<th>변경할 번호</th>
		<th>변경할 상태</th>
	</tr>
    <tr>
	    <form name="requestForm1" method=post action="${path}/front">
        <td>
			<input type=hidden name="adminNo" value="3">
			<input type=hidden name="userNo" value="4">
			<input type=hidden name="userStatus" value="1">	<!-- 활동정지는 1 -->
			<input type=hidden name="key" value="admin">
			<input type=hidden name="methodName" value="changeUserStatus">
			<input type=button value="수정하기" onClick="sendUpdate()">
		</td>
    	</form>
    </tr>
</table>

<hr>
<h1>댓글 삭제</h1>
<table>
	<tr bgcolor="pink" >
	    <th>관리자 번호</th>
		<th>삭제할 댓글</th>
	</tr>
    <tr>
	    <form name="requestForm2" method=post action="${path}/front">
        <td>
			<input type=hidden name="adminNo" value="3">
			<input type=hidden name="commentNo" value="0">
			<input type=hidden name="key" value="admin">
			<input type=hidden name="methodName" value="commentDelete">
			<input type=button value="댓글 삭제" onClick="commentDelete()">
		</td>
    	</form>
    </tr>
</table>

<hr>
<h1>게시글 삭제</h1>
<table>
	<tr bgcolor="pink" >
	    <th>관리자 번호</th>
		<th>삭제할 게시글</th>
	</tr>
    <tr>
	    <form name="requestForm3" method=post action="${path}/front">
        <td>
			<input type=hidden name="adminNo" value="3">
			<input type=hidden name="postNo" value="0">
			<input type=hidden name="key" value="admin">
			<input type=hidden name="methodName" value="postDelete">
			<input type=button value="게시글 삭제" onClick="postDelete()">
		</td>
    	</form>
    </tr>
</table>

<hr>
<h1>회원 정보 변경</h1>
<table>
	<tr bgcolor="pink" >
	    <th>회원 번호</th>
		<th>변경할 비밀번호</th>
		<th>변경할 닉네임</th>
		<th>변경할 성별</th>
	</tr>
    <tr>
	    <form name="requestForm4" method=post action="${path}/front">
        <td>
			<input type=hidden name="no" value="4">
			<input type=hidden name="pwd" value="3333">	
			<input type=hidden name="nickName" value="테스트2">	
			<input type=hidden name="gender" value="0">	
			<input type=hidden name="key" value="user">
			<input type=hidden name="methodName" value="userUpdate">
			<input type=button value="수정하기" onClick="sendUserUpdate()">
		</td>
    	</form>
    </tr>
</table>

<hr>
<h1>게시글 출력</h1>
<table border="1">
	<tr>
        <td>post_no</td>
        <td>post_type_no</td>
        <td>user_no</td>
        <td>post_title</td>
        <td>post_contents</td>
        <td>post_view_counts</td>
		<td>post_date</td>
		<td>
			<form name="requestForm5" method=post action="${path}/front">
				<input type=hidden name="no" value="4">
				<input type=hidden name="key" value="user">
				<input type=hidden name="methodName" value="postSelectByUserNo">
				<input type=button value="검색하기" onClick="postSelect()">
			</form>
		</td>
    </tr>
    
    <c:choose>
	    <c:when test="${empty requestScope.postList}">
		   	<tr>
	       		<td>등록된 상품이 없습니다.</td>
	    	</tr>
	    </c:when>
	    <c:otherwise>
			<c:forEach items="${requestScope.postList}" var="postDTO">
				<tr>
					<td>${postDTO.no}</td>
					<td>${postDTO.postTypeNo}</td>
					<td>${postDTO.userNo}</td>
					<td>${postDTO.title}</td>
					<td>${postDTO.contents}</td>
					<td>${postDTO.counts}</td>
					<td>${postDTO.date}</td>
					<td> </td>
				</tr>
		    </c:forEach>
		</c:otherwise>
    </c:choose>
</table>

<hr>
<h1>프로필</h1>
	<form method="post" enctype="multipart/form-data" id="upLoadForm">
		이름 :<input type="text" name="name" /><p>
		제목: <input type="text" name="subject" /><p>
		파일첨부:<input type="file" name="file" /><p>
		<input type=hidden name="key" value="user">
		<input type=hidden name="methodName" value="profileUpload">
		<input type="button" id="upload" value="업로드하기" />
	</form>
	<hr>
	<div></div>
</body>
</html>