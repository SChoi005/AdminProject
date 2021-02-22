package project.service;

import project.model.front.AdminMenu;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdminMenuService {

    public List<AdminMenu> getAdminMenu(){

        
        AdminMenu adminMenu =new AdminMenu();
        adminMenu.setTitle("고객 관리");
        adminMenu.setUrl("/pages/user");
        adminMenu.setCode("user");
        return Arrays.asList(adminMenu);

    }

}
