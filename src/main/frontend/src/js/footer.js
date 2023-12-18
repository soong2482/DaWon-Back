var target = document.querySelectorAll('.footer_second');
var btnPopClose = document.querySelectorAll('.pop_wrap .btn_close');
var targetID;

for(var i = 0; i < target.length; i++){
  target[i].addEventListener('click', function(){
    targetID = this.getAttribute('field');
    document.querySelector("#"+targetID).style.display = 'block';
        window.scrollTo({
                  top: 920,
                  left: 0,
                  behavior: "smooth"
                })

      });

}
// 팝업 닫기

for(var j = 0; j < target.length; j++){
  btnPopClose[j].addEventListener('click', function(){
    this.parentNode.parentNode.style.display = 'none';
  });
}

