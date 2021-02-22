package project.model.network.response;

public class CategoryApiResponse{
    
    private Long id;
    
    private String type;
    
    private String title;
    
    public CategoryApiResponse() {};
    
    public Long getId() { return id; }
    public String getType(){return type;}
    public String getTitle(){return title;}
    
    public void setId(Long id) { this.id=id;}
    public void setType(String type){this.type=type;}
    public void setTitle(String title){this.title=title;}
}