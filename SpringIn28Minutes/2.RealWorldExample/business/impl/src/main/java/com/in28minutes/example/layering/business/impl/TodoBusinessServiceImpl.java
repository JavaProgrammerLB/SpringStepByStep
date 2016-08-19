package com.in28minutes.example.layering.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.example.layering.business.api.TodoBusinessService;
import com.in28minutes.example.layering.data.api.TodoDataService;
import com.in28minutes.example.layering.model.api.client.Todo;

@Component
public class TodoBusinessServiceImpl implements TodoBusinessService {

	@Autowired
	TodoDataService todoDs;

	@Override
	public List<Todo> retrieveTodosRelatedToSpring(String user) {

		System.out
				.println("retrieveTodosRelatedToSpring is called with parameter "
						+ user);

		List<Todo> todos = todoDs.retrieveTodos(user);
		List<Todo> filteredTodos = filterTodosRelatedToSpring(todos);

		System.out
		.println("retrieveTodosRelatedToSpring completed execution and returned "
				+ filteredTodos);

		return filteredTodos;

	}

	// NOTE : We get everything from database and filter
	// instead of filtering in the database. Not the most efficient
	// implementation.
	private List<Todo> filterTodosRelatedToSpring(List<Todo> todos) {
		Date today = new Date();

		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getDesc().contains("Spring")) {
				filteredTodos.add(todo);
			}
		}

		return filteredTodos;
	}

}
