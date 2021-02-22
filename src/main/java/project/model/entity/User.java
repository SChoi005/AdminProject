package project.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import project.model.enumClass.UserStatus;


//@Data //ToString(exclude = )
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String account;
    
    private String password;
    
    @Enumerated(EnumType.STRING)
    private UserStatus status; // REGISTERED / UNREGISTERED / WAITING
    
    private String email;
    
    private String phoneNumber;
    
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
    
    //User 1 : N OrderGroup
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;
    
    
    public User() {}
    
    public User(Long id, String account, String password, UserStatus status, String email, String phoneNumber, LocalDateTime registeredAt, LocalDateTime unregisteredAt, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy, List<OrderGroup> orderGroupList){
        this.id = id;
        this.account = account;
        this.password = password;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registeredAt = registeredAt;
        this.unregisteredAt = unregisteredAt;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.orderGroupList=orderGroupList;
    }
    
    public Long getId(){ return id; }
    public String getAccount(){ return account; }
    public String getPassword(){return password;}
    public UserStatus getStatus(){return status;}
    public String getEmail(){ return email; }
    public String getPhoneNumber(){ return phoneNumber; }
    public LocalDateTime getRegisteredAt(){return registeredAt;}
    public LocalDateTime getUnRegisteredAt(){return unregisteredAt;}
    public LocalDateTime getCreatedAt(){ return createdAt; }
    public String getCreatedBy(){ return createdBy; }
    public LocalDateTime getUpdatedAt(){ return updatedAt; }
    public String getUpdatedBy(){ return updatedBy; }
    public List<OrderGroup> getOrderGroupList(){return orderGroupList;}
    
    public void setId(Long id){ this.id = id; }
    public void setAccount(String account) { this.account = account; }
    public void setPassword(String password){this.password=password;}
    public void setStatus(UserStatus status){this.status=status;}
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setRegisteredAt(LocalDateTime registeredAt){this.registeredAt=registeredAt;}
    public void setUnRegisteredAt(LocalDateTime unregisteredAt){this.unregisteredAt=unregisteredAt;}
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public void setUpdatedBy(String updatedBy) { this.updatedBy= updatedBy; }
    public void setOrderGroupList(List<OrderGroup> orderGroupList){this.orderGroupList=orderGroupList;}
    
    // @Override
    // public String toString(){
    //     return "(id : "+id+", account : "+account+", email : "+email+", phoneNumber : "+phoneNumber+", createdAt : "+createdAt+", createdBy : "+createdBy+", updatedAt : "+updatedBy+", updatedBy : "+updatedBy+" )";
    // }
}