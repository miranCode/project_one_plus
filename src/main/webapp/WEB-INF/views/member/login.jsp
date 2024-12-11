<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "member login"); 
%>
<jsp:include page="../inc/header.jsp" />
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.7.4/kakao.min.js"
  integrity="sha384-DKYJZ8NLiK8MN4/C5P2dtSmLQ4KwPaoqAfyA/DfmEc1VDxu4yyC7wy6K1Hs90nka" crossorigin="anonymous"></script>
<script type="text/javascript" src="/resources/js/login.js"></script>
<script>
//페이지가 로드되면 로그인 실패 메시지가 있는지 확인하고, 알림을 띄웁니다.
window.onload = function() {
    var loginError = '${loginError}';
    if (loginError) {
        alert(loginError); // "일치하는 정보가 없습니다"라는 메시지를 알림으로 표시
    }
};
function validCheck(form){
	if(!form.id.value){
		alert("아이디를 입력하세요");
		return false;
	}
	if(form.pw.value == ""){
		alert("비밀번호를 입력하세요");
		return false;
	}
};

$(document).ready(function(){
})
</script>
                <!-- #content 영역 시작 -->
                <div id="content">  
                    <div id="login">    
                        <h3>로그인</h3>
                        <form action="/member/login" method="post" onsubmit="return validCheck(this);">
                            <div>
                                <label for="id">아이디</label>
                                <div class="input-box">
                                    <input type="text" id="id" name="id" title="아이디" placeholder="아이디를 입력해주세요."  />
                                </div>
                            </div>
                            <div>
                                <label for="pw">비밀번호</label>
                                <div class="input-box">
                                    <button class="passview" type="button">
                                        <i class="xi-eye-off-o"></i>
                                    </button>
                                    <input type="password" id="pw" name="pw" value="" placeholder="비밀번호를 입력해주세요." title="비밀번호" autoComplete = "off" />
                                </div>
                            </div>
                            <div class="btn-box">
                                <button id="login_btn" type="submit">로그인</button>
                            </div>
                            <div class="checkbox-area flex ju-between al-center">
                                <div>
                                    <input type="checkbox" id="auto_login"  />
                                    <label for="auto_login">자동 로그인</label>
                                </div>
                                <ul class="flex">
                                    <li>
                                        <a href="/member/join">회원가입</a>
                                    </li>
                                    <li>
                                        <a onclick="findInfo('findId')">아이디 찾기</a>
                                    </li>
                                    <li>
                                        <a onclick="findInfo('findPw')">비밀번호 찾기</a>
                                    </li>
                                </ul>
                            </div>
                            
                            <div class="sns-area sns-login">
                                <p><span>SNS 간편 로그인</span></p>
                                <ul class="">
                                    <li>
                                        <a id="kakao-login-btn" href="https://kauth.kakao.com/oauth/authorize?client_id=558503d359c98d21606dc6d90c6795aa&redirect_uri=http://localhost:8080/auth/kakao/callback&response_type=code" class="bg-kakao">
                                            <div class="flex ju-between al-center">
                                                <div class="icon kakao">
                                                    <i class="xi-kakaotalk"></i>
                                                </div>
                                                <p>kakao Login</p>
                                                <i class="xi-angle-right"></i>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="/naver/login" target="_blank" class="bg-naver">
                                            <div class="flex ju-between al-center">
                                                <div class="icon naver">
                                                    <i class="xi-naver"></i>
                                                </div>
                                                <p>naver  Login</p>
                                                <i class="xi-angle-right"></i>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="/google/login" target="_blank" class="bg-google">
                                            <div class="flex ju-between al-center">
                                                <div class="icon google">
                                                    <i class="xi-google"></i>
                                                </div>
                                                <p>google  Login</p>
                                                <i class="xi-angle-right"></i>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="sns-area sns-login">
                            <p><span>비회원 조회</span></p>
                            <div class="btn-box">
                                <button id="login_btn" type="button" onclick="location.href='/member/nonmemberlogin'">비회원 조회</button>
                            </div>
                            </div>
                            <div class="go_home flex ju-center">
                                <a href="/">Home으로 돌아가기</a>
                            </div>
                        </form>
                    </div>  
                </div>
                <!-- #content 영역 끝 -->
<jsp:include page="../inc/footer.jsp" />
