package project.service;

import org.apache.coyote.http11.HeadersTooLargeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.ifs.CrudInterface;
import project.model.entity.Item;
import project.model.network.Header;
import project.model.network.request.ItemApiRequest;
import project.model.network.response.ItemApiResponse;
import project.repository.ItemRepository;
import project.repository.PartnerRepository;

@Service
public class ItemApiLogicService extends BaseService<ItemApiRequest, ItemApiResponse, Item>{
    
    @Autowired
    private PartnerRepository partnerRepository;
    
    // @Autowired
    // private ItemRepository itemRepository;
    
    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request){
        ItemApiRequest body = request.getData();
        
        Item item = new Item();
        item.setStatus(body.getStatus());
        item.setName(body.getName());
        item.setTitle(body.getTitle());
        item.setContent(body.getContent());
        item.setPrice(body.getPrice());
        item.setBrandName(body.getBrandName());
        item.setRegisteredAt(body.getRegisteredAt());
        item.setPartner(partnerRepository.getOne(body.getPartnerId()));
        
        Item newItem = baseRepository.save(item);
        
        return response(newItem);   
    }

    @Override 
    public Header<ItemApiResponse> read(Long id){
        return baseRepository.findById(id)
            .map(item->response(item))
            .orElseGet(()->Header.ERROR("데이터없음"));   
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request){
        
        ItemApiRequest body = request.getData();
        
        //map에서 리턴한 객체를 다음 map으로 넘겨줌
        return baseRepository.findById(body.getId())
            .map(entityItem ->{
                entityItem.setStatus(body.getStatus());
                entityItem.setName(body.getName());
                entityItem.setTitle(body.getTitle());
                entityItem.setContent(body.getContent());
                entityItem.setPrice(body.getPrice());
                entityItem.setBrandName(body.getBrandName());
                entityItem.setRegisteredAt(body.getRegisteredAt());
                entityItem.setUnregisteredAt(body.getUnregisteredAt());
                return entityItem;
            })
            .map(newEntityItem ->baseRepository.save(newEntityItem))
            .map(item->response(item))
            .orElseGet(()->Header.ERROR("데이터 없음"));
    }
    
    @Override
    public Header delete(Long id){
        return baseRepository.findById(id)
            .map(item-> {
                baseRepository.delete(item);
                return Header.OK();
            })
            .orElseGet(()->Header.ERROR("데이터 없음"));
    
    }
    
    public Header<ItemApiResponse> response(Item item){
        ItemApiResponse body = new ItemApiResponse();
        
        body.setId(item.getId());
        body.setStatus(item.getStatus());
        body.setName(item.getName());
        body.setTitle(item.getTitle());
        body.setContent(item.getContent());
        body.setPrice(item.getPrice());
        body.setBrandName(item.getBrandName());
        body.setRegisteredAt(item.getRegisteredAt());
        body.setUnregisteredAt(item.getUnregisteredAt());
        body.setPartnerId(item.getPartner().getId());
        body.setRegisteredAt(item.getRegisteredAt());
        body.setUnregisteredAt(item.getUnregisteredAt());
        
        return Header.OK(body);
    }
}