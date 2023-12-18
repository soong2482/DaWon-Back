var lease = document.getElementById('lease');
var rental = document.getElementById('rental');
var Target = document.getElementById('clock');
  function clock() {
                 var time = new Date();
                 var year =time.getFullYear();
                 var month = time.getMonth();
                 var date = time.getDate();
                 var day = time.getDay();


                 var hours = time.getHours();
                 var minutes = time.getMinutes();
                 var seconds = time.getSeconds();

                 Target.value =
                 `${year}.${month + 1}.${date} `+
                 `${hours < 10 ? `0${hours}` : hours}:${minutes < 10 ? `0${minutes}` : minutes}:${seconds < 10 ? `0${seconds}` : seconds}`;

             }
$('#lease').click(function(){
    var checked = $('#lease').is(':checked');

    if(checked)
        $('#rental').prop('checked',false);
});
$('#rental').click(function(){
    var checked = $('#rental').is(':checked');

    if(checked)
        $('#lease').prop('checked',false);
});

function doum(){
var returnValue= confirm('문의신청을 하시겠습니까?');
    if(returnValue==true){
var choice;
    var auth = document.getElementById('auth').value;
    var checked = $('#rental').is(':checked');
    var checked2 = $('#lease').is(':checked');
    var agreecheck = $('#auth').is(':checked');
    const name= document.getElementById('name').value;
    const phone = document.getElementById('phone').value;
    const carsort = document.getElementById('carsort').value;
    const region= document.getElementById('region').value;
    const text = document.getElementById('text').value;
    const date = document.getElementById('clock').value;
    clock();
    if(agreecheck){
    if(checked || checked2){
        if(checked){
            choice=rental.value;
        }
        if(checked2){
            choice=lease.value;
        }
        var InquiredForm={
           name:name,
           phone:phone,
           carsort:carsort,
           region:region,
           text:text,
           date:date,
           auth:auth,
           choice:choice
        }
           $.ajax({
                    url: "inquired/submit",
                    type: "POST",
                    data : InquiredForm,

                })
                .done(function(){
                  alert("문의신청이 완료되었습니다.");
                })
        }
        else{
          alert("리스 혹은 렌트를 선택하여 주세요.")}
     }
     else{
        alert("약관에 동의하여 주세요.")
     }
    }
    else{
       alert("문의신청이 취소되었습니다.")
    }
}
