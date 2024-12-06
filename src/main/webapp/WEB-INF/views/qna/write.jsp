<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "main"); 
%>
<jsp:include page="../inc/header.jsp" />
<%-- <%@ include file="../../../resources/css/write.css" %> --%>
<!-- <link href="../../../resources/css/write.css" type="text/css" rel="stylesheet" > -->
 <div>
 	<div>
 		<h1>글쓰기</h1>
 	</div>
 </div>
<form name="writeFrm" method="post" enctype="multipart/form-data"
	action="/qna/write">
	<div>
		<label>제목</label>
		<input type="text" name="title" id="title" required>
	</div>
	<div>
		<label>내용</label>
		<textarea id="content" name="content" required></textarea>
	</div>
	<div>
		<label>작성자</label>
		<input type="text" name="name" id="name" required>
	</div>
	<div>
		<label>email</label>
		<input type="text" name="email" id="email" required>
	</div>
	<div>
		<label>비밀번호</label>
		<input type="password" name="pass" id="pass" required>
	</div>
	<button type="submit">작성</button>
	<button type="button" onclick="location.href='/qna/List';">목록</button>
</form>

<!-- // -->
    
<jsp:include page="../inc/footer.jsp" />