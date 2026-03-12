// p.110
const BackComp = ( { OnMyEvent2} ) => {
    return(<>
    <li> 
        <a href="/" onClick={ () =>{ OnMyEvent2('백엔드 클릭됨');} } >  백앤드 </a>
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