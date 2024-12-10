<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% 
    request.setAttribute("bodyClass", "charge"); 
%>
<jsp:include page="../inc/header.jsp" />
				<!-- #content 영역 시작 -->
                <p class="page-tit">Data</p>
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
                                    <li>No</li>
                                    <li>이름</li>
                                    <li>사용량</li>
                                    <li>사용기간</li>
                                    <li>납부여부</li>
                                    <li>납부일</li>
                                    <li>납부기한</li>
                                    <li>요금</li>
                                </ul>
                            </li>
                            <li class="list-body">
                                <ul>
                                    <!-- 반복 -->
                                    <c:forEach items="${list}" var="list">
					                   	<li>
					                   		<a href="/charge/charge?uname=${list.uname}&email=${list.email}&phone_num=${list.phone_num}">
		                                        <ul class="row">
			                                        <li><c:out value="${list.code}"/></li>
			                                        <li><c:out value="${list.uname}"/></li>
							                   		<li><c:out value="${list.use_quentity}"/></li>
							                   		<li><fmt:formatDate pattern="yyyy-MM-dd" value="${list.use_start}"/>
							                   		 ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${list.use_end}"/></li>
							                   		<li><c:out value="${list.already_paid}"/></li>
							                   		<li><fmt:formatDate pattern="yyyy-MM-dd" value="${list.paid_day}"/></li>
							                   		<li><fmt:formatDate pattern="yyyy-MM-dd" value="${list.paid_limit}"/></li>
							                   		<li><c:out value="${list.charge}"/></li>
		                                        </ul>
	                                        </a>
	                                    </li>
                  					</c:forEach>
                                    <!-- 반복 -->
                                </ul>
                            </li>
                        </ul>
                        <div class="pagination">
				            <ul class="flex ju-center al-center">
				                <li><a href="?page=1">맨처음</a></li>
				                <li><a href="?page=${currentPage - 1 > 0 ? currentPage - 1 : 1}">처음</a></li>
				
				                <!-- 현재 페이지 표시 -->
				                <c:forEach begin="1" end="${totalPages}" var="i">
				                    <li class="${i == currentPage ? 'on' : ''}">
				                        <a href="?page=${i}">${i}</a>
				                    </li>
				                </c:forEach>
				
				                <li><a href="?page=${currentPage + 1 <= totalPages ? currentPage + 1 : totalPages}">뒤로</a></li>
				                <li><a href="?page=${totalPages}">맨뒤로</a></li>
				            </ul>
			        	</div>
                    </div>
                </div>
                <!-- #content 영역 끝 -->
<jsp:include page="../inc/footer.jsp" />
