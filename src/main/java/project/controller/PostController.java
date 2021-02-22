package project.controller;

import org.springframework.web.bind.annotation.*;
import project.model.SearchParam;

@RestController
@RequestMapping("/api") //클래스에대한 RequestMapping은 주소가 겹쳐도된다 메소드는 안됨
public class PostController{
    
    //HTML의 form태그사용, ajax 검색때 사용 --> 검색파라미터가 많을때
    //http post body -> data
    //rest client 크롬 확장프로그램 설치
    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }

}