package project.model.network.response;

import java.util.List;

public class UserOrderInfoApiResponse{
    
    private UserApiResponse userApiResponse;
    
    public UserApiResponse getUserApiResponse(){return userApiResponse;}
    public void setUserApiResponse(UserApiResponse userApiResponse){
        this.userApiResponse=userApiResponse;
    }
    
}