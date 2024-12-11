package org.zerock.dto;

public class NaverLoginDTO {
    private String id;          // �궗�슜�옄 ID
    private String email;       // �씠硫붿씪
    private String phone_num;      // �쟾�솕踰덊샇
    private String name;        // �궗�슜�옄 �씠由�
    private String birthday;    // �깮�씪 (MM-DD �삎�떇)
    private String birthyear;   // 異쒖깮�뿰�룄
    private String birth;       // 寃고빀�맂 �깮�씪 �젙蹂� (YYYY-MM-DD �삎�떇)
    private String regidate;    // 媛��엯�씪
    private String phoneNum;
    
    


    public NaverLoginDTO() {}

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
 // �닔�젙�맂 �븘�뱶 �꽑�뼵
      // �쟾�솕踰덊샇

    // �쟾�솕踰덊샇 �븘�뱶�뿉 ���븳 getter�� setter
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
        this.birth = generateFullBirth(birthday, this.birthyear); // 蹂�寃� �떆 full birth �뾽�뜲�씠�듃
    }

    public String getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
        this.birth = generateFullBirth(this.birthday, birthyear); // 蹂�寃� �떆 full birth �뾽�뜲�씠�듃
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

    // �쟾泥� �깮�씪 �젙蹂� �깮�꽦 (YYYY-MM-DD)
    private String generateFullBirth(String birthday, String birthyear) {
        if (birthyear != null && birthday != null) {
            return birthyear + "-" + birthday;
        }
        return null;
    }

    // �뵒踰꾧퉭�쓣 �쐞�븳 toString 硫붿꽌�뱶
    @Override
    public String toString() {
        return "NaverLoginDTO [id=" + id + ", email=" + email + ", phone_num=" + phone_num + ", name=" + name +
               ", birthday=" + birthday + ", birthyear=" + birthyear + ", birth=" + birth + ", regidate=" + regidate + "]";
    }
}
