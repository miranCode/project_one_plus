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
						<h3>${TMCharge.uname} 님</h3>
						<p>${TMCharge.supply_voltage}</p>
					</div>
					<div>
						<h3><fmt:formatDate pattern="yy.MM" value="${TMCharge.use_start}"/>월 요금</h3>
						<p>${TMCharge.already_paid}</p>
						<p class="txt sub bolder">${TMCharge.charge} 원</p>
					</div>
				</div>
				<div id="block_B">
	       			<c:forEach var="charge" items="${pastCharges}">
	       				<div>
			            	<div>
			                	<p><fmt:formatDate pattern="yy.MM" value="${charge.use_start}"/>월 사용량 : ${charge.use_quentity}</p>
			           		</div>
			            	<div>
			                	<p><fmt:formatDate pattern="yy.MM" value="${charge.use_start}"/>월 요금 : ${charge.charge} 원</p>
			           		</div>
		           		</div>
	        		</c:forEach>
	        		<div>
	            		<p>3개월 평균요금 : ${avgCharge} 원</p>
	        		</div>
	    		</div>
			</div>
			<div id="block_C">
				<div>
					<h3>상세보기</h3>
					<p>수전전압 : <c:out value="${TMCharge.supply_voltage}"/></p>
					<p>요금적용전력 : <c:out value="${TMCharge.billing_power}"/></p>
					<p>사용량 : <c:out value="${TMCharge.use_quentity}"/></p>
					<p>사용기간 : <fmt:formatDate pattern="yyyy-MM-dd" value="${TMCharge.use_start}"/>
							  ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${TMCharge.use_end}"/>
					</p>
				</div>
				<div>
					<h3>역률</h3>
					<p>지상역률 : <c:out value="${TMCharge.power_factor}"/></p>
					<p>잔상역률: <c:out value="${TMCharge.rdpower_factor}"/></p>
				</div>
			</div>
		</div>
<jsp:include page="../inc/footer.jsp" />