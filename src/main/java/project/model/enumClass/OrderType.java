package project.model.enumClass;


public enum OrderType{
    
    ALL(0, "묶음", "모든 상품을 묶음 발송"),
    EACH(1, "개별", "모든 상품을 준비되는대로 발송")
    ;
    
    private Integer id;
    private String title;
    private String description;
    
    OrderType(Integer id, String title, String description){
        this.id=id;
        this.title=title;
        this.description=description;
    }
    
    Integer getId(){return id;}
    String getTitle(){return title;}
    String getDescription(){return description;}
}