package com.example.genarateinterest.entity;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_type")
    protected String transactionType;

    @Column(name = "transaction_amount")
    protected String transactionAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", modifiedBy=" + modifiedBy +
                ", modifiedDate=" + modifiedDate +
                ", id=" + id +
                ", transactionType='" + transactionType + '\'' +
                ", transactionAmount='" + transactionAmount + '\'' +
                ", account=" + account +
                '}';
    }
}
