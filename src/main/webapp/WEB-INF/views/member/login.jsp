<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "member login"); 
%>
<jsp:include page="../inc/header.jsp" />
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.7.4/kakao.min.js"
  integrity="sha384-DKYJZ8NLiK8MN4/C5P2dtSmLQ4KwPaoqAfyA/DfmEc1VDxu4yyC7wy6K1Hs90nka" crossorigin="anonymous"></script>
<script>
  Kakao.init('33d350ee39f14c5305f7873eeffc074c'); // 사용하려는 앱의 JavaScript 키 입력
</script>
<script type="text/javascript" src="/resources/js/login.js"></script>
                <!-- #content 영역 시작 -->
                <div id="content">  
                    <div id="login">    
                        <h3>로그인</h3>
                        <form action="/member/login" method="post">
                            <div>
                                <label for="userId">아이디</label>
                                <div class="input-box">
                                    <input type="text" id="userId" name="id" placeholder="아이디를 입력해주세요."  />
                                </div>
                            </div>
                            <div>
                                <label for="userPass">비밀번호</label>
                                <div class="input-box">
                                    <input type="password" id="userPass" name="pass" placeholder="비밀번호를 입력해 주세요." />
                                </div>
                            </div>
                            <div class="btn-box">
                                <button id="login_btn" type="button">로그인</button>
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
                                        <a id="kakao-login-btn" href="javascript:loginWithKakao()" class="bg-kakao">
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
                                <button id="login_btn" type="button">비회원 조회</button>
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
