<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    request.setAttribute("bodyClass", "main");
%>
<jsp:include page="./inc/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<!-- #content 영역 시작 -->
	<div id="content">  
		<!-- box  -->
		<div class="box section01">
			<p style="filter:${level >= 2 ? 'none' : 'blur(5px)'};">
				안녕하세요! ${uname} 고객님
				<br />
				<fmt:formatDate pattern="MM" value="${TMCharge.use_start}"/>월 청구 요금 안내입니다.
			</p>
			<div style="filter:${level >= 2 ? 'none' : 'blur(5px)'};">
				<!-- 로그인 상태가 아닐 경우 처리 완료 -->
			<c:if test="${not empty TMCharge}" var="data">
				<!-- 로그인 상태이고 정보가 있을 경우 -->
				<dl>
					<dt>요금 청구 기준일</dt>
					<dd> <fmt:formatDate pattern="yyyy-MM-dd" value="${TMCharge.use_start}"/> - <fmt:formatDate pattern="yyyy-MM-dd" value="${TMCharge.use_end}"/></dd>
				</dl>
				<dl>
					<dt>당월 사용 전력량</dt>
					<dd class="bar-area">
						<span class="stic" style="display:block; width:80%; height:15px; background:yellow; "></span>
						<span class="stic-txt" style="left:80%;  ">${TMCharge.use_quentity}W</span>
					</dd>
				</dl>
				<dl>
					<dt>청구일 / 청구 비용</dt>
					<dd><fmt:formatDate pattern="MM 월 dd 일" value="${TMCharge.dill_date}"/> / ${TMCharge.charge} 원</dd>
				</dl>
				<dl>
					<dt>납부기한 / 납부여부</dt>
					<dd><fmt:formatDate pattern="yy 년 MM 월 dd 일" value="${TMCharge.paid_limit}"/> / ${TMCharge.already_paid}</dd>
				</dl>
				<div class="btn-box">
					<a href="http://localhost:8080/charge/charge" class="btn btn-bagic line">자세히 보기</a>
				</div>
				<!-- // 로그인 상태이고 정보가 있을 경우 -->
				</c:if>
				
				<!-- 로그인 상태 이지만 정보가 없을 경우 -->
				<c:if test="${ not data }">
				<div class="no-data">등록된 정보가 없습니다.</div>
				</c:if>
				<!-- // 로그인 상태 이지만 정보가 없을 경우 -->
			</div>
			
			<c:if test="${empty level}">
				<div class="blur">
					<p>로그인이 필요합니다.</p>
					<div class="btn-box">
						<a href="/member/login" class="btn btn-bagic">로그인</a>
					</div>
				</div>
			</c:if>
		</div>
		<!-- // box  -->
		<div class="section02">
			<p>전력 수급 현황 <span><fmt:formatDate value="<%= new java.util.Date() %>" pattern="yyyy-MM-dd EEEE" /></span></p>
			<ul class="flex">
				<li>
					<i class="xi-lightning txt-yellow"></i>
					<p>
						공급능력
						<span>103,751 MW</span>
					</p>
				</li>
				<li>
					<i class="xi-spinner-1 xi-spin txt-primary"></i>
					<p>
						현재부하
						<span>71,696 MW</span>
					</p>
				</li>
				<li>
					<i class="xi-network-server txt-green"></i>
					<p>
						공급예비
						<span>32,055 MW</span>
					</p>
				</li>
				<li>
					
					<i class="xi-percent"></i>
					<p>
						예비율
						<span>44.71%</span>
					</p>
				</li>
			</ul>
		</div>
	</div>
	<!-- #content 영역 끝 -->
<jsp:include page="./inc/footer.jsp" />
