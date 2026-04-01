// // 컴포넌트 생성 : export default function 컴포넌트명(props){return JSX 문법}

import { useState } from 'react';

// // 컴포넌트2
const TopComp = ({ MyData }) => {
    //     // const 상수 vs let 변수
    //     // ( 매개변수 ) => { } 화살표함수 vs function( 매개변수 ){ } 익명함수 vs function 함수명( 매개변수 ){ } 선언적함수
    //     // {MyData} , 구조분해 : 상위컴포넌트로 부터 props객체를 구조화해서 변수로 받기( props객체 내 MyData속성값 )
    //     // return : 함수의 반환값
    //     // 리액트JSX return : JSX 반환
    //     // JSX 이란? HTML + JS 조합된 문법
    //     // JSX 주석 : { /* 주석 */ }
    //     // JAVA MAP , 배열/리스트.stream.map((반복변수) -> {} )
    //     // JS MAP , 배열/리스트.map( (반복변수)  => { } )
    //         // ForEach 반복문 (리턴 x) vs MAP 반복문 (리턴 o)
    //         // JSX 문법에서 반복된 자료를 HTML로 구성하여 반환하는 구조 다수, MAP 활용된다.
    return (<>
        <ol>
            <li> 프론트엔드 </li>
            <ul>
                {MyData.front.map((item, i) => <li key={i} > {item} </li>)}
            </ul>
            <li> 백엔드</li>
            <ul>
                {MyData.back.map( (item,i) => <li key={i} > {item} </li>) }
            </ul>
        </ol>
    </>)
}// f end

function App() {
    const [MyData, setMyData] = useState({
        front: ['HTML5', 'CSS3', 'JavaScript', 'JQuery'],
        back: ['Java', 'Oracle', 'JSP', 'SpringBoot']
    });
    // 예) const [ a, b ] = { a : 1, b : 2 }
    // a에는 1, b에는 2
    // useState 훅(hook : 갈고리-연결 상태/값/데이터 <--갈고리--> 컴포넌트 )
    // 즉] 상태(state)가 (*주소/참조)값 변경되면 컴포넌트 렌더링된다.
    // const[ 상태명, set상태명 ] = useState( 초기값 )'
    // 리터럴 : 키보드로 부터 입력받은 상수 자료 , 주소/참조값 : 자료가 위치한 메모리 주소값
    // let a = 3; // 주소값 몇 개? 2개, 3(101번지) , a( 201번지 )
    // let b = 3; // 두 줄의 주소값 몇 개? 3개, 3( 101번지 ), a( 201번지 ), b( 202번지 )

    // MemberDto dto1 = new MemberDto();    // 주소값 몇 개? 2개, new MemberDto( 301번지 ) , dto1( 401번지 )
    // MemberDto dto2 = new MemberDto();    // 두 줄의 주소값 몇 개? 4개, new MemberDto( 01번지 ), new MemberDto( 302번지 ) , dto2( 402번지 )
    // MemberDto dto3 = dto2;               // 주소값 몇 개? 5개, new MemberDto( 301번지 ), new MemberDto( 302번지 ), dto2 ( 402번지 )

    // 1] 렌더링 안되는 코드 : 동일한 주소값의 값 추가 했으므로 새로고침 안됨.XXX
    const addFront = () => {
        MyData.front.push('React'); // MyData( 101동 203호 ), push( ): 배열내 값 추가함수, 주소변경 없이 주소내 값 추가(push) // 101동 203호 안방에 추가
        setMyData(MyData); // set상태명( 새로운주소값 ); // 상태는 값 변경 감지하지 않고 상태의 주소값 변경 감지한다.(얕은 비교) 
    }

    // 2] 렌더링 되는 코드 , { ... 기존객체 }, {...기존배열} , {...기존객체, 속성명:값 }, [...기존배열, 값 ]
    const addBack = () => {
        const newBack = [...MyData.back, 'Node.js'];
        const newMydata = { ...MyData, back: newBack }; // newMyData = { ...MyData( 101동 203호 )} // 101동 203호 통채로 바꾸기 = 렌더링
        setMyData(newMydata);                           // newMyData = 105동 702호
    }

    return (<>
        <h2>React-Shallow Comparison </h2>
        <TopComp MyData={MyData} />
        <button type='button' onClick={addFront}>프론트추가</button>
        <button type='button' onClick={addBack}>백엔드추가</button>
    </>)
} // f end

// onclick : HTML코드, onClick: JSX코드 (가상/가짜DOM)
// 리액트 가상/가짜 DOM 사용하는 이유 : HTML이 객체지향이 아니라서 HTML를 지향으로 만든 구조 JSX
// Dom: 

// 컴포넌트 1
export default function Exam1(props){
    return<App/>
}
