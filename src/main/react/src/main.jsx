import { createRoot } from 'react-dom/client'
// import './index.css'
// import App from './App.jsx'

//  index.html(싱글페이지) 에서 root라는 id 갖는 div 요소 호출
const root = document.querySelector('#root');

// test
import App from './test/App'
createRoot(root).render(
         <App/>
)

// reactweb
// import App from './reactweb/App'
// import {BrowserRouter} from 'react-router-dom'
//createRoot(root).render(
//    <BrowserRouter>
//         <App/>
//    </BrowserRouter>
// )

// practive 1
// import App from './sr practice1/App'
// import {BrowserRouter} from 'react-router-dom'
// createRoot(root).render(
//     <BrowserRouter>
//         <App/>
//     </BrowserRouter>
// )

// chapter 12 예제
// import App from './chapter12/App'; 
// import { BrowserRouter } from 'react-router-dom';
// createRoot(root).render(
//     <BrowserRouter>
//         <App/>
//     </BrowserRouter>
// )

// chapter 11 예제
// import Exam2 from './chapter11/Exam2.jsx';
// import { BrowserRouter } from 'react-router-dom'; // [1] 라이브러리 import하기
// [2] 최초 렌더링되는 컴포넌트에 BrowserRouter 감싼다.
// createRoot(root).render(
//     <BrowserRouter> 
//        <Exam2 />
//     </BrowserRouter>  
// );

// chapter 10 예제
// import Exam1 from './chapter10/Exam1.jsx';
// createRoot( root ).render(<Exam1 />);

 // chapter 9 예제
// import Exam2 from './chapter9/Exam2.jsx';
// createRoot( root ).render(<Exam2 />);

// chapter 8 예제
// import Exam1 from './chapter8/Exam1.jsx';
// createRoot( root ).render(<Exam1 />);

// chapter7 예제
// import Exam2 from './chapter7/Exam2.jsx';
// createRoot( root ).render(<Exam2 />);

// chapter6 예제
// import Exam1 from './chapter6/Exam1.jsx';
// createRoot(root).render(<Exam1/>);

// chapter5 예제
//import Exam2 from'./chapter5/Exam2.jsx' // 컴포넌트 불러오기
//createRoot( document.querySelector('#root')).render(<Exam2/>);

// chapter4 예제
// import Exam1 from'./chapter4/Exam1.jsx' // 컴포넌트 불러오기
// createRoot( document.querySelector('#root')).render(<Exam1/>);

//* 기존코드
// createRoot(document.getElementById('root')).render(<App />)

// [2] root 마크업에 렌더링(render)
// createRoot(root).render(<h1>안녕하세요</h1>)
// vs root.innerHTML = "<h1> 안녕하세요! </h1>" ;

