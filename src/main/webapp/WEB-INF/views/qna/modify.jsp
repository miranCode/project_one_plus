<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "write"); 
%>
<jsp:include page="../inc/header.jsp" />
	<div id="content">        
	    <div class="">
	    	<form role="form" action="/qna/modify" method="post">
				<fieldset>
					<input type="hidden" name="idx" value="${ board.idx }">
					<input type='hidden' name='pageNum' value='<c:out value="${ cri.pageNum }"/>'>
				    <input type='hidden' name='amount' value='<c:out value="${ cri.amount }"/>'>
					<dl class="txt-area">
						<dt>작성자</dt>
						<dd class="">
							${board.name }
							<input type="hidden" name="name" id="name" value='<c:out value="${board.name }"/>' readonly="readonly">
						</dd>
					</dl>
					<dl class="txt-area">
						<dt>이메일</dt>
						<dd class="">
							${board.email }
						</dd>
					</dl>
					<dl>
						<dt>제목</dt>
						<dd class="input-box">
							<input type="text" name="title" id="title" value='<c:out value="${ board.title }"/>'>
						</dd>
					</dl>
					<dl>
						<dt>내용</dt>
						<dd class="input-box">
							<textarea id="content" name="content"><c:out value="${board.content }"/></textarea>
						</dd>
					</dl>
					<div class="btn-area three">
	                    <button type="submit" class="red-line" data-oper='remove'>삭제</button>
	                    <a href="/qna/List" class="line">List</a>
	                    <button type="submit" data-oper='modify'>Write</button>
				</fieldset>
			</form>
	    </div>
	</div>
	

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
			formObj.attr("action","/qna/List").attr("method","get");
			var pageNumTag = $("input[name='pageNum']").clone();
			var amountTag = $("input[name='amount']").clone();
			
			formObj.empty();
			formObj.append(pageNumTag);
			formObj.append(amountTag);
		}
		formObj.submit();
	});
	
});
</script>
<jsp:include page="../inc/footer.jsp" />