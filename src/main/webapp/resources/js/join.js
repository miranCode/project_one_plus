$(document).ready(function(){

	let txt_info;
    txt_info_area = document.getElementsByClassName("input-box");
    for(i = 0; i < txt_info_area.length; i++){
        txt_info = document.createElement("p");
        txt_info_area[i].parentElement.appendChild(txt_info);
        txt_info.classList.add("txt-info");
    };
    
    // 아이디 
    let userid = document.getElementById("userid");
    let id_check = document.getElementById("id_check");
    let regId = /^[a-zA-Z][0-9a-zA-Z]{8,16}$/; // 정규 표현식 변수
    let idResult;

    // 패스워드
    let userPassword = document.getElementById("userpass");
    let regPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/; // 영문 숫자 특수기호 조합 8자리 이상
    let pwResult;

    // 패스워드재확인
    let passNumCheck = document.getElementById("userpass-ok");
    let passcheckResult;

    // 이름
    // 한글만
    // 최소 2글자 이상 
    let username = document.getElementById("username");
    let regName = /^[가-힣]+$/ ; 
    let nameResult;

    // 생년월일 
    let userBirth = document.getElementById("userbirthday")
    let regBirth = /^([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))$/;
    let birthResult;
    
    // 이메일
    // @
    // .
    let useremail = document.getElementById("usermail");
    let regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/; // 정규 표현식 변수
    let emailResult;
    
    // 휴대전화번호
    // 숫자만 (특수 문자 제거 + 공백 제거) 
    let phonNum = document.getElementById("usernumber");
    let usernumber_check = document.getElementById("usernumber_check");
    let regPhonp = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/; // 정규 표현식 변수
    let phonResult;

    // 각 인풋을 배열로 만든다. 
    let joinArr = [userid, userPassword, passNumCheck, username, userBirth, useremail, phonNum];
    console.log(joinArr);
    console.log(joinArr.length);

    // 각 인풋의 결과값을 저장하는 배열을 만든다. 
    let joinResult = [idResult, pwResult, passcheckResult, nameResult, birthResult, emailResult, phonResult];
    console.log(joinResult);
    console.log(joinResult.length);
    
    // 각 인풋의 배열에 따라 blur의 값을 반환한다.  
    for(i=0; i < joinArr.length; i++){
        console.log(joinArr[i]);
        joinArr[i].addEventListener("blur", function(){
            txt_info = this.parentElement.parentElement.lastElementChild;
            if(this.value.trim() === ""){
                txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
                txt_info.innerHTML = `<i class='xi-info-o'></i><span> ${this.title}은/는 필수 입력 정보입니다.</span>`;
                txt_info.classList.add("txt-red", "on"); // 클래스 추가
                // 보내면 안됨 
                joinResult[this] = false;
                console.log(joinResult[this] = false);
            };
        });
    };
    
    // 아이디 검증 
    
    /* 
        예상 가능한 상황
        input focus 
        input에서 아무 값 없이 focus가 out된 경우 (blur)
        input에서 focus out 인데 정규식에 맞지 않을 경우 (특수문자 사용 및 글자수가 미만이거나 초과할 경우)
        input에서 focus out 인데 정규식에 맞으나 중복검사를 하지 않은 경우

        button click ()
        아무것도 입력하지 않고 중복확인 버튼을 누른 경우 
        입력된 아이디가 규직에 맞지 않는데 중복확인 버튼을 누른 경우 
        중복 검사를 통과하지 못할 경우 

        기본 button 비활성화 
        input에 정규식에 맞는 문자가 들어갔을 경우에만 button을 활성화 하고싶음 

    */
    // input focus 상활 
    userid.addEventListener("input", function() {
        if(this.value.match(regId)){
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>해당 아이디는 중복 확인이 필요합니다.</span>`;
            txt_info.classList.add("txt-green", "on"); // 클래스 추가
            // 입력값이 변경될 때마다 버튼 활성화 여부 확인
            id_check.disabled = false; // 정규식에 맞으면 버튼 활성화
            id_check.classList.add("on");
            // 보내면 안됨 
        } else {
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            txt_info.innerHTML = `<i class='xi-error-o'></i><span>해당 아이디는 사용이 불가능합니다.(특수문자 및 공백 사용불가)</span>`;
            txt_info.classList.add("txt-red", "on"); // 클래스 추가
            // 입력값이 변경될 때마다 버튼 활성화 여부 확인
            id_check.classList.remove("on");
            id_check.disabled = true; // 정규식에 맞지 않으면 버튼 비활성화
            // 보내면 안됨 
        } 
        idResult = false;
    })
    // 중복 검사 
    id_check.addEventListener("click", function() {
        txt_info = this.parentElement.parentElement.lastElementChild;
        txt_info.classList.add("txt-info");
        alert("사용 가능한 아이디 입니다.")
        txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
        txt_info.innerHTML = `<i class='xi-info-o'></i> <span>사용가능한 아이디 입니다.</span>`;
        txt_info.classList.add("txt-green", "on"); // 클래스 추가
        // 보내야함 
        idResult = true;
    });
    // 비밀번호 검증
    userPassword.addEventListener("input", function(){
        txt_info = this.parentElement.parentElement.lastElementChild;
        if(this.value.match(regPw)){
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            // 보내야함 
            pwResult = true;
        }else{
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>비밀번호는 영문 숫자 특수기호 조합 8자리 이상입니다.</span>`;
            txt_info.classList.add("txt-red", "on"); // 클래스 추가
            // 보내면 안됨 
            pwResult = false;
        }
    });
    /* 
        예상 가능한 상황
        아무것도 입력하지 않을 경우 
        입력된 패스워드가 규직에 맞지 않을 경우 
    */

    // 비밀번호 재검증 
    /*
        확인은 위의 입력된 패스워드와 일치하는지 아닌지만 확인하면 된다. 
    */
    passNumCheck.addEventListener("input", function(){
        txt_info = this.parentElement.parentElement.lastElementChild;
        if(this.value !== userPassword.value){
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>비밀번호가 일치하지 않습니다.</span>`;
            txt_info.classList.add("txt-red", "on"); // 클래스 추가
            // 보내면 안됨 
            passcheckResult = false;
        }else{
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            // 보내도 됨 
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

    // 이름 
    username.addEventListener("input", function(){
        txt_info = this.parentElement.parentElement.lastElementChild;
        if(this.value.match(regName)){
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            // 보내야함
            nameResult = true;
        }else{
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>이름은 한글만 사용가능합니다.</span>`;
            txt_info.classList.add("txt-red", "on"); // 클래스 추가
            // 보내면 안됨 
            nameResult = false
        }
    });

    //생년월일
    userBirth.addEventListener("input", function(){
        txt_info = this.parentElement.parentElement.lastElementChild;
        if(this.value.match(regBirth)){
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            // 보내야함
            birthResult = true;
        }else if(isNaN(this.value)){
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>숫자만 입력 바랍니다.</span>`;
            txt_info.classList.add("txt-red", "on"); // 클래스 추가
            this.value = "";
            this.focus();
            // 보내면 안됨 
            birthResult = false;
        };
    });
   
    // 이메일 검증 
    useremail.addEventListener("input", function(){
        txt_info = this.parentElement.parentElement.lastElementChild;
        if(this.value.match(regPhonp)){
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            // 보내야함
            emailResult = true;
        }else{
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>이메일 입력양식을 확인바랍니다. </span>`;
            txt_info.classList.add("txt-red", "on"); // 클래스 추가
            // 보내면 안됨 
            emailResult = false;
        }
    });
    // 전화번호 검증 애초에 number 만 입력되도로 하믄 안되나? 
    // 숫자 인가 문자 인가 
    // isNan(1) = flase
    // isNan("1") = true
    phonNum.addEventListener("input", function(){
        txt_info = this.parentElement.parentElement.lastElementChild;
        if(this.value.match(regName)){
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            // 보내야함
            phonResult = true;

        }else if(isNaN(this.value)){
            txt_info.classList.remove("txt-red", "txt-green", "on"); // 기존 클래스 제거
            txt_info.innerHTML = `<i class='xi-info-o'></i><span>숫자만 입력 바랍니다.</span>`;
            txt_info.classList.add("txt-red", "on"); // 클래스 추가
            this.value = "";
            this.focus();
            // 보내면 안됨 
            phonResult = false;
        }
    });

    
    // 전체 동의체크 
    let agreedBox;
    let agreedAll = document.getElementById("agreed_all");
    let agreed01 = document.getElementsByName("ag_privercy");// 동의 1
    let agreed01R;
    let agreed02 = document.getElementsByName("ag_sevise");// 동의 2
    let agreed02R;
    
    // 전체동의에 체크가 되면 동의는 전부 체크 되어야 한다. 
    agreedAll.addEventListener("change", function() {
        if(this.checked === true){
            agreed01[0].checked = true;
            agreed02[0].checked = true;
        }else if(this.checked == false){
            agreed01[0].checked = false;
            agreed02[0].checked = false;
        }                    
    });
    
    // 개별 체크박스 상태가 둘다 체크이면 전체 동의 체크, 아니면 전체 동의 해제
    function updateAgreedAll() {
    	const allCheck = agreed01[0].checked && agreed02[0].checked;
    	agreedAll.checked = allCheck;
    }
    agreed01.forEach(radio =>radio.addEventListener("change", updateAgreedAll));
    agreed02.forEach(radio =>radio.addEventListener("change", updateAgreedAll));
    
    function validCheck(){
        if(idResult === true && pwResult === true && passcheckResult === true && nameResult === true && emailResult === true && phonResult === true && birthResult === true){
            alert("다 정상 입력")
            return true;
        }else{
            if (idResult !== true) {
                alert("아이디가 올바르지 않습니다.");
                userid.focus(); // 아이디 입력창에 포커스
                return false; // 기본 동작을 막아 폼 제출과 새로고침을 방지
            }else if(pwResult !== true){
                alert("비밀번호가 올바르지 않습니다.");
                userPassword.focus(); 
                return false; 
            }else if(passcheckResult !== true){
                alert("비밀번호 재확인이 올바르지 않습니다.");
                passNumCheck.focus(); 
                return false; 
            }else if(nameResult !== true){
                alert("이름이 올바르지 않습니다.");
                username.focus(); 
                return false; 
            }else if(emailResult !== true){
                alert("이메일이 올바르지 않습니다.");
                useremail.focus(); 
                return false; 
            }else if(phonResult !== true){
                alert("전화번호가 올바르지 않습니다.");
                phonNum.focus(); 
                return false; 
            }else if(birthResult !== true){
                alert("생년월일이 올바르지 않습니다.");
                userBirth.focus(); 
                return false; 
            }
        }
    }
 })