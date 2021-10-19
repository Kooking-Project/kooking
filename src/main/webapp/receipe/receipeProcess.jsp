<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script type="text/javascript">
const add_textbox = () => {
    const box = document.getElementById("process");
    const newP = document.createElement('p');
    	newP.innerHTML =" <input type='text'> <input type='button' value='삭제' onclick='remove(this)'>";
    	box.appendChild(newP);
    
}
const remove = (obj) => {
    document.getElementById('process').removeChild(obj.parentNode);
}
</script>
</head>
<body>
	<div id="process">
      	 <input type="button" id="addItem" value="추가하기" onclick="add_textbox();" />
    </div>
</body>
</html>