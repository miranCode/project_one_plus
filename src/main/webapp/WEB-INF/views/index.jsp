<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- css �ҷ����� -->
		<link href="/resources/css/style.css?after" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="/resources/js/slick-1.8.1/slick/slick.css"/>
        <!-- // css �ҷ����� -->
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css"><!-- ������ �ҷ����� -->
        <!-- web font �ҷ����� -->
        <link rel="stylesheet" href="https://webfontworld.github.io/pretendard/Pretendard.css">
        <!-- ���� js �ҷ�����  -->
		<script type="text/javascript" src="/resources/js/jquery-3.7.1.min.js"></script>
		<script type="text/javascript" src="/resources/js/slick-1.8.1/slick/slick.min.js"></script>
	</head>
	<body>
	 	<!-- wrap ���� ���� -->
        <div id="wrap">
        	<!-- header ���� ���� -->
            <header id="header">
				<p>���� ȭ��</p> 
				<!-- #gng ���� ���� -->
                <nav id="gnb">
                </nav>
                <!-- #gng ���� �� -->
			</header>
			<!-- header ���� �� -->
			<!-- #container ���� ���� -->
            <div id="container">
            	<!-- #content ���� ���� -->
                <div id="content">      
                	<a href="login">�α���</a>
					<button id="alertbtn">�˸�â</button>
					<script type="text/javascript" src="/resources/js/index.js"></script>  
                </div>
                <!-- #content ���� �� -->
            </div>
            <!-- #container ���� �� -->
            <!-- footer ���� ���� -->
            <footer id="footer">
            </footer>
            <!-- footer ���� �� -->
            <p>${ mode }</p>
            <p>�̸� ${ mode.name }</p>
			<p>���� ${ mode.age }</p>
		</div>
		<!-- wrap ���� �� -->
	</body>
</html>
