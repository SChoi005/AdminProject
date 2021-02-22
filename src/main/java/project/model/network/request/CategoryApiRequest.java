package project.model.network.request;

public class CategoryApiRequest{
    
    private Long id;
    
    private String type;
    
    private String title;
    
    public CategoryApiRequest() {};
    
    public Long getId() { return id; }
    public String getType(){return type;}
    public String getTitle(){return title;}
    
    public void setId(Long id) { this.id=id;}
    public void setType(String type){this.type=type;}
    public void setTitle(String title){this.title=title;}
}