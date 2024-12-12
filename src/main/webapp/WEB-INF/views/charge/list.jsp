<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% 
    request.setAttribute("bodyClass", "charge"); 
%>
<jsp:include page="../inc/header.jsp" />
				<!-- #content 영역 시작 -->
                <p class="page-tit">전력량 및 요금</p>
                <div id="content">        
                    <div class="list_board">
                        <div class="list-top flex ju-between al-end">
                            <p class="total">
                            	${uname}님 청구 요금입니다. <br />
                            	Total <span>10</span> / 1 page
                            </p>
                            <div class="search-input">
                                <input type="" id="search" name="" value=""/>
                                <button>
                                    <i class="xi-search"></i>
                                </button>
                            </div>
                        </div>
                        <ul class="list_board_body charge_type">
                            <li class="list-body">
                                <ul>
                                    <!-- 반복 -->
                                    <c:forEach items="${list}" var="list">
					                   	<li>
					                   		<a href="/charge/charge?code=${list.code}">		                   		
					                   			<div class="box">
					                   				<div class="tit-area">
						                   				<p class="txt small">
						                   					<i class="xi-won"></i> 
						                   					<fmt:formatDate pattern="MM월" value="${list.use_start}"/> 이용요금
						                   				</p>
						                   				<p>
						                   					<span class="txt bold" style="font-size:26px;"><fmt:formatNumber value="${list.charge}" type="number" pattern="#,##0"/></span>
						                   					<span style="font-size:14px">원</span>
						                   				</p>
						                   				<p style="font-size:12px">
						                   					<fmt:formatDate pattern="yy.MM.dd" value="${list.use_start}"/> ~ <fmt:formatDate pattern="yy.MM.dd" value="${list.use_end}"/>
						                   				</p>
					                   				</div>
					                   				<div class="bar-area">
						                   				<div style="background: #f5f5f5; border: 1px solid transparent;">
															<span class="stic" style="display:block;  border-right: 1px solid transparent; width:${list.use_quentity/(list.billing_power/100)}%; height:5px; background: rgb(73, 73, 238)">
															</span>
														</div>
														<div class="">
															<p style="font-size:12px; color:#999; margin-top:10px; line-height:1;">
																<fmt:formatDate pattern="MM월" value="${list.use_start}"/> 요금 적용 전력 / <fmt:formatDate pattern="MM월" value="${list.use_start}"/> 사용량
															</p>
															<p class="txt small bold">${list.billing_power} kWh / ${list.use_quentity} kWh</p>
														</div>
													</div>
													<p class="more txt-primary txt bold">자세히 보기 <i class="xi-angle-right-min"></i></p>
					                   			</div>
	                                        </a>
	                                    </li>
                  					</c:forEach>
                                    <!-- 반복 -->
                                </ul>
                            </li>
                        </ul>
                        <div class="pagination">
						    <ul class="flex ju-center al-center">
						        <li style="${currentPage == 1 ? 'display:none;' : ''}">
						            <a href="?page=1" class="${currentPage == 1 ? 'disabled' : ''}">맨처음</a>
						        </li>
						        <li style="${currentPage == 1 ? 'display:none;' : ''}">
						            <a href="?page=${currentPage - 1}" class="${currentPage == 1 ? 'disabled' : ''}">처음</a>
						        </li>
						        <c:forEach begin="1" end="${totalPages}" var="i">
						            <li class="${i == currentPage ? 'on' : ''}">
						                <a href="?page=${i}" class="${totalPages == 0 ? 'disabled' : ''}">${i}</a>
						            </li>
						        </c:forEach>
						        <li style="${currentPage == totalPages || totalPages == 0 ? 'display:none;' : ''}">
						            <a href="?page=${currentPage + 1 <= totalPages ? currentPage + 1 : currentPage}" class="${currentPage == totalPages || totalPages == 0 ? 'disabled' : ''}">
						                다음
						            </a>
						        </li>
						        <li style="${currentPage == totalPages || totalPages == 0 ? 'display:none;' : ''}">
						            <a href="?page=${totalPages}" class="${currentPage == totalPages || totalPages == 0 ? 'disabled' : ''}">맨뒤로</a>
						        </li>
						    </ul>
						</div>
                    </div>
                </div>
                <!-- #content 영역 끝 -->
<jsp:include page="../inc/footer.jsp" />
