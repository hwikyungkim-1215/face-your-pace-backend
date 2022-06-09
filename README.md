# Face Your Pace - 카우러너

### 목차

1. [🏃 서비스 소개](#-서비스-소개)
2. [🏃 프로젝트 세부 내용](#-프로젝트-세부-내용)
3. [⏰ 개발 기간](#-개발-기간-20220227--20220610)
4. [✨ 주요기능 소개](#-주요기능-소개)
5. [🛠️ 기술스택](#%EF%B8%8F-기술스택)
6. [✏️ 기획 및 설계](#%EF%B8%8F-기획-및-설계)
7. [👨‍👩‍👦‍👦 팀원 소개](#-팀원-소개)

## 2022 캡스톤 디자인 경진대회

[💻 2022 캡스톤 디자인 경진대회 설명페이지](https://www.swaicau.com/bbs/board.php?bo_table=program8)

본 프로젝트는 2022 캡스톤 디자인 경진대회에 참여하는 프로젝트임을 밝힙니다.

2022 캡스톤 디자인 경진대회 참여 링크 : https://www.swaicau.com/bbs/board.php?bo_table=program8&wr_id=136


# 🏃 서비스 소개
페이스 조절을 통해 운동 효율을 높여요!

Face Your Pace 는 달리기를 하는 사람들의 페이스 조절에 도움을 주어 운동 효율을 극대화시킬 수 있는 음악을 제공하는 스마트폰 앱이다.

<img width="903" alt="fyp표지" src="https://user-images.githubusercontent.com/56347876/172767446-63bf4b84-1afb-46c9-a566-b06c883bd899.png">

소개 및 데모 영상: https://www.youtube.com/watch?v=BbRuUzSmnZ0&ab_channel=%EA%B9%80%EC%9D%98%EC%B0%AC


### 🌞 프로젝트 동기

  스포츠 심리학 저널에 게재된 영국의 브루넬 대학교(Brunel University) 스포츠 교육학과 코스타스 카라게오그리스(Costas Karageorghis) 박사의 연구 결과에 따르면, 음악을 들으면서 운동하면 평소보다 15% 정도 더 오래 운동을 지속할 수 있다고 한다. 또한 운동할 때 음악을 적절하게 선택하면 신진대사, 근력, 호흡, 심박수 및 혈압 등에 영향을 주며 근육의 반사작용을 일으키게 하여 피로를 잊게 만들어주는 등 운동효과를 높여 준다.

  달리기의 경우, 1km를 얼마나 빠른 속도로 달리는지 측정지표인 ‘페이스(m/km)' 가 있다. 노래를 들으며 달릴 때, 목표로 하는 페이스와 속도가 맞는 노래를 듣는 경우에는 노래를 들으며 박자에 맞게 뛸 수 있지만, 본인의 페이스에 비해 조금 느리거나 빠른 노래가 나오면 운동 리듬 유지에 큰 어려움이 있다.

  사용자의 원하는 속도를 반영하여 노래를 재생시킴으로써 사용자의 운동 페이스를 일정하게 유지하게 한다. 이렇게 리듬을 잃지 않고 운동하게 도와줌으로써 운동 효과를 극대화시킬 수 있는 서비스를 만들게 되었다.

### 🌞 타겟층

1) 운동시 흐름이 끊기지 않고 규칙적인 페이스를 유지하고 싶은 사람
2) 듣고싶은 노래의 구간과 재생속도로 노래를 들으며 운동하고 싶은 사람
3) 본인의 신체 조건에 맞는 bpm을 추천받고 싶은 사람

결국 이 어플은 음악을 들으며 운동하는 모든 사람에게 도움이 된다.


# 🏃 프로젝트 세부 내용

### ✏️ Flow

![workflow](https://user-images.githubusercontent.com/56347876/172767889-95b2c800-073b-4e68-882c-0353701b3d09.png)

### ✏️ 프로젝트 구조

#### System Architecture 


<img width="665" alt="스크린샷 2022-06-09 오후 3 24 42" src="https://user-images.githubusercontent.com/56347876/172779026-4ab9c489-e03b-4e2d-b086-46a53e8e71f9.png">

1. React로 프론트를 구성하고 axios를 통해 Spring boot Rest API를 요청하고 응답
2. REST API를 통해 파이썬으로 개발한 음원 처리와 관련된 기능과 통신
3. Spring은 AWS RDS 서버에 있는 MySQLdb를 관리
4. API 서버는AWS EC2에 배포하고, DB는 AWS RDS를 이용하여 구축 

#### 음원 처리 기능(파이썬으로 진행)

1. librosa, ffmpeg 라이브러리를 사용
2. 해당 라이브러리를 활용해 음악의 음원의 BPM 변조
3. 사운드 클라우드와 연결하여 음악 서비스 제공


### ✏️ DB 설계

<img width="868" alt="디비설계" src="https://user-images.githubusercontent.com/56347876/172786270-fb9e3084-2e73-45bf-8f94-803d1032e518.png">

### ✏️ 기술 Logic

- 음악 다운로드 및 플레이리스트 생성

<img width="714" alt="다운플리생성" src="https://user-images.githubusercontent.com/56347876/172786023-39ee0e8c-9f82-424a-a9d4-8a61c674241d.png">

- 음원 처리

<img width="704" alt="음원" src="https://user-images.githubusercontent.com/56347876/172786053-b8b32555-1aae-4995-b8d4-48315a1b1bdc.png">

- BPM 추천

<img width="706" alt="bpm" src="https://user-images.githubusercontent.com/56347876/172786045-e3067479-1407-4240-8ace-7257705b06ff.png">



# ⏰ 개발 기간 (2022.02.27 ~ 2022.06.10)

기획 : 2022.02.27 ~ 2022.03.09    
개발 : 2022.03.10 ~ 2022.06.10


# 🛠️ 백엔드 실행

> ./gradlew build   
> cd build/libs   
> javr -jar faceYourPace-0.0.1-SNAPSHOT.jar

# 🏃 주요기능 소개

### 1️⃣ 로그인, 회원가입

<img width="1617" alt="1 로그인'" src="https://user-images.githubusercontent.com/56347876/172768562-01e41f7d-5760-4100-9453-a981fe719d9d.png">
<img width="1629" alt="2 회원가입" src="https://user-images.githubusercontent.com/56347876/172768607-7948eadc-d902-42ff-b9ed-5fb5a09bb97d.png"> 
<img width="1162" alt="회원가입222" src="https://user-images.githubusercontent.com/56347876/172796209-2a3881e9-3a88-45e1-807c-5181050db57c.png">


### 2️⃣ 메인 홈, 음악 추가

<img width="1629" alt="4 홈" src="https://user-images.githubusercontent.com/56347876/172769095-028714d1-69a3-401d-8c38-1607953fca45.png">
<img width="1175" alt="홈화면22" src="https://user-images.githubusercontent.com/56347876/172795998-5e32f277-ab34-4160-8204-26d456086827.png">
<img width="1629" alt="5 음악추가" src="https://user-images.githubusercontent.com/56347876/172769111-ec819169-251d-468e-a9fe-3887f4911e4b.png">


 ### 3️⃣ 플레이리스트, 스트리밍

<img width="1167" alt="플리음악목록" src="https://user-images.githubusercontent.com/56347876/172795931-7a46665a-00c8-4e57-8ee8-5520189dc67a.png">
<img width="1164" alt="플리음악추가" src="https://user-images.githubusercontent.com/56347876/172795963-a13d6126-7482-46c4-8555-0549eed68f29.png">
<img width="1625" alt="8 스트리밍" src="https://user-images.githubusercontent.com/56347876/172769363-6866e0f8-379a-4890-8f9d-ebcab4852cf2.png">


 ### 4️⃣ 음악 설정값 수정(config)

<img width="1631" alt="7 컨픽" src="https://user-images.githubusercontent.com/56347876/172769348-61f39d46-151a-42e1-8dac-e45cdd7c6433.png">


 ### 5️⃣ 사용자 신체 조건에 적합한 BPM 추천

<img width="1170" alt="bpm추천22" src="https://user-images.githubusercontent.com/56347876/172795882-4c704a9e-ff42-4744-8ae2-b2f0bf1f5ff7.png">


 ### 6️⃣ 사용자 정보 조회

<img width="1627" alt="10 정보조회" src="https://user-images.githubusercontent.com/56347876/172769449-bd36373c-493a-4c9b-b719-54c8235f5df0.png">



### 🛠️ 기술스택

- ForntEnd   
   - React Native
    - React Native Track Player
    - React Native Navigation

- BackEnd   
   - spring
    - Mysql 
    - JPA
 
- Function
    - Python
    - ffmpeg
 
### ✏️ 기획 및 설계

[📌 API 명세서](https://light-bay-b64.notion.site/API-a332d9c7632a4fe18ed4f120ff4eee74)

[📌 노션](https://light-bay-b64.notion.site/Face-Your-Pace-7f3801ddb7954ac391828738611ef13c)

[📌 Github(Frontend)](https://github.com/2022-1-Capstone-Project/face-your-pace-frontend)

[📌 Github(Backend)](https://github.com/2022-1-Capstone-Project/face-your-pace-backend)

[📌 Github(Function)](https://github.com/2022-1-Capstone-Project/face-your-pace-function)


### 👨‍👩‍👦‍👦 팀원 소개

|[김의찬](https://github.com/kuc00000)|[김휘경](https://github.com/hwikyungkim-1215)|[윤다인](https://github.com/yoondain)|
|:---:|:---:|:---:|
|프론트 개발|서버 개발|기능 개발|
|React Native<br/>로그인/회원가입 UI<br/>음악 추가 및 재생 UI<br/>플레이리스트 UI, BPM 추천 UI|Spring<br/>DB설계, 회원관리 기능<br/>음악 저장 기능, 플레이리스트 기능<br/>파이썬 연동, 서버 배포|Python<br/>사운드클라우드 URL을 통한 음원 다운 기능<br/>설정값에 따른 음원 추출 기능<br/>BPM 추천 기능|
