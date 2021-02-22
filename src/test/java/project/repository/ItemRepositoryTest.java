package project.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import project.ApplicationTests;
import project.model.entity.Item;
import project.model.enumClass.ItemStatus;

public class ItemRepositoryTest extends ApplicationTests{
    
    @Autowired
    private ItemRepository itemRepository;
    
    //@Test
    public void create(){
        Item item = new Item();
        item.setStatus(ItemStatus.UNREGISTERED);
        item.setName("삼성 노트북");
        item.setTitle("삼성 노트북 A100");
        item.setPrice(new BigDecimal(900000));
        item.setContent("2019년형 노트북 입니다.");
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        //item.setPartnerId(1L);
        
        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
        
    }

    //@Test
    public void read(){
        Long id = 1L;
        Optional<Item> item = itemRepository.findById(id);
        
        Assert.assertTrue(item.isPresent()); //optional일때 사용
        
        item.ifPresent(i->{
           System.out.println(i); 
        });
    }
    
}

