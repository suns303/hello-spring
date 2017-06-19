package kr.re.kitri.hello.model;

/**
 * Created by minheo on 2017. 6. 16..
 */
public class Member {
    private int memberSeq;
    private String userId;
    private String password;
    private String email;
    private int point;
    private String joinDate;

    public int getMemberSeq() {
        return memberSeq;
    }

    public void setMemberSeq(int memberSeq) {
        this.memberSeq = memberSeq;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint(int anInt) {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getJoinDate(String string) {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberSeq=" + memberSeq +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", point='" + point + '\'' +
                ", joinDate='" + joinDate + '\'' +
                '}';
    }
}