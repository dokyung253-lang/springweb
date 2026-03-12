import { useState } from "react"
import FrontComp from "./FrontComp";
import BackComp from "./BackComp";

export default function Exam2(props){
    
    // 1) useState 선언 : const [ 변수명, set변수(함수)명 ] = useState( 초기값 );
    const[mode, setMode] = useState( 'both' ); // mode : 상태변수 , setMode : 상태변수를 수정하는 함수

    // 2) 상태(값) 변경하는 함수 , set변수명( 새로운값 );  
    const handleSetMode = (mode) => {setMode(mode); } // 상태변수
    // vs 차이점 : 상태변수는 setXXX( ) 이용하여 1) 값 수정 2) 새로고침(함수/컴포넌트 재실행)
    let mode2 = 'both' // 일반변수
    mode2 = 'front'; // 일반변수 값 변경 이후에 아무런 추가기능이 없다.

    // 3) 컴포넌트 저장용 변수, 분기(if)에 따른 화면에 나오는 결과물
    let contents = '';
    
    // 4) 상태에 따라 컴포넌트 그리기, 분기(if), setMode가 실행돼서 상태가 변경되면 화면을 다시 그리므로( 리렌더링 =새로고침 =함수(컴포넌트)재호출 )
    if(mode == 'front'){  // 4-1 : mode가 front이면
        contents = <>
            <FrontComp onSetMode={ (mode) => { setMode(mode); } } />
        </>
    }else if( mode == "back"){ // 4-2 : mode가 back이면
        contents =<>
            <BackComp setMode = {setMode} />
        </>
    }else{ // 4-3 : mode가 front/back 아니면 둘다(both)
        contents = <>
        <FrontComp onSetMode={ (mode) => { setMode(mode); } } />
        <BackComp setMode = {setMode} />
        </>
    }

    // 5) 분기(if)에 따른 결과물을 return 에서 출력된다.
    return(<>
        <h3> chapter7 p.118 </h3>
        <a href="/" onClick={ ( ) => { setMode('both');}}> React-State</a>
        <ol>
            {contents}
        </ol>
    </>)
}