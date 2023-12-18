
     var Target = document.getElementById("clock");
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
                 `${year}.${month + 1}.${date}   `+
                 `${hours < 10 ? `0${hours}` : hours}:${minutes < 10 ? `0${minutes}` : minutes}:${seconds < 10 ? `0${seconds}` : seconds}`;

             }
             clock();
             setInterval(clock, 1000); // 1초마다 실행

            function readURL(input) {
              if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function(e) {
                  document.getElementById('preview').src = e.target.result;
                };
                reader.readAsDataURL(input.files[0]);
              } else {
                document.getElementById('preview').src = "";
              }
            }