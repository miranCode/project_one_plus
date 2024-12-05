<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ex02Bean
	<a href="/sample/ex02Bean?list%5B0%5D.name=aaa&list%5B2%5D.name=ddd">값</a>
	
	<p>대괄호 인코딩(URL 인코딩)</p>
	<ul>
		<li>[ (왼쪽 대괄호)는 %5B로 인코딩됩니다.</li>
		<li>] (오른쪽 대괄호)는 %5D로 인코딩됩니다.</li>
	</ul>
	
	
</body>
</html>