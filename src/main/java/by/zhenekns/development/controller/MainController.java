package by.zhenekns.development.controller;

import by.zhenekns.development.model.User;

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
        req.getRequestDispatcher(page_url).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
