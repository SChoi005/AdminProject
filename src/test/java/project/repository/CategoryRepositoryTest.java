package project.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import project.ApplicationTests;
import project.model.entity.*;

public class CategoryRepositoryTest extends ApplicationTests{
    @Autowired
    private CategoryRepository categoryRepository;
    
    
    //@Test
    public void create(){
        String type = "computer";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        
        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);
        
        Category newCategory = categoryRepository.save(category);
        
        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(), type);
        Assert.assertEquals(newCategory.getTitle(), title);
    }
    
    
    //@Test
    public void read(){
        //유일하지않으면 오류뜸
        Optional<Category> optionalCategory = categoryRepository.findByType("computer");
        optionalCategory.ifPresent(c -> {
            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });
    }
}