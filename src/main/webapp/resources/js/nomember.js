let nameResult;
let phonResult;
let emailResult;

$(document).ready(function(){
	let txt_info;
    let txt_info_area = document.getElementsByClassName("input-box");
    
    // 각 input에 맞는 txt-info p 요소를 생성한다.
    for(i = 0; i < txt_info_area.length; i++){
        txt_info = document.createElement("p");
        txt_info_area[i].parentElement.appendChild(txt_info);
        txt_info.classList.add("txt-info");
    };
    
    let username = document.getElementById("uname");
    let regName = /^[가-힣]+$/; 

    let phonNum = document.getElementById("phone_num");
    let regPhonp = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;

    let useremail = document.getElementById("email");
    let regEmail = /^[0-9a-zA-Z]*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
    
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
    
    
    // 각 인풋에 대한 검증 상태
    let loginArr = [username, phonNum, useremail];
    let loginResult = [nameResult, phonResult, emailResult];

    // 인풋 필드에 focus가 벗어날 때 처리
    for(i = 0; i < loginArr.length; i++){
    	loginArr[i].addEventListener("blur", function(){
            txt_info = this.parentElement.parentElement.lastElementChild;
            if(this.value.trim() === ""){
                txt_info.classList.remove("txt-red", "txt-green", "on");
                txt_info.innerHTML = `<i class='xi-info-o'></i><span> ${this.title}은/는 필수 입력 정보입니다.</span>`;
                txt_info.classList.add("txt-red", "on");
                loginResult[this] = false;
            }
        });
    }
})