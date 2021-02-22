package project.controller.api;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.controller.CrudController;
import project.ifs.CrudInterface;
import project.model.network.request.AdminUserApiRequest;
import project.model.network.response.AdminUserApiResponse;
import project.service.AdminUserApiLogicService;
import project.model.entity.AdminUser;
import project.model.network.Header;

@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController extends CrudController<AdminUserApiRequest,AdminUserApiResponse, AdminUser>{
    
    // @Autowired
    // AdminUserApiLogicService adminUserApiLogicService;
    
    // @PostConstruct
    // public void init(){
    //     this.baseService=adminUserApiLogicService;
    // }
    
    // @Override
    // @PostMapping("")
    // public Header<AdminUserApiResponse> create(@RequestBody Header<AdminUserApiRequest> request){
    //     return adminUserApiLogicService.create(request);
    // }
    
    // @Override
    // @GetMapping("{id}")
    // public Header<AdminUserApiResponse> read(@PathVariable Long id){
    //     return adminUserApiLogicService.read(id);
    // }
    
    // @Override
    // @PutMapping("")
    // public Header<AdminUserApiResponse> update(@RequestBody Header<AdminUserApiRequest> request){
    //     return adminUserApiLogicService.update(request);
    // }
    
    // @Override
    // @DeleteMapping("{id}")
    // public Header delete(@PathVariable Long id){
    //     return adminUserApiLogicService.delete(id);
    // }
    
}