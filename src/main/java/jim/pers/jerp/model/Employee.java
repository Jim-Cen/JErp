package jim.pers.jerp.model;

public class Employee {
    private int uuid;
    private String userName;
    private String pwd;
    private String email;
    private String tel;
    private int depUuid;

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getDepUuid() {
        return depUuid;
    }

    public void setDepUuid(int depUuid) {
        this.depUuid = depUuid;
    }

}
