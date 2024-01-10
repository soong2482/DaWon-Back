function requestJS(){
  
            function clock() {
                var time = new Date();
                var year = time.getFullYear();
                var month = time.getMonth();
                var date = time.getDate();
                var day = time.getDay();
            
                var hours = time.getHours();
                var minutes = time.getMinutes();
                var seconds = time.getSeconds();
            
                var target = document.getElementById('clock'); // 이 부분에서 Target 대신 직접 요소를 가져오도록 변경
                target.value =
                    year + '.' + (month + 1) + '.' + date + ' ' +
                    (hours < 10 ? '0' + hours : hours) + ':' +
                    (minutes < 10 ? '0' + minutes : minutes) + ':' +
                    (seconds < 10 ? '0' + seconds : seconds);
            }
            document.querySelector('.submit_button_button').addEventListener('click',async function(e){
                var returnValue = window.confirm('문의신청을 하시겠습니까?');
                
                if (returnValue === true) {
                    var choice;
                    var auth = document.getElementById('auth').value;
                    var rentalCheckbox = document.getElementById('rental');
                    var leaseCheckbox = document.getElementById('lease');
                    var agreeCheckbox = document.getElementById('auth');
                    const name = document.getElementById('name').value;
                    const phone = document.getElementById('phone').value;
                    const carsort = document.getElementById('carsort').value;
                    const region = document.getElementById('region').value;
                    const text = document.getElementById('text').value;
                    const date = document.getElementById('clock').value;
               
                    if (agreeCheckbox.checked) {
                        if (rentalCheckbox.checked || leaseCheckbox.checked) {
                            if (rentalCheckbox.checked) {
                                choice = rentalCheckbox.value;
                            }
                            if (leaseCheckbox.checked) {
                                choice = leaseCheckbox.value;
                            }
                            var inquiredForm = {
                                name: name,
                                phone: phone,
                                carsort: carsort,
                                region: region,
                                text: text,
                                date: date,
                                auth: auth,
                                choice: choice
                            };
            
                            try {
                                var response = await fetch("inquired/submit", {
                                    method: "POST",
                                    headers: {
                                        "Content-Type": "application/json"
                                    },
                                    body: JSON.stringify(inquiredForm)
                                });
            
                                if (response.ok) {
                                    alert("문의신청이 완료되었습니다.");
                                } else {
                                    alert("문의신청에 실패했습니다.");
                                }
                            } catch (error) {
                                console.error("Error:", error);
                                alert("문의신청 중에 오류가 발생했습니다.");
                            }
                        } else {
                            alert("리스 혹은 렌트를 선택하여 주세요.");
                        }
                    } else {
                        alert("약관에 동의하여 주세요.");
                    }
                } else {
                    alert("문의신청이 취소되었습니다.");
                }
            })
        }
        export default requestJS;