<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    // bodyClass를 기본값으로 빈 문자열 설정
    String bodyClass = (String) request.getAttribute("bodyClass");
    if (bodyClass == null) {
        bodyClass = ""; // 전달되지 않으면 기본값으로 빈 문자열 설정
    }	 
%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <!-- css 불러오기 -->
        <link rel="stylesheet" type="text/css" href="/resources/css/layout.css?after" />
        <link rel="stylesheet" type="text/css" href="/resources/css/main.css?after" />
        <link rel="stylesheet" type="text/css" href="/resources/js/slick-1.8.1/slick/slick.css"/>
        <!-- // css 불러오기 -->
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css"><!-- 아이콘 불러오기 -->
        <!-- web font 불러오기 -->
        <link rel="stylesheet" href="https://webfontworld.github.io/pretendard/Pretendard.css">
        <!-- 내부 링크 -->
        <script type="text/javascript" src="/resources/js/jquery-3.7.1.min.js"></script>
        <script type="text/javascript" src="/resources/js/slick-1.8.1/slick/slick.min.js"></script>
        <script> 
            // 페이지가 로딩된 후 다시 불러온다. 그래서 제이쿼리는 위에 있어도 괜찮다. 
            $(document).ready(function(){ 
                // 화면의 제일 위로 올라가기
                $("a.go_top").click(function(){
                    $('html, body').animate({
                        scrollTop: 0
                    }, 500);
                });
                // 화면의 제일 밑으로 내려가기
                $("a.go_button").click(function(){
                    $('html, body').animate({
                        scrollTop: $(document).height() - $(window).height()
                    }, 500);
                });

                // 슬릭 슬라이더 
                $('.main-visual').slick({
                    dots: true,
                    infinite: true,
                    arrows:true,
                    speed: 300,
                    slidesToShow: 1
                });
            })
        </script>
    </head>
    <body class="<%= bodyClass %>">
        <!-- wrap 영역 시작 -->
        <div id="wrap">
            <!-- header 영역 시작 -->
            <header id="header" class="">
                <!-- 로고 및 유틸 영역 시작 -->
                <div class="header-top">
                    <h1 class="logo">
                        <a href="./main.html">
                            골프용품점
                        </a>
                    </h1>
                    <div class="utill">
                        <ul>
                            <li><a href="./main.html">HOME</a></li>
                            <li><a href="./login.html">LOGIN</a></li>
                            <li><a href="./join.html">JOIN</a></li>
                        </ul>
                    </div>
                </div>
                <!-- 로고 및 유틸 영역 끝 -->
                <!-- #gng 영역 시작 -->
                <jsp:include page="./gnb.jsp" />
                <!-- #gng 영역 끝 -->
            </header>
            <!-- header 영역 끝 -->
            <!-- #container 영역 시작 -->
            <div id="container">