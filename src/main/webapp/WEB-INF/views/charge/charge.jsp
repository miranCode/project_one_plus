<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% 
    request.setAttribute("bodyClass", "charge"); 
%>
<jsp:include page="../inc/header.jsp" />
		<div id="content">        
			<div class="section01">
				<div id="block_A">
					<div>
						<h3>${Detail.uname} 님</h3>
						<p>${Detail.supply_voltage}</p>
					</div>
					<div>
						<h3><fmt:formatDate pattern="yy.MM" value="${Detail.use_start}"/>월 요금</h3>
						<p>${Detail.already_paid}</p>
						<p>${Detail.charge}</p>
					</div>
				</div>
				<div id="block_B">
					<h5>최근 사용요금</h5>
					<div class="">
						<div class="">
							<div>
								<p>10월 사용량</p>
								<p></p>
							</div>
							<div>
								<p>10월 요금</p>
								<p></p>
							</div>
						</div>
						<div class="">
							<div>
								<p>11월 사용량</p>
								<p></p>
							</div>
									
							<div>
								<p>11월 요금</p>
								<p></p>
							</div>
						</div>
						<div class="">
							<div>
								<p>12월 사용량</p>
								<p></p>
							</div>
							<div>
								<p>12월 요금</p>
								<p></p>
							</div>
						</div>
						<div>
							<p>3개월 평균요금: <!-- ${charge.charge / 3} --></p>
							<div><!-- 그래프 --></div>
						</div>
					</div>
				</div>
			</div>
			<div id="block_C">
				<div>
					<h3>상세보기</h3>
					<p>수전전압 : <c:out value="${Detail.supply_voltage}"/></p>
					<p>요금적용전력 : <c:out value="${Detail.billing_power}"/></p>
					<p>사용량 : <c:out value="${Detail.use_quentity}"/></p>
					<p>사용기간 : <fmt:formatDate pattern="yyyy-MM-dd" value="${Detail.use_start}"/>
							  ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${Detail.use_end}"/></p>
				</div>
				<div>
					<h3>역률</h3>
					<p>지상역률 : <c:out value="${Detail.power_factor}"/></p>
					<p>잔상역률: <c:out value="${Detail.rdpower_factor}"/></p>
				</div>
			</div>
		</div>
<jsp:include page="../inc/footer.jsp" />