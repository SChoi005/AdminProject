package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.ifs.CrudInterface;
import project.model.network.request.PartnerApiRequest;
import project.model.network.response.PartnerApiResponse;
import project.repository.CategoryRepository;
import project.repository.PartnerRepository;
import project.model.entity.Partner;
import project.model.network.Header;

@Service
public class PartnerApiLogicService extends BaseService<PartnerApiRequest,PartnerApiResponse, Partner>{
    
    // @Autowired
    // PartnerRepository partnerRepository;
    
    @Autowired
    CategoryRepository categoryRepository;
    
    @Override
    public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request){
        PartnerApiRequest body = request.getData();
        
        Partner partner = new Partner();
        
        partner.setStatus(body.getStatus());
        partner.setName(body.getName());
        partner.setAddress(body.getAddress());
        partner.setCeoName(body.getCeoName());
        partner.setCallCenter(body.getCallCenter());
        partner.setBusinessNumber(body.getbusinessNumber());
        partner.setPartnerNumber(body.getPartnerNumber());
        partner.setRegisteredAt(body.getRegisteredAt());
        partner.setUnregisteredAt(body.getUnregisteredAt());
        partner.setCategory(categoryRepository.getOne(body.getCategoryId()));
        
        Partner newPartner = baseRepository.save(partner);
        
        return response(newPartner);        
    }
    
    @Override
    public Header<PartnerApiResponse> read(Long id){
        return baseRepository.findById(id)
            .map(partner->response(partner))
            .orElseGet(()->Header.ERROR("데이터 없음"));
    }
    
    @Override
    public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request){
        PartnerApiRequest body = request.getData();
        
        return baseRepository.findById(body.getId())
            .map(partner->{
                partner.setStatus(body.getStatus());
                partner.setName(body.getName());
                partner.setAddress(body.getAddress());
                partner.setCeoName(body.getCeoName());
                partner.setCallCenter(body.getCallCenter());
                partner.setBusinessNumber(body.getbusinessNumber());
                partner.setPartnerNumber(body.getPartnerNumber());
                partner.setRegisteredAt(body.getRegisteredAt());
                partner.setUnregisteredAt(body.getUnregisteredAt());
                partner.setCategory(categoryRepository.getOne(body.getCategoryId()));
                
                return partner;
            })
            .map(changePartner->baseRepository.save(changePartner))
            .map(newPartner->response(newPartner))
            .orElseGet(()->Header.ERROR("데이터 없음"));
    }
    
    @Override
    public Header delete(Long id){
        return baseRepository.findById(id)
            .map(partner->{
                baseRepository.delete(partner);
                return Header.OK();
            })
            .orElseGet(()->Header.ERROR("데이터 없음"));
    }
    
    public Header<PartnerApiResponse> response(Partner partner){
        PartnerApiResponse body = new PartnerApiResponse();
        
        body.setId(partner.getId());
        body.setStatus(partner.getStatus());
        body.setName(partner.getName());
        body.setAddress(partner.getAddress());
        body.setCeoName(partner.getCeoName());
        body.setCallCenter(partner.getCallCenter());
        body.setBusinessNumber(partner.getbusinessNumber());
        body.setPartnerNumber(partner.getPartnerNumber());
        body.setRegisteredAt(partner.getRegisteredAt());
        body.setUnregisteredAt(partner.getUnregisteredAt());
        body.setCategoryId(partner.getCategory().getId());
        
        
        return Header.OK(body);
    }
}