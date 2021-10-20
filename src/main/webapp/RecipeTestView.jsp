<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
</head>
<body>

작성자 : ${wrapper.post.userNicname} <br>
작성일 : ${wrapper.post.date} 조회수 : ${wrapper.post.counts }<br>
제목 : ${wrapper.post.title }<br>
<img src="${path}/img/${wrapper.recipe.thumbnail}" />
${wrapper.post.contents }
${wrapper.recipe.name}
${wrapper.recipe.calorie}
${wrapper.recipe.cookingTime}
<br>

재료
<c:forEach items="${wrapper.ingredient}" var="ing" varStatus="state">
${ing.seq} : ${ing.name } : ${ing.cacty}<br>

</c:forEach>
<br><br>

조리순서


</body>
</html>