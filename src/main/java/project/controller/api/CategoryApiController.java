package project.controller.api;

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
import project.model.network.request.CategoryApiRequest;
import project.model.network.response.CategoryApiResponse;
import project.service.CategoryApiLogicService;
import project.model.network.Header;
import project.model.entity.Category;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController extends CrudController<CategoryApiRequest,CategoryApiResponse, Category>{
    
//     @Autowired
//     CategoryApiLogicService categoryApiLogicService;
    
//     @PostConstruct
//     public void init(){
//         this.baseService=categoryApiLogicService;
//     }
    
    // @Override
    // @PostMapping("")
    // public Header<CategoryApiResponse> create(@RequestBody Header<CategoryApiRequest> request){
    //     return categoryApiLogicService.create(request);
    // }
    
    // @Override
    // @GetMapping("{id}")
    // public Header<CategoryApiResponse> read(@PathVariable Long id){
    //     return categoryApiLogicService.read(id);    
    // }
    
    // @Override
    // @PutMapping("")
    // public Header<CategoryApiResponse> update(@RequestBody Header<CategoryApiRequest> request){
    //     return categoryApiLogicService.update(request);
    // }
    
    // @Override
    // @DeleteMapping("{id}")
    // public Header delete(@PathVariable Long id){
    //     return categoryApiLogicService.delete(id);
    // }
}