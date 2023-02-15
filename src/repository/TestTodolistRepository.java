package repository;

import entity.Todolist;

public class TestTodolistRepository {
    private static TodolistRepository repo = new TodolistRepositoryImpl();;
    public static void main(String[] args) {

        add();

//        edit();
//        hapus();
//        search();
        repo.sortTodo("desc");
        showTodo();

    }

    private static void search() {
        Todolist[] todo = repo.searchTodo("blablabla");
        System.out.println(todo.length);
        for (int i = 0; i < todo.length; i++) {
            System.out.println((i+1)+". "+todo[i].getTodo());
        }
    }

    private static void add() {
        System.out.println("----------------------------");
        repo.addTodo(new Todolist("ayam"));
        repo.addTodo(new Todolist("sampi"));
        repo.addTodo(new Todolist("badak"));
        repo.addTodo(new Todolist("cicak"));
        repo.addTodo(new Todolist("campung"));
        repo.addTodo(new Todolist("rusa"));
        repo.addTodo(new Todolist("kerbau"));
        repo.addTodo(new Todolist("kucing"));
        showTodo();
        System.out.println("----------------------------");
    }

    private static void hapus() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            System.out.println(repo.remove(1));
            showTodo();

        }
    }

    private static void edit() {
        System.out.println("----------------------");
        System.out.println(repo.editTodo(0,new Todolist("edit")));
        System.out.println(repo.editTodo(1,new Todolist("edit1")));
        System.out.println(repo.editTodo(2,new Todolist("edit2")));
        System.out.println(repo.editTodo(3,new Todolist("edit3")));
        System.out.println(repo.editTodo(4,new Todolist("edit4")));
        showTodo();

    }

    private static void showTodo(){
        for (int i = 0; i < repo.getAllTodo().length; i++) {
            if (repo.getAllTodo()[i] != null){
                System.out.println((i+1)+". "+repo.getAllTodo()[i].getTodo());
            }
        }
    }
}
