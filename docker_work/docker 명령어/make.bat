./mvnw clean

./mvnw package -DskipTests

docker build -t spring-boot-docker .

