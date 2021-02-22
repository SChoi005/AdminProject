package project.sample;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import project.ApplicationTests;
import project.model.entity.Category;
import project.repository.CategoryRepository;

public class CategorySample extends ApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;


    //@Test
    public void createSample(){
        List<String> category = Arrays.asList("COMPUTER","CLOTHING","MULTI_SHOP","INTERIOR","FOOD","SPORTS","SHOPPING_MALL","DUTY_FREE","BEAUTY");
        List<String> title = Arrays.asList("컴퓨터-전자제품","의류","멀티샵","인테리어","음식","스포츠","쇼핑몰","면세점","화장");

        for(int i = 0; i < category.size(); i++){
            String c = category.get(i);
            String t = title.get(i);
            Category create = new Category();
            create.setType(c);
            create.setTitle(t);

            categoryRepository.save(create);
        }


    }

}