import { Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Login from "./pages/member/login";
import Write from "./pages/board/write";
import Signup from "./pages/member/signup";
import Board from "./pages/board/Board";
import View from "./pages/board/view";

export default function App( props ){
    return (
        <div id="wrap">
            { /* 헤더 */}
            <Header/>{/* 헤더 */}
            <Routes>
                { /* 본문들 */ }
                <Route path="/member/signup" element={ <Signup />} />
                <Route path="/member/login" element={ <Login /> } />
                <Route path="/board/write" element={ <Write />} />
                <Route path="/board" element={ <Board /> } />
                <Route path="/board/View" element={ <View /> } /> { /* :bno -> URL 파라미터 , 게시물 번호 */ }
            </Routes>
            { /* 푸터 */ }
        </div>
    )
}