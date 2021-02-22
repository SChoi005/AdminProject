package project.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import project.ApplicationTests;
import project.model.entity.AdminUser;

public class AdminUserRepositoryTest extends ApplicationTests{

    @Autowired
    private AdminUserRepository adminUserRepository;
    
   // @Test
    public void create(){
        AdminUser adminUser = new AdminUser();
        adminUser.setAccount("AdminUser01");
        adminUser.setPassword("AdminUser01");
        adminUser.setStatus("REGISTERED");
        adminUser.setRole("PARTNER");
        // adminUser.setCreatedAt(LocalDateTime.now());
        // adminUser.setCreatedBy("AdminServer");
        
        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        
        Assert.assertNotNull(newAdminUser);
        
        newAdminUser.setAccount("CHANGE");
        adminUserRepository.save(newAdminUser);
    }
}