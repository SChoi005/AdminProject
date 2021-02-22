package project.model.network.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import project.model.enumClass.ItemStatus;

public class ItemApiResponse{
    private Long id;
    
    private ItemStatus status;
    
    private String name;
    
    private String title;
    
    private String content;
    
    private BigDecimal price;
    
    private String brandName;
    
    private LocalDateTime registeredAt;
    
    private LocalDateTime unregisteredAt;

    private Long partnerId;
    
    public ItemApiResponse() {}
    
    public Long getId(){ return id; }
    public ItemStatus getStatus(){return status;}
    public String getName(){ return name; }
    public String getTitle(){return title;}
    public String getBrandName(){return brandName;}
    public BigDecimal getPrice(){ return price; }
    public String getContent(){ return content; }
    public LocalDateTime getRegisteredAt(){return registeredAt;}
    public LocalDateTime getUnregisteredAt(){return unregisteredAt;}
    public Long getPartnerId(){return partnerId;}
    
    public void setId(Long id){ this.id = id; }
    public void setStatus(ItemStatus status){this.status=status;}
    public void setName(String name) { this.name = name; }
    public void setTitle(String title){this.title=title;}
    public void setBrandName(String brandName){this.brandName=brandName;}
    public void setPrice(BigDecimal price){ this.price = price; }
    public void setContent(String content){ this.content = content; }
    public void setRegisteredAt(LocalDateTime registeredAt){this.registeredAt=registeredAt;}
    public void setUnregisteredAt(LocalDateTime unregisteredAt){this.unregisteredAt=unregisteredAt;}
    public void setPartnerId(Long partnerId){this.partnerId=partnerId;}
}