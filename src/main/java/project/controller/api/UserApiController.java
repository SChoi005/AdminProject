package project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import project.model.entity.User;
import project.model.network.Header;
import project.controller.CrudController;
import project.ifs.CrudInterface;
import project.model.network.request.UserApiRequest;
import project.model.network.response.UserApiResponse;
import project.model.network.response.UserOrderInfoApiResponse;
import project.service.UserApiLogicService;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//@Slf4j 이거쓰면 로그남길수있음
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User>{
    
    @Autowired
    private UserApiLogicService userApiLogicService;
    
    @GetMapping("")
    public Header<List<UserApiResponse>> search(@PageableDefault(sort="id",direction = Sort.Direction.ASC, size=15) Pageable pageable){
        System.out.println(pageable.getPageNumber());
        return userApiLogicService.search(pageable);
    }
    
    @GetMapping("/{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id){
        return userApiLogicService.orderInfo(id);
    }
    // @Autowired
    // private UserApiLogicService userApiLogicService;
    
    // @PostConstruct
    // public void init(){
    //     this.baseService=userApiLogicService;
    // }
    
    // @Override
    // @PostMapping("") // /api/user
    // public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request){
    //     //log.info("{}",request);
    //     return userApiLogicService.create(request);
    // }
    
    // @Override
    // @GetMapping("{id}") // /api/user/{id}
    // public Header<UserApiResponse> read(@PathVariable Long id){
    //     return userApiLogicService.read(id);
    // }
    
    // @Override
    // @PutMapping("") // /api/user
    // public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request){
    //     return userApiLogicService.update(request);        
    // }
    
    // @Override
    // @DeleteMapping("{id}") // /api/user/{id}
    // public Header delete(@PathVariable Long id){
    //     return userApiLogicService.delete(id);        
    // }
    
}