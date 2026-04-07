import axios from "axios";
import { useState } from "react";
import ReactQuill from 'react-quill-new';
import 'react-quill-new/dist/quill.snow.css';
export default function Write(props) {

   
    // Rest Api로 글쓰기 요청
    const boardWrite = async (e) => { e.preventDefault();
        // 1) 입력받은 값 가져오기
        const btitle = e.target.btitle.value;
        // const bcontent = e.target.bcontent.value; // textarea -> quill 변경 **
        const uploadFile = e.target.uploadFile.files[0];
        // value : 입력받은 자료 , files : file type의 등록된 파일 , files[0] : 선택된 1개 파일
        // 2) 객체 구성하지 않고 멀티(대용량/바이트)폼 구성 , multipart/form-data
        const formData = new FormData(); // 대용량 폼을 지원하는 객체
        formData.append('btitle', btitle); //.append(속성명, 값); 대용량 폼에 속성 추가한다.
        formData.append('bcontent', value); // -> textarea -> quill 변경 ** value: 웹 에디터 입력값이 저장된 상태변수. value는 글 내용
            // * 만약에 첨부파일이 존재하면 추가
        if( uploadFile ){ formData.append('uploadFile', uploadFile); }
        // 3) AXIOS
        const response = await axios.post('http://localhost:8080/api/board/write4', // 서버주소
            formData, // 전송할 객체/폼
           { withCredentials: true } // 쿠키로 변경
        ); 
        const data = response.data;
        if (data == true) {
            alert('글쓰기 성공');
        } else {
            alert('글쓰기 실패');
        }
    }

    const [value, setValue] = useState(''); // 웹 에디터 입력값을 갖는 상태변수
    // * 웹 에디터 설정 변경 *
    const modules = {
        toolbar: [
            [ { header: [1, 2, 3, 4] } ],
            [ "bold" , "italic" , "underline" ], // 굵기, 기울임, 밑줄
            [ {"list" : "ordered"}, {"list" : "bullet"} ],
            ["image"] // 이미지 기능 추가
        ]
    }
    // * 웹 에디터 설정 변경 : https://quilljs.com/docs/formats*
    const formats = [
        "header", "bold", "italic", "underline",
        "list",
        "image"
    ]

    return (
        <div>
            <h3>글쓰기 페이지</h3>
            <form onSubmit={boardWrite}>
                제목 : <input name="btitle" />                   <br /><br />
                {/* 에디터  내용은 입력받은 값이 길어질 수 있기 때문에 textarea 대신에 리액트에서 제공하는 리액트 퀼 에디터 사용한다. */}
                <ReactQuill theme="snow" value={value} onChange={setValue} modules={modules} formats={formats} />    <br />
                첨부파일 : <input name="uploadFile" type="file" /><br />
                <button type="submit"> 등록하기 </button>
            </form>
        </div>
    )
}