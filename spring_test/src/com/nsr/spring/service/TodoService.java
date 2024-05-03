package com.nsr.spring.service;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.nsr.spring.vo.TodoVO;
import com.nsr.spring.vo.PageRequestDTO;
import com.nsr.spring.vo.PageResponseDTO;

public interface TodoService {
	public List listTodos() throws DataAccessException;
	public int addTodo(TodoVO todo) throws DataAccessException;
	public int removeTodo(int tno) throws DataAccessException;
	public int updateTodo(TodoVO todo) throws DataAccessException;
	public TodoVO getOne(Long tno) throws DataAccessException;
	public PageResponseDTO<TodoVO> getList(PageRequestDTO pageRequestDTO) throws DataAccessException;
	
}
