package org.zerock.dto;

public class NaverLoginDTO {
    private String id;          // 사용자 ID
    private String email;       // 이메일
    private String phone_num;      // 전화번호
    private String name;        // 사용자 이름
    private String birthday;    // 생일 (MM-DD 형식)
    private String birthyear;   // 출생연도
    private String birth;       // 결합된 생일 정보 (YYYY-MM-DD 형식)
    private String regidate;    // 가입일
    private String phoneNum;
    
    


    // 기본 생성자
    public NaverLoginDTO() {}

    // 전체 필드를 포함한 생성자
    public NaverLoginDTO(String id, String email, String mobile, String name, String birthday, String birthyear, String regidate) {
        this.id = id;
        this.email = email;
        this.phone_num = mobile;
        this.name = name;
        this.birthday = birthday;
        this.birthyear = birthyear;
        this.regidate = regidate;
        this.birth = generateFullBirth(birthday, birthyear);
        
        
    }
    



    // Getter/Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 // 수정된 필드 선언
      // 전화번호

    // 전화번호 필드에 대한 getter와 setter
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

 
    
    public String Phone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        this.birth = generateFullBirth(birthday, this.birthyear); // 변경 시 full birth 업데이트
    }

    public String getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
        this.birth = generateFullBirth(this.birthday, birthyear); // 변경 시 full birth 업데이트
    }

    public String getBirth() {
        return birth;
    }

    public String getRegidate() {
        return regidate;
    }

    public void setRegidate(String regidate) {
        this.regidate = regidate;
    }

    // 전체 생일 정보 생성 (YYYY-MM-DD)
    private String generateFullBirth(String birthday, String birthyear) {
        if (birthyear != null && birthday != null) {
            return birthyear + "-" + birthday;
        }
        return null;
    }

    // 디버깅을 위한 toString 메서드
    @Override
    public String toString() {
        return "NaverLoginDTO [id=" + id + ", email=" + email + ", phone_num=" + phone_num + ", name=" + name +
               ", birthday=" + birthday + ", birthyear=" + birthyear + ", birth=" + birth + ", regidate=" + regidate + "]";
    }
}
