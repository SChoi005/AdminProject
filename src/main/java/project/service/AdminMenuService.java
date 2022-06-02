package project.service;

import project.model.front.AdminMenu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AdminMenuService {

    public List<AdminMenu> getAdminMenu(){

        List<AdminMenu> menus = new ArrayList<>();
        
        menus.add(new AdminMenu("고객 관리","/pages/user","user"));
        menus.add(new AdminMenu("고객 주문 내역","/pages/order","order"));
        
        return menus;

    }

}
