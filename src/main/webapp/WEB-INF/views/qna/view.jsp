<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "view"); 
%>
<jsp:include page="../inc/header.jsp" />
	<dl>
        <dt>
            <p><c:out value="${ board.title }"/></p><!-- 제목 -->
            <ul class="flex">
                <li><span>작성자</span> <c:out value="${board.name }"/></li>
                <li><span>작성일</span> 00.00.00</li>
                <li><span>조회수</span> 00</li>
            </ul>
        </dt>
        <dd>
            ${board.content }
        </dd>
    </dl>
    <div class="flex">
        <div class="prev">
            <a href="">
                <span>이전글</span>
                <p class="ell">제목</p>
            </a>
        </div>
        <div class="next">
            <a href="">
                <p class="ell">제목</p>
                <span>다음글</span>
            </a>
        </div>
    </div>
    <div class="btn-area two">
        <button onclick="openModal('<c:out value="${ board.idx }"/>')" class="red-line">수정</button>
        <a href="/qna/List" class="line">목록</a>
    </div>
    <div id="passwordModal" style="display: none;">
    <div class="modal-content">
        <h3>비밀번호를 입력하세요</h3>
        <input type="password" id="pass" placeholder="비밀번호 입력" />
        <button onclick="submitPassword()">확인</button>
        <button onclick="closeModal()">취소</button>
    </div>
</div>
<script>
    // 모달 열기
    function openModal() {
        document.getElementById('passwordModal').style.display = 'block';
    }

    // 모달 닫기
    function closeModal() {
        document.getElementById('passwordModal').style.display = 'none';
    }

    // 비밀번호 제출
    function submitPassword() {
        const password = document.getElementById('pass').value;

        if (!password) {
            alert('비밀번호를 입력하세요.');
            return;
        }

        // 비밀번호를 서버로 전송
        fetch('/qna/verifyPassword', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                idx: '<c:out value="${ board.idx }"/>',
                password: password,
            }),
        })
        .then((response) => response.json())
        .then((data) => {
            if (data.success) {
                // 비밀번호가 맞으면 수정 페이지로 이동
                location.href = `/qna/modify?idx=${board.idx}`;
            } else {
                alert('비밀번호가 틀렸습니다.');
            }
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }
</script>
<jsp:include page="../inc/footer.jsp" />