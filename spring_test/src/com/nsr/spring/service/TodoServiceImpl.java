package com.nsr.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nsr.spring.dao.TodoDAO;
import com.nsr.spring.vo.TodoVO;
@Service("todoService")
@Transactional(propagation = Propagation.REQUIRED)
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoDAO todoDAO;
	
	@Override
	public List listTodos() throws DataAccessException {
		List todosList = null;
		todosList = todoDAO.selectAllTodoList();
		return todosList;
	}

	@Override
	public int addTodo(TodoVO todo) throws DataAccessException {
		return todoDAO.insertTodo(todo);
	}

	@Override
	public int removeTodo(int tno) throws DataAccessException {
		return todoDAO.deleteTodo(tno);
	}

	@Override
	public int updateTodo(TodoVO todo) throws DataAccessException {
		return todoDAO.updateTodo(todo);
	}

	@Override
	public TodoVO getOne(Long tno) throws DataAccessException {
		return todoDAO.selectOne(tno);
	}

	@Override
	public TodoVO modTodo(long tno) throws DataAccessException {
		TodoVO todoVO = new TodoVO();
		todoVO = todoDAO.selectOne(tno);
		System.out.println("modTodo: " + todoVO);
		
		return todoVO;
	}

}
