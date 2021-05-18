package by.zhenekns.development.controller;

import by.zhenekns.development.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainController extends HttpServlet {
    private static String page_url = "/WEB-INF/view/main.jsp";
    private List<User> users;

    @Override
    public void init(ServletConfig config) throws ServletException {
        users = new CopyOnWriteArrayList<>();
        users.add(new User("Zhenya", 19));
        users.add(new User("Uliana", 18));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", users);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(page_url);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if (!isValidData(req)) {
            doGet(req, resp);
        }
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        User user = new User(name, Integer.parseInt(age));
        users.add(user);
        doGet(req, resp);
    }

    private boolean isValidData(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        return name != null && name.length() > 0 &&
                age != null && age.length() > 0 &&
                age.matches("[+]?\\d+");
    }
}
