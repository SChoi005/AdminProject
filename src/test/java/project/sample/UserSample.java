package project.sample;

import project.ApplicationTests;
import project.model.entity.AdminUser;
import project.model.entity.User;
import project.model.enumClass.*;
import project.repository.AdminUserRepository;
import project.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Random;

public class UserSample extends ApplicationTests {

    private Random random;

    @Autowired
    private UserRepository userRepository;

    //@Test
    public void sampleCreate(){

        random = new Random();

        for(int i = 1 ; i < 1001; i++){
            // 가입 상태 랜덤
            int div = (random.nextInt(10)+1) % 2;
            UserStatus status = (div == 0 ? UserStatus.REGISTERED : UserStatus.UNREGISTERED);

            User user = new User();
            user.setAccount("TestUser"+i);
            user.setPassword("password"+i);
            user.setStatus(status);
            user.setEmail("TestUser"+i+"@gmail.com");
            user.setPhoneNumber("010-1111-"+String.format("%04d", i));
            user.setRegisteredAt(getRandomDate());
            user.setUnRegisteredAt(status.equals(UserStatus.UNREGISTERED) ? getRandomDate() : null );
            userRepository.save(user);
        }


    }


    private LocalDateTime getRandomDate(){
        return LocalDateTime.of(2019,getRandomNumber(),getRandomNumber(),getRandomNumber(),getRandomNumber(),getRandomNumber());
    }

    private int getRandomNumber(){
        return random.nextInt(11)+1;
    }
}
