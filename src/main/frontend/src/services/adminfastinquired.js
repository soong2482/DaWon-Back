function done(id){
    var returnValue= confirm('완료처리 하시겠습니까?');
    if(returnValue==true){
        var Fastinquired={
            id:id
        };
        $.ajax({
            url: "fastinquired/done",
            type: "POST",
            data : Fastinquired,

        })
        .done(function(){
          alert("완료처리되었습니다.");
        })
    }
 }
 function remove(id){
 var returnValue= confirm('삭제 하시겠습니까?');
  if(returnValue==true){
     var Fastinquired={
         id: id
     };
     $.ajax({
         url: "fastinquired/delete",
         type: "POST",
         data : Fastinquired,
     })
     .done(function(){
       alert("삭제 성공");
      })
   }
 }
