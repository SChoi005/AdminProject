package project.model.entity;

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
public class Partner{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String status;
    private String address;
    private String callCenter;
    private String partnerNumber;
    private String businessNumber;
    private String ceoName;
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
    
    //Partner N : 1 Category
    @ManyToOne
    private Category category;

    // Partner 1 : N Item
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
    private List<Item> itemList;
    
    public Partner(){}
    public Partner(Long id, String name, String status, String address, String callCenter, String partnerNumber, String businessNumber, String ceoName, LocalDateTime registeredAt, LocalDateTime unregisteredAt, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy, Category category, List<Item> itemList){
        this.id=id;
        this.name=name;
        this.status=status;
        this.address=address;
        this.callCenter=callCenter;
        this.partnerNumber=partnerNumber;
        this.businessNumber=businessNumber;
        this.ceoName=ceoName;
        this.registeredAt=registeredAt;
        this.unregisteredAt=unregisteredAt;
        this.createdAt=createdAt;
        this.createdBy=createdBy;
        this.updatedAt=updatedAt;
        this.updatedBy=updatedBy;
        this.category=category;
        this.itemList=itemList;
    }
    
    public Long getId() {return id;}  
    public String getName(){return name;}
    public String getStatus(){return status;}
    public String getAddress(){return address;}
    public String getCallCenter(){return callCenter;}
    public String getPartnerNumber(){return partnerNumber;}
    public String getbusinessNumber(){return businessNumber;}
    public String getCeoName(){return ceoName;}
    public LocalDateTime getRegisteredAt(){return registeredAt;}
    public LocalDateTime getUnregisteredAt(){return unregisteredAt;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public String getCreatedBy(){return createdBy;}
    public LocalDateTime getUpdatedAt(){return updatedAt;}
    public String getUpdatedBy(){return updatedBy;}
    public Category getCategory(){return category;}
    public List<Item> getItemList(){return itemList;}
    
    public void setId(Long id) {this.id=id;}  
    public void setName(String name){this.name=name;}
    public void setStatus(String status){this.status=status;}
    public void setAddress(String address){this.address=address;}
    public void setCallCenter(String callCenter){this.callCenter=callCenter;}
    public void setPartnerNumber(String partnerNumber){this.partnerNumber=partnerNumber;}
    public void setBusinessNumber(String businessNumber){this.businessNumber=businessNumber;}
    public void setCeoName(String ceoName){this.ceoName=ceoName;}
    public void setRegisteredAt(LocalDateTime registeredAt){this.registeredAt=registeredAt;}
    public void setUnregisteredAt(LocalDateTime unregisteredAt){this.unregisteredAt=unregisteredAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
    public void setCreatedBy(String createdBy){this.createdBy=createdBy;}
    public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
    public void setUpdatedBy(String updatedBy){this.updatedBy=updatedBy;}
    public void setCategory(Category category){this.category=category;}
    public void setItemList(List<Item> itemList){this.itemList=itemList;}
}