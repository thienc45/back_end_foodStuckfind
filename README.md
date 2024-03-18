# Spring Boot là gì? Tại sao lại chọn Spring Boot?

Spring Boot là một dự án bổ sung của Spring, nhằm đơn giản hóa việc phát triển ứng dụng Spring.

Spring Boot sử dụng Annotation để định nghĩa Endpoint, giúp dễ dàng xây dựng các endpoint RESTful mà không cần phải viết nhiều mã cấu hình. Các Annotation phổ biến như @RestController, @GetMapping, @PostMapping giúp việc xử lý HTTP requests trở nên dễ dàng và linh hoạt hơn.



# Thực thi dự án 
Cấu hình RestTemplate trong `spring-boot-starter-web`

Để cấu hình `RestTemplate` trong dự án sử dụng `spring-boot-starter-web`, ta sử dụng Annotation `@Configuration` để tạo bean `RestTemplate` thông qua Annotation `@Bean`.

`RestTemplate` là một công cụ mạnh mẽ trong Spring Boot, được sử dụng để thực hiện các chức năng phức tạp như gọi đến các REST services từ các trang web khác để lấy dữ liệu.

Sau khi cấu hình `RestTemplate` lấy dự liệu api từ một trang khác ta có thể sử dụng Annotation `@RestController` để tự động ánh xạ các yêu cầu HTTP đến các phương thức trong lớp và trả về dữ liệu dưới dạng JSON hoặc XML .
- Annotation `@RequestMapping` được sử dụng để định nghĩa ứng dụng chung cho đường dẫn API. Annotation `@CrossOrigin` cho phép quy định các chính sách giao tiếp giữa các tài nguyên từ các miền (origins) khác nhau. Annotation `@GetMapping` được sử dụng để lấy dữ liệu tương ứng.


# Triển khai ứng dụng Spring Boot trên AWS EC2 sử dụng Putty

1. **Tạo EC2 Instance**: Bắt đầu bằng việc tạo một EC2 Instance trên AWS Console.

2. **Download private key file**: Sau khi tạo EC2 Instance, tải về tệp khóa riêng tư (.pem).

3. **Thay đổi security group sử dụng port 8081**: Chỉnh sửa cấu hình nhóm bảo mật của EC2 Instance để mở cổng 8081 để có thể truy cập vào ứng dụng.

4. **Kết nối EC2 sử dụng Putty**: Sử dụng Putty để kết nối với EC2 Instance bằng cách sử dụng địa chỉ IP công khai của EC2 và tệp khóa riêng tư (.pem).

    ```bash
    ec2-user@public_host
    ```

5. **Thêm tệp .ppk vào Putty**: Sử dụng Puttygen để chuyển đổi tệp khóa riêng tư (.pem) sang định dạng .ppk, sau đó thêm tệp .ppk vào Putty để kết nối với EC2.

6. **Copy tệp Jar đến EC2 sử dụng WinSCP**: Sử dụng WinSCP để sao chép tệp jar của ứng dụng Spring Boot từ máy cục bộ của bạn đến EC2 Instance.

7. **Cài đặt Java Development Kit trên EC2**: Chạy lệnh sau trên EC2 để cài đặt JDK:

    ```bash
    sudo yum install java-17-openjdk-devel
    ```

8. **Chạy ứng dụng Java**: Sử dụng lệnh sau để chạy ứng dụng Java trên EC2:

    ```bash
    java -jar jar_name
    ```


[GitHub back_end_foodStuckfind](https://github.com/thienc45/back_end_foodStuckfind.git)


