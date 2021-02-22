package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.ifs.CrudInterface;
import project.model.entity.OrderGroup;
import project.model.network.Header;
import project.model.network.request.OrderGroupApiRequest;
import project.model.network.response.OrderGroupApiResponse;
import project.repository.OrderGroupRepository;
import project.repository.UserRepository;

@Service
public class OrderGroupLogicService extends BaseService<OrderGroupApiRequest,OrderGroupApiResponse, OrderGroup>{
    
    // @Autowired
    // private OrderGroupRepository orderGroupRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request){
        
        OrderGroupApiRequest body = request.getData();
        OrderGroup orderGroup = new OrderGroup();
        
        orderGroup.setStatus(body.getStatus());
        orderGroup.setOrderType(body.getOrderType());
        orderGroup.setRevAddress(body.getRevAddress());
        orderGroup.setRevName(body.getRevName());
        orderGroup.setPaymentType(body.getPaymentType());
        orderGroup.setTotalPrice(body.getTotalPrice());
        orderGroup.setTotalQuantity(body.getTotalQuantity());
        orderGroup.setOrderAt(body.getOrderAt());
        orderGroup.setArrivalDate(body.getArrivalDate());
        orderGroup.setUser(userRepository.getOne(body.getUserId()));
        
        OrderGroup newOrderGroup = baseRepository.save(orderGroup);
        
        return response(newOrderGroup);
    }
    
    @Override
    public Header<OrderGroupApiResponse> read(Long id){

        return baseRepository.findById(id)
            .map(orderGroup -> response(orderGroup))
            .orElseGet(()->Header.ERROR("데이터없음"));
    }
    
    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request){
        OrderGroupApiRequest body = request.getData();
        
        return baseRepository.findById(body.getId())
            .map(orderGroup->{
                orderGroup.setStatus(body.getStatus());
                orderGroup.setOrderType(body.getOrderType());
                orderGroup.setRevAddress(body.getRevAddress());
                orderGroup.setRevName(body.getRevName());
                orderGroup.setPaymentType(body.getPaymentType());
                orderGroup.setTotalPrice(body.getTotalPrice());
                orderGroup.setTotalQuantity(body.getTotalQuantity());
                orderGroup.setOrderAt(body.getOrderAt());
                orderGroup.setArrivalDate(body.getArrivalDate());
                orderGroup.setUser(userRepository.getOne(body.getUserId()));
                return orderGroup;
            })
            .map(changeOrderGroup -> baseRepository.save(changeOrderGroup))
            .map(newOrderGroup -> response(newOrderGroup))
            .orElseGet(()->Header.ERROR("데이터 없음"));
        
    }
    
    @Override
    public Header delete(Long id){
        return baseRepository.findById(id)
            .map(orderGroup->{
                baseRepository.delete(orderGroup);
                return Header.OK();
            })
            .orElseGet(()->Header.ERROR("데이터없음"));
    }
    
    public Header<OrderGroupApiResponse> response(OrderGroup orderGroup){
        
        
        OrderGroupApiResponse body = new OrderGroupApiResponse();
        body.setId(orderGroup.getId());
        body.setStatus(orderGroup.getStatus());
        body.setOrderType(orderGroup.getOrderType());
        body.setRevAddress(orderGroup.getRevAddress());
        body.setRevName(orderGroup.getRevName());
        body.setPaymentType(orderGroup.getPaymentType());
        body.setTotalPrice(orderGroup.getTotalPrice());
        body.setTotalQuantity(orderGroup.getTotalQuantity());
        body.setOrderAt(orderGroup.getOrderAt());
        body.setArrivalDate(orderGroup.getArrivalDate());
        body.setUserId(orderGroup.getUser().getId());
        
        
        return Header.OK(body);
    }
}