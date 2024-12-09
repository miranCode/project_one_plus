$(document).ready(function(){
    let txt_info;
    let txt_info_area = document.getElementsByClassName("input-box");

    for(i = 0; i < txt_info_area.length; i++){
        txt_info = document.createElement("p");
        txt_info_area[i].parentElement.appendChild(txt_info);
        txt_info.classList.add("txt-info");
    }

    // 아이디
    let userid = document.getElementById("id");
    let id_check = document.getElementById("id_check");
    let regId = /^[a-zA-Z][0-9a-zA-Z]{7,16}$/; // 정규 표현식 변수
    let idResult;

    // 패스워드
    let userPassword = document.getElementById("pw");
    let regPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/; // 영문 숫자 특수기호 조합 8자리 이상
    let pwResult;

    // 패스워드 재확인
    let passNumCheck = document.getElementById("userpass-ok");
    let passcheckResult;

    // 이름
    let username = document.getElementById("uname");
    let regName = /^[가-힣]+$/; 
    let nameResult;

    // 생년월일
    let userBirth = document.getElementById("birth");
    let regBirth = /^([0-9]{4}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))$/;
    let birthResult;

    // 이메일
    let useremail = document.getElementById("email");
    let regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
    let emailResult;

    // 휴대전화번호
    let phonNum = document.getElementById("phone_num");
    let regPhonp = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
    let phonResult;

    // 각 인풋을 배열로 만든다.
    let joinArr = [userid, userPassword, passNumCheck, username, userBirth, useremail, phonNum];
    let joinResult = [idResult, pwResult, passcheckResult, nameResult, birthResult, emailResult, phonResult];
    
    // 각 인풋의 배열에 따라 blur의 값을 반환한다.
    for(i = 0; i < joinArr.length; i++) {
        joinArr[i].addEventListener("blur", function() {
            let txt_info = this.parentElement.querySelector('.txt-info');  // 해당 입력 필드 아래의 .txt-info 요소 찾기
            if(this.value.trim() === "") {
                txt_info.classList.remove("txt-red", "txt-green", "on");
                txt_info.innerHTML = `<i class='xi-info-o'></i><span> ${this.title}은/는 필수 입력 정보입니다.</span>`;
                txt_info.classList.add("txt-red", "on");
                joinResult[this] = false;
            }
        });
    }

    // 아이디 검증
    userid.addEventListener("input", function() {
        let txt_info = this.parentElement.querySelector('.txt-info');  // 해당 입력 필드 아래의 .txt-info 요소 찾기
        if(this.value.match(regId)) {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>해당 아이디는 중복 확인이 필요합니다.</span>`;
            txt_info.classList.add("txt-red", "on");
            id_check.disabled = false; 
            id_check.classList.add("on");
            idResult = true;
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-error-o'></i><span>해당 아이디는 사용이 불가능합니다.(특수문자 및 공백 사용불가)</span>`;
            txt_info.classList.add("txt-red", "on");
            id_check.classList.remove("on");
            id_check.disabled = true;
            idResult = false;
        }
    });

    // 중복 검사
    id_check.addEventListener("click", function() {
        let txt_info = this.parentElement.querySelector('.txt-info');  // 해당 입력 필드 아래의 .txt-info 요소 찾기
        alert("사용 가능한 아이디 입니다.");
        txt_info.classList.remove("txt-red", "txt-green", "on");
        txt_info.innerHTML = `<i class='xi-info-o'></i> <span>사용가능한 아이디 입니다.</span>`;
        txt_info.classList.add("txt-green", "on");
        idResult = true;
    });

    // 비밀번호 검증
    userPassword.addEventListener("input", function() {
        let txt_info = this.parentElement.querySelector('.txt-info');  // 해당 입력 필드 아래의 .txt-info 요소 찾기
        if(this.value.match(regPw)) {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            pwResult = true;
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>비밀번호는 영문 숫자 특수기호 조합 8자리 이상입니다.</span>`;
            txt_info.classList.add("txt-red", "on");
            pwResult = false;
        }
    });

    // 비밀번호 재검증
    passNumCheck.addEventListener("input", function() {
        let txt_info = this.parentElement.querySelector('.txt-info');  // 해당 입력 필드 아래의 .txt-info 요소 찾기
        if(this.value !== userPassword.value) {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>비밀번호가 일치하지 않습니다.</span>`;
            txt_info.classList.add("txt-red", "on");
            passcheckResult = false;
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            passcheckResult = true;
        }
    });

    // 이름
    username.addEventListener("input", function() {
        let txt_info = this.parentElement.querySelector('.txt-info');  // 해당 입력 필드 아래의 .txt-info 요소 찾기
        if(this.value.match(regName)) {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            nameResult = true;
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>이름은 한글만 사용가능합니다.</span>`;
            txt_info.classList.add("txt-red", "on");
            nameResult = false;
        }
    });

    // 생년월일
    userBirth.addEventListener("input", function() {
        let txt_info = this.parentElement.querySelector('.txt-info');  // 해당 입력 필드 아래의 .txt-info 요소 찾기
        if(this.value.match(regBirth)) {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            birthResult = true;
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>숫자만 입력 바랍니다.</span>`;
            txt_info.classList.add("txt-red", "on");
            birthResult = false;
        }
    });

    // 이메일 검증
    useremail.addEventListener("input", function() {
        let txt_info = this.parentElement.querySelector('.txt-info');  // 해당 입력 필드 아래의 .txt-info 요소 찾기
        if(this.value.match(regEmail)) {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            emailResult = true;
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>이메일 입력양식을 확인바랍니다. </span>`;
            txt_info.classList.add("txt-red", "on");
            emailResult = false;
        }
    });

    // 전화번호 검증
    phonNum.addEventListener("input", function() {
        let txt_info = this.parentElement.querySelector('.txt-info');  // 해당 입력 필드 아래의 .txt-info 요소 찾기
        if(this.value.match(regPhonp)) {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            phonResult = true;
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>전화번호를 확인바랍니다.</span>`;
            txt_info.classList.add("txt-red", "on");
            phonResult = false;
        }
    });
});
