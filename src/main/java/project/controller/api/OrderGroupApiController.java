package project.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.controller.CrudController;
import project.model.entity.OrderGroup;
import project.model.network.request.OrderGroupApiRequest;
import project.model.network.response.OrderGroupApiResponse;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest,OrderGroupApiResponse, OrderGroup>{
    
    
    
    // @Autowired
    // private OrderGroupLogicService orderGroupLogicService;
    
    // @PostConstruct
    // public void init(){
    //     this.baseService = orderGroupLogicService;
    // }
    
    // @Override
    // @PostMapping("")
    // public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request){
    //     return orderGroupLogicService.create(request);
    // }
    
    // @Override
    // @GetMapping("{id}")
    // public Header<OrderGroupApiResponse> read(@PathVariable Long id){
    //     return orderGroupLogicService.read(id);
    // }
    
    // @Override
    // @PutMapping("")
    // public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> request){
    //     return orderGroupLogicService.update(request);   
    // }
    
    // @Override
    // @DeleteMapping("{id}")
    // public Header delete(@PathVariable Long id){
    //     return orderGroupLogicService.delete(id);
    // }
}