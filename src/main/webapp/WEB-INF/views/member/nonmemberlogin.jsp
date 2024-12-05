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
                        <h3>비회원 조회</h3>
                        <!-- 비회원 조회 -->
                        <form action="..." method="post">
                            <div>
                                <div class="input-box">
                                    <input type="text" id="userName" placeholder="이름"  />
                                </div>
                            </div>
                            <div>
                                <div class="input-box">
                                    <input type="text" id="userPhone" placeholder="휴대폰 번호(- 없이 입력)" />
                                </div>
                            </div>
                            <div>
                                <div class="input-box">
                                    <input type="text" id="userEmail" placeholder="이메일" />
                                </div>
                            </div>
                            <div class="btn-box">
                                <button id="login_btn" type="button">조회</button>
                            </div>
                 
                            <div class="go_home flex ju-center">
                                <a href="./main.html">Home으로 돌아가기</a>
                            </div>
                        </form>
                    </div>  
                </div>
                <!-- #content 영역 끝 -->
<jsp:include page="../inc/footer.jsp" />
