# JavaAlgorithm

알고리즘 문제 풀이 레포지토리입니다.
자바(Java)를 이용하여 백준(Baekjoon), SWEA, 프로그래머스(Programmers) 등의 알고리즘 문제를 풀이한 소스 코드들이 포함되어 있습니다.

## 📁 패키지 구조 (Package Structure)

소스 코드는 `src` 폴더 내에 다음과 같은 계층적 패키지 구조로 정리되어 있습니다.

```text
src/
 ├── baekjoon/     # 백준 알고리즘 문제 풀이
 ├── programmers/  # 프로그래머스 문제 풀이
 ├── swea/         # SW Expert Academy 문제 풀이
 └── study/        # 알고리즘 스터디 관련 코드
```

### 🗓️ 세부 패키지 규칙

각 플랫폼 디렉토리 안에는 **학습 시기(월/주차/일자)** 또는 **기타(etc)** 패키지로 세분화하여 각 문제별로 코드를 보관하고 있습니다.

패키지 네이밍 규칙:
`{platform}.month{MM}.week{WW}.day{MMDD}.problem{Number}`

**분류 예시:**
* `baekjoon.month01.week04.day0126.problem1629`
  * 플랫폼: 백준 (Baekjoon)
  * 시기: 1월 4주차 (01/26)
  * 문제: 1629번 문제
  
* `swea.month02.week02.day0210.problem1249`
  * 플랫폼: SWEA
  * 시기: 2월 2주차 (02/10)
  * 문제: 1249번 문제

* `baekjoon.etc.problem1000`
  * 특정 주차에 포함되지 않는 기타(etc) 백준 1000번 문제 풀이

## ⚙️ 환경 (Environment)
- **Language**: Java
- **IDE**: Eclipse / IntelliJ IDEA
