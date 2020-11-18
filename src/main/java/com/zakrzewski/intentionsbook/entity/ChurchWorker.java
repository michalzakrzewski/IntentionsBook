package com.zakrzewski.intentionsbook.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "church_worker")
public class ChurchWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "church_role")
    private String churchRole;


    public ChurchWorker() {
    }

    public ChurchWorker(String login, String password, String fullName, String churchWorkerRole) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.churchRole = churchWorkerRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getChurchRole() {
        return churchRole;
    }

    public void setChurchRole(String churchRole) {
        this.churchRole = churchRole;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChurchWorker that = (ChurchWorker) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(churchRole, that.churchRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, fullName, churchRole);
    }

    @Override
    public String toString() {
        return "ChurchWorker{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", churchRole='" + churchRole + '\'' +
                '}';
    }
}
