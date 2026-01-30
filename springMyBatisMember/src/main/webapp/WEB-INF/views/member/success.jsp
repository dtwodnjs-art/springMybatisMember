<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T1 Community | Success</title>
<style>
    /* T1 Official Theme */
    :root {
        --t1-red: #E2012D;
        --t1-black: #0f0f0f;
        --t1-gray: #1a1a1a;
        --t1-gold: #C69C6D;
    }

    body {
        background-color: var(--t1-black);
        font-family: 'Pretendard', sans-serif;
        color: #ffffff;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        margin: 0;
    }

    .write-container {
        width: 100%;
        max-width: 500px;
        background: var(--t1-gray);
        padding: 50px;
        border-radius: 15px;
        border: 2px solid var(--t1-red);
        box-shadow: 0 0 30px rgba(226, 1, 45, 0.2);
        text-align: center;
    }

    .header h1 {
        font-size: 2rem;
        font-weight: 900;
        letter-spacing: -1px;
        margin-bottom: 30px;
    }

    .header span {
        color: var(--t1-red);
    }

    /* Buttons */
    .btn-area {
        display: flex;
        gap: 15px;
        margin-top: 30px;
    }

    .btn {
        flex: 1;
        padding: 15px;
        font-size: 1rem;
        font-weight: bold;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: 0.3s;
        text-transform: uppercase;
        text-decoration: none; /* 링크 밑줄 제거 */
        display: inline-block;
        line-height: 1.2;
    }

    .btn-submit {
        background: var(--t1-red);
        color: #fff;
    }

    .btn-submit:hover {
        background: #ff1a4a;
        transform: translateY(-3px);
        box-shadow: 0 5px 15px rgba(226, 1, 45, 0.5);
    }

    .btn-cancel {
        background: #333;
        color: #bbb;
    }

    .btn-cancel:hover {
        background: #444;
        color: #fff;
    }
</style>
</head>
<body>

    <div class="write-container">
        <div class="header">
            <h1><span>SUCCESS</span><br>${not empty message ? message : '회원가입이 완료되었습니다.'}</h1>
        </div>
        
        <div class="btn-area">
            <a href="/member/insertForm" class="btn btn-submit">추가 가입</a>
            <a href="/member/memberList" class="btn btn-cancel">회원 리스트</a>
        </div>
    </div>

</body>
</html>