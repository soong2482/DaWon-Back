import DawonLogo from "../../assets/dawonlogo.png";
function adminfastinquired(){

    return(
        <div class="fastinquired_container">
        <div class="top">
                <img src="/img/dawonlogo.png"/>
                <div class="text">빠른 문의 관리</div>
        </div>
        <div class="middle">
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Brand</th>
                    <th>Car</th>
                    <th>Auth</th>
                    <th>success</th>
                    <th>Date</th>
                    <th>완료</th>
                    <th>삭제</th>
                </tr>
                </thead>
                <tbody>
                <tr th:each="fastinquired : ${fastinquireds}" th:style="${fastinquired.success == '완료' ? 'background-color:#DFE3FF;':'background-color:white'}">
                    <td th:text="${fastinquired.id}"></td>
                    <td th:text="${fastinquired.name}"></td>
                    <td th:text="${fastinquired.phone}"></td>
                    <td th:text="${fastinquired.brand}"></td>
                    <td th:text="${fastinquired.carsort}"></td>
                    <td th:text="${fastinquired.auth}"></td>
                    <td th:text="${fastinquired.success}"></td>
                    <td th:text="${fastinquired.date}"></td>
                    <td><button class="success" th:id="${fastinquired.id}" onclick="done(this.getAttribute('id'))">완료</button></td>
                    <td><button class="delete" th:id="${fastinquired.id}" onclick="remove(this.getAttribute('id'))">삭제</button></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="board_page">
            <a href="#" class="bt first"><<</a>
            <a href="#" class="bt prev"><</a>
            <a href="#" class="num on">1</a>
            <a href="#" class="num">2</a>
            <a href="#" class="num">3</a>
            <a href="#" class="num">4</a>
            <a href="#" class="num">5</a>
            <a href="#" class="bt next">></a>
            <a href="#" class="bt last">>></a>
        </div>
    </div>
    )
}
export default adminfastinquired;