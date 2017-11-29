package danieltilley.ie.trainingpal.model;

public class User {
    private String Id;
    private String Password;
    private String F_Name;
    private String L_Name;
    private String E_Mail;
    private String Phone_Number;
    private String DOB;
    private String Type;
    private String Bio;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getF_name() {
        return F_Name;
    }

    public void setF_name(String F_Name) { this.F_Name = F_Name; }

    public String getL_name() {
        return L_Name;
    }

    public void setL_name(String L_Name) {
        this.L_Name = L_Name;
    }

    public String getE_mail() {
        return E_Mail;
    }

    public void setE_mail(String E_Mail) {
        this.E_Mail = E_Mail;
    }

    public String getPhone_number() { return Phone_Number; }

    public void setPhone_number(String Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    public String getDob() {
        return DOB;
    }

    public void setDob(String dob) {
        this.DOB = DOB;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String Bio) {
        this.Bio = Bio;
    }
}
