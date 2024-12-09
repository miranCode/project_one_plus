<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "view"); 
%>
<jsp:include page="../inc/header.jsp" />
	<dl>
        <dt>
            <p><c:out value="${ board.title }"/></p><!-- 제목 -->
            <ul class="flex">
                <li><span>작성자</span> <c:out value="${board.name }"/></li>
                <li><span>작성일</span> 00.00.00</li>
                <li><span>조회수</span> 00</li>
            </ul>
        </dt>
        <dd>
            ${board.content }
        </dd>
    </dl>
    <div class="flex">
        <div class="prev">
            <a href="">
                <span>이전글</span>
                <p class="ell">제목</p>
            </a>
        </div>
        <div class="next">
            <a href="">
                <p class="ell">제목</p>
                <span>다음글</span>
            </a>
        </div>
    </div>
    <div class="btn-area two">
        <button type="submit" class="red-line">Modipy</button>
        <a href="/qna/List" class="line">List</a>
    </div>
	<!-- 
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
	 -->
	<!-- // -->
<jsp:include page="../inc/footer.jsp" />