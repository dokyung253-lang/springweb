import { NavLink } from "react-router-dom";

const TopNavi = () =>{
    // jsx와 js 구분 : 컴포넌트(함수) 내 리턴(반환)값 뒤로 JSX문법. 그외는 JS
    // jsx에서 html 없는 마크업들은 모두 컴포넌트이며 외부호출 시 import 넣는다.
    // a마크업과 NavLink 구분 : NavLink= 화면깜빡임 x(리액트장점)
    return (
        <nav>
            <NavLink to="/">생명주기</NavLink>
            <NavLink to="/local">내부통신</NavLink>
            <NavLink to="/external">외부통신</NavLink>
        </nav>
    )
}
export default TopNavi;