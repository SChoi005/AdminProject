package project.model.network.request;

import java.time.LocalDateTime;

public class PartnerApiRequest{
    private Long id;
    private String name;
    private String status;
    private String address;
    private String callCenter;
    private String partnerNumber;
    private String businessNumber;
    private String ceoName;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private Long categoryId;
    
    public PartnerApiRequest() {}
    
    public Long getId() {return id;}  
    public String getName(){return name;}
    public String getStatus(){return status;}
    public String getAddress(){return address;}
    public String getCallCenter(){return callCenter;}
    public String getPartnerNumber(){return partnerNumber;}
    public String getbusinessNumber(){return businessNumber;}
    public String getCeoName(){return ceoName;}
    public LocalDateTime getRegisteredAt(){return registeredAt;}
    public LocalDateTime getUnregisteredAt(){return unregisteredAt;}
    public Long getCategoryId(){return categoryId;}
    
    public void setId(Long id) {this.id=id;}  
    public void setName(String name){this.name=name;}
    public void setStatus(String status){this.status=status;}
    public void setAddress(String address){this.address=address;}
    public void setCallCenter(String callCenter){this.callCenter=callCenter;}
    public void setPartnerNumber(String partnerNumber){this.partnerNumber=partnerNumber;}
    public void setBusinessNumber(String businessNumber){this.businessNumber=businessNumber;}
    public void setCeoName(String ceoName){this.ceoName=ceoName;}
    public void setRegisteredAt(LocalDateTime registeredAt){this.registeredAt=registeredAt;}
    public void setUnregisteredAt(LocalDateTime unregisteredAt){this.unregisteredAt=unregisteredAt;}
    public void setCategoryId(Long categoryId){this.categoryId=categoryId;}
}