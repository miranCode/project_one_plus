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
                                    <c:forEach items="${list}" var="charge">
					                   	<li>
					                   		<a href="/charge/charge?code=${charge.code}">
		                                        <ul class="row">
			                                        <li><c:out value="${charge.code}"/></li>
			                                        <li><c:out value="${charge.uname}"/></li>
							                   		<li><c:out value="${charge.use_quentity}"/></li>
							                   		<li><fmt:formatDate pattern="yyyy-MM-dd" value="${charge.use_start}"/>
							                   		 ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${charge.use_end}"/></li>
							                   		<li><c:out value="${charge.already_paid}"/></li>
							                   		<li><fmt:formatDate pattern="yyyy-MM-dd" value="${charge.paid_day}"/></li>
							                   		<li><fmt:formatDate pattern="yyyy-MM-dd" value="${charge.paid_limit}"/></li>
							                   		<li><c:out value="${charge.charge}"/></li>
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
<jsp:include page="../inc/footer.jsp" />
