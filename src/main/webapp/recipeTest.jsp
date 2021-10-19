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
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.form.min.js"></script>
<script type="text/javascript">

function recipeInsert(){
	document.requestForm1.submit();
}
function recipeUpdate(){
	document.requestForm2.submit();
}

$(function() {
	$("#upload").on("click", function() {
		$("#upLoadForm").ajaxForm({
			url :"${path}/uploadServlet", // 서버요청주소
			type : "post", //get or post요청방식
			dataType : "json", //서버가보내오는 데이터타입(text,html,json,xml)
			//data:, //서버에게 보내는 parameter정보
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
					str += "img : " + "<img src='${path}/save/"+ item.filesystemName +"'><br>";
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
	<h1>게시글 등록</h1>
	<table border="1">
		<tr bgcolor="pink">
			<td>post_no</td>
			<td>post_type_no</td>
			<td>user_no</td>
			<td>post_title</td>
			<td>post_contents</td>
			<td>post_view_counts</td>
			<td>post_date</td>
		</tr>

		<c:choose>
			<c:when test="${empty requestScope.postList}">
				<tr>
					<td>등록된 정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.postList}" var="postDTO">
					<tr>
						<td><input type=text name="post_no" size="10"
							value="post_no.seq"></td>${postDTO.no}</td>
						<td><input type=text name="post_type_no" size="10"
							value="레시피카테고리">${postDTO.postTypeNo}</td>
						<td>${postDTO.userNo}</td>
						<td>${postDTO.title}</td>
						<td>${postDTO.contents}</td>
						<td>${postDTO.counts}</td>
						<td>${postDTO.date}</td>
						<td></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
	<h1>레시피 등록</h1>
	<table border="1">
		<tr bgcolor="pink">
			<th>레시피이름</th>
			<th>칼로리</th>
			<th>조리시간</th>
			<th>레시피 국가</th>
			<th>레시피 분류</th>
			<th>레시피 난이도</th>
		</tr>
		<tr>
			<th>"recipe_name"</th>
			<th>"calorie"</th>
			<th>"cookingTime"</th>
			<th>"recipe_nation"</th>
			<th>"recipe_type"</th>
			<th>"recipe_level"</th>
		</tr>
		<c:choose>
			<c:when test="${empty requestScope.recipeList}">
				<tr>
					<td>등록된 정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.recipeList}" var="recipeDTO">
					<tr>
						<td>${recipeDTO.no}</td>
						<td>${recipeDTO.recipe_name}</td>
						<td>${recipeDTO.calorie}</td>
						<td>${recipeDTO.cookingTime}</td>
						<td>${recipeDTO.recipe_nation}</td>
						<td>${recipeDTO.recipe_type}</td>
						<td>${recipeDTO.recipe_level}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>

	<h1>재료 등록</h1>
	<table border="1">
		<tr bgcolor="pink">
			<th>재료이름</th>
			<th>재료순서</th>
			<th>재료용량</th>
		</tr>
		<tr>
			<th>"ingredient_name"</th>
			<th>"ingredient_seq"</th>
			<th>"ingredient_cacty"</th>
		</tr>
		<c:choose>
			<c:when test="${empty requestScope.ingredientList}">
				<tr>
					<td>등록된 정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.ingredientList}"
					var="ingredientDTO">
					<tr>
						<td>${ingredientDTO.ingredient_name}</td>
						<td>${ingredientDTO.ingredient_seq}</td>
						<td>${ingredientDTO.ingredient_cacty}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>

	<h1>조리과정 등록</h1>
	<table border="1">
		<tr bgcolor="pink">
			<th>조리과정이미지 URL</th>
			<th>조리과정순서</th>
			<th>조리과성설명</th>
			<th>조리과정팁</th>
		</tr>
		<tr>
			<th>"process_url"</th>
			<th>"process_seq"</th>
			<th>"process_desc"</th>
			<th>"process_tip"</th>
		</tr>
		<c:choose>
			<c:when test="${empty requestScope.ingredientList}">
				<tr>
					<td>등록된 정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.processList}" var="processDTO">
					<tr>
						<td>${processDTO.process_url}</td>
						<td>${processDTO.process_seq}</td>
						<td>${processDTO.process_desc}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>

	<h1>이미지 등록</h1>
	<table>
		<tr bgcolor="pink">
			<th>이미지 URL</th>
			<th>이미지용량</th>
		</tr>
		<tr>
			<th>"image_url"</th>
			<th>"image_size"</th>
		</tr>
		<c:choose>
			<c:when test="${empty requestScope.imageList}">
				<tr>
					<td>등록된 정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.imageList}" var="imageDTO">
					<tr>
						<td>${imageDTO.image_url}</td>
						<td>${imageDTO.image_size}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
</body>
</html>