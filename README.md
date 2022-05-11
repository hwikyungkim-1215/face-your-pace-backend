## 1. 셋팅 환경
### IntelliJ, MySQL

## 2. 데이터베이스 설정

### application.yml 설정

mysql 정보 설정
- username: mysql 유저네임으로 수정
- password: mysql 비밀번호로 수정

DB 데이터 보존 설정
- delete: 재실행시 데이터 다 날라감(초기화 할 때 사용)
- update: 재실행시 데이터 보존
<img width="956" alt="스크린샷 2022-05-11 오후 8 04 22" src="https://user-images.githubusercontent.com/56347876/167835203-73f496a7-4d17-49c4-855a-021e2117ef26.png">

## 3. 백엔드 구조

music: 음악 설정값을 통해 음악 추가
playList: 플레이리스트 생성

music과 playList는 상속관계

(여기선 로컬에 이미 존재하는 음악을 기준으로 한다)
1. 회원1이 플레이리스트를 추가한다(music_id와 playList_id로 연결하여 추가하게 된다)
2. 회원1이 음악을 추가한다
3. 음악과 플레이리스트는 상속관계  

-> 아래 예시를 참고로 하면,
play_list 테이블은 member_id와의 관계를 나타낸다.
play_list_music 테이블은 music_id와 play_list_id의 관계를 나타낸다.

ex) member테이블에서 id가 1인 회원이 music테이블의 id가 5인 음악을 플레이리스트(play_list테이블에서 id는 8)에추가하면,
play_list테이블에 member_id 1과 play_list_id 8이 추가되고
play_list_music테이블에 music_id 15과 play_list_id 8이 추가된다.

### 주의! 
회원가입 후 로그인을 해야 이후 기능을 실행할 수 있다.

## 4. TEST 예시
### 회원가입 포스트맨 입력 방법
<img width="857" alt="회원가입_포스트맨TEST" src="https://user-images.githubusercontent.com/56347876/163378077-7626afb0-680c-4091-8edf-f848e9fb9928.png">

#### MySQL member table
<img width="1025" alt="member" src="https://user-images.githubusercontent.com/56347876/167833894-3b0d4fb6-5ca1-4be3-ba4d-60c8a3a3c613.png">

### 로그인 포스트맨 입력 방법
<img width="858" alt="로그인" src="https://user-images.githubusercontent.com/56347876/166095828-fcc31652-9dc8-4a4d-b31b-9e233a018d22.png">

### 음악 추가 포스트맨 입력 방법(회원가입 -> 로그인 진행 후에 접근 가능)
<img width="864" alt="음악 설정 추가" src="https://user-images.githubusercontent.com/56347876/167833873-f4300fe4-bc39-4632-b500-906c2b20f573.png">

#### MySQL music table
<img width="815" alt="music table" src="https://user-images.githubusercontent.com/56347876/167833900-45c9ed62-4f06-4eb1-9241-8210aa025c84.png">


### 플레이리스트 추가
<img width="871" alt="플레이리스트 추가" src="https://user-images.githubusercontent.com/56347876/167833884-4f02901e-2611-4ebe-bf73-e145fac462fa.png">

#### MySQL play_list table
<img width="813" alt="플레이리스트 table" src="https://user-images.githubusercontent.com/56347876/167833891-ace2d194-5ba3-4b3c-9edd-5cc924759113.png">

### MySQL play_list_music table
<img width="815" alt="playListMusic table" src="https://user-images.githubusercontent.com/56347876/167833908-8ccb5b56-a037-4029-889e-cf7df902d7df.png">

