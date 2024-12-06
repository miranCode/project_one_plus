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
		<div class="box section01">
			<p style="filter:${empty id ? 'blur(5px)' : 'none'};">
			
				�ȳ��ϼ���! ${uname} ����
				<br />
				(�α��ν�, �ֽ� ���� �� ���) û�� ��� �ȳ��Դϴ�.
			</p>
			<div style="filter:${empty id ? 'blur(5px)' : 'none'};">
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
			<c:if test="${ empty id }">
				<div class="blur">
					<p>�α����� �ʿ��մϴ�.</p>
					<div class="btn-box">
						<a href="/member/login" class="btn btn-bagic">�α���</a>
					</div>
				</div>
			</c:if>
		</div>
		<!-- // box  -->
		<div class="section02">
			<p>���� ���� ��Ȳ <span>(00.00.00 ����)</span></p>
			<ul class="flex">
				<li>
					<i class="xi-lightning txt-yellow"></i>
					<p>
						���޴ɷ�
						<span>103,751 MW</span>
					</p>
				</li>
				<li>
					<i class="xi-spinner-1 xi-spin txt-primary"></i>
					<p>
						�������
						<span>71,696 MW</span>
					</p>
				</li>
				<li>
					<i class="xi-network-server txt-green"></i>
					<p>
						���޿���
						<span>32,055 MW</span>
					</p>
				</li>
				<li>
					
					<i class="xi-percent"></i>
					<p>
						������
						<span>44.71%</span>
					</p>
				</li>
			</ul>
		</div>
	</div>
	<!-- #content ���� �� -->
<jsp:include page="./inc/footer.jsp" />
