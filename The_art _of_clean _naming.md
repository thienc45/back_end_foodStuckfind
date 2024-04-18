
Một trong những phần khó nhất về mã hóa là "đặt tên" cho công cụ.

Khi được thực hiện chính xác, bất kỳ ai cũng có thể đọc mã của bạn.

Đăng ký

Khi thực hiện kém, những người khác có thể dành một lượng thời gian đáng kể để cố gắng tìm ra những gì đang xảy ra.

Một trong những phần khó nhất về mã hóa là "đặt tên" cho công cụ.

Khi được thực hiện chính xác, bất kỳ ai cũng có thể đọc mã của bạn.

Đăng ký

Khi thực hiện kém, những người khác có thể dành một lượng thời gian đáng kể để cố gắng tìm ra những gì đang xảy ra.

Nghệ thuật đặt tên sạch sẽ, và vâng, đó là một nghệ thuật, là thứ mà bạn có thể thực hành bất cứ lúc nào bạn viết mã. Đó là điều tôi thực hiện có chủ ý khi tôi viết mã. Có những lúc việc đặt tên đến với tôi một cách tự nhiên. Sau đó, có những lúc tôi không biết khi nào tôi nên đặt tên cho một cái gì đó nên tôi gọi nó là x.

Đó là khi tôi bắt đầu đặt tên cho mọi thứ x thay vì đó là nhân viên, khách hàng hay sinh viên. Hãy đi sâu vào và xem các ví dụ về các quy ước đặt tên tốt nhất trong mã.

Rõ ràng là chìa khóa


----------------------

Làm thế nào để một người thể hiện sự rõ ràng? Điều này không phải là siêu rõ ràng khi cố gắng đặt tên cho một cái gì đó?

Ví dụ, chúng ta hãy nghĩ về những ngày trong tuần. Tổng cộng có 7. Do đó, chúng ta có thể có mã như thế này:

    week = [‘Monday’, ‘Tuesday’, ‘Wednesday’, ‘Thursday’, ‘Friday’, ‘Saturday’, ‘Sunday’] 
    
    day = week[2]

Nhìn vào điều này, bạn có thể đang theo dõi cùng với suy nghĩ rằng điều này là hiển nhiên theo mặc định. Tuy nhiên, đây không phải là trường hợp. Ngày này có thể có ý nghĩa bất cứ điều gì. Đây có phải là một ngày trong năm? Ngày như ban ngày (đối diện với ban đêm)? Tuần này cũng có thể gây nhầm lẫn khi bạn chỉ nhìn vào quy ước đặt tên biến ngày.

Chúng ta có thể nâng cao điều này bằng cách nói:

    days_of_the_week = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'] 
    
    selected_day = days_of_the_week[2]

Bây giờ điều này đang trở nên tốt hơn, days\_of\_the\_week có ý nghĩa hơn chỉ một tuần và selected\_day có ý nghĩa hơn chỉ một ngày.

Tuy nhiên, khi nhìn vào selected\_day, cả 2 tượng trưng cho điều gì? 2 có phải là một chỉ số không? Trong trường hợp chính xác này, nó là, nhưng chúng tôi bắt đầu danh sách vào thứ Hai. Điều này có thể làm rối tung mọi thứ trong tương lai? Chúng tôi có thể làm cho điều này cụ thể hơn cho trường hợp sử dụng của chúng tôi không?

    MONDAY = 0 
    TUESDAY = 1 
    WEDNESDAY = 2 
    THURSDAY = 3 
    FRIDAY = 4 
    SATURDAY = 5 
    SUNDAY = 6 
    
    days_of_the_week = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'] 
    
    selected_day = days_of_the_week[WEDNESDAY]

Chúng ta có thể làm cho điều này thậm chí còn dễ đọc hơn bằng cách liệt kê trong ngày, nhưng tôi nghĩ bạn hiểu vấn đề. Bất kể điểm bắt đầu của mã này là gì, bạn biết ngay rằng selected\_day là "Thứ tư".

Cảm ơn bạn đã đọc Brain Bytes! Đăng ký miễn phí để nhận bài viết mới và hỗ trợ công việc của tôi!

Đăng ký

Cung cấp ngữ cảnh khi cần thiết


---------------------------------

Cung cấp ngữ cảnh trong tên biến là điều cần thiết để làm cho mã của bạn tự giải thích. Nó giúp các nhà phát triển khác (và chính bạn trong tương lai) hiểu mục đích và phạm vi của một biến mà không cần phải theo dõi việc sử dụng nó trên cơ sở mã. Thông tin ngữ cảnh trong một tên biến làm rõ vai trò của biến trong một cấu trúc hoặc quy trình lớn hơn.

#### **Tại sao ngữ cảnh lại quan trọng**

Nếu không có ngữ cảnh thích hợp, các nhà phát triển có thể hiểu sai mục đích hoặc phạm vi của biến, dẫn đến các lỗi tiềm ẩn hoặc lạm dụng các biến. Đặt tên theo ngữ cảnh đặc biệt quan trọng trong các cơ sở mã lớn hơn, nơi các biến có thể tương tác trên các mô-đun hoặc hàm khác nhau và sự mơ hồ có thể dẫn đến sự nhầm lẫn đáng kể.

#### **Giải thích ví dụ**

Giả sử chúng ta có mã như:

    first_name = "John" 
    last_name = "Doe"

Trong đoạn trích này, first\_name và last\_name quá chung chung. Trong một ứng dụng đơn giản hoặc nhỏ, điều này có thể thoát khỏi. Nếu mã này là một phần của một hệ thống lớn hơn xử lý nhiều thực thể, chẳng hạn như khách hàng, nhân viên và người dùng, thì không rõ những cái tên này đề cập đến ai.

Nếu chúng ta tiếp tục chỉ ra những gì có thể sai với những điều trên, chúng ta có thể thấy rằng:

*   **Sự mơ hồ:** Nếu không có ngữ cảnh, nhà phát triển có thể cho rằng những tên này đề cập đến người dùng hiện đang đăng nhập, hồ sơ nhân viên hoặc các thực thể khác.
    
*   **Khó khăn bảo trì:** Nếu người khác hoặc thậm chí bạn truy cập lại mã sau này, bạn sẽ phải suy ra ngữ cảnh từ việc sử dụng, điều này có thể tốn thời gian và dễ bị lỗi.
    

Để làm cho điều này dễ đọc hơn, chỉ cần thêm ngữ cảnh vào mỗi biến:

    customer_first_name = "Eric"
    customer_last_name = "Roby"

Bây giờ chúng ta ngay lập tức biết họ và tên dành cho ai. Họ là cho khách hàng! Bằng cách tiền tố first\_name và last\_name với customer\_, mục đích của các biến trở nên rõ ràng:

*   **Rõ ràng:** Rõ ràng là các biến này lưu trữ họ và tên của khách hàng, không phải bất kỳ thực thể nào khác.
    
*   **Dễ bảo trì:** Khi bạn hoặc các nhà phát triển khác xem lại mã, sẽ ngay lập tức rõ ràng những biến này đại diện cho điều gì, giảm tải nhận thức và khả năng nhầm lẫn.
    
*   **Cộng tác tốt hơn:** Trong môi trường nhóm, việc đặt tên rõ ràng, theo ngữ cảnh giúp các thành viên trong nhóm nhanh chóng hiểu và cộng tác trên mã, ngay cả khi họ nhìn thấy một phần cụ thể lần đầu tiên.
    

Tránh những con số kỳ diệu:


-----------------------------

Khái niệm "số ma thuật" trong lập trình đề cập đến việc sử dụng các số được mã hóa cứng trong mã của bạn mà không có ngữ cảnh hoặc tên giải thích. Những con số này được gọi là "ma thuật" vì ý nghĩa của chúng không rõ ràng nếu không có ngữ cảnh bổ sung, khiến mã khó hiểu và khó duy trì hơn. Thay thế các số ma thuật bằng các hằng số được đặt tên không chỉ làm rõ mục đích của chúng mà còn đơn giản hóa các sửa đổi trong tương lai và tăng khả năng đọc của mã.

Có một vài lý do tại sao bạn nên tránh những con số kỳ diệu, nhưng lý do lớn nhất sẽ là vì khả năng đọc.

Giả sử chúng ta có mã này:

    if age >= 21:
        # Do something

Không rõ 21 là viết tắt của gì. Tại sao tuổi phải lớn hơn 21 để làm điều gì đó? Cũng là tuổi của cái gì, một người?

Tại Hoa Kỳ, tuổi uống rượu là 21. Tôi biết điều này khác nhau giữa các quốc gia nhưng tôi muốn đảm bảo rằng tất cả chúng ta đều ở trên cùng một trang về mã sắp tới.

    legal_drinking_age = 21
    if user_age >= legal_drinking_age:
        # Cheers!

Có 0 nhầm lẫn với mã này. Độ tuổi uống rượu hợp pháp là 21 và khi user\_age lớn hơn hoặc bằng 21, họ có thể uống. Có ý nghĩa và dễ đọc.

Trong phiên bản cải tiến:

*   **Mã tự giải thích:** Biến legal\_drinking\_age chỉ ra rằng 21 là ngưỡng tuổi uống rượu hợp pháp. Nó hoạt động như mã tự ghi lại, làm cho các nhận xét không cần thiết để giải thích tầm quan trọng của con số.
    
*   **Dễ dàng cập nhật:** Nếu tuổi uống rượu hợp pháp thay đổi, bạn chỉ cần cập nhật hằng số legal\_drinking\_age và thay đổi phản ánh bất cứ nơi nào nó được sử dụng.
    
*   **Giảm lỗi:** Bằng cách sử dụng hằng số có tên, bạn giảm nguy cơ mắc lỗi chính tả hoặc cập nhật không chính xác. Thay đổi một lần xuất hiện từ 21 thành 18 nhưng thiếu những lần khác có thể gây ra lỗi. Với một hằng số được đặt tên, rủi ro này được giảm thiểu.
    

Tránh viết tắt và viết tắt


----------------------------

Tránh viết tắt và viết tắt trong mã của bạn trừ khi chúng được hiểu rộng rãi là một nguyên tắc quan trọng trong việc viết mã sạch, dễ đọc và có thể duy trì. Chữ viết tắt và từ viết tắt có thể che khuất đáng kể ý nghĩa mã của bạn và khiến người khác (và chính bạn trong tương lai) khó hiểu hơn, đặc biệt nếu chúng không phải là tiêu chuẩn trên toàn miền hoặc cộng đồng lập trình.

### **Tại sao tránh viết tắt và tắt từ**

1.  **Rõ ràng:** Các chữ viết tắt hoặc từ viết tắt không chuẩn có thể dẫn đến nhầm lẫn hoặc giải thích sai. Ví dụ: acc có thể có nghĩa là "tài khoản", "bộ tích lũy" hoặc "bộ tăng tốc", tùy thuộc vào ngữ cảnh.
    
2.  **Khả năng đọc:** Tên đầy đủ làm cho mã của bạn dễ đọc và tự giải thích hơn. Người đọc không phải tạm dừng để giải mã chữ viết tắt là viết tắt của gì hoặc tìm kiếm nó ở nơi khác.
    
3.  **Bối cảnh quốc tế:** Trong các nhóm toàn cầu, một chữ viết tắt có ý nghĩa trong một ngôn ngữ hoặc văn hóa có thể không rõ ràng hoặc có nghĩa khác ở một ngôn ngữ khác.
    
4.  **Tính nhất quán:** Các nhà phát triển khác nhau có thể sử dụng các chữ viết tắt khác nhau cho cùng một thuật ngữ, dẫn đến việc đặt tên không nhất quán trên cơ sở mã.
    

### **Phân tích ví dụ chi tiết**

#### Không viết tắt

    account_balance

*   **Rõ ràng:** Thuật ngữ account\_balance không có chỗ cho sự mơ hồ; nó chỉ ra rằng biến đại diện cho số dư của một tài khoản.
    

#### Với chữ viết tắt

    acc_bal

*   **Không rõ ràng:** Ở đây, acc có thể là viết tắt của "account", nhưng nó cũng có thể có nghĩa là "accumulator" hoặc bất kỳ thuật ngữ nào khác bắt đầu bằng "acc". Tương tự, bal có thể có nghĩa là "cân bằng", nhưng nó cũng có thể là viết tắt của "đạn đạo", "ban công", v.v., trong các ngữ cảnh khác nhau.
    

### **Các phương pháp hay nhất để đặt tên**

1.  **Sử dụng Tên đầy đủ:** Luôn chọn tên mô tả đầy đủ thay vì viết tắt. Ví dụ: sử dụng customer\_address thay vì cust\_addr.
    
2.  **Các từ viết tắt phổ biến là Okay:** Có thể sử dụng các từ viết tắt và chữ viết tắt được công nhận rộng rãi là tiêu chuẩn trong ngành hoặc ngôn ngữ lập trình. Ví dụ, HTTP cho Hypertext Transfer Protocol được công nhận rộng rãi.
    
3.  **Tài liệu viết tắt không rõ ràng:** Nếu bạn phải sử dụng chữ viết tắt, hãy đảm bảo nó được ghi lại gần với lần sử dụng đầu tiên hoặc trong một khu vực tài liệu chung nếu nó được sử dụng rộng rãi trên cơ sở mã.
    
4.  **Viết tắt nhất quán:** Nếu chữ viết tắt là cần thiết và không có tiêu chuẩn tồn tại, hãy xác định một tiêu chuẩn trong dự án của bạn và sử dụng nó một cách nhất quán.
    
5.  **Đánh giá mã:** Sử dụng các đánh giá mã để nắm bắt và thảo luận về các chữ viết tắt không chuẩn, đảm bảo sự đồng thuận của nhóm về các quy ước đặt tên.
    

Bằng cách ưu tiên đặt tên rõ ràng và mô tả, bạn nâng cao khả năng hiểu và khả năng bảo trì mã của mình, giúp các nhà phát triển hiện tại và tương lai dễ tiếp cận hơn, bao gồm cả những người có thể không chia sẻ ngữ cảnh hoặc nền tảng của bạn.

Chúc vui vẻ

Eric

Cảm ơn bạn đã đọc Brain Bytes! Đăng ký miễn phí để nhận bài viết mới và hỗ trợ công việc của tôi.


