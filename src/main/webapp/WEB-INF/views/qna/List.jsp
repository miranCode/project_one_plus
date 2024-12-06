<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ include file="../../../resources/js/board.js" %> --%>
<% 
    request.setAttribute("bodyClass", "main"); 
%>
<jsp:include page="../inc/header.jsp" />
				<!-- #content 영역 시작 -->
                <p class="page-tit">공지사항</p>
                <div id="content">        
                    <div class="list_board">
                        <div class="list-top flex ju-between al-end">
                            <p class="total">Total <span>10</span> / 1 page</p>
                            <div class="search-input">
                                <input type="" id="search" name="" value=""/>
                                <button>
                                    <i class="xi-search"></i>
                                </button>
                            </div>
                        </div>
                        <ul class="list_board_body">
                            <li class="list-header">
                                <ul class="row">
                                    <li>No.</li>
                                    <li>제목</li>
                                    <li>작성자</li>
                                    <li>작성일</li>
                                    <li>조회수</li>
                                </ul>
                            </li>
                            <li class="list-body">
                                <ul>
                                	<c:forEach items="${list}" var="board">
                                    	<li>
                                            <ul class="row">
                                                <li><c:out value="${board.idx }"/></li>
                                                <li class="ell">
                                                <a href='/qna/view?idx=<c:out value="${board.idx }"/>'>
                                                <c:out value="${ board.title }" /></a>
                                                </li>
                                                <li><c:out value="${ board.name }"/></li>
                            					<li><fmt:formatDate pattern="yyyy-MM-dd" value="${ board.postdate }"/></li>
                            					<li><c:out value="${ board.visitcount }"/></li>
                                            </ul>
                                    	</li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </ul>
                        <div>
                        	<button id="regBtn" type="button">글쓰기</button>
                        </div>
                        <div class="pagination">
                            <ul class="flex ju-center al-center">
                                <li><a href="">맨처음</a></li>
                                <li><a href="">처음</a></li>
                                <li class="on"><a href="">1</a></li>
                                <li><a href="">2</a></li>
                                <li><a href="">3</a></li>
                                <li><a href="">4</a></li>
                                <li><a href="">5</a></li>
                                <li><a href="">뒤로</a></li>
                                <li><a href="">맨뒤로</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- #content 영역 끝 -->
<script>
$(document).ready(function(){
	var result = `<c:out value="${result}"/>`;
	
	checkModal(result);
	
	history.replaceState({},null,null)
	
	function checkModal(result){
		if(result === '' || history.state ){
			return;
		}
		
		if(parseInt(result) > 0 ){
			$(".modal-body").html("게시글" + parseInt(result) + " 번이 등록되었습니다.")
		}
		
		$("#myModal").modal("show");
	}
	
	$("#regBtn").on("click", function(){
		self.location = "/qna/write";
	})
});
</script>
<jsp:include page="../inc/footer.jsp" />
<!-- // -->