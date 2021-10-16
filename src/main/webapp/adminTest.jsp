<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	document.requestForm.submit();
}
function commentDelete(){
	document.requestForm.submit();
}
function postDelete(){
	document.requestForm.submit();
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
	    <form name="requestForm" method=post action="${path}/front">
        <td>
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
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
	    <form name="requestForm" method=post action="${path}/front">
        <td>
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
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
	    <form name="requestForm" method=post action="${path}/front">
        <td>
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
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