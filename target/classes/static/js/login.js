var input=document.getElementById("upwd");
input.onfocus=function(){
    this.type="password";
}
var span=document.querySelector(".border_box span");
var key=1;
span.onclick=function(){
    if(key==1){
    this.className="iconfont icon-yanjing1";
    input.type="text";
    key=0;
    }else{
        this.className="iconfont icon-yanjing";
        input.type="password";
        key=1;
    }
}
