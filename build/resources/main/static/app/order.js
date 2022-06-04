(function ($) {
    // userinfo  
    var user = new Vue({
        el : '#userInfo',
        data : {
            id : "",
            account : "",
            status :"",
            email : "",
            phone_number:"",
            registered_at:"",
            un_registered_at:""
        }
    });
    
    
    // orderGroupList    
    var orderGroupList = new Vue({
        el : '#orderGroupList',
        data : {
            orderGroupList:{}
        }
    });
    
    var orderDetail = new Vue({
        el : '#orderDetail',
        data : {
            orderDetail:{}
        }
    })
    
    
    $('#search').click(function () {
        var id = document.getElementById("id")
        searchStart(id.value, event)
        console.log(id.value)
    });
    
    function searchStart(index, e) {
        e.preventDefault();
        
        $.get("/api/user/"+index+"/orderInfo", function (response) {
            orderGroupList.orderGroupList = response.data.user_api_response.order_group_api_response_list;
            orderDetail.orderDetail = response.data.user_api_response.order_group_api_response_list;
            user.id = response.data.user_api_response.id;
            user.status= response.data.user_api_response.status;
            user.account= response.data.user_api_response.account;
            user.email= response.data.user_api_response.email;
            user.phone_number = response.data.user_api_response.phone_number;
            user.registered_at = response.data.user_api_response.registered_at;
            user.un_registered_at = response.data.user_api_response.un_registered_at;
        })
        
    };
    
    
})(jQuery)