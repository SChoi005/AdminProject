package project.service;

import org.springframework.stereotype.Service;

import project.ifs.CrudInterface;
import project.model.network.request.CategoryApiRequest;
import project.model.network.response.CategoryApiResponse;
import project.model.entity.Category;
import project.model.network.Header;
import org.springframework.beans.factory.annotation.Autowired;
import project.repository.CategoryRepository;

@Service
public class CategoryApiLogicService extends BaseService<CategoryApiRequest, CategoryApiResponse, Category>{
    
    // @Autowired
    // CategoryRepository categoryRepository;
    
    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request){
        CategoryApiRequest body = request.getData();
        Category category = new Category();
        
        category.setTitle(body.getTitle());
        category.setType(body.getType());
        
        Category newCategory = baseRepository.save(category);
        
        return response(newCategory);
    }
    
    @Override
    public Header<CategoryApiResponse> read(Long id){
        return baseRepository.findById(id)
            .map(category->response(category))
            .orElseGet(()->Header.ERROR("데이터 없음"));
    }
    
    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request){
        CategoryApiRequest body = request.getData();
        
        return baseRepository.findById(body.getId())
            .map(category->{
                category.setTitle(body.getTitle());
                category.setType(body.getType());
                return category;
            })
            .map(changeCategory->baseRepository.save(changeCategory))
            .map(newCategory->response(newCategory))
            .orElseGet(()->Header.ERROR("데이터 없음"));
    }
    
    @Override
    public Header delete(Long id){
        return baseRepository.findById(id)
            .map(category->{
                baseRepository.delete(category);
                return Header.OK();
            })
            .orElseGet(()->Header.ERROR("데이터 없음"));
    }
    
    public Header<CategoryApiResponse> response(Category category){
        CategoryApiResponse body = new CategoryApiResponse();
        body.setId(category.getId());
        body.setTitle(category.getTitle());
        body.setType(category.getType());
        
        return Header.OK(body);
    }
    
}