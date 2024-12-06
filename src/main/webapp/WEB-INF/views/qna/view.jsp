<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../inc/header.jsp" />

	<div>
		<label>제목</label>
		<input type="text" name="title" id="title" value='<c:out value="${ board.title }"/>' readonly="readonly">
	</div>
	<div>
		<label>내용</label>
		<textarea id="content" name="content" readonly="readonly"><c:out value="${board.content }"/></textarea>
	</div>
	<div>
		<label>작성자</label>
		<input type="text" name="name" id="name" value='<c:out value="${board.name }"/>' readonly="readonly">
	</div>
	<button type="submit">수정</button>
	<button type="">삭제</button>
	<button type="button" onclick="location.href='/qna/List';">목록</button>
	<!-- // -->
<jsp:include page="../inc/footer.jsp" />