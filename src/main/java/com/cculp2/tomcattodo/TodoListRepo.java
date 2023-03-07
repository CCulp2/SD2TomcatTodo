package com.cculp2.tomcattodo;

import java.util.List;

public interface TodoListRepo {
    public void addTodo(Todo todo);
    public void removeTodo(int id);
    public List<Todo> getTodoList();
}
