<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "charge"); 
%>
<jsp:include page="../inc/header.jsp" />
		<div id="content">        
            <h3>ȸ������</h3>
			<div id="smartView">
				<h2>����Ʈ��</h2>
			</div>
			<div id="block_A">
				<div id="block_A_1">
					<h3><!-- �� �̸� -->AAA ��</h3>
					<p><!-- ��ݸ� -->AAA</p>
				</div>
				<div id="block_A_2">
					<h3><!-- ��� û����� -->12�� û�����</h3>
					<p><!-- ���ο��� -->���οϷ�</p>
					<div id="block_A_1_1">
						<p class="this_charge"><!-- ��� -->99900</p>
					</div>
				</div>
			</div>
			<div id="block_B">
				<div id="block_B_1">
					<div id="block_B_1_1">
						<h5>�ֱ� 3������ ��ݱ׷���</h5>
						<p>3���� ���</p>
						<div id="block_B_1_1_1"><!-- �׷��� --></div>
					</div>
				</div>
				<div id="block_B_2">
					<div id="block_B_2_1">
						<p>10�� ���</p>
						<p></p>
					</div>
					<div id="block_B_2_2">
						<p>11�� ���</p>
						<p></p>
					</div>
					<div id="block_B_2_3">
						<p>12�� ���</p>
						<p></p>
					</div>
					<div id="block_B_2_4">
						<p>10�� ��뷮</p>
						<p></p>
					</div>
					<div id="block_B_2_5">
						<p>11�� ��뷮</p>
						<p></p>
					</div>
					<div id="block_B_2_6">
						<p>12�� ��뷮</p>
						<p></p>
					</div>		
				</div>
			</div>
		</div>
<jsp:include page="../inc/footer.jsp" />