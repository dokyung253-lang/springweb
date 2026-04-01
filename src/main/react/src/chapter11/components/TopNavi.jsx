import { Link, NavLink } from "react-router-dom";

export default function TopNavi( props ){ // 상단메뉴/바 = 헤더메뉴 컴포넌트
    // <a> : a마크업은 클릭하면 브라우저 전체 새로고침( 깜빡임 o ) < a href = "URL" >
    // <Link> : 클릭하면 새로고침 없이 URL 변경 ( 깜빡임 x ) <Link to = "URL" >
    
    return(
        <nav>
            <a href="/"> Home </a>
            <NavLink to="/intro"> 인트로 </NavLink>
            <NavLink to="/intro/router"> Router관련 Hook </NavLink>
            <Link to="/gogo"> 잘못된URL </Link>
        </nav>
    )
}