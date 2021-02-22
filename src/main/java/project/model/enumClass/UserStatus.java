package project.model.enumClass;

public enum UserStatus{
    // id, title, description 순
    REGISTERED(0, "등록", "사용자 등록상태"),
    UNREGISTERED(1, "해지", "사용자 해지상태")
    ;
    
    private Integer id;
    private String title;
    private String description;
    
    UserStatus(){}
    UserStatus(Integer id, String title, String description){
        this.id=id;
        this.title=title;
        this.description=description;
    }
    
    Integer getId(){return id;}
    String getTitle(){return title;}
    String getDescription(){return description;}
}