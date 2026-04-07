import axios from "axios";
import { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom"

export default function BoardView(props) {
    
    // [1] 현재 URL 상의 쿼리스트링 값 가져오기, 조회할 게시물번호 가져오기
    const [searchParams] = useSearchParams(); // 예] "http://localhost:5173/board/view?bno=17"
    const bno = searchParams.get("bno"); // URL 상의 bno 값 가져오기, 17

    // [3]
    const [board, setBoard] = useState(null); // 게시물 정보 저장하는 상태변수, 초기값은 null

    // [2] 
    const findById = async () => {
        try{
            const response = await axios.get(`http://localhost:8080/api/board/view?bno=${bno}`);
            const data = response.data;
            setBoard(data); // 받아온 게시물 정보를 상태변수에 저장
        }catch(e){ console.log(e); }
    }

    // [4] 실행시점
    useEffect( () => { findById(); }, [] ); 

    // [5] 만약에 아직 axios의 결과가 없으면
    if( !board ){ return <div> 게시물 정보 로딩중... </div> }

    return (<>
        <div>
            <div> 작성자 : {board.mname} | 작성일 : {board.createDate} </div>
            <h2> 게시물 상세 </h2>
            <div> 제목 : {board.btitle} </div>

            { /* {} 내부 :  만약에 웹에디터 사용할 경우에는 HTML 형식으로 저장되므로 HTML 형식으로 출력해야한다. */}
            { /* dangerouslySetInnerHTML: 리액트는 가상 DOM이라서 직접적인 HTML 대입 비권장한다. 직접 HTML 대입하는 방법 */ }
            <div dangerouslySetInnerHTML={ { __html : board.bcontent } } />

            <div> 
                { // 만약 첨부파일 존재하면, 
                    board.bfile && ( // bfile이 존재하면 , 업로드 경로에서 파일명의 다운로드 링크 추가
                        <a href={`http://localhost:8080/upload/${board.bfile}`} download > {board.bfile.split(
                        "_"[1] )} 다운로드
                        </a> // 업로드 경로에서 파일명의 다운로드 링크 추가
                    )
                }
                 </div>
        </div>
    </>)
}