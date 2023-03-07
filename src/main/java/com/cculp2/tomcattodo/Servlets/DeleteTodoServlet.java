package com.cculp2.tomcattodo.Servlets;

import com.cculp2.tomcattodo.TodoListHibernateRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteTodoServlet", value = "/DeleteTodoServlet")
public class DeleteTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TodoListHibernateRepo repo = (TodoListHibernateRepo) getServletContext().getAttribute("repo");
        int idToDelete = Integer.parseInt(request.getParameter("delete"));
        System.out.println("Attempting to delete");
        repo.removeTodo(idToDelete);

        response.sendRedirect("/todo");
    }
}
