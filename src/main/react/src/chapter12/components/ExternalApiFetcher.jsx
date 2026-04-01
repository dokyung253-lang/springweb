import { useState, useEffect } from "react";
import axios from "axios";

function RandomUser(props){
    const [MyJson, setMyJson] = useState({ results : [ ] }); // 상태변수 선언, 객체(배열)
    // 서버가 통신하여 자료를 가져오는 시간 기다리지 않고 서버가 응답하면 다시 렌더링되니까.

    // 컴포넌트 라이프사이클(마운트-업데이트-언마운트)의 hook(갈고리) 이용한 추가작업
    const 가져오기함수 = async() =>{
        const 서버응답 = await axios.get( 'https://api.randomuser.me?results=10')
        const 응답본문 = 서버응답.data; // { results : ~~ , info : ~~ }
        setMyJson( 응답본문 )
    }
    useEffect(( ) => { 
        가져오기함수(); // 마운트 : 서버로부터 정보를 요청하자. 주로 REST API(AXIOS)
    }, [] );

    // [2] <table> 마크업 내 <tr> 구성하는 함수
    let trTag = MyJson.results.map((data) => {
        return(
            <tr key={data.login.md5}>
                <td><img src={data.picture.thumbnail} alt={data.login.username} /></td>
                <td><a href='/' onClick={(e)=> {
                    e.preventDefault();
                    props.onProfile(data);
                }}>{data.login.username}</a>
                </td>
                <td>{data.name.title} {data.name.first} {data.name.last} </td>
                <td>{data.nat}</td>
                <td>{data.email}</td>
            </tr>
        );
    });
    return (
        <div>
            <table boarder='1'>
                <thead>
                    <tr>
                        <th>사진</th><th>로그인</th><th>이름</th>
                        <th>국가</th><th>Email</th>
                    </tr>
                </thead>
                <tbody>{trTag}</tbody>
            </table>
        </div>
    );
};


// ExternalApiFetcher.jsx
export default function ExternalApiFetcher(props){
return (<>
    <h2>외부서버 통신</h2>
    <RandomUser></RandomUser>
    </>)
}
