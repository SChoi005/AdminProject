package project.model.enumClass;


public enum ItemStatus{
    
    REGISTERED(0, "등록", "상품 등록 상태"),
    UNREGISTERED(1, "해지", "상품 해지 상태"),
    WAITING(2, "검수(대기)", "상품 검수 상태")
    ;
    
    private Integer id;
    private String title;
    private String description;
    
    ItemStatus(Integer id, String title, String description){
        this.id=id;
        this.title=title;
        this.description=description;
    }
    
    public Integer getId(){return id;}
    public String getTitle(){return title;}
    public String getDescription(){return description;}
    
}