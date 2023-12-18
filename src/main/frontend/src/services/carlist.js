function requestpost(name,sort){
    var data = name.split(' ');
    var datalink= "";
    for(var i=0; i<data.length; i++){
    if(i==data.length-1){
        datalink += data[i];
    }
    else{
    datalink += data[i]+"+";
    }
    }
    location.href="request?name="+datalink+"&sort="+sort;

    }