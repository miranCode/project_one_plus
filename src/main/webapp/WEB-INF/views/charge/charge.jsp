<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% 
    request.setAttribute("bodyClass", "charge"); 
%>
<jsp:include page="../inc/header.jsp" />
		<div id="content" class="view">        
			<div class="box">
				<p>
					<span>${TMCharge.uname} 님</span> 
					<fmt:formatDate pattern="yy년 MM월" value="${TMCharge.use_start}"/> 이용요금 안내입니다.
				</p>
				<div class="tit-area">
      				<p class="">
      					<span class="txt bold"><fmt:formatNumber value="${TMCharge.charge}" type="number" pattern="#,##0"/></span>
      					<span>원</span>
      				</p>
      				<p>
      					사용 기간 : <fmt:formatDate pattern="yy.MM.dd" value="${TMCharge.use_start}"/> ~ <fmt:formatDate pattern="yy.MM.dd" value="${TMCharge.use_end}"/>
      				</p>
    			</div>
    			<div class="bill-area">
    				<div class="bg-gray">
    					<dl class="flex ju-between">
    						<dt>수전전압</dt>
    						<dd>${TMCharge.supply_voltage}</dd>
    					</dl>
    					<dl class="flex ju-between">
    						<dt>요금적용전력</dt>
    						<dd>${TMCharge.billing_power} kWh</dd>
    					</dl>
    					<dl class="flex ju-between">
    						<dt>사용량</dt>
    						<dd>${TMCharge.use_quentity} kWh</dd>
    					</dl>
    					<div style="background: #fff; border: 1px solid transparent;">
							<span class="stic" style="display:block;  border-right: 1px solid transparent; width:${TMCharge.use_quentity/(TMCharge.billing_power/100)}%; height:5px; background: rgb(73, 73, 238)">
							</span>
						</div>
    					<dl class="flex ju-between">
    						<dt>지상역률</dt>
    						<dd>${TMCharge.power_factor} %</dd>
    					</dl>
    					<dl class="flex ju-between">
    						<dt>잔상역률</dt>
    						<dd>${TMCharge.rdpower_factor} %</dd>
    					</dl>
    				</div>
    			</div>
    			<div class="chart">
    				<p class="txt bold sub">최근 3개월 이용내역</p>
					<p class="avg">3개월 평균 요금 : <fmt:formatNumber value="${avgCharge}" type="number" pattern="#,##0"/> 원</p>
					<div class="flex ju-between">
						<c:forEach var="charge" items="${pastCharges}">
		       				<div>
				            	<div class="bar" style="background:#f5f5f5; width:5px; height:100%; position:relative; margin:0 auto;">
				            		<span class="stic" style="position:absolute; bottom:0; left:0; display:block; border-right: 1px solid transparent; width:5px; height:${charge.use_quentity/(charge.billing_power/100)}%; background: rgb(73, 73, 238)">
			                		</span>
				           		</div>
				            	<div>
				                	<p>
				                		<span class="txt bold small" style="margin-top:5px"><fmt:formatDate pattern="yy년 MM월" value="${charge.use_start}"/></span>
				                		<span class="price"><fmt:formatNumber value="${charge.charge}" type="number" pattern="#,##0"/></span>
				                	</p>
				           		</div>
			           		</div>
		        		</c:forEach>
					</div>
				</div>
			</div>
		</div>
<jsp:include page="../inc/footer.jsp" />