<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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

#boardContent{

text-align: center;
}

.success{
	width: 100px;
}

#messageTitle{
	height: 50px;
}

#messageContent{

	height: 500px;
}

.nice-select {
  border: none;
  background-color: #f3f5f8;
  border-radius: 0;
  width: 100%;
  height: 50%;
  line-height: 30px;
  color: #2f2f2f; }
  .nice-select span {
    color: #2f2f2f; }
  .nice-select::after {
    right: 20px; }
  .nice-select .list {
    background-color: #ffffff;
    border: none;
    border-radius: 0;
    box-shadow: 0 0 4px 0 rgba(0, 0, 0, 0.1);
    margin-top: 0;
    width: 100%; }


</style>    


<SCRIPT language=javascript>

function checkValid() {
    var f = window.document.boardForm;
		
	if ( f.type.value == "") {
	    alert( "게시글 카테고리를 선택해 주세요." );
	    f.boardCategory.focus();
		return false;
    }
	if ( f.title.value == "" ) {
		alert( "제목을 입력해 주세요." );
		f.title.focus();
		return false;
	}
	if ( f.content.value == "" ) {
		alert( "내용을 입력해 주세요." );
		f.content.focus();
		return false;
	}
	
    return true;
}


</script>
    
</head>

<body>
    <!-- Preloader -->
    <div id="preloader">
        <i class="circle-preloader"></i>
        <img src="img/core-img/salad.png" alt="">
    </div>
    <!--  Preloader End -->
    
        <!-- ##### Breadcumb Area Start ##### -->
    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/breadcumb5.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcumb-text text-center">
                        <h2>게시글 작성</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcumb Area End ##### -->
    
    <!-- BoardContent Start -->
    <form name="boardForm" method="post" action="${pageContext.request.contextPath}/front?key=post&methodName=insertPost" 
 	onSubmit='return checkValid()'>
    <p>
    <div class="wrapper" style="text-align:center">
    <div class="row" id="boardContent">
	<div class="col-md-3"></div>
    <div class="col-md-6">
    <div class="table table-responsive">
        <table class="table">     
        <tr>
            <th class="success col-md-3">카테고리</th>
     	    <td>
           	 <select class="select" name="type" id="boardCategory">
             	<option value="" disabled selected>선택</option>
           	   	<option value="2">TIP</option>
        	   	<option value="3">후기</option>
          	    <option value="4">Q&A</option>

         	 </select>
         	 </td>
            <th class="success col-md-3">작성자</th>
            <td><!--  <input type="hidden" name="user" value="" disabled>--></td>
        </tr>         
        <tr>
            <th class="success">제목</th>
            <td colspan="6">
            	<textarea class="form-control" id="title" placeholder="제목을 입력해주세요."></textarea>
            </td>
        </tr>
         
        <tr>
            <th class="success">글 내용</th>
            <td colspan="6">
            	<textarea class="form-control" id="content" placeholder="내용을 입력해주세요."></textarea>
           	</td>
        </tr>
         
        <tr>
            <td colspan="6" class="text-center">
  				<input type=submit class="btn btn-warning" value=작성>       
				<input type="button" class="btn btn-danger" value="취소" onclick="javascript:history.back()">
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
<jsp:include page="../common/footer.jsp"/>   