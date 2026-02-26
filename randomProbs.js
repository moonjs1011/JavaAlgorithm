(function pickRandomProblem() {
    // 1. 모든 문제 행(tr)을 가져옵니다.
    const rows = document.querySelectorAll('.table tbody tr');
    
    if (rows.length === 0) {
        console.error("문제를 찾을 수 없습니다. 문제집 페이지가 맞는지 확인해주세요!");
        return;
    }

    // 2. 기존에 하이라이트된 행이 있다면 초기화합니다.
    rows.forEach(row => {
        row.style.outline = 'none';
        row.style.backgroundColor = '';
    });

    // 3. 무작위 인덱스 선택
    const randomIndex = Math.floor(Math.random() * rows.length);
    const selectedRow = rows[randomIndex];

    // 4. 하이라이트 효과 적용 (border 대신 outline을 써야 테이블 구조가 안 깨집니다)
    selectedRow.style.outline = '4px solid #ff4d4d'; // 강렬한 레드 테두리
    selectedRow.style.backgroundColor = '#fff0f0';    // 연한 핑크 배경색
    selectedRow.style.transition = 'all 0.3s ease';  // 부드러운 시각 효과

    // 5. 해당 문제로 부드럽게 스크롤
    selectedRow.scrollIntoView({ behavior: 'smooth', block: 'center' });

    // 6. 콘솔에 선택된 문제 정보 출력
    const problemId = selectedRow.cells[0].innerText.trim();
    const problemTitle = selectedRow.cells[1].innerText.trim();
    console.log(`%c🎯 오늘의 당첨 문제: [${problemId}] ${problemTitle}`, "color: #ff4d4d; font-size: 14px; font-weight: bold;");
})();