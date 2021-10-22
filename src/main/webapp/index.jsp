<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<!-- Favicon -->
    <link rel="icon" href="img/core-img/kfavicon.ico">
    
    <!-- Title -->
    <title>Kooking - Kosta cooking | Home</title>    
    
    <style>
    .lst_recipe {
	overflow: hidden;
	margin-bottom: 56px;
	width: 1040px;
	position: relative;
	left: -16px;
}

.inner {
	position: relative;
	width: 1024px;
	margin: auto;
}

.lst_recipe>li {
	width: 244px;
	height: 390px;
	margin: 0 0 16px 16px;
	position: relative;
	border: 1px solid #7c7c7c;
	box-sizing: border-box;
	float: left;
	background-color: #fff;
}

.lst_recipe li .thmb {
	display: block;
	margin: 4px;
	position: relative;
}

.lst_recipe li .thmb img {
	width: 234px;
	height: 234px;
	display: block;
}

.lst_recipe li .thmb:after {
	position: absolute;
	display: block;
	content: '';
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	background: url(/assets/_img/common/img_grad-dcde50e….png) center center
		no-repeat;
	background-size: 234px 234px;
	z-index: 1;
}

.lst_recipe li .judge {
	position: absolute;
	top: 187px;
	right: 10px;
	color: #eee;
	font-size: 13px;
	text-align: center;
	line-height: 1;
	z-index: 5;
}

.lst_recipe li .judge strong {
	font-size: 25px;
	color: #fff;
	display: block;
	font-family: Microsoft YaHei, 'NSB';
}

.lst_recipe li .author {
	text-align: center;
	width: 100%;
	z-index: 5;
	display: block;
	margin-top: -40px;
	position: relative;
}

button, a {
	outline: none;
	text-decoration: none;
	color: #444;
	padding: 0;
	margin: 0;
	cursor: pointer;
}

.lst_recipe li .author img {
	width: 61px;
	height: 61px;
	border-radius: 50%;
	overflow: hidden;
	display: block;
	margin: 0 auto 5px;
	vertical-align: middle;
}

.lst_recipe li .author strong {
	color: #808080;
	font-size: 14px;
	font-weight: normal;
}

.lst_recipe li .author strong a {
	color: #808080;
}

.lst_recipe li .author {
	text-align: center;
	width: 100%;
	z-index: 5;
	display: block;
	margin-top: -40px;
	position: relative;
}

.lst_recipe li p {
	text-align: center;
	font-size: 15px;
	font-family: Microsoft YaHei, 'NSB';
	line-height: 19px;
	letter-spacing: -0.025em;
	padding: 2px 10px 0;
	margin-bottom: 5px;
}

.lst_recipe li p a {
	color: #3b3b3b;
}

.lst_recipe li p strong {
	display: block;
	overflow: hidden;
	margin-top: 5px;
	word-break: keep-all;
	white-space: nowrap;
	text-overflow: ellipsis;
	color: gray;
}

.lst_recipe .option {
	width: 244px;
	position: absolute;
	bottom: 0;
	height: 27px;
	border-top: 1px solid #e1e1e1;
	display: flex;
	justify-content: center;
	align-content: center;
	align-items: center;
}

.option-col {
	flex-grow: 1;
	text-align: center;
	display: flex;
	justify-content: space-evenly;
	align-items: center;
}

.option-vlaue, .option-svg {
	display: flex;
}

.option-value {
	padding-top: 5px;
}

.recipe-text{
	padding: 20px;
	font-size:20px;
	font-weight:bold;

}

.recipe-alert img{
	max-height: 40px;
	width:auto;
	padding:5px;
	margin-right:20px;
}

.recipe-alert{
	font-size:17px;
}

.pagination-link{
	font-size:25px;
	padding: 20px;
}

.pagination-link:hover, .pagination-link:focus{
	color : black !important;
}

.pagination-wrapper{
	text-align:center;
	padding:30px;

}

    .active{
    	color:tomato;
    }



    
    
    </style>
</head>

<body>
	<!-- header -->
	<jsp:include page="/common/header.jsp"/>
	
    <!-- Preloader -->
    <div id="preloader">
        <i class="circle-preloader"></i>
        <img src="${pageContext.request.contextPath}/img/core-img/salad.png" alt="">
    </div>
    
    
    
    
    
    <!-- 이쪽부분 수정해주세요 -->
    	<div class="inner">
		<ul class="lst_recipe">
			<li><a class="call_recipe thmb" href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> 
			<img src="https://cdn.crowdpic.net/list-thumb/thumb_l_DD51FBE2D7E141BD017D9DA4B3004708.jpg"
					alt="">
			</a> <span class="judge">평가점수
			<c:choose>
				<c:when test="${recipe.score}>=0">
				<strong>5.0</strong>
				</c:when>
				<c:otherwise>
				<strong>?</strong>
				</c:otherwise>
			</c:choose>
			</span> <span
				class="author"> <a href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> <img
						alt="프로필 이미지"
						src="http://images.socdoc.io/images/article/2021/04/19/375589/903536b126be_883152e0e6f8.png">
				</a> <strong><a href="${path}/front?key=search&methodName=view&no=${recipe.post.no}">${recipe.post.userNicname }</a></strong>
			</span>
				<p>
					<a class="call_recipe" href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> ${recipe.name } 
					<strong>${recipe.post.title }</strong>
					</a>
				</p>
				<div class="option">
					<div class="option-col">
						<div class="option-svg">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
		  <path
									d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z" />
		  <path
									d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z" />
		</svg>
						</div>
						<div class="option-value">${recipe.cookingTime}분</div>
					</div>
					<div class="option-col">
						<div class="option-svg">
						</div>
						<div class="option-value">${recipe.type}</div>
					</div>
				</div></li>
							<li><a class="call_recipe thmb" href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> 
			<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcvEEDeFMCaZ0SVW__wVNWhicyzVdkKBxU0A&usqp=CAU"
					alt="">
			</a> <span class="judge">평가점수
			<c:choose>
				<c:when test="${recipe.score}>=0">
				<strong>4.5</strong>
				</c:when>
				<c:otherwise>
				<strong>?</strong>
				</c:otherwise>
			</c:choose>
			</span> <span
				class="author"> <a href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> <img
						alt="프로필 이미지"
						src="https://t1.kakaocdn.net/kakaocorp/kakaocorp/admin/news/79590191017a00001.jpg">
				</a> <strong><a href="${path}/front?key=search&methodName=view&no=${recipe.post.no}">${recipe.post.userNicname }</a></strong>
			</span>
				<p>
					<a class="call_recipe" href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> ${recipe.name } 
					<strong>${recipe.post.title }</strong>
					</a>
				</p>
				<div class="option">
					<div class="option-col">
						<div class="option-svg">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
		  <path
									d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z" />
		  <path
									d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z" />
		</svg>
						</div>
						<div class="option-value">${recipe.cookingTime}분</div>
					</div>
					<div class="option-col">
						<div class="option-svg">
						</div>
						<div class="option-value">${recipe.type}</div>
					</div>
				</div></li>
				
							<li><a class="call_recipe thmb" href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> 
			<img src="https://i0.wp.com/sharehows.com/wp-content/uploads/2016/08/Spam-mayonnaise-on-rice-00.png?fit=800%2C400"
					alt="">
			</a> <span class="judge">평가점수
			<c:choose>
				<c:when test="${recipe.score}>=0">
				<strong>4.8}</strong>
				</c:when>
				<c:otherwise>
				<strong>?</strong>
				</c:otherwise>
			</c:choose>
			</span> <span
				class="author"> <a href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> <img
						alt="프로필 이미지"
						src="http://file3.instiz.net/data/cached_img/upload/2019/11/08/16/2bb7eb77fd6c02bb493a327a60420262.jpg">
				</a> <strong><a href="${path}/front?key=search&methodName=view&no=${recipe.post.no}">${recipe.post.userNicname }</a></strong>
			</span>
				<p>
					<a class="call_recipe" href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> ${recipe.name } 
					<strong>${recipe.post.title }</strong>
					</a>
				</p>
				<div class="option">
					<div class="option-col">
						<div class="option-svg">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
		  <path
									d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z" />
		  <path
									d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z" />
		</svg>
						</div>
						<div class="option-value">${recipe.cookingTime}분</div>
					</div>
					<div class="option-col">
						<div class="option-svg">
						</div>
						<div class="option-value">${recipe.type}</div>
					</div>
				</div></li>
				
							<li><a class="call_recipe thmb" href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> 
			<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTykkg4msCEHbPZpixYydQIOynQPKECRvxaSg&usqp=CAU"
					alt="">
			</a> <span class="judge">평가점수
			<c:choose>
				<c:when test="${recipe.score}>=0">
				<strong>3.5</strong>
				</c:when>
				<c:otherwise>
				<strong>?</strong>
				</c:otherwise>
			</c:choose>
			</span> <span
				class="author"> <a href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> <img
						alt="프로필 이미지"
						src="https://mblogthumb-phinf.pstatic.net/MjAxOTExMTdfMzQg/MDAxNTczOTkxOTYyMzg5.E2pNwh6fa1lHruB9h2wnJE_OXoGId1uEJlgyzzMOYCgg.54xwldcGrpXZK_aD5-CPEOkps0MPxgPjErG6Oyw8B4Ag.JPEG.sweety_420/1573991961889.jpg?type=w800">
				</a> <strong><a href="${path}/front?key=search&methodName=view&no=${recipe.post.no}">${recipe.post.userNicname }</a></strong>
			</span>
				<p>
					<a class="call_recipe" href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> ${recipe.name } 
					<strong>${recipe.post.title }</strong>
					</a>
				</p>
				<div class="option">
					<div class="option-col">
						<div class="option-svg">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
		  <path
									d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z" />
		  <path
									d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z" />
		</svg>
						</div>
						<div class="option-value">${recipe.cookingTime}분</div>
					</div>
					<div class="option-col">
						<div class="option-svg">
						</div>
						<div class="option-value">${recipe.type}</div>
					</div>
				</div></li>
		</ul>
		</div>
    
    
     <!-- ### 오늘의 추천 레시피 start ### -->
    <section class="top-catagory-area section-padding-80-0">
        <div class="container">
        	<div class="section-heading">
					<h3>오늘의 추천 레시피 </h3>
			</div>
            <div class="row">
                <!-- Top Catagory Area -->
                <div class="col-12 col-lg-4">
                    <div class="single-top-catagory">
                        <img src="img/bg-img/bg2.jpg" alt="">
                        <!-- Content -->
                        <div class="top-cta-content">
                            <h3>Strawberry Cake</h3>
                            <h6>Simple &amp; Delicios</h6>
                            <a href="receipe.jsp" class="btn delicious-btn">더보기</a>
                        </div>
                    </div>
                </div>
                <!-- Top Catagory Area -->
                <div class="col-12 col-lg-4">
                    <div class="single-top-catagory">
                        <img src="img/bg-img/bg3.jpg" alt="">
                        <!-- Content -->
                        <div class="top-cta-content">
                            <h3>Chinesse Noodles</h3>
                            <h6>Simple &amp; Delicios</h6>
                            <a href="receipe.jsp" class="btn delicious-btn">더보기</a>
                        </div>
                    </div>
                </div>
                <!-- Top Catagory Area -->
                <div class="col-12 col-lg-4">
                    <div class="single-top-catagory">
                        <img src="img/bg-img/bg3.jpg" alt="">
                        <!-- Content -->
                        <div class="top-cta-content">
                            <h3>Chinesse Noodles</h3>
                            <h6>Simple &amp; Delicios</h6>
                            <a href="receipe.jsp" class="btn delicious-btn">더보기</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ### 오늘의 추천 레시피 end ### -->
    
    <!-- ###회원 랭킹(베스트셰프) start -->
    <section class="best-receipe-area">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading">
                        <h3>회원 랭킹 Best Chef</h3>
                    </div>
                </div>
            </div>

            <div class="row">
            
                <!-- Single Best Receipe Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-best-receipe-area mb-30">
                    	<a href="user.jsp">
                        	<img src="img/bg-img/r1.jpg" alt="">
                        </a>
                        <div class="receipe-content">
                            <a href="user.jsp">
                                <h5>lee쉐프</h5>
                            </a>
                            <div class="ratings">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Best Receipe Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-best-receipe-area mb-30">
                    	<a href="user.jsp">
                        	<img src="img/bg-img/r2.jpg" alt="">
                        </a>
                        <div class="receipe-content">
                            <a href="user.jsp">
                                <h5>은하수진주</h5>
                            </a>
                            <div class="ratings">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Best Receipe Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-best-receipe-area mb-30">
                    	<a href="user.jsp">
                        	<img src="img/bg-img/r3.jpg" alt="">
                        </a>
                        <div class="receipe-content">
                            <a href="user.jsp">
                                <h5>햇살머금은집</h5>
                            </a>
                            <div class="ratings">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </div>
                        </div>
                    </div>
                </div>
                
          </div>
          </div>
          </section>
          
          <!-- ###회원 랭킹(베스트셰프) end -->
          
    <!-- ##### 랭킹레시피 Start ##### -->
    <section class="small-receipe-area section-padding-80-0">
        <div class="container">
        	<div class="section-heading">
					<h3>랭킹 레시피</h3>
			</div>
            <div class="row">
                <!-- Small Receipe Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-small-receipe-area d-flex">
                        <!-- Receipe Thumb -->
                        <div class="receipe-thumb">
                             <img src="img/bg-img/sr1.jpg" alt="">
                        </div>
                        <!-- Receipe Content -->
                        <div class="receipe-content">
                            <span>January 04, 2018</span>
                            <a href="receipe.jsp">
                                <h5>Homemade italian pasta</h5>
                            </a>
                            <div class="ratings">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </div>
                            <p>2 Comments</p>
                        </div>
                    </div>
                </div>

                <!-- Small Receipe Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-small-receipe-area d-flex">
                        <!-- Receipe Thumb -->
                        <div class="receipe-thumb">
                            <img src="img/bg-img/sr2.jpg" alt="">
                        </div>
                        <!-- Receipe Content -->
                        <div class="receipe-content">
                            <span>January 04, 2018</span>
                            <a href="receipe.jsp">
                                <h5>Baked Bread</h5>
                            </a>
                            <div class="ratings">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </div>
                            <p>2 Comments</p>
                        </div>
                    </div>
                </div>

                <!-- Small Receipe Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-small-receipe-area d-flex">
                        <!-- Receipe Thumb -->
                        <div class="receipe-thumb">
                            <img src="img/bg-img/sr3.jpg" alt="">
                        </div>
                        <!-- Receipe Content -->
                        <div class="receipe-content">
                            <span>January 04, 2018</span>
                            <a href="receipe.jsp">
                                <h5>Scalops on salt</h5>
                            </a>
                            <div class="ratings">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </div>
                            <p>2 Comments</p>
                        </div>
                    </div>
                </div>

                <!-- Small Receipe Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-small-receipe-area d-flex">
                        <!-- Receipe Thumb -->
                        <div class="receipe-thumb">
                            <img src="img/bg-img/sr4.jpg" alt="">
                        </div>
                        <!-- Receipe Content -->
                        <div class="receipe-content">
                            <span>January 04, 2018</span>
                            <a href="receipe.jsp">
                                <h5>Fruits on plate</h5>
                            </a>
                            <div class="ratings">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </div>
                            <p>2 Comments</p>
                        </div>
                    </div>
                </div>

                <!-- Small Receipe Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-small-receipe-area d-flex">
                        <!-- Receipe Thumb -->
                        <div class="receipe-thumb">
                            <img src="img/bg-img/sr5.jpg" alt="">
                        </div>
                        <!-- Receipe Content -->
                        <div class="receipe-content">
                            <span>January 04, 2018</span>
                            <a href="receipe.jsp">
                                <h5>Macaroons</h5>
                            </a>
                            <div class="ratings">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </div>
                            <p>2 Comments</p>
                        </div>
                    </div>
                </div>

                <!-- Small Receipe Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-small-receipe-area d-flex">
                        <!-- Receipe Thumb -->
                        <div class="receipe-thumb">
                            <img src="img/bg-img/sr6.jpg" alt="">
                        </div>
                        <!-- Receipe Content -->
                        <div class="receipe-content">
                            <span>January 04, 2018</span>
                            <a href="receipe.jsp">
                                <h5>Chocolate tart</h5>
                            </a>
                            <div class="ratings">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </div>
                            <p>2 Comments</p>
                        </div>
                    </div>
                </div>

                <!-- Small Receipe Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-small-receipe-area d-flex">
                        <!-- Receipe Thumb -->
                        <div class="receipe-thumb">
                            <img src="img/bg-img/sr7.jpg" alt="">
                        </div>
                        <!-- Receipe Content -->
                        <div class="receipe-content">
                            <span>January 04, 2018</span>
                            <a href="receipe.jsp">
                                <h5>Berry Desert</h5>
                            </a>
                            <div class="ratings">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </div>
                            <p>2 Comments</p>
                        </div>
                    </div>
                </div>

                <!-- Small Receipe Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-small-receipe-area d-flex">
                        <!-- Receipe Thumb -->
                        <div class="receipe-thumb">
                            <img src="img/bg-img/sr8.jpg" alt="">
                        </div>
                        <!-- Receipe Content -->
                        <div class="receipe-content">
                            <span>January 04, 2018</span>
                            <a href="receipe.jsp">
                                <h5>Zucchini Grilled on peper</h5>
                            </a>
                            <div class="ratings">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </div>
                            <p>2 Comments</p>
                        </div>
                    </div>
                </div>

                <!-- Small Receipe Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-small-receipe-area d-flex">
                        <!-- Receipe Thumb -->
                        <div class="receipe-thumb">
                            <img src="img/bg-img/sr9.jpg" alt="">
                        </div>
                        <!-- Receipe Content -->
                        <div class="receipe-content">
                            <span>January 04, 2018</span>
                            <a href="receipe.jsp">
                                <h5>Chicken Salad</h5>
                            </a>
                            <div class="ratings">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </div>
                            <p>2 Comments</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### 랭킹레시피 End ##### -->
    
    <!-- footer -->
    <jsp:include page="/common/footer.jsp"/>  
</body>

</html>
 