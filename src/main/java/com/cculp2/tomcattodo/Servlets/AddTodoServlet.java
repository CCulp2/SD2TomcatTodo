package com.cculp2.tomcattodo.Servlets;
import com.cculp2.tomcattodo.Todo;
import com.cculp2.tomcattodo.TodoListHibernateRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddTodoServlet", value = "/AddTodo")
public class AddTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/AddTodo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TodoListHibernateRepo repo = (TodoListHibernateRepo) getServletContext().getAttribute("repo");
        Todo todoToBeAdded = new Todo();

        String title = request.getParameter("title");
        String details = request.getParameter("details");
        todoToBeAdded.setTitle(title);
        todoToBeAdded.setDetails(details);
        repo.addTodo(todoToBeAdded);

        response.sendRedirect("/todo");
    }
}
