package repository;

import entity.Todolist;

public interface TodolistRepository {
    Todolist[] getAllTodo();
    void addTodo(Todolist todolist);
    boolean editTodo (int nomor, Todolist todolist);
    boolean isNumberAvailable(int nomor);
    boolean remove(int nomor);
    Todolist[] searchTodo(String keyword);
    void sortTodo(String typeSort);
}
