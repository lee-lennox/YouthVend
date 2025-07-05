package za.ac.youthVend.domain;

import jakarta.persistence.*;
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;

    protected String fullName;
    protected String email;
    protected String password;

    public User(String email, Long id, String name, String password) {
        this.email = email;
        this.userId = id;
        this.fullName = name;
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
