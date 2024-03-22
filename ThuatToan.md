# Hành trình xuyên qua thế giới thuật toán:

Đã lâu rồi tôi mới viết một bài báo và bài viết hôm nay sẽ tập trung vào các thuật toán thường xuyên khiến chúng tôi đau đầu. Tôi dự định thu thập một bản tóm tắt thông tin thuật toán nhiều nhất mà tôi đã đọc và nghiên cứu. Nó sẽ hơi dài một chút nhưng tôi rất vui được cùng bạn tìm hiểu sâu về nó.

Để hiểu khái niệm về thuật toán, tôi nghĩ cần phải nắm được một số [**cấu trúc dữ liệu**](https://ocw.metu.edu.tr/course/view.php?id=90) . Nếu bạn muốn [xem qua](https://towardsdatascience.com/8-common-data-structures-every-programmer-must-know-171acf6a1a42) , tôi sẽ đính kèm một số liên kết [ở đây](https://www.techtarget.com/searchdatamanagement/definition/data-structure) trước khi chúng ta bắt đầu.

## Các chủ đề chúng tôi sẽ đề cập trong bài viết này:

- Thuật toán là gì?
- Nguyên tắc cơ bản của phân tích thuật toán
- Phân tích hiệu suất của một thuật toán
- Ký hiệu Big-O
- Trường hợp tốt nhất và trường hợp xấu nhất
- Kỹ thuật thiết kế thuật toán
- Chiến lược tìm kiếm thuật toán
- Ví dụ về một số thuật toán nổi tiếng

> Lấy cà phê của bạn và bắt đầu bài viết này.

# **Thuật toán**

Thuật toán là một tập hợp các hướng dẫn để hoàn thành một nhiệm vụ. Mục đích của thuật toán là cung cấp hướng dẫn rõ ràng để giải quyết vấn đề, cụ thể là đạt được đầu ra cần thiết cho bất kỳ đầu vào hợp lệ nào trong một khung thời gian cụ thể. Mỗi đoạn mã có thể được gọi là một thuật toán.

Việc sử dụng các thuật toán được phổ biến rộng rãi trong **việc giải quyết vấn đề** , **nâng cao hiệu quả** và **đổi mới** trên nhiều lĩnh vực khác nhau. Tầm quan trọng của chúng nằm ở những tiến bộ trong công nghệ, khoa học và ứng dụng thực tế, khi chúng đưa ra các giải pháp có cấu trúc và hiệu quả cho nhiều thách thức khác nhau.

![alt text](image-15.png)

                      Từ một bức vẽ trong sổ tay của tôi

# Các phương pháp xác định thuật toán

Đôi khi một thuật toán được mô tả bằng từ ngữ (ở dạng miễn phí và từng bước) hoặc bằng mã giả.

Sử dụng ngôn ngữ tự nhiên có sức hấp dẫn rõ ràng; tuy nhiên, sự mơ hồ cố hữu của bất kỳ ngôn ngữ tự nhiên nào khiến cho việc mô tả thuật toán ngắn gọn và rõ ràng trở nên khó khăn một cách đáng ngạc nhiên.

Tuy nhiên, có thể làm được điều này là một kỹ năng quan trọng mà bạn nên cố gắng phát triển trong quá trình học thuật toán.

- **Ngôn ngữ tự nhiên:** Thuật toán có thể được mô tả bằng ngôn ngữ tự nhiên, như tiếng Anh. Phương pháp này có thể tiếp cận được với nhiều đối tượng nhưng có thể thiếu độ chính xác và tính chất rõ ràng cần thiết cho các thuật toán phức tạp.
- **Mã giả:** Một thuật toán kết hợp các yếu tố của cả ngôn ngữ tự nhiên và quy ước ngôn ngữ lập trình được gọi là mã giả, là một mô tả cấp cao, không chính thức. Nó có cấu trúc chặt chẽ hơn ngôn ngữ tự nhiên và giúp thu hẹp khoảng cách giữa sự hiểu biết của con người và mã. Mã giả, như tên cho thấy, là một mã sai hoặc một cách thể hiện mã mà ngay cả một người bình thường có một số kiến ​​thức lập trình cấp trường cũng có thể hiểu được.

\*\*Ví dụ: Tính số Fibonacci đến 50

Mã giả\*\*

**1-** Khai báo biến số nguyên n  
**2-** Khai báo biến số nguyên sum  
**3-** Khai báo biến số nguyên f1  
**4-** Khai báo biến số nguyên f2  
**5-** Đặt tổng bằng 0  
**6-** Đặt f1 và f2 đến 1  
**7-** Đặt n thành 50  
**8-** Lặp lại n lần  
**_a._** tổng=f1+f2  
**_b._** f2=f1  
**_c._** f1=tổng  
**_d._** in tổng  
**9-** Kết thúc vòng lặp

- **Lưu đồ:** Trong những ngày đầu của điện toán, phương tiện chủ yếu để xác định thuật toán là lưu đồ, một phương pháp biểu diễn thuật toán bằng một tập hợp các hình dạng hình học được kết nối chứa các mô tả về các bước của thuật toán.
- **Mã ngôn ngữ lập trình:** Một phương pháp có độ chính xác cao là viết thuật toán trực tiếp bằng ngôn ngữ lập trình. Nó phù hợp khi mục tiêu là triển khai thuật toán trong phần mềm. Tuy nhiên, nó có thể khó tiếp cận hơn đối với những người không phải là lập trình viên.

// Triển khai đệ quy ví dụ về

lớp Fibonacci Series { static int fib ( int n) { if (n <= 1 ) return n; trả về fib(n - 1 ) + fib(n - 2 ); } public static void main (String args\[\]) { int N \= 50 ; for ( int i \= 0 ; i < N; i++) {System.out.println(fib(i) + " " );} } }

# Nguyên tắc cơ bản của phân tích thuật toán

Chúng tôi thường muốn thuật toán của mình sở hữu một số phẩm chất. Sau **sự đúng đắn** , điều quan trọng nhất cho đến nay là **hiệu quả** .

Có hai loại **hiệu quả** của thuật toán : **hiệu quả về thời gian** , cho biết thuật toán chạy nhanh như thế nào và **hiệu quả về không gian** , cho biết nó sử dụng thêm bao nhiêu bộ nhớ.

Một đặc tính mong muốn khác của thuật toán là **tính đơn giản** . Không giống như hiệu quả, có thể được xác định và nghiên cứu một cách chính xác bằng sự chặt chẽ về mặt toán học, sự đơn giản, giống như vẻ đẹp, ở một mức độ đáng kể trong mắt người nhìn. Đôi khi các thuật toán đơn giản hơn cũng hiệu quả hơn các giải pháp thay thế phức tạp hơn. Thật không may, điều đó không phải lúc nào cũng đúng, trong trường hợp đó cần phải thực hiện một sự thỏa hiệp sáng suốt.

Tuy nhiên, một đặc tính mong muốn khác của thuật toán là **tính tổng quát** . Trên thực tế, có hai vấn đề ở đây: tính tổng quát của vấn đề mà thuật toán giải quyết và tập hợp đầu vào mà thuật toán chấp nhận.

Nếu bạn không hài lòng với tính **hiệu quả** , **tính đơn giản** hoặc **tính tổng quát** của thuật toán , bạn phải quay lại bảng vẽ và thiết kế lại thuật toán.

Một vấn đề quan trọng khác của việc giải quyết vấn đề bằng thuật toán là câu hỏi liệu mọi vấn đề có thể được giải quyết bằng thuật toán hay không. Ở đây chúng ta không nói về những bài toán không có nghiệm, chẳng hạn như tìm nghiệm thực của phương trình bậc hai với phân biệt âm. Đối với những trường hợp như vậy, kết quả đầu ra chỉ ra rằng bài toán không có lời giải là tất cả những gì chúng ta có thể và nên mong đợi từ một thuật toán.

![alt text](image-16.png)

Chúng ta có thể lấy **Bài toán cầu Königsberg** làm ví dụ về một thuật toán không có lời giải. Nếu bạn thắc mắc nó là gì thì tôi đã thêm một liên kết [vào đây](https://maa.org/press/periodicals/convergence/leonard-eulers-solution-to-the-konigsberg-bridge-problem) để bạn nghiên cứu.

Chúng ta cũng không nói về những vấn đề được nêu một cách mơ hồ. Ngay cả một số vấn đề rõ ràng phải có câu trả lời đơn giản là có hoặc không cũng **không thể giải quyết được** , tức là không thể giải được bằng bất kỳ thuật toán nào.

Tóm lại, việc triển khai một thuật toán một cách chính xác là cần thiết nhưng chưa đủ: bạn sẽ không muốn làm giảm sức mạnh của thuật toán bằng việc triển khai không hiệu quả.

# Phân tích hiệu suất của một thuật toán

Các giải pháp hoặc thuật toán khác nhau phải được đánh giá về **hiệu suất** và **hiệu quả** của chúng , bao gồm thời gian cần thiết để chạy/thực thi và tổng bộ nhớ đã tiêu thụ.

Hiệu suất của một thuật toán nảy sinh từ câu hỏi làm thế nào để đo lường hiệu suất của thuật toán đó.

Vấn đề này phát sinh khi lựa chọn thuật toán “tốt nhất” trong số các thuật toán được đưa ra để giải một bài toán. Ba phương pháp cơ bản thường được sử dụng để đo hiệu suất của thuật toán: Đây là **phân tích thử nghiệm** , **phân tích xác suất (trường hợp trung bình)** và **phân tích trường hợp xấu nhất** . Ưu tiên của chúng tôi sẽ là tập trung vào phân tích trường hợp xấu nhất, được kết nối với ký hiệu Big-O mà chúng tôi dự định đề cập.

![alt text](image-17.png)

Phân tích trường hợp xấu nhất là phân tích độ lệch so với mức tối ưu xảy ra khi áp dụng heuristic H đặc biệt cho các trường hợp của bài toán P. Độ phức tạp của thuật toán liên quan đến thời gian thực hiện của nó. Thời gian mà một thuật toán yêu cầu, còn được gọi là thời gian chạy, phụ thuộc vào cả cấu trúc và kích thước của dữ liệu.

Hiệu quả trong trường hợp xấu nhất của thuật toán là hiệu quả của nó đối với đầu vào trong trường hợp xấu nhất có kích thước n, là đầu vào (hoặc đầu vào) có kích thước n mà thuật toán chạy lâu nhất trong số tất cả các đầu vào có thể có của kích thước đó.

Để so sánh và xếp hạng các bậc tăng trưởng như vậy, các nhà khoa học máy tính sử dụng ba ký hiệu: Big oh, big omega và big theta. Trong 3 phương pháp này chúng ta sẽ chỉ tập trung vào ký hiệu Big-O.

![alt text](image-18.png)

# Ký hiệu Big-O

Trong khoa học máy tính, ký hiệu O lớn được sử dụng để phân loại các thuật toán theo yêu cầu về thời gian hoặc không gian chạy của chúng tăng lên khi kích thước đầu vào tăng lên.

![alt text](image-19.png)

![](https://miro.medium.com/v2/resize:fit:656/1*R-nihcTkRFnzJM9JqY3O4g.png)

# Kỹ thuật thiết kế thuật toán

Kỹ thuật thiết kế thuật toán (hoặc mô hình hoặc chiến lược) là một cách tiếp cận chung để giải quyết vấn đề bằng thuật toán, áp dụng cho nhiều vấn đề khác nhau từ các lĩnh vực điện toán khác nhau.

![alt text](image-20.png)

Một số kỹ thuật thiết kế thuật toán

![alt text](image-21.png)

# Một số ví dụ về thuật toán

# **CHIA & CHINH PHỤC**

Thuật toán chia để trị hoạt động theo sơ đồ chung sau:

- Một bài toán được chia thành nhiều bài toán con cùng loại, lý tưởng nhất là có kích thước bằng nhau.
- Các bài toán con được giải (thường là đệ quy, mặc dù đôi khi một thuật toán khác được sử dụng, đặc biệt khi các bài toán con trở nên đủ nhỏ).
- Nếu cần thiết, lời giải của các bài toán con sẽ được kết hợp để có được lời giải cho bài toán ban đầu.

# **_Hợp nhất Sắp xếp_**

Sắp xếp hợp nhất là một ví dụ hoàn hảo về việc áp dụng thành công kỹ thuật chia để trị. Nó được định nghĩa là một thuật toán sắp xếp hoạt động bằng cách chia một mảng thành các mảng con nhỏ hơn, sắp xếp từng mảng con và sau đó hợp nhất các mảng con đã sắp xếp lại với nhau để tạo thành mảng được sắp xếp cuối cùng.

![alt text](image-22.png)

_Sắp xếp hợp nhất là một thuật toán đệ quy liên tục chia mảng làm đôi cho đến khi không thể chia thêm được nữa, tức là mảng chỉ còn một phần tử (mảng có một phần tử luôn được sắp xếp). Sau đó, các mảng con đã sắp xếp được hợp nhất thành một mảng đã sắp xếp._

![alt text](image-23.png)

[https://en.m.wikipedia.org/wiki/File:Merge-sort-example-300px.gif](https://en.m.wikipedia.org/wiki/File:Merge-sort-example-300px.gif)

## **Các ứng dụng của Sắp xếp Hợp nhất:**

- Sắp xếp các tập dữ liệu lớn (Độ phức tạp về thời gian trong trường hợp xấu nhất là O(n log n))
- Sắp xếp bên ngoài
- Sắp xếp tùy chỉnh
- Vấn đề đếm đảo ngược

> Hãy viết mã:
> import java.util.Arrays;

class Quicksort {

static int partition(int array[], int low, int high) {

    int pivot = array[high];
    int i = (low - 1);

    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {
        i++;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }

    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    return (i + 1);

}

static void quickSort(int array[], int low, int high) {
if (low < high) {

      int pi = partition(array, low, high);

      quickSort(array, low, pi - 1);
      quickSort(array, pi + 1, high);
    }

}
}

class Main {
public static void main(String args[]) {

    int[] data = { 8, 7, 2, 1, 0, 9, 6 };
    System.out.println("Unsorted Array");
    System.out.println(Arrays.toString(data));

    int size = data.length;

    Quicksort.quickSort(data, 0, size - 1);

    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(data));

}
}

# **_Sắp xếp nhanh chóng_**

Quicksort là thuật toán sắp xếp quan trọng khác dựa trên phương pháp chia để trị. Không giống như mergesort chia các phần tử đầu vào theo vị trí của chúng trong mảng, quicksort chia chúng theo giá trị của chúng.

Quá trình quan trọng trong “ **Sắp xếp nhanh”** là một **phân vùng()** . Các phân vùng nhằm mục đích định vị **_trục xoay_** (có thể là bất kỳ phần tử nào) vào đúng vị trí trong mảng đã sắp xếp. Đặt tất cả các phần tử nhỏ hơn ở bên trái của trục và tất cả các phần tử lớn hơn ở bên phải của trục.

![alt text](image-25.png)

> Hãy viết mã:

# Cây nhị phân

Các thuật toán chia để trị quan trọng nhất cho cây nhị phân là ba phép duyệt cổ điển: **preorder** , **inorder** và **postorder** . Tất cả ba lần duyệt đều truy cập các nút của cây nhị phân một cách đệ quy, tức là bằng cách truy cập vào gốc của cây cũng như các cây con trái và phải của cây. Chúng chỉ khác nhau ở thời điểm truy cập của root:

- Trong **quá trình duyệt theo thứ tự trước** , gốc được truy cập trước khi thăm cây con trái và phải (theo thứ tự đó).

![alt text](image-26.png)

Một ví dụ về “Truyền tải đặt hàng trước”

- Trong **quá trình duyệt theo thứ tự** l, gốc được truy cập sau khi thăm cây con bên trái của nó nhưng trước khi thăm cây con bên phải.

![alt text](image-27.png)

Một ví dụ về “Truyền tải theo thứ tự”

- Trong **quá trình duyệt theo thứ tự sau** , gốc được truy cập sau khi truy cập cây con bên trái và bên phải (theo thứ tự đó).

![alt text](image-28.png)

Một ví dụ về “Truyền tải theo thứ tự sau”

# **BIẾN ĐỔI & CHINH PHỤC**

Công việc biến đổi và chinh phục được tiến hành theo hai giai đoạn. Đầu tiên, trong giai đoạn chuyển đổi, trường hợp của vấn đề được sửa đổi để, vì lý do này hay lý do khác, phù hợp hơn với giải pháp. Sau đó, ở giai đoạn thứ hai hay giai đoạn chinh phục, nó được giải quyết.

![alt text](image-29.png)

- Sắp xếp trước
- Cây
- Heap & Heapsort

Hãy chọn “Thuật toán Heapsort” để kiểm tra.

# **Heapsort**

Heap là Cây nhị phân hoàn chỉnh trong đó giá trị tại mỗi nút lớn hơn hoặc nhỏ hơn nút con của nó. Có hai loại Heap:

- **Heap tối đa** : Giá trị của mỗi nút LỚN HƠN so với các nút con của nó.
- **Min Heap** : Giá trị của mỗi nút NHỎ HƠN so với các nút con của nó.

Heapify là hoạt động xây dựng một đống từ các phần tử của một mảng. Hoạt động Heapify có thể được sử dụng để xây dựng vùng heap tối đa hoặc vùng heap tối thiểu.

![](https://miro.medium.com/v2/resize:fit:446/1*pFX7PzBxeRZ11qmoJP_BhA.gif)

[https://commons.wikimedia.org/wiki/File:Heap_sort_example.gif](https://commons.wikimedia.org/wiki/File:Heap_sort_example.gif)

Trong ví dụ về cây dưới đây, tất cả cha mẹ đều được xếp nhỏ hơn con cái của họ. (Min-đống)

![alt text](image-30.png)

Để không làm bài dài hơn chúng ta sẽ bỏ qua thao tác **xóa** , **thêm dữ liệu** và xem xét việc sắp xếp.

![alt text](image-31.png)

# LẬP TRÌNH NĂNG ĐỘNG

Lập trình động là một kỹ thuật lập trình máy tính trong đó một vấn đề thuật toán trước tiên được chia thành các vấn đề phụ, kết quả được lưu lại và sau đó các vấn đề phụ được tối ưu hóa để tìm ra giải pháp tổng thể - thường liên quan đến việc tìm giá trị lớn nhất và nhỏ nhất phạm vi của truy vấn thuật toán.

- Hàng xu
- Vấn đề về ba lô
- Thuật toán Warshall và Floyd

# **Vấn đề về hàng xu**

![alt text](image-32.png)

Một số đồng xu có mệnh giá khác nhau được xếp thành một hàng.

Hai người chơi lần lượt lấy một đồng xu ở hai đầu hàng. Họ có thể tự do lựa chọn đầu hàng nào để lấy đồng xu, nhưng không được phép lấy đồng xu từ giữa hàng. Người chiến thắng trong trò chơi là người chơi thu thập được nhiều tiền nhất.

Peter Winkler, trong cuốn sách [Câu đố toán học](https://faculty.dartmouth.edu/artsandsciences/news/2023/10/math-puzzles-public) của mình , mô tả một chiến lược đơn giản được đảm bảo có hiệu quả nhưng chỉ khi số lượng đồng xu là số chẵn.

## Nếu số xu là CHỈ?

Nếu tổng số đồng lẻ lớn hơn thì người chơi 1 bắt đầu trò chơi với đồng xu thứ nhất và tiếp tục lấy các đồng xu lẻ. Ngược lại, người chơi 1 lấy đồng xu cuối cùng và tiếp tục lấy đồng xu chẵn. Điều này có thể thực hiện được vì khi bắt đầu trò chơi, người chơi 1 có quyền lựa chọn là chọn đồng xu đầu tiên là số lẻ hoặc đồng xu cuối cùng là số chẵn. Sau khi người chơi 1 nhặt được đồng xu mà mình chọn, người chơi 2 luôn phải đối mặt với các đồng xu chẵn lẻ đối diện ở cả hai đầu. Vì vậy, bất kể người chơi 2 lấy đồng xu từ đầu nào, người chơi 1 đều có thể nhặt đồng xu từ cùng một đầu và sẽ được đảm bảo không thua trò chơi.

![alt text](image-33.png)

# THAM

Những yêu cầu này giải thích tên của kỹ thuật: ở mỗi bước, nó gợi ý một cách **“tham lam”** chọn phương án thay thế tốt nhất hiện có với hy vọng rằng một chuỗi các lựa chọn tối ưu cục bộ sẽ mang lại giải pháp tối ưu (toàn cầu) cho toàn bộ vấn đề.

- Vấn đề đồ thị
- Thuật toán Dijkstra
- Cây bao trùm
- Thuật toán cơ bản

# Thuật toán cơ bản

Thuật toán cây khung tối thiểu Prim là một trong những phương pháp hiệu quả để tìm cây khung tối thiểu của đồ thị.

Thuật toán, tương tự như bất kỳ thuật toán đường đi ngắn nhất nào, bắt đầu từ một đỉnh được đặt làm gốc và đi qua tất cả các đỉnh trong biểu đồ bằng cách xác định các cạnh liền kề có chi phí thấp nhất.

![alt text](image-34.png)

**_BƯỚC 1_**

![alt text](image-35.png)

**_BƯỚC 2_**

![alt text](image-36.png)

**_BƯỚC 3_**

![alt text](image-37.png)

**_BƯỚC 4_**

![alt text](image-38.png)

**_BƯỚC 5_**

![alt text](image-39.png)

# **Lực lượng vũ phu**

Thuật toán Brute Force đúng như tên gọi của chúng - các phương pháp đơn giản để giải quyết vấn đề dựa vào sức mạnh tính toán tuyệt đối và thử mọi khả năng thay vì các kỹ thuật nâng cao để nâng cao hiệu quả.

- Sắp xếp bong bóng
- Sắp xếp lựa chọn
- Tìm kiếm theo chiều rộng
- Tìm kiếm theo chiều sâu

# Sắp xếp bong bóng

Bubble Sort là một thuật toán sắp xếp đơn giản giúp hoán đổi các phần tử liền kề liên tục nếu chúng sai thứ tự. Độ phức tạp về thời gian trung bình và trường hợp xấu nhất của thuật toán này khiến nó không phù hợp với các tập dữ liệu lớn.

![](https://miro.medium.com/v2/resize:fit:281/1*1MiLjMYgr2r2fDORCJn89w.gif)

[https://commons.wikimedia.org/wiki/File:Bubble-sort-example-300px.gif](https://commons.wikimedia.org/wiki/File:Bubble-sort-example-300px.gif)

Giả sử chúng ta đang cố gắng sắp xếp các phần tử theo **thứ tự tăng dần** .

**_BƯỚC 0_**

![alt text](image-40.png)

**_BƯỚC 1_**

![alt text](image-41.png)

**_BƯỚC 2_**

![alt text](image-42.png)

**_BƯỚC 3_**

![alt text](image-43.png)

> Hãy mã…
> import java.util.Arrays;

class Main {
static void bubbleSort(int array[]) {

    int size = array.length;
    int temp;

    for (int i = 0; i < size - 1; i++)

      for (int j = 0; j < size - i - 1; j++)

        if (array[j] > array[j + 1]) {

          temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }

}

public static void main(String args[]) {

    int[] data = { -6, 47, 0, 18, -8 };

    Main.bubbleSort(data);

    System.out.println("Sorted Array in Ascending Order:");
    System.out.println(Arrays.toString(data));

}
}

Trong thuật toán trên, tất cả các so sánh được thực hiện ngay cả khi mảng đã được sắp xếp!

# Sắp xếp lựa chọn

Sắp xếp lựa chọn là một thuật toán sắp xếp chọn phần tử nhỏ nhất từ ​​danh sách chưa được sắp xếp trong mỗi lần lặp và đặt phần tử đó vào đầu danh sách chưa được sắp xếp.

![](https://miro.medium.com/v2/resize:fit:253/1*2a0cRzZpoN7e7vS0sE8_rw.gif)

[https://codepumpkin.com/selection-sort-algorithms/#google_vignette](https://codepumpkin.com/selection-sort-algorithms/#google_vignette)

**BƯỚC 1**

- Đặt phần tử đầu tiên là **tối thiểu** .

![alt text](image-44.png)

**BƯỚC 2**

- So sánh **mức tối thiểu** với phần tử thứ ba. Một lần nữa, nếu phần tử thứ ba nhỏ hơn thì chỉ định **mức tối thiểu** cho phần tử thứ ba, nếu không thì không làm gì cả. Quá trình tiếp tục cho đến phần tử cuối cùng.

![alt text](image-45.png)

**BƯỚC 3**

- Sau mỗi lần lặp, **giá trị tối thiểu** được đặt ở phía trước danh sách chưa được sắp xếp.

![alt text](image-46.png)

**BƯỚC 4**

- Đối với mỗi lần lặp, việc lập chỉ mục bắt đầu từ phần tử chưa được sắp xếp đầu tiên. Các bước từ 1 đến 3 được lặp lại cho đến khi tất cả các phần tử được đặt vào đúng vị trí của chúng.

> Hãy mã hóa…
> import java.util.Arrays;

class SelectionSort {
void selectionSort(int array[]) {
int size = array.length;

    for (int step = 0; step < size - 1; step++) {
      int min_idx = step;

      for (int i = step + 1; i < size; i++) {

        if (array[i] < array[min_idx]) {
          min_idx = i;
        }
      }
      int temp = array[step];
      array[step] = array[min_idx];
      array[min_idx] = temp;
    }

}
public static void main(String args[]) {
int[] data = { 28, 16, 11, 18, 6 };
SelectionSort ss = new SelectionSort();
ss.selectionSort(data);
System.out.println("Sorted Array in Ascending Order: ");
System.out.println(Arrays.toString(data));
}
}
view rawselectionSort.java hosted with ❤ by GitHub

# Tìm kiếm theo chiều rộng

Tìm kiếm theo chiều rộng là một chiến lược đơn giản trong đó nút gốc được mở rộng trước, sau đó tất cả các nút kế thừa của nút gốc được mở rộng tiếp theo, sau đó là các nút kế thừa _của chúng_ , v.v.

Thực hiện:

- _rìa_ là hàng đợi FIFO, tức là những người kế nhiệm mới đi ở cuối
- TÌM KIẾM CÂY(vấn đề, FIFO-QUEUE())

![](https://miro.medium.com/v2/resize:fit:469/1*BOQIZUXIaT4pJITaDOWQ8A.gif)

[https://commons.wikimedia.org/wiki/File:Breadth-First-Search-Algorithm.gif](https://commons.wikimedia.org/wiki/File:Breadth-First-Search-Algorithm.gif)

# **Tìm kiếm theo chiều sâu**

Tìm kiếm theo chiều sâu hoặc Truyền tải theo chiều sâu là một thuật toán đệ quy để tìm kiếm tất cả các đỉnh của biểu đồ hoặc cấu trúc dữ liệu cây. Truyền tải có nghĩa là truy cập tất cả các nút của biểu đồ.

- Mở rộng nút chưa được mở rộng sâu nhất
- Việc tìm kiếm tiến hành ngay lập tức tới mức sâu nhất của cây tìm kiếm -> Các nút không có nút kế thừa

![](https://miro.medium.com/v2/resize:fit:469/1*C4PNW6JKPrxGhNveGCOipA.gif)

[https://en.m.wikipedia.org/wiki/File:Depth-First-Search.gif](https://en.m.wikipedia.org/wiki/File:Depth-First-Search.gif)

> Là một sinh viên đại học, tôi cố gắng viết bằng cách phân tích những gì tôi đã học được từ những bài học đã học và những điều tôi tò mò. Tôi tin rằng tôi đã thu thập được nhiều kiến ​​thức hơn. Hãy chia sẻ ý kiến ​​​​của bạn dưới đây.
