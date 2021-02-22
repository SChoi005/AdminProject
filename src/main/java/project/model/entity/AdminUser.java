package project.model.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.LastModifiedBy;
import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class AdminUser{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String account;
    private String password;
    private String status;
    private String role;
    private LocalDateTime lastLoginAt;
    private LocalDateTime passwordUpdatedAt;
    private Integer loginFailCount;
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
    
    public AdminUser(){}
    public AdminUser(Long id, String account, String password, String status, String role, LocalDateTime lastLoginAt, LocalDateTime passwordUpdatedAt, Integer loginFailCount, LocalDateTime registeredAt, LocalDateTime unregisteredAt, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy){
        this.id = id;
        this.account = account;
        this.password = password;
        this.status = status;
        this.lastLoginAt=lastLoginAt;
        this.passwordUpdatedAt=passwordUpdatedAt;
        this.loginFailCount=loginFailCount;
        this.registeredAt=registeredAt;
        this.unregisteredAt=unregisteredAt;
        this.createdAt=createdAt;
        this.createdBy=createdBy;
        this.updatedAt=updatedAt;
        this.updatedBy=updatedBy;
    }

    public Long getId(){ return id; }
    public String getAccount(){ return account; }
    public String getPassword(){return password;}
    public String getStatus(){return status;}
    public String getRole(){return role;}
    public LocalDateTime getLastLoginAt(){return lastLoginAt;}
    public LocalDateTime getPasswordUpdatedAt(){return passwordUpdatedAt;}
    public Integer getLoginFailCount(){return loginFailCount;}
    public LocalDateTime getRegisteredAt(){return registeredAt;}
    public LocalDateTime getUnregisteredAt(){return unregisteredAt;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public String getCreatedBy(){return createdBy;}
    public LocalDateTime getUpdatedAt(){return updatedAt;}
    public String getUpdatedBy(){return updatedBy;}
    
    public void setId(Long id){ this.id = id; }
    public void setAccount(String account) { this.account = account; }
    public void setPassword(String password){this.password=password;}
    public void setStatus(String status){this.status=status;}
    public void setRole(String role){this.role=role;}
    public void setLastLoginAt(LocalDateTime lastLoginAt){this.lastLoginAt=lastLoginAt;}
    public void setPasswordUpdatedAt(LocalDateTime passwordUpdatedAt){this.passwordUpdatedAt=passwordUpdatedAt;}
    public void setLoginFailCount(Integer loginFailCount){this.loginFailCount=loginFailCount;}
    public void setRegisteredAt(LocalDateTime registeredAt){this.registeredAt=registeredAt;}
    public void setUnregisteredAt(LocalDateTime unregisteredAt){this.unregisteredAt=unregisteredAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
    public void setCreatedBy(String createdBy){this.createdBy=createdBy;}
    public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
    public void setUpdatedBy(String updatedBy){this.updatedBy=updatedBy;}
}