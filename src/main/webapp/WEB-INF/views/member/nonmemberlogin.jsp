<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    request.setAttribute("bodyClass", "member login"); 
%>
<jsp:include page="../inc/header.jsp" />
<script type="text/javascript" src="/resources/js/nomember.js"></script>
<script>
//페이지가 로드되면 로그인 실패 메시지가 있는지 확인하고, 알림을 띄웁니다.
window.onload = function() {
    var loginError = '${loginError}';
    if (loginError) {
        alert(loginError); // "일치하는 정보가 없습니다"라는 메시지를 알림으로 표시
    }
};
function validCheck(form){
	if(!form.uname.value){
		alert("이름을 입력하세요");
		return false;
	}else if(nameResult === false){
    	alert("이름을 확인해주세요");
    	form.uname.focus();
        return false;
    }
	
	if(form.phone_num.value == ""){
		alert("전화번호를 입력하세요");
		return false;
	}else if(phonResult === false){
    	alert("전화번호를 확인해주세요");
    	form.phone_num.focus();
        return false;
    }
	
	if(form.email.value == ""){
		alert("이메일을 입력하세요");
		return false;
	}else if(emailResult === false){
    	alert("이메일을 확인해주세요");
    	form.email.focus();
        return false;
    }
	return true;
};

$(document).ready(function(){
})
</script>
                <!-- #content 영역 시작 -->
                <div id="content">  
                    <div id="login">    
                        <h3>비회원 조회</h3>
                        <!-- 비회원 조회 -->
                        <form action="/member/nonmemberlogin" method="post"  onsubmit="return validCheck(this);">
                            <div>
                                <div class="input-box">
                                    <input type="text" id="uname" name="uname" title="이름"  placeholder="이름"  />
                                </div>
                            </div>
                            <div>
                                <div class="input-box">
                                    <input type="text" id="phone_num" name="phone_num" title="휴대폰" placeholder="휴대폰 번호(010-0000-0000)" />
                                </div>
                            </div>
                            <div>
                                <div class="input-box">
                                    <input type="text" id="email" name="email" placeholder="이메일" title="이메일" />
                                </div>
                            </div>
                            <div class="btn-box">
                                <button id="login_btn" type="submit">조회</button>
                            </div>
                 
                            <div class="go_home flex ju-center">
                                <a href="/">Home으로 돌아가기</a>
                            </div>
                        </form>
                    </div>  
                </div>
                <!-- #content 영역 끝 -->
<jsp:include page="../inc/footer.jsp" />
