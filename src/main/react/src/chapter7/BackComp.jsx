// p.117
// 부모 컴포넌트로 부터 상태변경함수를 pros로 받아서
// props {} 구조분해할당하여 a 클릭하면
// 상태를 back으로 수정한다.
const BackComp = ( { setMode } ) => {
    return(<>
    <li> 
        <a href="/" onClick={ () => { 
            event.preventDefault();
            setMode('back');
} } >  백앤드 </a>
    </li>
    <ul>
        <li> Java </li>
        <li> Python </li>
        <li> Node.js </li>
        <li> Spring </li>
    </ul>
    </>)
 }
export default BackComp;