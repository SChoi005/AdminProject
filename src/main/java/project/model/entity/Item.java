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

import project.model.enumClass.ItemStatus;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Item{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private ItemStatus status; //등록, 해지, 검수중(등록대기중)
    
    private String name;
    
    private String title;
    
    private String brandName;
    
    private BigDecimal price;
    
    private String content;
    
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @CreatedBy
    private String createdBy;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    @LastModifiedBy
    private String updatedBy;
    
    // Item N : 1 Partner
    @ManyToOne
    private Partner partner;
    
    // Item 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy="item")
    private List<OrderDetail> orderDetailList;
    
    public Item() {}

    public Item(Long id, ItemStatus status, String name, String title, String brandName, BigDecimal price, String content, LocalDateTime registeredAt, LocalDateTime unregisteredAt, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy, Partner partner, List<OrderDetail> orderDetailList){
        this.id = id;
        this.status=status;
        this.name = name;
        this.title=title;
        this.brandName=brandName;
        this.price = price;
        this.content = content;
        this.registeredAt=registeredAt;
        this.unregisteredAt=unregisteredAt;
        this.createdAt=createdAt;
        this.createdBy=createdBy;
        this.updatedAt=updatedAt;
        this.updatedBy=updatedBy;
        this.partner=partner;
        this.orderDetailList=orderDetailList;
    }
    
    public Long getId(){ return id; }
    public ItemStatus getStatus(){return status;}
    public String getName(){ return name; }
    public String getTitle(){return title;}
    public String getBrandName(){return brandName;}
    public BigDecimal getPrice(){ return price; }
    public String getContent(){ return content; }
    public LocalDateTime getRegisteredAt(){return registeredAt;}
    public LocalDateTime getUnregisteredAt(){return unregisteredAt;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public String getCreatedBy(){return createdBy;}
    public LocalDateTime getUpdatedAt(){return updatedAt;}
    public String getUpdatedBy(){return updatedBy;}
    public Partner getPartner(){return partner;}
    public List<OrderDetail> getOrderDetailList(){return orderDetailList;}
    
    public void setId(Long id){ this.id = id; }
    public void setStatus(ItemStatus status){this.status=status;}
    public void setName(String name) { this.name = name; }
    public void setTitle(String title){this.title=title;}
    public void setBrandName(String brandName){this.brandName=brandName;}
    public void setPrice(BigDecimal price){ this.price = price; }
    public void setContent(String content){ this.content = content; }
    public void setRegisteredAt(LocalDateTime registeredAt){this.registeredAt=registeredAt;}
    public void setUnregisteredAt(LocalDateTime unregisteredAt){this.unregisteredAt=unregisteredAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
    public void setCreatedBy(String createdBy){this.createdBy=createdBy;}
    public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
    public void setUpdatedBy(String updatedBy){this.updatedBy=updatedBy;}
    public void setPartner(Partner partner){this.partner=partner;}
    public void setOrderDetailList(List<OrderDetail> orderDetailList){this.orderDetailList=orderDetailList;}
}