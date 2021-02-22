package project.controller;

import org.springframework.web.bind.annotation.*;
import project.model.SearchParam;
import project.model.network.Header;

@RestController
@RequestMapping("/api")// Localhost:8080/api
public class GetController{
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // Localhost:8080/api/getMethod
    public String getRequest(){
        return "Hi getMethod";
    }
    
    @GetMapping("/getParameter") // Localhost:8080/api/getParameter? id=1234&password=abcd, method 지정필요 없음
    public String getParameter(@RequestParam String id, @RequestParam String password){
        System.out.println("id : "+id);
        System.out.println("password : "+password);
        return id+password;
    }
    
    // Localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public String getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());
        
        //{"account" : "", "email" : "", "page" : 0}
        return "OK";
    }
    
    @GetMapping("/Header")
    public Header getHeader(){
        Header header = new Header();
        header.setResultCode("OK");
        header.setDescription("OK");
        
        // { "resultCode" : "OK", "description" : "OK" }
        return header;
    }
}