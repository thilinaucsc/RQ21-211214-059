package com.example.genarateinterest.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "account")
public class Account extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "terminated_date")
    protected Timestamp terminatedDate;

    @Size(max = 10)
    @Column(name = "terminated_by")
    protected String terminatedBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Customer customer;

    @Column(name = "balance")
    protected String balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNo='" + accountNo + '\'' +
                ", terminatedDate=" + terminatedDate +
                ", terminatedBy='" + terminatedBy + '\'' +
                ", customer=" + customer +
                ", balance='" + balance + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", modifiedBy=" + modifiedBy +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
