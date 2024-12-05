<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "member join"); 
%>
<jsp:include page="../inc/header.jsp" />
                <!-- #content ���� ���� -->
                <div id="content">        
                    <h3>ȸ������</h3>
                    <div class="form-box">
                        <form name="form1" onsubmit="return validCheck()">
                            <div>
                                <label for="userid">���̵�</label>
                                <div class="input-box">
                                    <input type="text" id="userid" name="userid" value="" maxlength="16" placeholder="���̵� �Է����ּ���." title="���̵�" />
                                    <button type="button" id="id_check" class="check_btn">�ߺ�Ȯ��</button>
                                </div>
                            </div>
                            <div>
                                <label for="userpass">��й�ȣ</label>
                                <div class="input-box">
                                    <button class="passview" type="button">
                                        <i class="xi-eye-off-o"></i>
                                    </button>
                                    <input type="password" id="userpass" name="userpass" value="" placeholder="��й�ȣ�� �Է����ּ���." title="��й�ȣ" autoComplete = "off" />
                                </div>
                            </div>
                            <div>
                                <label for="userpass-ok">��й�ȣ Ȯ��</label>
                                <div class="input-box">
                                    <button class="passview" type="button">
                                        <i class="xi-eye-off-o"></i>
                                    </button>
                                    <input type="password" id="userpass-ok" name="userpass-ok" value="" placeholder="��й�ȣ�� ���Է����ּ���." title="��й�ȣ Ȯ��" autoComplete = "off" />
                                </div>
                            </div>
                            <div>
                                <label for="username">�̸�</label>
                                <div class="input-box">
                                    <input type="text" id="username" name="username" value="" placeholder="�̸��� �Է����ּ���." title="�̸�" />
                                </div>
                            </div>
                            <div class="birthday">
                                <label for="userbirthday">�������</label>
                                <div class="input-box"> 
                                    <input type="text" id="userbirthday" name="userbirthday" value="" placeholder="yymmdd" title="�������" />
                                </div>
                            </div>
                            <div>
                                <label for="usermail">�̸���</label>
                                <div class="input-box"> 
                                    <input type="text" id="usermail" name="usermail" value="" placeholder="" title="�̸���" />
                                </div>
                            </div>
                            <div>
                                <label for="usernumber">�޴���ȭ��ȣ</label>
                                <div class="input-box"> 
                                    <input type="text" id="usernumber" name="usernumber" value="" placeholder="01000000000"  title="�޴���ȭ��ȣ" />
                                    <button type="button" id="usernumber_check" class="check_btn">������û</button>
                                </div>
                            </div>
                            <div>
                                <label for="userIn">������ȣ</label>
                                <div class="input-box">
                                    <input type="text" id="userIn" name="userIn" value="" maxlength="16" placeholder="������ȣ�� �Է����ּ���." title="������ȣ" />
                                    <span class="time_count">03:00</span>
                                    <button type="button" id="usernumber_check" class="check_btn">����Ȯ��</button>
                                </div>
                            </div>
                            <div class="agreed-box">
                                <div class="check-box all">
                                    <input type="checkbox" id="agreed_all" value="" />
                                    <label for="agreed_all">��ü����</label>
                                </div>
                                <div class="radio-box">
                                    <p><span>(�ʼ�)</span> �������� ���� �� �̿뿡 �����Ͻʴϱ�?</p>
                                    <ul class="flex">
                                        <li>
                                            <input type="radio" id="ag_privercy_01" name="ag_privercy" value="" />
                                            <label for="ag_privercy_01">�����մϴ�.</label>
                                        </li>
                                        <li>
                                            <input type="radio" id="ag_privercy_02" name="ag_privercy" value="" />
                                            <label for="ag_privercy_02">�������� �ʽ��ϴ�.</label>
                                        </li>
                                    </ul>
                                </div>
                                <div class="radio-box">
                                    <p><span>(�ʼ�)</span> ������� �� �������� Ȱ�뿡 �����Ͻʴϱ�?</p>
                                    <ul class="flex">
                                        <li>
                                            <input type="radio" id="ag_sevise_01" name="ag_sevise" value="" />
                                            <label for="ag_sevise_01">�����մϴ�.</label>
                                        </li>
                                        <li>
                                            <input type="radio" id="ag_sevise_02" name="ag_sevise" value="" />
                                            <label for="ag_sevise_02">�������� �ʽ��ϴ�.</label>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="btn-box">
                                <button id="join_btn" type="button" onclick="validCheck()">ȸ������</button>
                            </div>
                            <div class="go_home flex ju-center">
                                <a href="./main.html">Home���� ���ư���</a>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- #content ���� �� -->
<jsp:include page="../inc/footer.jsp" />
