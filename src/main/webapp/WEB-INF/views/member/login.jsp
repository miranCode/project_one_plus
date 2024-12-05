<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "member login"); 
%>
<jsp:include page="../inc/header.jsp" />
                <!-- #content ���� ���� -->
                <div id="content">  
                    <div id="login">    
                        <h3>�α���</h3>
                        <form action="..." method="post">
                            <div>
                                <label for="userId">���̵�</label>
                                <div class="input-box">
                                    <input type="text" id="userId" placeholder="���̵� �Է����ּ���."  />
                                </div>
                            </div>
                            <div>
                                <label for="userPass">��й�ȣ</label>
                                <div class="input-box">
                                    <input type="password" id="userPass" placeholder="��й�ȣ�� �Է��� �ּ���." />
                                </div>
                            </div>
                            <div class="btn-box">
                                <button id="login_btn" type="button">�α���</button>
                            </div>
                            <div class="checkbox-area flex ju-between al-center">
                                <div>
                                    <input type="checkbox" id="auto_login"  />
                                    <label for="auto_login">�ڵ� �α���</label>
                                </div>
                                <ul class="flex">
                                    <li>
                                        <a href="./join.html">ȸ������</a>
                                    </li>
                                    <li>
                                        <a onclick="findInfo('findId')">���̵� ã��</a>
                                    </li>
                                    <li>
                                        <a onclick="findInfo('findPw')">��й�ȣ ã��</a>
                                    </li>
                                </ul>
                            </div>
                            
                            <div class="sns-area sns-login">
                                <p><span>SNS ���� �α���</span></p>
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
                                <a href="./main.html">Home���� ���ư���</a>
                            </div>
                        </form>
                    </div>  
                </div>
                <!-- #content ���� �� -->
<jsp:include page="../inc/footer.jsp" />
