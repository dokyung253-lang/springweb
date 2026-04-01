import { useEffect, useState } from "react"

function MoveBox(props){
    // props란? 상위컴포넌트에서 해당 컴포넌트 호출 시 전달해주는 속성명과 속성값들(여러개)을 객체로 받는 매개변수
    // props -> { initPosition : 50 }
    // useState란? 컴포넌트내 데이터(값) 상태관리하는 함수 , 왜 관리함? 부분 새로고침(함수재호출)하려고
        // const [상태명, set상태명] = useState(초기값);
    const [position, setPosition] = useState(props.initPosition);// 50이 props에 들어감
    const [leftCount, setLeftCount] = useState(1); // 상태(변수) 선언

    // [0] CSS문법을 객체지향으로 표현 가능, 변수대입은 `${}` 백틱사용하여 사용 가능
    const boxStyle = {
        backgroundColor : 'red', position : 'relative', textAlign : 'center',
        width : '100px' , height: '100px', margin:'10px', lineHeight: '100px',
        left: `${position}px` // css 요소의 JS변수 대입, 즉] css를 변수화/객체화
    };

    // [1]
    const moveLeft = () =>{
        setPosition(() => position - 20);
        setLeftCount(() => leftCount + 1);
    };

    // [2]
    const moveRight = () => {
        setPosition(() => position + 20);
    };
    
    // [3]
    useEffect(function(){
        console.log('useEffect 실행 ==> 3. 컴포넌트 마운트') // 최초 실행 시 or moveLeft 함수 실행 시
        return ()=>{
         console.log('useEffect 실행 ==> 4. 컴포넌트 언마운트') // 재렌더링 시 기존렌더링된 화면(함수)은 지움, 언마운트 후 바로 마운트
        }
    } , [leftCount] ) // 의존성배열이란? state(상태)변수 배열 내 대입하여 해당하는 상태가 변경되면 useEffect가 실행
    // } ) // 179 (1) 마운트 매번 실행
    // } , [ ] ) // 179 (2) 마운트 최초 1번 실행
    // } , [leftCount] ) // 179 (3) left는 실행되고, right는 실행 X

    // [4] 
    console.log('return실행 ==> 2. 렌더링(return문))');
    // 해당 컴포넌트 실행하고, '좌측이동' 3번 실행했을 때 return문 총 몇 번? 4번
    // 해당 컴포넌트 실행하고, '우측이동' 3번 실행했을 때 return문 총 몇 번? 4번
    // 해당 컴포넌트 실행하고, '좌측이동' 3번 실행했을 때 마운트 총 몇 번? 4번
    // 해당 컴포넌트 실행하고, '우측이동' 3번 실행했을 때 마운트 총 몇 번? 1번

    return (
        <div>
            <h4>함수형 컴포넌트의 생명주기</h4>
            <div style={boxStyle}>{leftCount}</div>
            <input type="button" value="좌측이동" onClick={moveLeft} />
            <input type="button" value="우측이동" onClick={moveRight} />
        </div>
    )

}

export default function LifeCycle(props){
    // html에 없는 마크업들은 모두 컴포넌트 취급한다. 즉] 컴포넌트란? 나만의 마크업 만들기
    return (<>
    <h2> chapter12 </h2>
    <MoveBox initPosition={50}></MoveBox>
    </>)
}