<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용량 조회</title>
</head>
<body>
	<jsp:include page="../inc/header.jsp" />
	<jsp:include page="../inc/gnb.jsp" />
	<div id="wrap">
		<div id="smartView">
			<h2>스마트뷰</h2>
			<div>
				<a href=""></a>
				<a href=""></a>
				<a href=""></a>
			</div>
		</div>
		<div>
			<div>당월 실시간 요금</div>
			<div>
				<p>실시간 사용량</p>
				<p></p>
			</div>
			<div>
				<p>예상 사용량</p>
				<p></p>
			</div>
			<div>
				<p>실시간 요금</p>
				<p></p>
			</div>
			<div>
				<p>예상 요금</p>
				<p></p>
			</div>
		</div>
		<div>
			<div>당월 실시간 요금 적용 기준</div>
			<table>
				<tr>
					<td>적용전기요금</td>
					<td>기본요금단가</td>
					<td>기본요금</td>
					<td>요금적용전력</td>
					<td>최대수요전력</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			<button type="button">예상 요금내역 보기</button>
		</div>
		<div>
			<!-- 시간대별 구분(그래프) -->
		</div>
		<div>
			<table>
				<tr>
					<th rowspan="2">기본요금(원/kW)</th>
					<td rowspan="3"></td>
				</tr>
				<tr>
					<th colspan="4">전력량요금(원/kWh)</th>
					<th>시간대</th>
					<th>경부하</th>
					<th>중간부하</th>
					<th>최대부하</th>
				</tr>
				<tr>
					<th>여름철(6~8월)<th>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>봄 가을철(3~5,9~10월)</th>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>겨울철(11~2월)</th>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
	</div>
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>