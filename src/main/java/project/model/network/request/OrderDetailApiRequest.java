package project.model.network.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailApiRequest{
    private Long id;
    private String status;
    private LocalDateTime arrivalDate;
    private Integer quantity;
    private BigDecimal totalPrice;
    private Long itemId;
    private Long orderGroupId;
    
    public OrderDetailApiRequest(){}
    
    public Long getId() { return id; }
    public String getStatus(){return status;}
    public LocalDateTime getArrivalDate(){return arrivalDate;}
    public Integer getQuantity(){return quantity;}
    public BigDecimal getTotalPrice(){return totalPrice;}
    public Long getItemId(){return itemId;}
    public Long getOrderGroupId(){return orderGroupId;}
    
    public void setId(Long id) { this.id = id; }
    public void setStatus(String status){this.status=status;}
    public void setArrivalDate(LocalDateTime arrivalDate){this.arrivalDate=arrivalDate;}
    public void setQuantity(Integer quantity){this.quantity=quantity;}
    public void setTotalPrice(BigDecimal totalPrice){this.totalPrice=totalPrice;}
    public void setItemId(Long itemId){this.itemId=itemId;}
    public void setOrderGroupId(Long orderGroupId){this.orderGroupId=orderGroupId;}
}