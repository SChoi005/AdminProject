package project.model.front;

public class AdminMenu {

    private String title;
    private String url;
    private String code;
    
    public AdminMenu() {}
    public AdminMenu(String title, String url, String code){
        this.title=title;
        this.url=url;
        this.code=code;
    }
    
    
    public String getTitle(){return title;}
    public String getUrl(){return url;}
    public String getCode(){return code;}
    
    public void setTitle(String title){this.title=title;}
    public void setUrl(String url){this.url=url;}
    public void setCode(String code){this.code=code;}
}
