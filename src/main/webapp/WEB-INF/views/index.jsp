<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "main"); 
%>
<jsp:include page="./inc/header.jsp" />

	<!-- #content ���� ���� -->
	<div id="content">  
		<!-- box  -->
		<div class="box">
			<p>
				�ȳ��ϼ���! (�α��ν�, ���̸� ���) ����
				<br />
				(�α��ν�, �ֽ� ���� �� ���) û�� ��� �ȳ��Դϴ�.
			</p>
			<div style="filter:blur(5px)">
				<dl>
					<dt>��� û�� ������</dt>
					<dd>00.00.00 - 00.00.00</dd>
				</dl>
				<dl>
					<dt>��� ��� ���·�</dt>
					<dd class="bar-area">
						<span class="stic" style="display:block; width:80%; height:15px; background:yellow; "></span>
						<span class="stic-txt" style="left:80%;  ">50w</span>
					</dd>
				</dl>
				<dl>
					<dt>û���� / û�� ���</dt>
					<dd>00.00.00 / 000.000 ��</dd>
				</dl>
				<dl>
					<dt>���α��� / ���ο���</dt>
					<dd>00.00.00 / �̳�</dd>
				</dl>
				<div class="btn-box">
					<a href="" class="btn btn-bagic line">�ڼ��� ����</a>
				</div>
			</div>
			<div class="blur">
				<p>�α����� �ʿ��մϴ�.</p>
				<div class="btn-box">
					<a href="/member/login" class="btn btn-bagic">�α���</a>
				</div>
			</div>
		</div>
		<!-- // box  -->
		<div class="">
			<p></p>
		</div>
	</div>
	<!-- #content ���� �� -->
<jsp:include page="./inc/footer.jsp" />
