# Giới Thiệu: GraphQL

Grapql nó chỉ có duy nhất một entpoint  khác với restapi sẽ có nhiều endpoit khác nhau
Nó chỉ là một ngôn ngữ truy vấn nên nó không phải là khả năng thay thế cho thằng rest 
Mà chúng ta có thể bổ sung cho nhau và kết hợp cả 2 ở trong cùng 1 dự án 
Grapql có một hệ thống kiểu dữ liệu rõ ràng  và font end dễ dàng biết  được những sự thay đổi khi thực hiện request tới backend và thực hiện query mutation 

#  Có 3 loại GrahQL: 

![Alt text](image.png)

![Alt text](image-1.png)

# Sự khác biệt giữa GraphQl và restful api

![Alt text](image-2.png)

# Cách triển khai GraphQl trên spring boot



###  các depency cần thiết 

````java
  <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-graphql</artifactId>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.graphql-java/graphql-java -->
        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphql-java</artifactId>
            <version>21.3</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.graphql-java/graphql-java-extended-scalars -->
        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphql-java-extended-scalars</artifactId>
            <version>22.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.graphql-java/graphql-java-tools -->
        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphql-java-tools</artifactId>
            <version>5.2.4</version>
        </dependency>
````

Link chạy: http://localhost:8081/graphiql


```graphql
Get All Books

query {
  getAllBooks {
    id
    title
    author
  }
}

return 

{
  "data": {
    "getAllBooks": [
      {
        "id": "9",
        "title": "The Great Gats3333by",
        "author": "2222222"
      }
    ]
  }
}

Get Detail Books

query {
  getBookById(id: 9) {
    id
    title
    author
  }
}

return 

{
  "data": {
    "getBookById": {
      "id": "9",
      "title": "The Great Gats3333by",
      "author": "2222222"
    }
  }
}

Create Book

mutation {
  createBook(title: "The Great Gatsby", author: "F. Scott Fitzgerald") {
    id
    title
    author
  }
}

return 

{
  "data": {
    "createBook": {
      "id": "18",
      "title": "The Great Gatsby",
      "author": "F. Scott Fitzgerald"
    }
  }
}

Update book

mutation {
  updateBook(id: 18, title: "The Great Gatsby (Updated)", author: "F. Scott Fitzgerald") {
    id
    title
    author
  }
}

return 

{
  "data": {
    "updateBook": {
      "id": "18",
      "title": "The Great Gatsby (Updated)",
      "author": "F. Scott Fitzgerald"
    }
  }
}

Delete book
mutation {
  deleteBook(id: 1)
}

return 
{
  "data": {
    "deleteBook": true
  }
}

Authentication

signin

mutation {
  authenticateUser(username: "123", password: "123") {
    token
    username
    id
    roles
  }
}

return 

{
  "data": {
    "authenticateUser": {
      "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjMiLCJpYXQiOjE3MTc0ODQ1NDQsImV4cCI6MTcxNzU3MDk0NH0.EHbqKj9XAWWOGJ02-aZS7EbuNILt_3UCrNLl0sF1MAY",
      "username": "123",
      "id": "2",
      "roles": [
        "ROLE_USER"
      ]
    }
  }
}

signup

mutation {
  registerUser(
    signUpRequest: {
      username: "1233",
      email: "user@232232.com",
      password: "1234",
      role: ["user"]
    }
  ) {
    message
  }
}

return 

{
  "data": {
    "authenticateUser": {
      "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjMiLCJpYXQiOjE3MTc0ODQ1NDQsImV4cCI6MTcxNzU3MDk0NH0.EHbqKj9XAWWOGJ02-aZS7EbuNILt_3UCrNLl0sF1MAY",
      "username": "123",
      "id": "2",
      "roles": [
        "ROLE_USER"
      ]
    }
  }
}


```


