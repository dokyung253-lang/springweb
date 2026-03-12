
// 컴포넌트 만드는 방법
// 1. 폴더 우클릭 -> new file
// 2. 첫글자가 대문자인 .jsx 파일 생성
// 3. export default function 컴포넌트명(props) { }
// 4. 컴포넌트 내 return(<> </>)


 p.111, 컴포넌트 가져오기? 다른 jsx 파일에서 컴포넌트 가져오기
import BackComp from "./BackComp.jsx";
import FrontComp from "./FrontComp.jsx"



export default function Exam1(props){
    return(<>
    <h3> chapter6 p.110 </h3>
        <ol>
        <FrontComp></FrontComp>
        <BackComp OnMyEvent2={(msg) => {alert(msg);}}></BackComp>
        </ol>
    </>);
}