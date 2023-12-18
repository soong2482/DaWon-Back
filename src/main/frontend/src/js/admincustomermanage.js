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
}

function changenumber(id,number){
  var num = document.querySelector(".changenumber"+number).value;
  var returnValue= confirm('순서를 변경 하시겠습니까?');
  if(returnValue==true){
  var AlterForm ={
    id:id,
    number:number,
    num:num
  };
  $.ajax({
    url: "altercustomerupload",
    type: "POST",
    data : AlterForm,
})
.done(function(){
  alert("순서가 변경되었습니다.");
})
}
else{
  alert("순서변경이 취소 되었습니다.")
}
}
function remove(id,number){
  var returnValue= confirm('리뷰를 삭제 하시겠습니까?');
  if(returnValue==true){
    var AlterForm ={
      id:id,
      number:number
    };
    $.ajax({
      url: "removecustomerupload",
      type: "POST",
      data : AlterForm,
  })
  .done(function(){
    alert("삭제가 완료되었습니다.");
  })
  }
  else{
    alert("삭제가 취소되었습니다.")
  }
}