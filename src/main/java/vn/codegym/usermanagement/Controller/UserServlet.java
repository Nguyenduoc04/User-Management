package vn.codegym.usermanagement.Controller;

import vn.codegym.usermanagement.Model.User;
import vn.codegym.usermanagement.Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "userServlet", value = "/users")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    private List<String> getCountries() {
        List<String> countries = new ArrayList<>();
        countries.add("Vietnam");
        countries.add("USA");
        countries.add("UK");
        countries.add("Spain");
        countries.add("Japan");
        countries.add("Korea");
        return countries;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                try {
                    deleteUser(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "view":
                viewUser(request, response);
                break;
            case "search":
                searchUser(request, response);
                break;
            case "sort":
                sortUser(request, response);
                break;
            default:
                listUsers(request, response);
        }
    }

    // ===== POST =====
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    // ===== SHOW LIST =====
    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> users = userService.findAll();
        request.setAttribute("users", users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    // ===== CREATE =====
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("countries", getCountries());
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            request.setAttribute("error", "Invalid email format!");
            request.setAttribute("countries", getCountries());
            request.getRequestDispatcher("user-create.jsp").forward(request, response);
            return;
        }

        User user = new User(name, email, country);
        userService.save(user);

        response.sendRedirect("users");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);

        request.setAttribute("user", user);
        request.setAttribute("countries", getCountries());

        RequestDispatcher dispatcher = request.getRequestDispatcher("user-update.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            request.setAttribute("error", "Invalid email format!");
            request.setAttribute("user", userService.findById(id));
            request.setAttribute("countries", getCountries());
            request.getRequestDispatcher("user-update.jsp").forward(request, response);
            return;
        }
        String country = request.getParameter("country");

        User user = new User(id, name, email, country);
        userService.update(user);

        response.sendRedirect("users");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));
        userService.remove(id);

        response.sendRedirect("users");
    }

    private void viewUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        if (user == null) {
            response.sendRedirect("users");
            return;
        }

        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-view.jsp");
        dispatcher.forward(request, response);
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String country = request.getParameter("country");

        List<User> users = userService.searchByCountry(country);
        request.setAttribute("users", users);

        request.getRequestDispatcher("user-list.jsp").forward(request, response);
    }

    private void sortUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> users = userService.sortByName();
        request.setAttribute("users", users);

        request.getRequestDispatcher("user-list.jsp").forward(request, response);
    }
}