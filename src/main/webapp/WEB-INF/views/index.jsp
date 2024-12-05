<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- css 불러오기 -->
		<link href="/resources/css/style.css?after" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="/resources/js/slick-1.8.1/slick/slick.css"/>
        <!-- // css 불러오기 -->
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css"><!-- 아이콘 불러오기 -->
        <!-- web font 불러오기 -->
        <link rel="stylesheet" href="https://webfontworld.github.io/pretendard/Pretendard.css">
        <!-- 내부 js 불러오기  -->
		<script type="text/javascript" src="/resources/js/jquery-3.7.1.min.js"></script>
		<script type="text/javascript" src="/resources/js/slick-1.8.1/slick/slick.min.js"></script>
	</head>
	<body>
	 	<!-- wrap 영역 시작 -->
        <div id="wrap">
        	<!-- header 영역 시작 -->
            <header id="header">
				<p>메인 화면</p> 
				<!-- #gng 영역 시작 -->
                <nav id="gnb">
                </nav>
                <!-- #gng 영역 끝 -->
			</header>
			<!-- header 영역 끝 -->
			<!-- #container 영역 시작 -->
            <div id="container">
            	<!-- #content 영역 시작 -->
                <div id="content">      
                	<a href="login">로그인</a>
					<button id="alertbtn">알림창</button>
					<script type="text/javascript" src="/resources/js/index.js"></script>  
                </div>
                <!-- #content 영역 끝 -->
            </div>
            <!-- #container 영역 끝 -->
            <!-- footer 영역 시작 -->
            <footer id="footer">
            </footer>
            <!-- footer 영역 끝 -->
            <p>${ mode }</p>
            <p>이름 ${ mode.name }</p>
			<p>나이 ${ mode.age }</p>
		</div>
		<!-- wrap 영역 끝 -->
	</body>
</html>
