package controller;

import model.bean.Category;
import model.bean.Product;
import model.service.ICategoryService;
import model.service.IProductService;
import model.service.Impl.CategoryServiceImpl;
import model.service.Impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ICategoryService categoryService = new CategoryServiceImpl();
    IProductService productService = new ProductServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                findAll(request, response);
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
                insert(request, response);
                break;
            case "edit":
                update(request, response);
                break;
        }
    }


    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.findAll();
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String nameProductSearch = request.getParameter("nameProductSearch");

        List<Product> productList = productService.search(nameProductSearch);
        List<Category> categoryList = categoryService.findAll();


        request.setAttribute("nameProductSearch", nameProductSearch);
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idDelete"));
        boolean flag = productService.delete(id);
        if (flag) {
            request.setAttribute("mess", "xoá thành công");
        } else {
            request.setAttribute("mess", "xoá thất bại");
        }

        // trả lại trang list
        List<Product> productList = productService.findAll();
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));

        List<Product> productList = productService.findAll();
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = categoryService.findAll();

        request.setAttribute("categoryList", categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Category> categoryList = categoryService.findAll();
//        Integer id = Integer.parseInt(request.getParameter("id"));
//
//
//        String name = request.getParameter("name");
//        Double price = Double.parseDouble(request.getParameter("price"));
//        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
//        String color = request.getParameter("color");
//        String describe = request.getParameter("describe");
//        Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
//        Product product = new Product(name, price, quantity, color, describe, categoryId);
//
//
//        boolean flag = productService.update(product);
//        if (flag) {
//            request.setAttribute("product", product);
//            request.setAttribute("categoryList", categoryList);
//            request.setAttribute("mess", "edit thành công");
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
//            dispatcher.forward(request, response);
//        } else {
//            RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
//            dispatcher.forward(request, response);
//        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String describe = request.getParameter("describe");
        Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Product product = new Product(name, price, quantity, color, describe, categoryId);
        Boolean flag = productService.insert(product);
        if (flag) {
            List<Product> productList = productService.findAll();
            List<Category> categoryList = categoryService.findAll();

            request.setAttribute("productList", productList);
            request.setAttribute("categoryList", categoryList);
            request.setAttribute("mess", "thêm mới thành công");

            RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mess", "thêm mới thất bại");
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
            dispatcher.forward(request, response);
        }

    }

}
