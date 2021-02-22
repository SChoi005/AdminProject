package project.model.network.request;

import javax.persistence.*;

import project.model.enumClass.UserStatus;

import java.time.LocalDateTime;


public class UserApiRequest{
    
    private Long id;
    
    private String account;
    
    private String password;
    
    private UserStatus status;
        
    private String email;
    
    private String phoneNumber;
    
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    
    public UserApiRequest() {}    
    
    public Long getId(){ return id; }
    public String getAccount(){ return account; }
    public String getPassword(){return password;}
    public UserStatus getStatus(){return status;}
    public String getEmail(){ return email; }
    public String getPhoneNumber(){ return phoneNumber; }
    public LocalDateTime getRegisteredAt(){return registeredAt;}
    public LocalDateTime getUnRegisteredAt(){return unregisteredAt;}
    
    public void setId(Long id){ this.id = id; }
    public void setAccount(String account) { this.account = account; }
    public void setPassword(String password){this.password=password;}
    public void setStatus(UserStatus status){this.status=status;}
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setRegisteredAt(LocalDateTime registeredAt){this.registeredAt=registeredAt;}
    public void setUnRegisteredAt(LocalDateTime unregisteredAt){this.unregisteredAt=unregisteredAt;}
}