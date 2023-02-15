package repository;

import entity.Todolist;

public interface TodolistRepository {
    Todolist[] getAllTodo();
    void addTodo(Todolist todolist);
    boolean editTodo (int nomor, Todolist todolist);
    boolean remove(int nomor);
    Todolist[] searchTodo(String keyword);
    Todolist[] sortTodo();
}
