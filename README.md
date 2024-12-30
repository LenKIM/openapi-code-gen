# openapi-codegen-demo

해당 openapi-generator 에서 제공하는 spring-boot Codegen 을 커스텀한 Repository 입니다.



## 구성

- api-codegen(Java Version 11)

api-codegen 은 기존에 제공하던 [OPEN API codegenerator](https://openapi-generator.tech/) 를 Custom 한 모듈입니다. 문자열 템플릿 [mustache](https://mustache.github.io/) 에 대한 설정은 api-codegen/src/main/resources/custom-codegen 을 통해 확인하실 수 있습니다.

- api-mockserver(Java Version 11)

API 계약서(openapi.yaml) 기반으로 가짜 서버를 동작 시킬 수 있는 모듈입니다. 자세한 내용은 [MockServer Using OpenAPI](https://www.mock-server.com/mock_server/using_openapi.html) 에서 확인하실 수 있습니다.

- app(Java Version 11)

API 계약서를 설계하여 실제로 동작하는 애플리케이션이 동작하는 모듈입니다.



## How to run CodeGen

1. `./gradlew :api-codegen:build`

api-codegen 모듈을 Build 합니다.

2. `./gradlew clean :app:build`

openapi-generated 폴더가 생성되었음을 확인할 수 있습니다.

> 주의! 
>
> api-codegen build 를 먼저 실행 후, app 모듈의 코드를 빌드해야만 합니다.



## How to run Mockserver

`./gradlew :api-mockserver:run`

http://localhost:8085/apis/orders 에 접속하여 Mock Server 가 동작함을 확인할 수 있습니다.

## How to run App

` ./gradlew :app:bootRun` 

http://localhost:8080/apis/orders 에 접속하여 App 이 동작함을 확인할 수 있습니다.

> 주의!
>
> api-codegen build 를 먼저 실행 후, app 모듈의 코드를 실행해야만 합니다.

###### 

## API FIRST DESIGN 개발 프로세스

1. API 명세를 기반으로 API 계약서를 설계 한다.
   - app/src/main/codegen-config/api-order-contract.yml 에서 API 설계한 내용을 찾을 수 있습니다.
2. 설계된 API 계약서를 기반으로 이해관계자와 토론과 공유를 한다.
3. Open API 도구를 활용하여(여기서는 Code Generator) 코드를 구현한다.
4. API 문서를 관심있어 하는 이해관계자에게 전달한다.


만약, API 명세가 변경됨에 따른 프로세스는 다음과 같습니다.

1. API 명세가 담긴 API 계약서에서 변경할 API 의 내용을 변경한다.
2. 변경된 API 계약서를 기반으로 다시 Code Generator 를 실행한다.
3. API 가 변경되어 구현되지 않은 부분을 구현한다.