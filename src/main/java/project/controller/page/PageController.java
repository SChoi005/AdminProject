package project.controller.page;
import project.service.AdminMenuService;
import project.service.UserApiLogicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PageController {

    @Autowired
    private AdminMenuService adminMenuService;

    @Autowired
    private UserApiLogicService userApiLogicService;

    
    @RequestMapping(path = {""})
    public ModelAndView index() {
        return new ModelAndView("pages/main")
                .addObject("menuList", adminMenuService.getAdminMenu())
                .addObject("code", "main")
                ;
    }

    @RequestMapping("/user")
    public ModelAndView user() {
        return new ModelAndView("pages/user")
                .addObject("menuList", adminMenuService.getAdminMenu())
                .addObject("code", "user")
                ;
    }
    
    @RequestMapping("/order")
    public ModelAndView order(){
        return new ModelAndView("pages/order")
                .addObject("menuList", adminMenuService.getAdminMenu())
                .addObject("code", "order")
                ;
    }
}
