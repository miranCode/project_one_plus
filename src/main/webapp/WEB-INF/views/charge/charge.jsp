<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "charge"); 
%>
<jsp:include page="../inc/header.jsp" />
		<div id="content">        
            <h3>회원가입</h3>
			<div id="smartView">
				<h2>스마트뷰</h2>
			</div>
			<div id="block_A">
				<div id="block_A_1">
					<h3><!-- 고객 이름 -->AAA 님</h3>
					<p><!-- 요금명 -->AAA</p>
				</div>
				<div id="block_A_2">
					<h3><!-- 당월 청구요금 -->12월 청구요금</h3>
					<p><!-- 납부여부 -->납부완료</p>
					<div id="block_A_1_1">
						<p class="this_charge"><!-- 요금 -->99900</p>
					</div>
				</div>
			</div>
			<div id="block_B">
				<div id="block_B_1">
					<div id="block_B_1_1">
						<h5>최근 3개월간 요금그래프</h5>
						<p>3개월 평균</p>
						<div id="block_B_1_1_1"><!-- 그래프 --></div>
					</div>
				</div>
				<div id="block_B_2">
					<div id="block_B_2_1">
						<p>10월 요금</p>
						<p></p>
					</div>
					<div id="block_B_2_2">
						<p>11월 요금</p>
						<p></p>
					</div>
					<div id="block_B_2_3">
						<p>12월 요금</p>
						<p></p>
					</div>
					<div id="block_B_2_4">
						<p>10월 사용량</p>
						<p></p>
					</div>
					<div id="block_B_2_5">
						<p>11월 사용량</p>
						<p></p>
					</div>
					<div id="block_B_2_6">
						<p>12월 사용량</p>
						<p></p>
					</div>		
				</div>
			</div>
		</div>
<jsp:include page="../inc/footer.jsp" />