<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "member join"); 
%>
<jsp:include page="../inc/header.jsp" />
<script type="text/javascript" src="/resources/js/join.js"></script>
                <!-- #content 영역 시작 -->
                <div id="content">        
                    <h3>회원가입</h3>
                    <div class="form-box">
                        <form action="/member/join" method="post" onsubmit="return validCheck(this);">
                            <div>
                                <label for="id">아이디</label>
                                <div class="input-box">
                                    <input type="text" id="id" name="id" maxlength="16" placeholder="아이디를 입력해주세요." title="아이디" />
                                    <button type="button" id="id_check" class="check_btn">
                                    	중복확인
                                    </button>
                                </div>
                            </div>
                            <div>
                                <label for="pw">비밀번호</label>
                                <div class="input-box">
                                    <button class="passview" type="button">
                                        <i class="xi-eye-off-o"></i>
                                    </button>
                                    <input type="password" id="pw" name="pw" placeholder="비밀번호를 입력해주세요." title="비밀번호" autoComplete = "off" />
                                </div>
                            </div>
                            <div>
                                <label for="userpass-ok">비밀번호 확인</label>
                                <div class="input-box">
                                    <button class="passview" type="button">
                                        <i class="xi-eye-off-o"></i>
                                    </button>
                                    <input type="password" id="userpass-ok" name="userpass-ok"  placeholder="비밀번호를 재입력해주세요." title="비밀번호 확인" autoComplete = "off" />
                                </div>
                            </div>
                            <div>
                                <label for="uname">이름</label>
                                <div class="input-box">
                                    <input type="text" id="uname" name="uname" placeholder="이름을 입력해주세요." title="이름" />
                                </div>
                            </div>
                            <div class="birth">
                                <label for="userbirthday">생년월일</label>
                                <div class="input-box"> 
                                    <input type="text" id="birth" name="birth" placeholder="yyyyMMdd" title="생년월일" />
                                </div>
                            </div>
                            <div>
                                <label for="email">이메일</label>
                                <div class="input-box"> 
                                    <input type="text" id="email" name="email" placeholder="ex) aaa@aaa.com" title="이메일" />
                                </div>
                            </div>
                            <div>
                                <label for="phone_num">휴대전화번호</label>
                                <div class="input-box"> 
                                    <input type="text" id="phone_num" name="phone_num" placeholder="01000000000"  title="휴대전화번호" />
                                    <!-- <button type="button" id="usernumber_check" class="check_btn">인증요청</button> -->
                                </div>
                            </div>
                            <!--  
	                            <div>
	                                <label for="userIn">인증번호</label>
	                                <div class="input-box">
	                                    <input type="text" id="userIn" name="userIn" value="" maxlength="16" placeholder="인증번호를 입력해주세요." title="인증번호" />
	                                    <span class="time_count">03:00</span>
	                                    <button type="button" id="usernumber_check" class="check_btn">인증확인</button>
	                                </div>
	                            </div>
                           -->
                            <div class="agreed-box">
                                <div class="check-box all">
                                    <input type="checkbox" id="agreed_all" />
                                    <label for="agreed_all">전체동의</label>
                                </div>
                                <div class="radio-box">
                                    <p><span>(필수)</span> 개인정보 수집 및 이용에 동의하십니까?</p>
                                    <ul class="flex">
                                        <li>
                                            <input type="radio" id="ag_privercy_01" name="ag_privercy" value="동의함" />
                                            <label for="ag_privercy_01">동의합니다.</label>
                                        </li>
                                        <li>
                                            <input type="radio" id="ag_privercy_02" name="ag_privercy" value="동의하지않음" />
                                            <label for="ag_privercy_02">동의하지 않습니다.</label>
                                        </li>
                                    </ul>
                                </div>
                                <div class="radio-box">
                                    <p><span>(필수)</span> 광고수신 및 개인정보 활용에 동의하십니까?</p>
                                    <ul class="flex">
                                        <li>
                                            <input type="radio" id="ag_sevise_01" name="ag_sevise" value="동의함" />
                                            <label for="ag_sevise_01">동의합니다.</label>
                                        </li>
                                        <li>
                                            <input type="radio" id="ag_sevise_02" name="ag_sevise" value="동의하지않음" />
                                            <label for="ag_sevise_02">동의하지 않습니다.</label>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="btn-box">
                                <button id="join_btn" type="submit">회원가입</button>
                            </div>
                            <div class="go_home flex ju-center">
                                <a href="/">Home으로 돌아가기</a>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- #content 영역 끝 -->
<jsp:include page="../inc/footer.jsp" />
