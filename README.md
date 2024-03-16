1. Spring boot là gì? Tại sao lại chọn Spring boot?

Spring Boot là một dự án bổ sung của Spring, nhằm đơn giản hóa
việc phát triển ứng dụng Spring

Sử dụng Annotation để Định nghĩa Endpoint: Spring Boot cung cấp các Annotation như @RestController, @GetMapping, @PostMapping, vv. để dễ dàng định nghĩa các endpoint RESTful mà không cần phải viết nhiều mã cấu hình.

2. Cách build project dự án em chọn dependency:

spring-boot-starter-web:
+Dependency này là một trong những dependency cơ bản khi phát triển ứng dụng web với Spring Boot.
Nó cung cấp các thư viện và cấu hình cần thiết để phát triển các ứng dụng web, bao gồm Spring MVC và một máy chủ nhúng (embedded server) như Tomcat để chạy ứng dụng.

spring-boot-devtools:
+Dependency này cung cấp các công cụ hỗ trợ cho quá trình phát triển và làm nhanh quá trình phát triển ứng dụng Spring Boot.
Nó giúp giảm thời gian phát triển bằng cách tự động khởi động lại ứng dụng khi có sự thay đổi trong mã nguồn.

spring-boot-starter-test:
+chạy và quản lý các test unit trong ứng dụng Spring Boot

3. Cấu hình RestTemplate có sẵn trong spring-boot-starter-web bằng
   +@Configuration để dùng @Bean tạo bean RestTemplate
   -> để thực hiện các chức năng phức tạp gọi đến các REST services nên em dùng nó để call api lấy dữ liệu từ trang web khác .

Sau đó dùng @RestController nó sẽ tự động ánh xạ các yêu cầu HTTP đến các phương thức trong lớp và trả về dữ liệu dưới dạng JSON hoặc XML
@RequestMapping sử dụng ứng dụng chung cho đường dẫn api
@CrossOrigin cho phép quy định các chính sách giao tiếp giữa các tài nguyên khác nhau từ các miền (origins) khác nhau
Dùng @GetMapping để lấy giữ liệu tương ứng

     <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

4. Deploy Sping Boot Application with aws ec2 (.ppk->Putty)

Tạo EC2 Instance

Dowload private key file

Thay đổi security group sử dụng port 8081

Kết nối EC2 sử dụng Putty
ec2-user@public_host
Thêm ppk file to putty

Copy Jar file to EC2@ using App WinScp
sudo yum install java-17-openjdk-devel

Chạy chương trình java : java -jar jar_name
(Cách tạo file jar -> Vào dự án ->cmd ->mvn clean install)

