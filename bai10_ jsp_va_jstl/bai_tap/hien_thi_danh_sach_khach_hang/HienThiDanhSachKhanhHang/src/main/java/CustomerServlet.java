import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "")
public class CustomerServlet extends HttpServlet {
    //    tạo chuỗi chứa thông tin khách hàng
    List<Customer> customerList = new ArrayList<>();


    @Override
    public void init() throws ServletException {
        customerList.add(new Customer("Linh Ngọc Đàm", "08/06/1996", "Hà Nội", "https://kenh14cdn.com/203336854389633024/2021/9/8/-1631110907237612602136.jpg"));
        customerList.add(new Customer("Lê Thy Ngọc", "12/11/1995", "Đà Lạt", "https://kenh14cdn.com/2018/12/27/c755f3efc2ae2bf072bf-1544831426998822773261-1545898629610155513390.jpg"));
        customerList.add(new Customer("Vũ Thị Khánh Huyền", "16/03/2004", "Đà Nẵng", "https://static2.yan.vn/YanNews/2167221/202203/nhan-sac-that-gay-that-vong-cua-hot-tiktoker-vu-thi-khanh-huyen-c266baff.jpg"));
        customerList.add(new Customer("Lê Bống", "31/02/1995", "Hà Nội", "https://media.2dep.vn/upload/luanhuynh/2022/01/13/le-bong-nu-sinh-voi-man-lot-xac-ngoan-muc-den-hot-girl-sieu-3-vong-cua-lang-tik-tok-viet-nam-1642069816-4.png"));
        customerList.add(new Customer("Lê Thị Khánh Huyền", "20/12/2004", "Hồ Chí Minh", "https://static2.yan.vn/YanNews/202105/202105170329163774-0f5aef49-3c30-420b-8ccd-b983d0d3553a.jpeg"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerListData", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
