package com.nsr.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nsr.spring.dao.TodoDAO;
import com.nsr.spring.vo.TodoVO;
import com.nsr.spring.vo.pageRequestDTO;
import com.nsr.spring.vo.pageResponseDTO;
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
	public pageResponseDTO<TodoVO> getList(pageRequestDTO pageRequestDTO) throws DataAccessException {
		
		System.out.println("service");
		List<TodoVO> voList = todoDAO.selectList(pageRequestDTO);
		System.out.println("voList : " + voList);
		int total = todoDAO.getCount(pageRequestDTO);
		
		System.out.println("dao => getList => total : " + total);
		
		pageResponseDTO<TodoVO> pageResponseDTO = new pageResponseDTO(pageRequestDTO, voList, total);
		
		return pageResponseDTO;
	}

}
