<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "main"); 
%>
<jsp:include page="./inc/header.jsp" />

	<!-- #content ���� ���� -->
	<div id="content">  
		<div class="box">
			<p>�α����� �ʿ��մϴ�.</p>
			<div class="btn-box">
				<a href="/member/login" class="btn btn-bagic">�α���</a>
			</div>
		</div>
	</div>
	<!-- #content ���� �� -->
<jsp:include page="./inc/footer.jsp" />
