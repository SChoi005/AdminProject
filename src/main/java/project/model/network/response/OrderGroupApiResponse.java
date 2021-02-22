package project.model.network.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import project.model.enumClass.OrderType;

public class OrderGroupApiResponse {
    
    private Long id;
    private String status;
    private OrderType orderType; //주문의 형태 - 일괄/개별
    private String revAddress;
    private String revName;
    private String paymentType; //카드/현금
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;
    private Long userId;
    private List<ItemApiResponse> itemApiResponseList;
    
    public OrderGroupApiResponse() {}
    
    public Long getId() { return id; }
    public String getStatus(){return status;}
    public OrderType getOrderType(){return orderType;}
    public String getRevAddress(){return revAddress;}
    public String getRevName(){return revName;}
    public String getPaymentType(){return paymentType;}
    public BigDecimal getTotalPrice(){return totalPrice;}
    public Integer getTotalQuantity(){return totalQuantity;}
    public LocalDateTime getOrderAt(){return orderAt;}
    public LocalDateTime getArrivalDate(){return arrivalDate;}
    public Long getUserId(){return userId;}
    public List<ItemApiResponse> getItemApiResponseList(){return itemApiResponseList;}
    
    public void setId(Long id) { this.id = id; }
    public void setStatus(String status){this.status=status;}
    public void setOrderType(OrderType orderType){this.orderType=orderType;}
    public void setRevAddress(String revAddress){this.revAddress=revAddress;}
    public void setRevName(String revName){this.revName=revName;}
    public void setPaymentType(String paymentType){this.paymentType=paymentType;}
    public void setTotalPrice(BigDecimal totalPrice){this.totalPrice=totalPrice;}
    public void setTotalQuantity(Integer totalQuantity){this.totalQuantity=totalQuantity;}
    public void setOrderAt(LocalDateTime orderAt){this.orderAt=orderAt;}
    public void setArrivalDate(LocalDateTime arrivalDate){this.arrivalDate=arrivalDate;}
    public void setUserId(Long userId){this.userId=userId;}
    public void setItemApiResponseList(List<ItemApiResponse> itemApiResponseList){this.itemApiResponseList=itemApiResponseList;}
}