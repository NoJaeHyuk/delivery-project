# 배달 어플 기능 구현 프로젝트

## 🚚 프로젝트 소개 
배달어플의 기능을 구현한 Back-End API 서비스 프로젝트입니다. 

## 🧑🏻‍💻 구성원 
### BE 
> @[노재혁](https://github.com/NoJaeHyuk)


## 📚 Stack
<br/>
<div algin = left>
  <img src="https://img.shields.io/badge/java-FF5A00?style=for-the-badge&logo=Java&logoColor=white">
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
  <br/>
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=springboot&logoColor=black">
  <img src="https://img.shields.io/badge/spring security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=black">
  <br/>
  <img src="https://img.shields.io/badge/swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black">
  <br/>
  <img src="https://img.shields.io/badge/mariadb-4479A1?style=for-the-badge&logo=mariadb&logoColor=white">
  <br/>
  <img src="https://img.shields.io/badge/intellij-000000?style=for-the-badge&logo=intellijidea&logoColor=white">
  <img src="https://img.shields.io/badge/postman-FF6C37?style=for-the-badge&logo=postman&logoColor=black">
</div>


## 📑 Convention
### 패키지 구조
```
├─main
│  ├─java
│  │  └─com
│  │      └─sjc
│  │          └─delivery
│  │              ├─config
│  │              ├─domain
│  │              │  ├─cart
│  │              │  │  ├─controller
│  │              │  │  ├─entity
│  │              │  │  ├─repository
│  │              │  │  └─service
│  │              │  ├─food
│  │              │  │  ├─controller
│  │              │  │  ├─dto
│  │              │  │  │  ├─request
│  │              │  │  │  └─response
│  │              │  │  ├─entity
│  │              │  │  ├─exception
│  │              │  │  ├─repository
│  │              │  │  └─service
│  │              │  ├─order
│  │              │  │  ├─controller
│  │              │  │  ├─dto
│  │              │  │  │  ├─request
│  │              │  │  │  └─response
│  │              │  │  ├─entity
│  │              │  │  ├─exception
│  │              │  │  ├─repository
│  │              │  │  └─service
│  │              │  ├─store
│  │              │  │  ├─controller
│  │              │  │  ├─dto
│  │              │  │  │  ├─request
│  │              │  │  │  └─response
│  │              │  │  ├─entity
│  │              │  │  ├─exception
│  │              │  │  ├─repository
│  │              │  │  └─service
│  │              │  └─user
│  │              │      ├─controller
│  │              │      ├─dto
│  │              │      │  ├─request
│  │              │      │  └─response
│  │              │      ├─entity
│  │              │      ├─exception
│  │              │      ├─repository
│  │              │      └─service
│  │              └─global
│  │                  ├─enums
│  │                  ├─exception
│  │                  ├─handler
│  │                  ├─response
│  │                  └─utils
│  └─resources
│      ├─static
│      └─templates
└─test
    └─java
        └─com
            └─sjc
                └─delivery
```
### 📄ERD
[ERD 설계 링크](https://www.erdcloud.com/d/yzQhyrumBreu3Zqu3)   

### Commit 
- Feat: 기능 구현
- Fix: 수정
- Refactor: 개선
- Design: 스타일
- Command: 주석
- Doc: 문서, 이슈 템플릿
- Chore: 코드에 영향을 주지 않는 작업들
- Delete: 파일 삭제
- Test: 테스트 관련 작업들

### Branch 전략
- main(master) : 기준이 되는 브랜치로 제품을 배포하는 브랜치
- develop : 개발 브랜치로 개발자들이 이 브랜치를 기준으로 각자 작업한 기능들을 Merge
- feature : 단위 기능을 개발하는 브랜치로 기능 개발이 완료되면 develop 브랜치에 Merge

### Issues, PR, Merge
1. 프로젝트 진행 계획 및 이슈를 Github 이슈탭의 정해진 양식에 맞게 등록한다.
2. 생성한 이슈에 대해서 개발을 한 후에, 이슈를 닫는 pull-request를 develop 브랜치로 생성합니다.
3. 최종적으로 PR에서 이슈가 발견되지 않으면 main 브랜치로 PR을 보내 병합한다. 

## 🧑🏻‍💻 개발 기간 : `2주, 23.11.20 (월) ~ 23.12.01 (금)`









