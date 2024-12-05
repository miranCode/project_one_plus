<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		로그인이다.
		<form action="login" method="post">
			<fieldset>
				<div>
					<label for="id">아이디</label>
					<div>
						<input type="text" name="id" id="id" />
					</div>
				</div>
				<div>
					<label for="password">비밀번호</label>
					<div>
						<input type="password" name="password" id="password" />
					</div>
				</div>
				<button type="submit">로그인</button>
			</fieldset>
		</form>
	</body>
</html>