# 1. Base 이미지 지정
FROM eclipse-temurin:17-jdk-alpine

# 2. 빌드된 jar 파일 위치 지정
ARG JAR_FILE=build/libs/*.jar

# 3. jar 파일을 컨테이너 내부로 복사
COPY ${JAR_FILE} app.jar

# 4. prod 프로필을 활성화하여 실행하는 명령어
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/app.jar"]