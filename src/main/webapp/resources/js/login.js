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
    let idResult;
    
    // 패스워드
    let userPassword = document.getElementById("pw");
    let pwResult;
    
    // 각 인풋에 대한 검증 상태
    let loginArr = [userid, userPassword];
    let loginResult = [idResult, pwResult];

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
    
})