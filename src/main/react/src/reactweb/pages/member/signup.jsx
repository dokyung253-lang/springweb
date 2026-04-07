import axios from "axios";

export default function Signup(props){

    // [1] rest api 에게 axios로 통신
    const signup = async(e) => { e.preventDefault();
    const mid = e.target.mid.value;
    const mpwd = e.target.mpwd.value;
    const mname = e.target.mname.value;
    const obj = { mid, mpwd, mname }
    const response = await axios.post("http://localhost:8080/api/member/signup", obj );
    const data = response.data;
    if( data ){
        alert('회원가입성공');
        location.href="/";
    }else{ alert('회원가입실패');}
    }

    return(<>
        <div>
            <h3>회원가입 페이지</h3>
            <form onSubmit={signup}>
            아이디 : <input name="mid" placeholder="아이디입력"/>       <br />
            비밀번호 : <input name="mpwd" placeholder="비밀번호입력" />  <br />
            닉네임 : <input name="mname" placeholder="닉네임입력" />    <br />
            <button type="submit">회원가입</button>
            </form>
        </div>
    </>)
}