<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "main"); 
%>
<jsp:include page="./inc/header.jsp" />

	<!-- #content 영역 시작 -->
	<div id="content">  
		<!-- box  -->
		<div class="box section01">
			<p style="filter:${empty id ? 'blur(5px)' : 'none'};">
			
				안녕하세요! ${uname} 고객님
				<br />
				(로그인시, 최신 발행 달 출력) 청구 요금 안내입니다.
			</p>
			<div style="filter:${empty id ? 'blur(5px)' : 'none'};">
				<dl>
					<dt>요금 청구 기준일</dt>
					<dd>00.00.00 - 00.00.00</dd>
				</dl>
				<dl>
					<dt>당월 사용 전력량</dt>
					<dd class="bar-area">
						<span class="stic" style="display:block; width:80%; height:15px; background:yellow; "></span>
						<span class="stic-txt" style="left:80%;  ">50w</span>
					</dd>
				</dl>
				<dl>
					<dt>청구일 / 청구 비용</dt>
					<dd>00.00.00 / 000.000 원</dd>
				</dl>
				<dl>
					<dt>납부기한 / 납부여부</dt>
					<dd>00.00.00 / 미납</dd>
				</dl>
				<div class="btn-box">
					<a href="" class="btn btn-bagic line">자세히 보기</a>
				</div>
			</div>
			<c:if test="${ empty id }">
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
			<p>전력 수급 현황 <span>(00.00.00 요일)</span></p>
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
