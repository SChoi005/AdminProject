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
import project.model.network.request.OrderDetailApiRequest;
import project.model.network.response.OrderDetailApiResponse;
import project.service.OrderDetailApiLogicService;
import project.model.entity.OrderDetail;
import project.model.network.Header;

@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailApiController extends CrudController<OrderDetailApiRequest, OrderDetailApiResponse, OrderDetail>{
    
    // @Autowired
    // OrderDetailApiLogicService orderDetailApiLogicService;
    
    // @PostConstruct
    // public void init(){
    //     this.baseService=orderDetailApiLogicService;
    // }
    
    // @Override
    // @PostMapping("")
    // public Header<OrderDetailApiResponse> create(@RequestBody Header<OrderDetailApiRequest> request){
    //     return orderDetailApiLogicService.create(request);
    // }
    
    // @Override
    // @GetMapping("{id}")
    // public Header<OrderDetailApiResponse> read(@PathVariable Long id){
    //     return orderDetailApiLogicService.read(id);
    // }
    
    // @Override
    // @PutMapping("")
    // public Header<OrderDetailApiResponse> update(@RequestBody Header<OrderDetailApiRequest> request){
    //     return orderDetailApiLogicService.update(request);
    // }
    
    // @Override
    // @DeleteMapping("{id}")
    // public Header delete(@PathVariable Long id){
    //     return orderDetailApiLogicService.delete(id);
    // }
    
}