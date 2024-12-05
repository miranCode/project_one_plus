<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "member login"); 
%>
<jsp:include page="../inc/header.jsp" />
                <!-- #content 영역 시작 -->
                <div id="content">  
                    <div id="login">    
                        <h3>로그인</h3>
                        <form action="..." method="post">
                            <div>
                                <label for="userId">아이디</label>
                                <div class="input-box">
                                    <input type="text" id="userId" placeholder="아이디를 입력해주세요."  />
                                </div>
                            </div>
                            <div>
                                <label for="userPass">비밀번호</label>
                                <div class="input-box">
                                    <input type="password" id="userPass" placeholder="비밀번호를 입력해 주세요." />
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
                                        <a href="./join.html">회원가입</a>
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
                                        <a href="" target="_blank" class="bg-kakao">
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
                                        <a href="" target="_blank" class="bg-naver">
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
                                        <a href="" target="_blank" class="bg-facebook">
                                            <div class="flex ju-between al-center">
                                                <div class="icon facebook">
                                                    <i class="xi-facebook"></i>
                                                </div>
                                                <p>facebook  Login</p>
                                                <i class="xi-angle-right"></i>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="go_home flex ju-center">
                                <a href="./main.html">Home으로 돌아가기</a>
                            </div>
                        </form>
                    </div>  
                </div>
                <!-- #content 영역 끝 -->
<jsp:include page="../inc/footer.jsp" />
