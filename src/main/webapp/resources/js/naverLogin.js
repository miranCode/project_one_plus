/**
 * 
 */
$(document).ready(function(){
    // 예시로 'p' 태그 안의 내용을 가져옴
    let naverLogInfo = $("p").html();
    
    // naverlogInfo 함수 호출 (로그인 정보 객체를 직접 전달)
    naverlogInfo({ loginfo: naverLogInfo });  // 데이터를 객체 형식으로 전달
});

function naverlogInfo(loginfo) {
    console.log("Sending login info:", loginfo); // 전달되는 데이터 확인
    $.ajax({
        type: 'POST',
        url: '/naver/loginfo',
        data: JSON.stringify(loginfo),
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            console.log("Success:", result);
        },
        error: function(xhr, status, errorThrown) {
            console.log("Error:", errorThrown);
        }
    });
}
