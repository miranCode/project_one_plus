<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "main"); 
%>
<jsp:include page="./inc/header.jsp" />

	<!-- #content 영역 시작 -->
	<div id="content">  
		<div class="box">
			<p>로그인이 필요합니다.</p>
			<div class="btn-box">
				<a href="/member/login" class="btn btn-bagic">로그인</a>
			</div>
		</div>
	</div>
	<!-- #content 영역 끝 -->
<jsp:include page="./inc/footer.jsp" />
