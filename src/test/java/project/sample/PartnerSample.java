package project.sample;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import project.ApplicationTests;
import project.model.entity.Category;
import project.model.entity.Partner;
import project.repository.CategoryRepository;
import project.repository.PartnerRepository;

public class PartnerSample extends ApplicationTests {

    private Random random;

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //@Test
    public void sampleCreate(){
        random = new Random();
        List<Category> categoryList = categoryRepository.findAll();

        for(int i = 0; i < categoryList.size(); i++){
            Category category = categoryList.get(i);

            for(int j = 1; j < 10; j++){

                // 가입 상태 랜덤
                int div = (random.nextInt(10)+1) % 2;
                String status = (div == 0 ? "REGISTERED" : "UNREGISTERED");

                Partner partner = new Partner();
                partner.setCategory(category);
                partner.setName(category.getTitle()+j+" 호점");
                partner.setStatus(status);
                partner.setAddress("서울시 강남구 "+j+"번길"+random.nextInt(100)+1+"호");
                partner.setCallCenter("070-"+String.format("%04d", random.nextInt(100)+1)+"-"+String.format("%04d", random.nextInt(100)+1));
                partner.setPartnerNumber("010-1111-"+String.format("%04d", i));
                partner.setBusinessNumber((random.nextInt(999999999)+1)+""+j);
                partner.setCeoName(j+" 대표");
                partner.setRegisteredAt(getRandomDate());
                partner.setUnregisteredAt(status.equals("UNREGISTERED") ? getRandomDate() : null );

                partnerRepository.save(partner);
            }
        }
    }


    private LocalDateTime getRandomDate(){
        return LocalDateTime.of(2019,getRandomNumber(),getRandomNumber(),getRandomNumber(),getRandomNumber(),getRandomNumber());
    }

    private int getRandomNumber(){
        return random.nextInt(11)+1;
    }
}
