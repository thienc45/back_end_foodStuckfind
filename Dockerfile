# Sử dụng image chứa Java và Maven để build ứng dụng
FROM maven:3.8.4-openjdk-17 AS builder

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép tất cả các file từ thư mục gốc của dự án vào thư mục làm việc trong container
COPY . .

# Sử dụng Maven để build ứng dụng
RUN mvn clean package

# Sử dụng image chứa Java và Spring Boot để chạy ứng dụng
FROM openjdk:17-jdk-alpine

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép tệp jar đã được build từ builder stage vào thư mục làm việc trong container
COPY --from=builder /app/target/demo_food_truck_find-0.0.1-SNAPSHOT.jar .

# Chạy ứng dụng Spring Boot
CMD ["java", "-jar", "demo_food_truck_find-0.0.1-SNAPSHOT.jar"]
