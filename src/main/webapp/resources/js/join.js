let idResult;
let pwResult;
let passcheckResult;
let nameResult;
let birthResult;
let emailResult;
let phonResult;
let agreed01Result;
let agreed02Result;

$(document).ready(function(){
    let txt_info;
    let txt_info_area = document.getElementsByClassName("input-box");
    
    // 각 input에 맞는 txt-info p 요소를 생성한다.
    for(i = 0; i < txt_info_area.length; i++){
        txt_info = document.createElement("p");
        txt_info_area[i].parentElement.appendChild(txt_info);
        txt_info.classList.add("txt-info");
    };
    
    // 아이디 
    let userid = document.getElementById("id");
    let id_check = document.getElementById("id_check");
    let regId = /^[a-zA-Z][0-9a-zA-Z]{7,16}$/;
    
    let idCheckResult;

    // 패스워드
    let userPassword = document.getElementById("pw");
    let regPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;


    // 비밀번호 확인
    let passNumCheck = document.getElementById("userpass-ok");
 

    // 이름
    let username = document.getElementById("uname");
    let regName = /^[가-힣]+$/; 
    

    // 생년월일 
    let userBirth = document.getElementById("birth");
    let regBirth = /^([0-9]{4}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))$/;
    
    
    // 이메일
    let useremail = document.getElementById("email");
    let regEmail = /^[0-9a-zA-Z]*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
    

    // 휴대전화번호
    let phonNum = document.getElementById("phone_num");
    let regPhonp = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
    
    // 아이디 검증
    userid.addEventListener("input", function() {
        txt_info = this.parentElement.parentElement.lastElementChild;
        if(this.value.match(regId)) {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>해당 아이디는 중복 확인이 필요합니다.</span>`;
            txt_info.classList.add("txt-red", "on");
            id_check.disabled = false;
            id_check.classList.add("on");
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-error-o'></i><span>아이디는 영문자로 시작하고 8자 이상이어야 합니다.</span>`;
            txt_info.classList.add("txt-red", "on");

            id_check.classList.remove("on");
            id_check.disabled = true;
        }
        idResult = false;
    });
    id_check.addEventListener("click", function() {
    	let id = document.getElementById("id").value.trim();  // 입력된 아이디 값
    	txt_info = userid.parentElement.parentElement.lastElementChild;
    	// Ajax로 전송
        $.ajax({
            url: '/member/idCheck',  // 요청 URL
            data: {
                id: id  // 보내는 데이터
            },
            type: 'POST',
            dataType: 'json',  // 예상되는 응답 형식
            success: function(result) {
                // 응답 결과 로그 확인
                console.log('서버 응답:', result);
                
                // 아이디가 사용 가능할 경우
                if (result) {
                    alert("사용 가능한 아이디입니다.");
                    txt_info.classList.remove("txt-red", "txt-green", "on");
                    txt_info.innerHTML = `<i class='xi-info-o'></i><span>해당 아이디는 사용 가능한 아이디입니다.</span>`;
                    txt_info.classList.add("txt-green", "on");
                    idResult = true;  // 아이디가 사용 가능
                    id_check.disabled = false;
                    id_check.classList.remove("on");
                } else {
                    // 아이디가 중복된 경우
                    alert("중복된 아이디입니다.");
                    txt_info.classList.remove("txt-red", "txt-green", "on");
                    txt_info.innerHTML = `<i class='xi-info-o'></i><span>해당 아이디는 사용 불가합니다.</span>`;
                    txt_info.classList.add("txt-red", "on");
                    idResult = false;  // 아이디가 중복
                }
            },
            error: function(xhr, status, error) {
                // Ajax 요청 중 에러 발생 시
                console.error("Error:", error);
                alert("아이디 중복 확인 중 오류가 발생했습니다.");
            }
        });
        
    });

    // 비밀번호 검증
    userPassword.addEventListener("input", function() {
        txt_info = this.parentElement.parentElement.lastElementChild;
        if(this.value.match(regPw)){
            txt_info.classList.remove("txt-red", "txt-green", "on");
            pwResult = true;
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>비밀번호는 영문, 숫자, 특수기호 조합 8자리 이상이어야 합니다.</span>`;
            txt_info.classList.add("txt-red", "on");
            pwResult = false;
        }
    });

    // 비밀번호 재확인
    passNumCheck.addEventListener("input", function(){
        txt_info = this.parentElement.parentElement.lastElementChild;
        if(this.value !== userPassword.value){
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>비밀번호가 일치하지 않습니다.</span>`;
            txt_info.classList.add("txt-red", "on");
            passcheckResult = false;
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            passcheckResult = true;
        }
    });
    
    // 비밀번호 노출 
    let passview = document.getElementsByClassName("passview"); 
    console.log(passview);
    for(i=0; i < passview.length; i++){

    }
    // passview를 배열로 변환한 후, 각 요소를 순회한다. (확인 필요)
    Array.from(passview).forEach(function(element) {
        let passclick = 0;
        element.addEventListener("click", function() {
            // 클릭한 수를 세어줍니다.
            passclick++;
            // 클릭된 passview 요소의 다음 형제 요소를 가져옵니다.
            let passType = this.nextElementSibling;
            // 클릭된 passview 요소 첫번째 자식을 가져옵니다. 
            let passicon = this.children[0];
            if(passclick % 2 == 0){
                passType.type = "password";
                passicon.classList.remove("xi-eye-o", "xi-eye-off-o", "txt-primary");
                passicon.classList.add("xi-eye-off-o");
            }else{
                passType.type = "text";
                passicon.classList.remove("xi-eye-o", "xi-eye-off-o", "txt-primary");
                passicon.classList.add("xi-eye-o", "txt-primary");
            }
        });
    });

    // 이름 검증
    username.addEventListener("input", function() {
        txt_info = this.parentElement.parentElement.lastElementChild;
        if(this.value.match(regName)){
            txt_info.classList.remove("txt-red", "txt-green", "on");
            nameResult = true;
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>이름은 한글만 사용 가능합니다.</span>`;
            txt_info.classList.add("txt-red", "on");
            nameResult = false;
        }
    });
    
    // 생년월일 
    userBirth.addEventListener("input", function() {
    	 txt_info = this.parentElement.parentElement.lastElementChild;
    	 if(this.value.match(regBirth)){
    		 txt_info.classList.remove("txt-red", "txt-green", "on");
    		 birthResult = true;
    	 }else {
             txt_info.classList.remove("txt-red", "txt-green", "on");
             txt_info.innerHTML = `<i class='xi-info-o'></i><span>생년월일을 형식에 맞게 입력바랍니다. 예시 yyyymmdd</span>`;
             txt_info.classList.add("txt-red", "on");
             birthResult = false;
         }
    });

    // 이메일 검증
    useremail.addEventListener("input", function() {
        txt_info = this.parentElement.parentElement.lastElementChild;
        if(this.value.match(regEmail)){
            txt_info.classList.remove("txt-red", "txt-green", "on");
            emailResult = true;
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>이메일 입력양식을 확인 바랍니다.</span>`;
            txt_info.classList.add("txt-red", "on");
            emailResult = false;
        }
    });

    // 전화번호 검증
    phonNum.addEventListener("input", function() {
        txt_info = this.parentElement.parentElement.lastElementChild;
        if(this.value.match(regPhonp)){
            txt_info.classList.remove("txt-red", "txt-green", "on");
            phonResult = true;
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on");
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>전화번호 형식을 확인 바랍니다.</span>`;
            txt_info.classList.add("txt-red", "on");
            phonResult = false;
        }
    });

    // 전체 동의 체크
    let agreedAll = document.getElementById("agreed_all");
    let agreed01 = document.getElementsByName("ag_privercy");
    let agreed02 = document.getElementsByName("ag_sevise");

    agreedAll.addEventListener("change", function() {
        if(this.checked === true){
            agreed01[0].checked = true;
            agreed02[0].checked = true;
            agreed01Result = true;
            agreed02Result = true;
        } else {
            agreed01[0].checked = false;
            agreed02[0].checked = false;
            agreed01Result = false;
            agreed02Result = false;
        }                    
    });
    
    
    // 각 인풋에 대한 검증 상태
    let joinArr = [userid, userPassword, passNumCheck, username, userBirth, useremail, phonNum];
    let joinResult = [idResult, pwResult, passcheckResult, nameResult, birthResult, emailResult, phonResult];

    // 인풋 필드에 focus가 벗어날 때 처리
    for(i = 0; i < joinArr.length; i++){
        joinArr[i].addEventListener("blur", function(){
            txt_info = this.parentElement.parentElement.lastElementChild;
            if(this.value.trim() === ""){
                txt_info.classList.remove("txt-red", "txt-green", "on");
                txt_info.innerHTML = `<i class='xi-info-o'></i><span> ${this.title}은/는 필수 입력 정보입니다.</span>`;
                txt_info.classList.add("txt-red", "on");
                joinResult[this] = false;
            }
        });
    }
    
});
