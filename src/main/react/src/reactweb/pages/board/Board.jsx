import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export default function Board(props) {
// [2] axios로 부터 받은 게시물들을 저장하는 상태변수
    const [list, setList] = useState([]); // 초기값은 빈 배열, 게시물 여러개 저장해야 하므로 배열로 선언
    
    // [1] axios 통신
    const findAll = async () => {
        try{
            const response = await axios.get('http://localhost:8080/api/board/list');
            const data = response.data;
            setList(data); // 받아온 게시물들을 상태변수에 저장
console.log(data);
        }catch(e){ console.log(e); }
    }

    // [3] axios 실행시점, findAll() 함수 열리면 최초 1번 실행
    useEffect( () => { findAll(); }, [] ) // 컴포넌트가 열리면 최초 1번 실행, 빈배열은 의존성 배열, 의존성 배열이 비어있으면 최초 1번 실행

    return (<>
             <div>
            <h3>게시판 페이지</h3>
            <table border="1">
                <thead>
                    <tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
                </thead>
                <tbody>
                    {
                        list.map( board => {
                            return (
                                <tr>
                                    <td>{ board.bno }</td> 
                                    <td>
                                        <Link to={`/board/view?bno=${board.bno}`}>
                                            { board.btitle }
                                        </Link>
                                    </td>
                                    <td>{ board.mname }</td>
                                    <td>{ board.CreateDate?.split("T")[0] }</td>
                                </tr>
                            );
                        })
                    }
                </tbody>
            </table>

             </div>
    </>)
}
