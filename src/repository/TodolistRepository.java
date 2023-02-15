package repository;

import entity.Todolist;

public interface TodolistRepository {
    Todolist[] getAllTodo(); //berhasil
    void addTodo(Todolist todolist); //berhasil
    boolean editTodo (int nomor, Todolist todolist); //berhasil
    boolean isNumberAvailable(int nomor); //berhasil
    boolean remove(int nomor); //berhasil
    Todolist[] searchTodo(String keyword);//berhasil
    void sortTodo(String typeSort);
}
