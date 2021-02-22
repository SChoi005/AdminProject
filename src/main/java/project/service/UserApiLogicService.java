package project.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import project.model.entity.OrderGroup;
import project.model.entity.User;
import project.model.enumClass.UserStatus;
import project.model.network.Header;
import project.model.network.Pagination;
import project.model.network.request.UserApiRequest;
import project.model.network.response.ItemApiResponse;
import project.model.network.response.OrderGroupApiResponse;
import project.model.network.response.UserApiResponse;
import project.model.network.response.UserOrderInfoApiResponse;
import project.repository.UserRepository;

@Service
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User>{
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OrderGroupLogicService orderGroupLogicService;
    
    @Autowired
    private ItemApiLogicService itemApiLogicService;
    
    //1. request data 가져오기
    //2. user 생성
    //3. 생성된 데이터 -> UserApiResponse return
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request){
        
        // 1. request data 가져오기
        UserApiRequest userApiRequest = request.getData();
        
        // 2. user 생성
        User user = new User();
        user.setAccount(userApiRequest.getAccount());
        user.setPassword(userApiRequest.getPassword());
        user.setStatus(UserStatus.REGISTERED);
        user.setPhoneNumber(userApiRequest.getPhoneNumber());
        user.setEmail(userApiRequest.getEmail());
        user.setRegisteredAt(LocalDateTime.now());
        
        User newUser = baseRepository.save(user);
        
        //3. 생성된 데이터 -> UserApiResponse return
        
        return Header.OK(response(newUser));
    }
    
    @Override
    public Header<UserApiResponse> read(Long id){
        
        // id -> respository getOne, getById
        Optional<User> optional = baseRepository.findById(id);
        
        // user -> userApiResponse return
        return optional
            .map(user -> response(user)) //있을때
            .map(userApiResponse->Header.OK(userApiResponse))
            .orElseGet(()->Header.ERROR("데이터없음")); //없을떄      
    }
    
    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request){
        
        //1.data
        UserApiRequest userApiRequest = request.getData();
        
        //2.id->user데이터를 찾고
        Optional<User> optional = baseRepository.findById(userApiRequest.getId());
        
        return optional.map(user ->{
            //3.update
            user.setAccount(userApiRequest.getAccount());
            user.setPassword(userApiRequest.getPassword());
            user.setStatus(userApiRequest.getStatus());
            user.setPhoneNumber(userApiRequest.getPhoneNumber());
            user.setEmail(userApiRequest.getEmail());
            user.setRegisteredAt(userApiRequest.getRegisteredAt());
            user.setUnRegisteredAt(userApiRequest.getUnRegisteredAt());
            
            return user;

        })
        .map(user -> baseRepository.save(user)) //update ->newUser
        .map(updateUser -> response(updateUser))            //userApiResponse
        .map(user -> Header.OK(user))
        .orElseGet(()->Header.ERROR("데이터없음"));
    }
    
    @Override
    public Header delete(Long id){
        // id -> repository -> user
        Optional<User> optional = baseRepository.findById(id);
        
        
        // repository -> delete
        return optional.map(user->{
            baseRepository.delete(user);
            return Header.OK();
        })
        .orElseGet(()->Header.ERROR("데이터 없음"));
        
    }
    
    private UserApiResponse response(User user){
        //user->userApiResponse
        
        UserApiResponse userApiResponse = new UserApiResponse();
        
        userApiResponse.setId(user.getId());
        userApiResponse.setAccount(user.getAccount());
        userApiResponse.setPassword(user.getPassword());
        userApiResponse.setEmail(user.getEmail());
        userApiResponse.setPhoneNumber(user.getPhoneNumber());
        userApiResponse.setStatus(user.getStatus());
        userApiResponse.setRegisteredAt(user.getRegisteredAt());
        userApiResponse.setUnRegisteredAt(user.getUnRegisteredAt());

        //Header + data return
        
        return userApiResponse;
    }
    
    public Header<List<UserApiResponse>> search(Pageable pageable){
        
        Page<User> users = userRepository.findAll(pageable);
        
        List<UserApiResponse> userApiResponseList = users.stream()
            .map(user->response(user))
            .collect(Collectors.toList());
        
        Pagination pagination = new Pagination();
        
        pagination.setTotalPages(users.getTotalPages());
        pagination.setTotalElements(users.getTotalElements());
        pagination.setCurrentPage(users.getNumber());
        pagination.setCurrentElements(users.getNumberOfElements());
        
        return Header.OK(userApiResponseList,pagination);
    }
    
    public Header<UserOrderInfoApiResponse> orderInfo(Long id){
        
        User user = userRepository.getOne(id);
        
        UserApiResponse userApiResponse = response(user);
        
        
        List<OrderGroup> orderGroupList = user.getOrderGroupList();
        List<OrderGroupApiResponse> orderGroupApiResponseList = orderGroupList.stream()
            .map(orderGroup->{
                OrderGroupApiResponse orderGroupApiResponse = orderGroupLogicService.response(orderGroup).getData();
                
                List<ItemApiResponse> itemApiResponseList = orderGroup.getOrderDetailList().stream()
                    .map(detail->detail.getItem())
                    .map(item-> itemApiLogicService.response(item).getData())
                    .collect(Collectors.toList());
                
                orderGroupApiResponse.setItemApiResponseList(itemApiResponseList);
                return orderGroupApiResponse;
            })
            .collect(Collectors.toList());
        
        userApiResponse.setOrderGroupAPiResponseList(orderGroupApiResponseList);
        UserOrderInfoApiResponse userOrderInfoApiResponse = new UserOrderInfoApiResponse();
        userOrderInfoApiResponse.setUserApiResponse(userApiResponse);
        
        return Header.OK(userOrderInfoApiResponse);
    }
}