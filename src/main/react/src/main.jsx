import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

// chapter4 예제
// import Exam1 from'./chapter4/Exam1.jsx' // 컴포넌트 불러오기
// createRoot( document.querySelector('#root')).render(<Exam1/>);

// chapter5 예제
import Exam2 from'./chapter5/Exam2.jsx' // 컴포넌트 불러오기
createRoot( document.querySelector('#root')).render(<Exam2/>);

//* 기존코드
// createRoot(document.getElementById('root')).render(<App />)

// [1] index.html(싱글페이지) 에서 root라는 id 갖는 div 요소 호출
// const root = dovument.querySelector('#root');

// [2] root 마크업에 렌더링(render)
// createRoot(root).render(<h1>안녕하세요</h1>)
// vs root.innerHTML = "<h1> 안녕하세요! </h1>" ;

