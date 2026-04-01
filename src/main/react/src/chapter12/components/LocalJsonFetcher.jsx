import {useState, useEffect} from 'react';
import axios from 'axios';

const GlobalTop = (props) => {
    console.log('1. 컴포넌트 실행');
    const [myList, setmyList] = useState([]); // 빈배열 갖는 상태변수

    // [1] AXIOS 사용하기, 설치 : npm i axios, 임포트 : import axios from 'axios'
    // function axios1( ){ }
    const axios1 = async() => { // axios 통신하는 함수 하나 만든다. async 동기화 한다.
        const response = await axios.get('./json/myData.json'); // await 동기화된 axios 통신한다.
        // response 에는 HTTP 응답관련 정보들이 객체로 들어있다.
        // 그중에 response.data는 실질적인 결과물(내용물/body) 있다.
        const result = response.data; // 통신결과 내 .data가 실질적인 결과물(내용물/body)가져온다.
        setmyList(result); // axios 통신결과를 상태변수에 대입한다.<렌더링>
    }
    // [2]
    // useState(() => {})      : 최초실행, 렌더링 할때마다 새로고침
    // useState(() => {}, [])   : 최초실행
    // useState(() => {}, [상태변수1, 상태변수2])   : 최초실행, 특정상태 변경될 때마다 실행
     useEffect( () => {
        console.log( '3. useEffect 실행' )
        axios1();
    }, [ ]);

    // [3] 현재상태(myList => Json => axios) 정보를 반복하여 html 구성 함수
    // 리스트/배열변수명.map((반복변수) => {return (<> JSX </>) } ) // 주로 html 구성할 때 사용한다. 
    let listTag = myList.map((data) => {
        // 첫번째 반복 data = {"num":1, "id":"yu", "name":"유비", "cell":"(02) 235-1111"}
        // 두번째 반복 data = {"num":2, "id":"kwan", "name":"관우", "cell":"(051) 235-2222"},
        // 세번째 반복 data = {"num":3, "id":"jang", "name":"장비", "cell":"(031) 235-3333"}

        return (
            <li key={data.id}>
                <a href={data.id} data-id={data.num} onClick={ (e)=>{
                    e.preventDefault(); // a마크업 관련된 기본 기능 제거 (깜빡거리는 기능 제거)
                    props.myListClick(e.target.dataset.id); // 부모로 부터 전달받은 함수(myListClick) 실행
                }}>{data.id}</a>
            </li>
        );
    });


    console.log('2. return 실행')
    return(<>
        <nav>
            <ul>
            {listTag}
            </ul>
        </nav>
    </>)

 
}

// 클릭된 정보를 그리는 컴포넌트
const ContentBody = (props) =>{
    return(<>
        <div>
            <h2>{props.myResult.name}</h2>
            <ul>
                <li> num: {props.myResult.num} </li>
                <li> id: {props.myResult.id} </li>
                <li> cell: {props.myResult.cell} </li>
                <li> description: {props.myResult.description} </li>
            </ul>
        </div>
    </>)
}

// LocalJsonFetcher.jsx
export default function LocalJsonFetcher( props ){

    const [myResult , setmyResult] =useState({}); // 상태변수 , 배열 아닌 객체, 빈객체  
    console.log(myResult); // 확인

    return(<>
    <h3>내부서버통신</h3>
    <GlobalTop myListClick={ async (num) => { 
        // async ( ) => { } vs async function함수명(){}
        console.log('클릭', num );

        // fetch대신 axios
        const response = await axios.get(`./json/dto${num}.json`);
        const result = response.data;
        setmyResult(result);
    }}> </GlobalTop>

    <ContentBody myResult={myResult}>
    </ContentBody>
    </>)
}
/*
  // 함수선언
  function add( x ){
    return x+3;
  }  

  // 일반함수 호출 : add(3)
  // 컴포넌트 함수 호출 : <add x+3 >
*/