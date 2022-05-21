import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/* Trong phần này, chúng ta sẽ tạo một ứng dụng máy tính với các phép toán cơ bản: Cộng, Trừ, Nhân và Chia.
       Ứng dụng cho phép người dùng nhập vào 2 toán hạng và lựa chọn toán tử. Ứng dụng sẽ hiển thị kết
       quả hoặc thông báo lỗi nếu có.
       Lỗi có thể xảy ra: Chia cho 0. */
@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operator = request.getParameter("operator-input");
        try {
            float number1 = Float.parseFloat(request.getParameter("first-number"));
            float number2 = Float.parseFloat(request.getParameter("second-number"));
            request.setAttribute("result", Calculator.calculate(number1, number2, operator));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("number 1 or number 2 no input!!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
