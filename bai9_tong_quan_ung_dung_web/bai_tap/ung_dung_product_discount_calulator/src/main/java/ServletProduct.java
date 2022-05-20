import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Ứng dụng Product Discount Calculator được sử dụng để tính chiết khấu cho sản phẩm khi mua hàng online.
        Trong trang đầu tiên, người dùng sẽ nhập vào các dữ liệu sau:
        Product Description: Mô tả của sản phẩm
        List Price: Giá niêm yết của sản phẩm
        Discount Percent: Tỷ lệ chiết khấu (phần trăm)
        Khi người dùng nhấn vào nút Calculate Discount (Tính chiết khấu) thì sẽ đi đến trang /display-discount và hiển thị kết quả.

        Trang kết quả sẽ hiển thị các thông tin ngươờ dùng nhập vào, kèm theo kết quả tính toán:
        Discount Amount: Lượng chiết khấu
        Discount Price: Giá sau khi đã được chiết khấu
        Công thức tính chiết khấu là:
        Discount Amount = List Price * Discount Percent * 0.01

        Hướng dẫn
        Bước 1: Tạo trang index.jsp với form bao gồm các trường như mô tả. Phương thức của form là POST.
        Bước 2: Tạo DiscountServlet để nhận dữ liệu, tính toán và hiển thị kết quả.
 */
@WebServlet(name = "ServletProduct", urlPatterns = "/display-discount")
public class ServletProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("productDescription");
        float listPrice = Float.parseFloat(request.getParameter("listPrice"));
        float discountPercent = Float.parseFloat(request.getParameter("discountPercent"));

        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;
        request.setAttribute("productDescription", productDescription);
        request.setAttribute("listPrice", listPrice);
        request.setAttribute("discountAmount", discountAmount);
        request.setAttribute("discountPrice", discountPrice);
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
