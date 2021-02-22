package project.model.network.request;

import java.time.LocalDateTime;

public class AdminUserApiRequest{
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
    
    public AdminUserApiRequest() {}
    
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
}