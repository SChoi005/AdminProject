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

@Entity
@EntityListeners(AuditingEntityListener.class)
public class OrderDetail{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String status;
    private LocalDateTime arrivalDate;
    private Integer quantity;
    private BigDecimal totalPrice;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @CreatedBy
    private String createdBy;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    @LastModifiedBy
    private String updatedBy;
    
    //OrderDetail N : 1 Item
    @ManyToOne
    private Item item;
    
    //OrderDetail N : 1 OrderGroup
    @ManyToOne
    private OrderGroup orderGroup;
    
    
    
    public OrderDetail() {}
    
    public OrderDetail(Long id, String status, LocalDateTime arrivalDate, Integer quantity, BigDecimal totalPrice, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy, Item item, OrderGroup orderGroup){
        this.id = id;
        this.status=status;
        this.arrivalDate=arrivalDate;
        this.quantity=quantity;
        this.totalPrice=totalPrice;
        this.createdAt=createdAt;
        this.createdBy=createdBy;
        this.updatedAt=updatedAt;
        this.updatedBy=updatedBy;
        this.item=item;
        this.orderGroup=orderGroup;
    }
    
    public Long getId() { return id; }
    public String getStatus(){return status;}
    public LocalDateTime getArrivalDate(){return arrivalDate;}
    public Integer getQuantity(){return quantity;}
    public BigDecimal getTotalPrice(){return totalPrice;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public String getCreatedBy(){return createdBy;}
    public LocalDateTime getUpdatedAt(){return updatedAt;}
    public String getUpdatedBy(){return updatedBy;}
    public Item getItem(){return item;}
    public OrderGroup getOrderGroup(){return orderGroup;}
    
    public void setId(Long id) { this.id = id; }
    public void setStatus(String status){this.status=status;}
    public void setArrivalDate(LocalDateTime arrivalDate){this.arrivalDate=arrivalDate;}
    public void setQuantity(Integer quantity){this.quantity=quantity;}
    public void setTotalPrice(BigDecimal totalPrice){this.totalPrice=totalPrice;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
    public void setCreatedBy(String createdBy){this.createdBy=createdBy;}
    public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
    public void setUpdatedBy(String updatedBy){this.updatedBy=updatedBy;}
    public void setItem(Item item){this.item=item;}
    public void setOrderGroup(OrderGroup orderGroup){this.orderGroup=orderGroup;}
}