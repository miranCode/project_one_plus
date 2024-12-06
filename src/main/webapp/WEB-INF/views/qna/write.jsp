<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "main"); 
%>
<jsp:include page="../inc/header.jsp" />
<%@ include file="../../../resources/css/write.css" %>

    <div id="write">
        <header id="write1">
            <div class="log">
                <img src="<%= request.getContextPath() %>/image/google.jpg" width="100%" height="100">
            </div>
            <div class="editor">
                <p>글 쓰 기</p>
            </div>
        </header>
        <div id="write2">
            <div>
                <select name="category" id="category">
                    <option value="tech">Technology</option>
                    <option value="fashion">Fashion</option>
                    <option value="food">Food</option>
                </select>
            </div>
            <div>
                <button>첨부파일</button>
            </div>
        </div>
        <div class="title">
            <textarea id="textarea" rows="5" cols="100%"></textarea>
        </div>
        <textarea id="textarea" rows="20" cols="150"></textarea>
    </div>


    <div class="complete">
        <button>작성 완료</button>
    </div>



    
    <jsp:include page="../inc/footer.jsp" />