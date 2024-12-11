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
                            <p class="total">Total <span>${pageMaker.total}</span> / ${pageMaker.cri.pageNum} page</p>
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
                                    		<a class='move' href='<c:out value="${board.idx }"/>'>
	                                            <ul class="row">
	                                                <li><c:out value="${board.idx }"/></li>
	                                                <li class="ell">
	                                                <c:out value="${ board.title }" />
	                                                </li>
	                                                <li><c:out value="${ board.name }"/></li>
	                            					<li><fmt:formatDate pattern="yyyy-MM-dd" value="${ board.postdate }"/></li>
	                            					<li><c:out value="${board.visitcount }"/></li>
	                                            </ul>
                                            </a>
                                    	</li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </ul>
                        <div class="btn-area three flex ju-end">
                        	<button id="regBtn" type="button">글쓰기</button>
                        </div>
                        <form id="actionForm" action="/qna/List" method="get">
                        	<input type="hidden" name="pageNum" value='${pageMaker.cri.pageNum}'>
                       		<input type="hidden" name="amount" value='${pageMaker.cri.amount}'>
                        </form>
                        <div class="pagination">
                            <ul class="flex ju-center al-center">
                             	<c:if test="${ pageMaker.prev }">
                             		<li class="paginate_button previous">
                             		<a href="${ pageMaker.startPage -1 }">이전</a></li>
                             	</c:if>
                             	<c:forEach var="num" begin="${ pageMaker.startPage }" end="${ pageMaker.endPage }">
                             		<li class = "paginate_button ${ pageMaker.cri.pageNum == num ? "active":"" }"><a href="${ num }">${ num }</a></li>
                             	</c:forEach>
                             	<c:if test="${ pageMaker.next }">
                             		<li class="paginate_button next"><a href="${ pageMaker.endPage +1 }">다음</a></li>
                             	</c:if>
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
	
	var actionForm = $("#actionForm");
	
	$(".paginate_button a").on("click",function(e){
		
		e.preventDefault();
		
		console.log('click');
		
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
	
	$(".move").on("click",function(e){
		
		e.preventDefault();
		actionForm.append("<input type='hidden' name='idx' value='"+$(this).attr("href")+"'>");
		actionForm.attr("action","/qna/view");
		actionForm.submit();
	});
});
</script>
<jsp:include page="../inc/footer.jsp" />
<!-- // -->