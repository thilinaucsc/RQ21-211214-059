package com.example.genarateinterest.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(max = 10)
    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "terminated_date")
    protected Timestamp terminatedDate;

    @Size(max = 10)
    @Column(name = "terminated_by")
    protected String terminatedBy;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rd_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Timestamp getTerminatedDate() {
        return terminatedDate;
    }

    public void setTerminatedDate(Timestamp terminatedDate) {
        this.terminatedDate = terminatedDate;
    }

    public String getTerminatedBy() {
        return terminatedBy;
    }

    public void setTerminatedBy(String terminatedBy) {
        this.terminatedBy = terminatedBy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", modifiedBy=" + modifiedBy +
                ", modifiedDate=" + modifiedDate +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", terminatedDate=" + terminatedDate +
                ", terminatedBy='" + terminatedBy + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
