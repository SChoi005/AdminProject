package project.controller.api;

import project.model.entity.Item;
import project.model.network.Header;
import project.model.network.request.ItemApiRequest;
import project.model.network.response.ItemApiResponse;
import project.service.ItemApiLogicService;

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


@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item>{
    
    // @Autowired
    // private ItemApiLogicService itemApiLogicService;
    
    // @PostConstruct
    // public void init(){
    //     this.baseService = itemApiLogicService;
    // }

}