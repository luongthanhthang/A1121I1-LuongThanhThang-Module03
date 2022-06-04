package controller;

import model.bean.User;
import model.service.IUserService;
import model.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//Mô tả
//        Cập nhật bài thực hành quản lý User, thêm chức năng:
//        Tìm kiếm theo country
//        Sắp xếp theo name
//        Hướng dẫn
//        Bước 1: Cập nhật lớp UserDAO
//        Bước 2: Cập nhật lớp UserServlet
//        Bước 3: Cập nhật view

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService;

    public void init() {
        userService = new UserService();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "sort":
                    sortUser(request, response);
                    break;
                case "search":
                    searchUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    //    ----------------------------------------------------------------
//    ----------------hiển thị tất cả users------------
    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<User> listUser = userService.selectAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    //    ----------------show form tạo mới user-------------
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    //    ---------hiển thị form edit-------------
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userService.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    //    -------------thực hiện thêm mới user-------------
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);

        Map<String, String> error =userService.insertUser(newUser);

        if (error.isEmpty()) {
            request.setAttribute("mess", "Them moi thanh cong");
        } else {
            request.setAttribute("mess", "Them moi that bai");
            request.setAttribute("errors",error);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    //    -----------tiến hành cập nhật user--------------
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User book = new User(id, name, email, country);
        boolean flag = userService.updateUser(book);
        if (flag) {
            request.setAttribute("mess", "cập nhật thành công");
        } else {
            request.setAttribute("mess", "cập nhật thất bại");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        dispatcher.forward(request, response);
    }

    //    ------------xoá user--------------
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        boolean flag = userService.deleteUser(id);
        if (flag) {
            request.setAttribute("mess", "xoá thanh cong");
        } else {
            request.setAttribute("mess", "xoá that bai");
        }

        List<User> listUser = userService.selectAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    //    -------------------tìm kiếm user-----------------
    private void searchUser(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("inputSearch");
        List<User> userList1 = userService.searchUser(country);
//        System.out.println(userList1.size());

        //        -------lấy lại list user-------------
//        try {
//            listUser(request, response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }

        if (userList1.isEmpty()) {
            request.setAttribute("mess", "NOT FOUND USERS");
            List<User> listUser = userService.selectAllUser();
            request.setAttribute("listUser", listUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
            try {
//                listUser(request, response);
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            request.setAttribute("userList1", userList1);
            System.out.println(userList1.toString());
            List<User> listUser = userService.selectAllUser();
            request.setAttribute("listUser", listUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
            try {
//                listUser(request, response);
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //    --------------------sap xep----------------------
    private void sortUser(HttpServletRequest request, HttpServletResponse response) {
        String sortType = request.getParameter("sortAttribute");
        System.out.println(sortType);
        List<User> userList = userService.sortUser(sortType);
        request.setAttribute("listUser", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
