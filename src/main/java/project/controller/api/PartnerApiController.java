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
import project.model.network.request.PartnerApiRequest;
import project.model.network.response.PartnerApiResponse;
import project.service.PartnerApiLogicService;
import project.model.entity.Partner;
import project.model.network.Header;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest,PartnerApiResponse, Partner>{
    
    // @Autowired
    // PartnerApiLogicService partnerApiLogicService;
    
    // @PostConstruct
    // public void init(){
    //     this.baseService=partnerApiLogicService;
    // }
    
    // @Override
    // @PostMapping("")
    // public Header<PartnerApiResponse> create(@RequestBody Header<PartnerApiRequest> request){
    //     return partnerApiLogicService.create(request);
    // }

    // @Override
    // @GetMapping("{id}")
    // public Header<PartnerApiResponse> read(@PathVariable Long id){
    //     return partnerApiLogicService.read(id);
    // }

    // @Override
    // @PutMapping("")
    // public Header<PartnerApiResponse> update(@RequestBody Header<PartnerApiRequest> request){
    //     return partnerApiLogicService.update(request);
    // }

    // @Override
    // @DeleteMapping("{id}")
    // public Header delete(@PathVariable Long id){
    //     return partnerApiLogicService.delete(id);
    // }
}