mysql 오류로 인해 오류 해결 전까지 h2 데이터베이스를 이용합니다.

## 1. h2 데이터베이스 설치(Version 1.4.200를 사용해주세요)

 [1.4.200버전 다운]
 
 윈도우 설치 버전: https://h2database.com/h2-setup-2019-10-14.exe

 윈도우, 맥, 리눅스 실행 버전: https://h2database.com/h2-2019-10-14.zip

## 2. h2 설치 후 데이터베이스 파일 생성하기

jdbc:h2:~/jpashop (최소 한번)
~/jpashop.mv.db 파일 생성 확인
이후 부터는 jdbc:h2:tcp://localhost/~/jpashop 이렇게 접속


## 3. 데이터베이스 실행하기

1) 터미널에서 h2가 설치된 위치로 이동(cd)
2) cd bin
3) ./h2.sh
4) 터미널로 h2를 실행하면 localhost:8082로 접근한다.
5) JDBC URL을 jdbc:h2:tcp://localhost/~/fyp0로, 사용자명은 sa로 설정한 후 연결한다.

<img width="493" alt="h2셋팅" src="https://user-images.githubusercontent.com/56347876/163377875-93c0819b-503d-49d9-b2f7-3dd6450888ab.png">


## TEST 예시
### 회원가입 포스트맨 입력 방법
<img width="857" alt="회원가입_포스트맨TEST" src="https://user-images.githubusercontent.com/56347876/163378077-7626afb0-680c-4091-8edf-f848e9fb9928.png">

### h2 DB 
<img width="1068" alt="h2_예시" src="https://user-images.githubusercontent.com/56347876/163377955-f203d751-10b8-4ac1-93e1-0ffa927af15f.png">
