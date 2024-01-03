import DawonLogo from "../../assets/dawonlogo.png";
import "../../styles/adminpage.css";
function AdminHome(){
    return(
        <div className="admin_container">
        <div className="sidebar">
            <div className="sidetitle">
                <img src={DawonLogo}/>
            </div>
            <hr/>
            <div className="sidecontent">
                <ul>
    
                    <div className="sidecontent_title">문의</div>
                    <li className="fast_inquired_check">빠른 문의 확인</li>
                    <li className="inquired_check">문의 학인</li>
                    <hr/>
                    <br/>
    
                    <div className="sidecontent_title">차량</div>
                    <li className="alter_car">차량 관리(수정,삭제)</li>
    
                    <hr/>
                    <br/>
                    <div className="sidecontent_title">배너</div>
                    <li className="alter_banner">배너 관리(수정,삭제)</li>
    
                    <hr/>
                    <br/>
                    <div className="sidecontent_title">고객 후기</div>
                    <li className="add_customer">고객 후기 추가</li>
                    <li className="alter_customer">고객 후기 관리(수정,삭제)</li>
                    <hr/>
                    <br/>
    
    
                </ul>
            </div>
        </div>
        <div className="main">
        <div className="top">
            <div className="content_title">adminpage</div>
        </div>
        <div className="main_content">
            <div id = "content" className="content"/>
        </div>
    </div>
</div>
    )
}
export default AdminHome;