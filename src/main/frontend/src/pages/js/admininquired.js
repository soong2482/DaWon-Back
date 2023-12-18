var target = document.querySelectorAll('.btn_open');
var btnPopClose = document.querySelectorAll('.pop_wrap .btn_close');
var targetID;

// 팝업 열기
for(var i = 0; i < target.length; i++){
  target[i].addEventListener('click', function(){
    targetID = this.getAttribute('field');

    document.querySelector("#"+targetID).style.display = 'block';
  });
}

// 팝업 닫기
for(var j = 0; j < target.length; j++){
  btnPopClose[j].addEventListener('click', function(){
    this.parentNode.parentNode.style.display = 'none';
  });
}``

function done(id){
    var returnValue= confirm('완료처리 하시겠습니까?');
    if(returnValue==true){
        var inquired={
            id:id
        };
        $.ajax({
            url: "inquired/done",
            type: "POST",
            data : inquired,

        })
        .done(function(){
          alert("완료처리되었습니다.");
        })
    }
 }
 function remove(id){
 var returnValue= confirm('삭제 하시겠습니까?');
  if(returnValue==true){
     var inquired={
         id: id
     };
     $.ajax({
         url: "inquired/delete",
         type: "POST",
         data : inquired,
     })
     .done(function(){
       alert("삭제 성공");
      })
   }
 }
