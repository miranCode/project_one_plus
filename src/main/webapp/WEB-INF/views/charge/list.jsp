<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% 
    request.setAttribute("bodyClass", "charge"); 
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
                                    <li>No</li>
                                    <li>이름</li>
                                    <li>전화번호</li>
                                    <li>이메일</li>
                                    <li>요금적용전력</li>
                                    <li>지상역률</li>
                                    <li>수전전압</li>
                                    <li>사용량</li>
                                    <li>잔상역률</li>
                                    <li>사용시작일</li>
                                    <li>사용종료일</li>
                                    <li>납부여부</li>
                                    <li>납부일</li>
                                    <li>청구일</li>
                                    <li>납부기한</li>
                                    <li>납부방식</li>
                                </ul>
                            </li>
                            <li class="list-body">
                                <ul>
                                    <!-- 반복 -->
                                    <c:forEach items="${list}" var="charge">
					                   	<li>
	                                        <ul class="row">
		                                        <li><c:out value="${charge.code}"/></li>
						                   		<li><c:out value="${charge.uname}"/></li>
						                   		<li><c:out value="${charge.phone_num}"/></li>
						                   		<li><c:out value="${charge.email}"/></li>
						                   		<li><c:out value="${charge.billing_power}"/></li>
						                   		<li><c:out value="${charge.power_factor}"/></li>
						                   		<li><c:out value="${charge.supply_voltage}"/></li>
						                   		<li><c:out value="${charge.use_quentity}"/></li>
						                   		<li><c:out value="${charge.rdpower_factor}"/></li>
						                   		<li><fmt:formatDate pattern="yyyy-MM-dd" value="${charge.use_start}"/></li>
						                   		<li><fmt:formatDate pattern="yyyy-MM-dd" value="${charge.use_end}"/></li>
						                   		<li><c:out value="${charge.already_paid}"/></li>
						                   		<li><c:out value="${charge.paid_day}"/></li>
						                   		<li><c:out value="${charge.dill_date}"/></li>
						                   		<li><c:out value="${charge.paid_limit}"/></li>
						                   		<li><c:out value="${charge.how_to_pay}"/></li>
	                                        </ul>
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
