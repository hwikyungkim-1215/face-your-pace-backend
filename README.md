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
5) JDBC URL을 jdbc:h2:tcp://localhost/~/fyp0로 설정한 후 연결한다.
