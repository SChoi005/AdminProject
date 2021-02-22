package project.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import project.model.enumClass.OrderType;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class OrderGroup{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String status;
    
    @Enumerated(EnumType.STRING)
    private OrderType orderType; //주문의 형태 - 일괄/개별
    
    private String revAddress;
    private String revName;
    private String paymentType; //카드/현금
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @CreatedBy
    private String createdBy;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    @LastModifiedBy
    private String updatedBy;
    
    // OrderGroup N : 1 User
    @ManyToOne
    private User user;
    
    // OrderGroup 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;
    
    public OrderGroup(){}
    public OrderGroup(Long id, String status, OrderType orderType, String revAddress, String revName, String paymentType,  BigDecimal totalPrice, Integer totalQuantity, LocalDateTime orderAt, LocalDateTime arrivalDate, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy, User user, List<OrderDetail> orderDetailList){
        this.id = id;
        this.status=status;
        this.orderType=orderType;
        this.revAddress=revAddress;
        this.revName=revName;
        this.paymentType=paymentType;
        this.totalPrice=totalPrice;
        this.totalQuantity=totalQuantity;
        this.orderAt=orderAt;
        this.arrivalDate=arrivalDate;
        this.createdAt=createdAt;
        this.createdBy=createdBy;
        this.updatedAt=updatedAt;
        this.updatedBy=updatedBy;
        this.user=user;
        this.orderDetailList=orderDetailList;
    }

    public Long getId() { return id; }
    public String getStatus(){return status;}
    public OrderType getOrderType(){return orderType;}
    public String getRevAddress(){return revAddress;}
    public String getRevName(){return revName;}
    public String getPaymentType(){return paymentType;}
    public BigDecimal getTotalPrice(){return totalPrice;}
    public Integer getTotalQuantity(){return totalQuantity;}
    public LocalDateTime getOrderAt(){return orderAt;}
    public LocalDateTime getArrivalDate(){return arrivalDate;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public String getCreatedBy(){return createdBy;}
    public LocalDateTime getUpdatedAt(){return updatedAt;}
    public String getUpdatedBy(){return updatedBy;}
    public User getUser(){return user;}
    public List<OrderDetail> getOrderDetailList(){return orderDetailList;}
    
    public void setId(Long id) { this.id = id; }
    public void setStatus(String status){this.status=status;}
    public void setOrderType(OrderType orderType){this.orderType=orderType;}
    public void setRevAddress(String revAddress){this.revAddress=revAddress;}
    public void setRevName(String revName){this.revName=revName;}
    public void setPaymentType(String paymentType){this.paymentType=paymentType;}
    public void setTotalPrice(BigDecimal totalPrice){this.totalPrice=totalPrice;}
    public void setTotalQuantity(Integer totalQuantity){this.totalQuantity=totalQuantity;}
    public void setOrderAt(LocalDateTime orderAt){this.orderAt=orderAt;}
    public void setArrivalDate(LocalDateTime arrivalDate){this.arrivalDate=arrivalDate;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
    public void setCreatedBy(String createdBy){this.createdBy=createdBy;}
    public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
    public void setUpdatedBy(String updatedBy){this.updatedBy=updatedBy;}
    public void setUser(User user){this.user=user;}
    public void setOrderDetailList(List<OrderDetail> orderDetailList) {this.orderDetailList=orderDetailList;}
}