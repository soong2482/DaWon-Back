import React, { useEffect } from 'react';
import $ from 'jquery';
function HomeJS(){

    var returnValue= window.confirm('문의신청을 하시겠습니까?');
    if(returnValue==true){
        var name=document.getElementById('name').value;
        var phone = document.getElementById('phone').value;
        var phone1 = document.getElementById('phone1').value;
        var phone2 = document.getElementById('phone2').value;
        var brand = document.getElementById('brand').value;
        var carsort = document.getElementById('carsort').value;
        var checkbox = document.getElementById('auth');
        var clock = document.getElementById('clock').value;
        if(checkbox.checked==false){
           alert("개인정보 수집및 이용에 동의해주세요.")
        }
         if(checkbox.checked==true){
        var Fastinquired={
            name:name,
            phone:phone,
            phone1:phone1,
            phone2:phone2,
            brand:brand,
            carsort:carsort,
            date:clock

        };
        $.ajax({
            url: "fastinquired/inquire",
            type: "POST",
            data : Fastinquired,

        })
        .done(function(){
          alert("문의신청이 완료되었습니다.");
        })
    }
    }
    else{
    alert("문의신청이 취소되었습니다.")
    }
 var Target = document.getElementById('clock');
                 var time = new Date();
                 var year =time.getFullYear();
                 var month = time.getMonth();
                 var date = time.getDate();
                 var day = time.getDay();


                 var hours = time.getHours();
                 var minutes = time.getMinutes();
                 var seconds = time.getSeconds();

                 Target.value =
                 `${year}.${month + 1}.${date}   `+
                 `${hours < 10 ? `0${hours}` : hours}:${minutes < 10 ? `0${minutes}` : minutes}:${seconds < 10 ? `0${seconds}` : seconds}`;
             clock();
             setInterval(clock, 1000); // 1초마다 실행

	$("#inquiredimg").click(function(){
		//사용하고자 하는 함수
		window.location.href="requestpage";

	});
    window.open("https://open.kakao.com/o/s6kBd69d");
var target = document.querySelectorAll('.btn_open');
var btnPopClose = document.querySelectorAll('.pop_wrap .btn_close');
var targetID;

// 팝업 열기
for(var i = 0; i < target.length; i++){
  target[i].addEventListener('click', function(){
    targetID = this.getAttribute('field');
    window.scrollTo({
              top: 920,
              left: 0,
              behavior: "smooth"
            })
    document.querySelector("#"+targetID).style.display = 'block';
  });

}
// 팝업 닫기
for(var j = 0; j < target.length; j++){
  btnPopClose[j].addEventListener('click', function(){
    this.parentNode.parentNode.style.display = 'none';
  });
}




}
export default HomeJS;