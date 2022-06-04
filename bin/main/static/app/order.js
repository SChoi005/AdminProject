(function ($) {

    var user = {
        id : 0,
        account : "",
        email : "",
    }
    
    
    // userinfo    
    var userInfo = new Vue({
        el : '#userInfo',
        data : {
            userInfo:{}
        }
    });
    
    $('#search').click(function () {
        var account = document.getElementById("account")
        searchStart(account.value)
        console.log(account.value)
    });
    
    function searchStart(index) {
        $.get("/api/user/"+index+"/orderInfo", function (response) {
            user = response.data.user_api_response;
            
        })
    };
    
    
})(jQuery)