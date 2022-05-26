package controller;

import model.bean.Customer;
import model.service.ICustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
// Trong phần này, chúng ta sẽ phát triển một ứng dụng quản lý khách hàng. Ứng dụng có các chức năng chính sau:
//
//Hiển thị danh sách khách hàng
//Thêm một khách hàng mới
//Sửa đổi thông tin của khách hàng
//Xoá một khách hàng
//Xem thông tin chi tiết của khách hàng

//        /customers?action=create: Tạo một khách hàng mới
//        /customers?action=edit: Cập nhật thông tin khách hàng
//        /customers?action=delete: Xoá một khách hàng
//        Các giá trị khác: Hiển thị thông tin khách hàng
@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewCustomer(request,response);
            default:
                listCustomer(request, response);
                break;
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------
    // Phương thức hiển thị list customer
    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findALl();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //    Phương thức showCreateForm(request, response); sẽ trả về một form được định nghĩa trong view customer/create.jsp
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //    Phương thức createCustomer(request, response) sẽ nhận về các tham số được gửi lên từ form,
    //    khởi tạo đối tượng Customer và lưu trữ vào trong một danh sách khách hàng giả lập.
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = (int) (Math.random() * 10000);

        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // phương thức edit get

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        // lấy id từ trong bảng
        int id = Integer.parseInt(request.getParameter("id"));
        //lấy customer theo id sẵn có
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher;
        // kiểm tra có customer để edit không, nếu có thì mới hiện trang edit, nếu không thì hiện trang lỗi
        if (customer == null) {
            request.setAttribute("id", id);
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("id", id);
            request.setAttribute("customerEdit", customer);
            dispatcher = request.getRequestDispatcher("view/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // phương thức edit customer post
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        // tìm customer cần edit trong list customer
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            // update customer
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);

            customerService.update(id, customer);

            request.setAttribute("customer", customer);
            request.setAttribute("message", "Customer information was updated");
            dispatcher = request.getRequestDispatcher("view/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // xoá khách hàng get
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("id", id);
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("view/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            customerService.remove(id);
            try {
                // trả về trang /customer
                response.sendRedirect("/customer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // hiển trị view khách hàng
    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher;

        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("view/view.jsp");
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
