package com.cculp2.tomcattodo.Servlets;
import com.cculp2.tomcattodo.Todo;
import com.cculp2.tomcattodo.TodoListHibernateRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoListServlet", value = "/todo")
public class TodoListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TodoListHibernateRepo repo = (TodoListHibernateRepo) getServletContext().getAttribute("repo");
        List<Todo> todoList = repo.getTodoList();

        request.setAttribute("todoList", todoList);
        getServletContext().getRequestDispatcher("/TodoList.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
