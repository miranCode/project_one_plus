<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../inc/header.jsp" />
<form role="form" action="/qna/modify" method="post">
	<input type="hidden" name="idx" value="${ board.idx }">
	<div>
		<label>제목</label>
		<input type="text" name="title" id="title" value='<c:out value="${ board.title }"/>'>
	</div>
	<div>
		<label>내용</label>
		<textarea id="content" name="content"><c:out value="${board.content }"/></textarea>
	</div>
	<div>
		<label>작성자</label>
		<input type="text" name="name" id="name" value='<c:out value="${board.name }"/>' readonly="readonly">
	</div>
	<button type="submit" data-oper='modify'>수정완료</button>
	<button type="submit" data-oper='remove'>삭제</button>
	<button type="button" data-oper='list'>목록</button>
</form>
	<!-- // -->
<script type="text/javascript">
$(document).ready(function(){
	var formObj = $("form");
	
	$('button').on("click", function(e){
		e.preventDefault();
		
		var operation = $(this).data("oper");
		
		if(operation === 'remove'){
			formObj.attr("action","/qna/remove");
		}else if(operation === 'list'){
			self.location = "/qna/List";
			return;
		}
		formObj.submit();
	});
	
});
</script>
<jsp:include page="../inc/footer.jsp" />