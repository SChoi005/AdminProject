package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.ifs.CrudInterface;
import project.model.network.request.OrderDetailApiRequest;
import project.model.network.response.OrderDetailApiResponse;
import project.repository.ItemRepository;
import project.repository.OrderDetailRepository;
import project.repository.OrderGroupRepository;
import project.model.entity.OrderDetail;
import project.model.network.Header;

@Service
public class OrderDetailApiLogicService extends BaseService<OrderDetailApiRequest,OrderDetailApiResponse, OrderDetail>{
    
    // @Autowired
    // private OrderDetailRepository orderDetailRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Autowired
    private OrderGroupRepository orderGroupRepository;
    
    @Override
    public Header<OrderDetailApiResponse> create(Header<OrderDetailApiRequest> request){
        
        OrderDetailApiRequest body  = request.getData();
        
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setStatus(body.getStatus());
        orderDetail.setArrivalDate(body.getArrivalDate());
        orderDetail.setQuantity(body.getQuantity());
        orderDetail.setTotalPrice(body.getTotalPrice());
        orderDetail.setItem(itemRepository.getOne(body.getItemId()));
        orderDetail.setOrderGroup(orderGroupRepository.getOne(body.getOrderGroupId()));
        
        OrderDetail newOrderDetail = baseRepository.save(orderDetail);
        
        return response(newOrderDetail);
    }
    
    @Override
    public Header<OrderDetailApiResponse> read(Long id){
        
        return baseRepository.findById(id)
            .map(orderDetail->response(orderDetail))
            .orElseGet(()->Header.ERROR("데이터 없음"));
    }
    
    @Override
    public Header<OrderDetailApiResponse> update(Header<OrderDetailApiRequest> request){
        OrderDetailApiRequest body = request.getData();
        return baseRepository.findById(body.getId())
            .map(orderDetail->{
                orderDetail.setStatus(body.getStatus());
                orderDetail.setArrivalDate(body.getArrivalDate());
                orderDetail.setQuantity(body.getQuantity());
                orderDetail.setTotalPrice(body.getTotalPrice());
                orderDetail.setItem(itemRepository.getOne(body.getItemId()));
                orderDetail.setOrderGroup(orderGroupRepository.getOne(body.getOrderGroupId()));
                return orderDetail;
            })
            .map(changeOrderDetail->baseRepository.save(changeOrderDetail))
            .map(newOrderDetail->response(newOrderDetail))
            .orElseGet(()->Header.ERROR("데이터 없음"));
    }
    
    @Override
    public Header delete(Long id){
        return baseRepository.findById(id)
            .map(orderDetail->{
                baseRepository.delete(orderDetail);
                return Header.OK();
            })
            .orElseGet(()->Header.ERROR("데이터 없음"));
    }


    public Header<OrderDetailApiResponse> response(OrderDetail orderDetail){
        OrderDetailApiResponse body = new OrderDetailApiResponse();
        body.setId((orderDetail.getId()));
        body.setStatus(orderDetail.getStatus());
        body.setArrivalDate(orderDetail.getArrivalDate());
        body.setQuantity(orderDetail.getQuantity());
        body.setTotalPrice(orderDetail.getTotalPrice());
        body.setItemId(orderDetail.getItem().getId());
        body.setOrderGroupId(orderDetail.getOrderGroup().getId());
        
        return Header.OK(body);
    }
}