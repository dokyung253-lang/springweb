// p.117, 컴포넌트 내보내기? 다른 jsx에서 해당하는 컴포넌트 사용하기 위해
// 부모 컴포넌트로 부터 상태변경함수를 props로 받아서
// a 클릭하면 상태를 front로 변경한다.
export default function FrontComp(props){
    return(<>
        <li> <a href="/" onClick={ () => {
            event.preventDefault();
            props.onSetMode( 'front' );
            } }>프론트앤드
            </a>
        </li>
        <ul>
            <li> HTML5 </li>
            <li> CSS3 </li>
            <li> JavaScript </li>
            <li> jQuery </li>
        </ul>
    </>);
}