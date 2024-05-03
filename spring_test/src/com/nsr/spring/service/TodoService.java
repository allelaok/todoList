package com.nsr.spring.service;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.nsr.spring.vo.TodoVO;
import com.nsr.spring.vo.pageRequestDTO;
import com.nsr.spring.vo.pageResponseDTO;

public interface TodoService {
	public List listTodos() throws DataAccessException;
	public int addTodo(TodoVO todo) throws DataAccessException;
	public int removeTodo(int tno) throws DataAccessException;
	public int updateTodo(TodoVO todo) throws DataAccessException;
	public TodoVO getOne(Long tno) throws DataAccessException;
	public pageResponseDTO<TodoVO> getList(pageRequestDTO pageRequestDTO) throws DataAccessException;
	
}
