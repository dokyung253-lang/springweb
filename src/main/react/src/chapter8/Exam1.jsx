/*
    export default function 컴포넌트명(props){
    return(<> 
    </>)}
*/
import catImg from '../assets/cat.jpg' // 이미지 불러오는 방법2
import "./index.css" /* 현재 컴포넌트에 전통css 파일 호출 */
export default function Exam1(props){
    const myStyle ={
        color : "white",  background : "DodgerBlue",
        padding : "10px", "fontFamily" : "Verdana"
    }
    const iWidth = { maxWidth : '300px'} // 인라인 css 방식은 객체 형태이다.
    // 조심할 점 : max-width --> maxWidth 하이픈(-) 대신에 카멜표현식 사용한다.

    // 정적파일 : public 이하 경로만 지정한다.
    // 즉[/public/img/.img] -> /img/.img
    
    return(<> 
        <h3> 스타일과 이미지 127p</h3>
        <ol>
            <li style={ { color : "red" } }> 프론트엔드 </li>  
            <ul>
                <li><img src="/img/dog.avif" style={iWidth}/></li>
                <li><img src={catImg} style={iWidth}/></li>
                <li><img src="https://placehold.co/600x400" style={iWidth} /></li>
            </ul>
                <li className="backEnd"> 백엔드 </li>
            <ul>
                <li id="backEndSub">Java</li>
                <li class='warnings'>Oracle</li>
                <li style={myStyle}>JSP</li>
                <li>SpringBoot</li>
            </ul>
        </ol>
    </>)
}