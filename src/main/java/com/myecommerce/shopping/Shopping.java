package com.myecommerce.shopping;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "shopping")
public class Shopping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username" , nullable = false, length = 45)
    private String username;

    @Column(name="is_vip", nullable = false)
    private String isVip;

    @Column(name="total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name="last_purchase_date" , nullable = false)
    private LocalDate lastPurchaseDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }



    public LocalDate getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    public void setLastPurchaseDate(LocalDate lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", isVip='" + isVip + '\'' +
                ", totalAmount=" + totalAmount +
                ", lastPurchaseDate=" + lastPurchaseDate +
                '}';
    }
}
