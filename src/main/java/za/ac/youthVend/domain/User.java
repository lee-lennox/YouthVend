package za.ac.youthVend.domain;

import jakarta.persistence.*;
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;

    protected String fullName;
    protected String email;
    protected String password;

    public User(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    protected User(){}
    public String getEmail() {
        return email;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", id=" + userId +
                ", name='" + fullName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
