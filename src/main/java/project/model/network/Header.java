package project.model.network;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Header<T>{
    
    //api 통신 시간
    //@JsonProperty("transaction_time") // snakecase로 이름 변환
    private LocalDateTime transactionTime;
    
    //api 응답 코드
    private String resultCode;
    
    //api 부가 설명
    private String description;
    
    private T data;

    private Pagination pagination;
    
    // OK
    public static <T> Header<T> OK(){
        Header header = new Header();
        header.setTransactionTime(LocalDateTime.now());
        header.setResultCode("OK");
        header.setDescription("OK");
        
        return (Header<T>)header;
    }
    
    // Data OK
    public static <T> Header<T> OK(T data){
        Header header = new Header();
        header.setTransactionTime(LocalDateTime.now());
        header.setResultCode("OK");
        header.setDescription("OK");
        header.setData(data);
        
        return (Header<T>)header;
    }
    
    public static <T> Header<T> OK(T data, Pagination pagination){
        Header header = new Header();
        header.setTransactionTime(LocalDateTime.now());
        header.setResultCode("OK");
        header.setDescription("OK");
        header.setData(data);
        header.setPagination(pagination);
        return (Header<T>)header;
    }
    
    
    // Error
    public static <T> Header<T> ERROR(String description){
        Header header = new Header();
        header.setTransactionTime(LocalDateTime.now());
        header.setResultCode("ERROR");
        header.setDescription(description);
        
        return (Header<T>)header;
    }
    
    
    
    public Header(){}

    public LocalDateTime getTransactionTime(){return transactionTime;}
    public String getResultCode(){return resultCode;}
    public String getDescription(){return description;}
    public T getData(){return data;}
    public Pagination getPagination(){return pagination;}
    
    public void setTransactionTime(LocalDateTime transactionTime){this.transactionTime=transactionTime;}
    public void setResultCode(String resultCode){this.resultCode=resultCode;}
    public void setDescription(String description){this.description=description;}
    public void setData(T data){this.data=data;}
    public void setPagination(Pagination pagination){this.pagination=pagination;}
}