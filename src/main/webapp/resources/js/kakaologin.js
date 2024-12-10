
$(document).ready(function(){
 	// 카카오 SDK 초기화
	Kakao.init('33d350ee39f14c5305f7873eeffc074c'); // 사용하려는 앱의 JavaScript 키 입력

    // 카카오 로그인 함수
    function loginWithKakao() {
    	console.log("작동여부확인");
        Kakao.Auth.login({
            success: function(authObj) {
                // 로그인 성공 시, authObj에 토큰 정보가 포함됨
                console.log('카카오 로그인 성공', authObj);
                // 로그인 후 서버로 access token 전송
                sendTokenToServer(authObj.access_token);
            },
            fail: function(err) {
                console.error('카카오 로그인 실패', err);
            }
        });
    }

    // 서버에 access token 전송
    function sendTokenToServer(accessToken) {
        fetch('http://localhost:8080/auth/kakao/callback', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ access_token: accessToken }),
        })
        .then(response => response.json())
        .then(data => {
            console.log('서버 응답:', data);
        })
        .catch(error => {
            console.error('서버 오류:', error);
        });
    }
})