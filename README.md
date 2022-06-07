# spring-boot-hexagonal-architecture-application

## 개발환경 구성

### Build

```
./gradlew clean build -x npm_ci -x npmBuild
```

### [Docker](https://www.docker.com/get-started) Install

### MariaDB Install

* docker-compose 실행

```
docker-compose up -d
```

### MariaDB Create Database

```
docker exec -it mariadb106 bash
mysql --protocol=tcp -hlocalhost -P3306 -uroot -proot
mysql> CREATE DATABASE board DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

MariaDB 접속 정보

* host / port: `localhost:3306`
* username: `root`
* password: `root`

### Data Migration (flyway)

최초로 마이그레이션을 실행할 때는 전체 데이터베이스를 초기화 할 수 있습니다.

```
./flyway-migration.sh
```

이후부터는 `flywayMigrate` 만 실행하여 테스트 데이터는 남겨두고 계속 DB 스키마만 변경할 수 있습니다.

```
./gradlew flywayMigrate
```

특정 도메인에 대해 스키마 변경을 진행하기 위해서는 모메인 모듈 명을 표기하여 실행합니다.

```
./gradlew board-persistence-adapter:flywayMigrate
```

### IntegrationTest

```
./gradlew integrationTest -x npm_ci -x npmBuild
```