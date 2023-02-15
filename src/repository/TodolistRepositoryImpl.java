package repository;

import entity.Todolist;

import java.util.ArrayList;
import java.util.List;

public class TodolistRepositoryImpl implements TodolistRepository {

    private Todolist[] todolists = new Todolist[5];

    @Override
    public Todolist[] getAllTodo() {
        return todolists;
    }

    private void resizeArrayIsFull(){
        if (todolists[todolists.length-1] != null){
            Todolist[] tempTodolist = todolists;
            todolists = new Todolist[todolists.length*2];
            for (int i = 0; i < tempTodolist.length; i++) {
                todolists[i] = tempTodolist[i];
            }
        }
    }

    @Override
    public void addTodo(Todolist todolist) {
        resizeArrayIsFull();
        for (int i = 0; i < todolists.length; i++) {
            if (todolists[i] == null){
                todolists[i] = todolist;
                break;
            }
        }
    }

    @Override
    public boolean isNumberAvailable(int nomor) {
        return (nomor > 0 && nomor < todolists.length-1) && todolists[nomor-1]!= null;
    }

    @Override
    public boolean editTodo(int nomor, Todolist todolist) {
        if (isNumberAvailable(nomor)){
            todolists[nomor-1] = todolist;
            return true;
        }return false;
    }

    @Override
    public boolean remove(int nomor) {
        if (isNumberAvailable(nomor)){
            for (int i = nomor-1; i < todolists.length ; i++) {
                if (i < todolists.length-1){
                    todolists[i] = todolists[i+1];
                }else todolists[i] = null;
            }
            return true;
        }return false;
    }

    @Override
    public Todolist[] searchTodo(String keyword) {
        List<Todolist> todolistList = new ArrayList<>();
        for (int i = 0; i < todolists.length && todolists[i]!= null; i++) {
            if (todolists[i].getTodo().contains(keyword)){
                todolistList.add(todolists[i]);
            }
        }
        return todolistList.toArray(new Todolist[]{});
    }
    @Override
    public void sortTodo(String typeSort) {
        for (int i = 0; i < todolists.length; i++) {
            for (int j = i+1; j < todolists.length; j++) {
                if (todolists[i] != null && todolists[j] != null) {
                    if (typeSort.contains("asc")) {
                        if (todolists[i].getTodo().compareTo(todolists[j].getTodo()) > 0) {
                            sort(i, j);
                        }
                    } else if(typeSort.contains("desc")) {
                        if (todolists[i].getTodo().compareTo(todolists[j].getTodo()) <= 0) {
                            sort(i, j);
                        }
                    }
                }
            }
        }
    }
    private void sort(int i,int j){
        Todolist tempTodo = todolists[i];
        todolists[i] = todolists[j];
        todolists[j] = tempTodo;
    }
}
