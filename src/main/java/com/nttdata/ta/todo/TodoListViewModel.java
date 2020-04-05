package com.nttdata.ta.todo;

import java.util.ArrayList;

import javax.validation.Valid;

public class TodoListViewModel {

	@Valid
	private ArrayList<TodoItem> todoList = new ArrayList<TodoItem>();
	
	public TodoListViewModel() {}
	
	public TodoListViewModel(Iterable<TodoItem> items) {
		items.forEach(todoList:: add);
	}

	public TodoListViewModel(ArrayList<TodoItem> todoList) {
		this.todoList = todoList;
	}

	public ArrayList<TodoItem> getTodoList() {
		return todoList;
	}

	public void setTodoList(ArrayList<TodoItem> todoList) {
		this.todoList = todoList;
	}
}