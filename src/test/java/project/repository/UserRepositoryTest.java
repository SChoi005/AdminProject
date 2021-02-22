package project.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import project.ApplicationTests;
import project.model.entity.*;
import project.model.enumClass.UserStatus;

public class UserRepositoryTest extends ApplicationTests{

    //직접객체를 만들지않고 스프링이 직접관리를하고 의존성을 주입시켜주겠다 -> Dependency Injection(DI)
    @Autowired
    private UserRepository userRepository;
    
    //@Test
    public void create(){
        String account = "Test03";
        String password = "Test03";
        UserStatus status = UserStatus.REGISTERED;
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt= LocalDateTime.now();
        LocalDateTime createdAt=LocalDateTime.now();
        String createdBy = "AdminServer";
        
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        // user.setCreatedAt(createdAt);
        // user.setCreatedBy(createdBy);
        
        User newUser = userRepository.save(user);
        
        Assert.assertNotNull(newUser);
    }
    
    // @Test
    // @Transactional
    public void read(){
        //nullpointer 이거 뜨면 Optional로 설정해줘야함
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        
        user.getOrderGroupList().stream().forEach(orderGroup->{
            
            System.out.println("-----------주문묶음------------");
            
            System.out.println("수령인 : "+orderGroup.getRevName());
            System.out.println("수령지 : "+orderGroup.getRevAddress());
            System.out.println("총금액 : "+orderGroup.getTotalPrice());
            System.out.println("총수량 : "+orderGroup.getTotalQuantity());
            
            System.out.println("-----------주문상세------------");
            
            orderGroup.getOrderDetailList().forEach(orderDetail->{
                System.out.println("파트너사 이름 : "+orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리 : "+orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문상품 : "+orderDetail.getItem().getName()
);
                System.out.println("고객센터 번호 : "+orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태 : "+orderDetail.getStatus());
                System.out.println("도착예정일자 : "+orderDetail.getArrivalDate());
                
            });
            
        });
        Assert.assertNotNull(user);
    } 
    
    //@Test
    public void update(){ 
        Optional<User> user = userRepository.findById(2L); //Type이 Long이기때문에 
        
        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");
            userRepository.save(selectUser);
        });
        
    }
    
    //@Test
    //@Transactional // 롤백 어노테이션
    public void delete(){
        Optional<User> user = userRepository.findById(3L); //Type이 Long이기때문에 
        Assert.assertTrue(user.isPresent()); //true
        
        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });
        
        Optional<User> deleteUser = userRepository.findById(3L);
        
        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : " + deleteUser.get());
        }
        else{
            System.out.println("데이터 삭제 데이터 없음");
        }
        
        Assert.assertFalse(deleteUser.isPresent()); //true

    }
}