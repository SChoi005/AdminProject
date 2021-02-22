package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.ifs.CrudInterface;
import project.model.network.request.AdminUserApiRequest;
import project.model.network.response.AdminUserApiResponse;
import project.repository.AdminUserRepository;
import project.model.entity.AdminUser;
import project.model.network.Header;

@Service
public class AdminUserApiLogicService extends BaseService<AdminUserApiRequest,AdminUserApiResponse,AdminUser>{
    
    // @Autowired
    // AdminUserRepository adminUserRepository;
    
    @Override
    public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request){
        AdminUserApiRequest body = request.getData();
        AdminUser adminUser = new AdminUser();
        adminUser.setStatus(body.getStatus());
        adminUser.setAccount(body.getAccount());
        adminUser.setRole(body.getRole());
        adminUser.setPassword(body.getPassword());
        adminUser.setPasswordUpdatedAt(body.getPasswordUpdatedAt());
        adminUser.setLastLoginAt(body.getLastLoginAt());
        adminUser.setLoginFailCount(body.getLoginFailCount());
        adminUser.setRegisteredAt(body.getRegisteredAt());
        adminUser.setUnregisteredAt(body.getUnregisteredAt());
        
        AdminUser newAdminUser = baseRepository.save(adminUser);
        
        return response(newAdminUser);
    }
    
    @Override
    public Header<AdminUserApiResponse> read(Long id){
        return baseRepository.findById(id)
            .map(adminUser->response(adminUser))
            .orElseGet(()->Header.ERROR("데이터없음"));
    }
    
    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request){
        AdminUserApiRequest body = request.getData();
        return baseRepository.findById(body.getId())
            .map(adminUser->{
                adminUser.setStatus(body.getStatus());
                adminUser.setAccount(body.getAccount());
                adminUser.setRole(body.getRole());
                adminUser.setPassword(body.getPassword());
                adminUser.setPasswordUpdatedAt(body.getPasswordUpdatedAt());
                adminUser.setLastLoginAt(body.getLastLoginAt());
                adminUser.setLoginFailCount(body.getLoginFailCount());
                adminUser.setRegisteredAt(body.getRegisteredAt());
                adminUser.setUnregisteredAt(body.getUnregisteredAt());
                
                return adminUser;
            })
            .map(changeAdminUser->baseRepository.save(changeAdminUser))
            .map(newAdminUser->response(newAdminUser))
            .orElseGet(()->Header.ERROR("데이터 없음"));
    }
    
    @Override
    public Header delete(Long id){
        return baseRepository.findById(id)
            .map(adminUser->{
                baseRepository.delete(adminUser);
                return Header.OK();
            })
            .orElseGet(()->Header.ERROR("데이터 없음"));
    }
    
    public Header<AdminUserApiResponse> response(AdminUser adminUser){
        AdminUserApiResponse body = new AdminUserApiResponse();
        body.setId(adminUser.getId());
        body.setStatus(adminUser.getStatus());
        body.setAccount(adminUser.getAccount());
        body.setRole(adminUser.getRole());
        body.setPassword(adminUser.getPassword());
        body.setPasswordUpdatedAt(adminUser.getPasswordUpdatedAt());
        body.setLastLoginAt(adminUser.getLastLoginAt());
        body.setLoginFailCount(adminUser.getLoginFailCount());
        body.setRegisteredAt(adminUser.getRegisteredAt());
        body.setUnregisteredAt(adminUser.getUnregisteredAt());
        
        return Header.OK(body);
    }
}