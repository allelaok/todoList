package com.nsr.spring.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.nsr.spring.vo.TodoVO;

public interface TodoDAO {
	public List selectAllTodoList() throws DataAccessException;
	public int insertTodo(TodoVO todo) throws DataAccessException;
	public int deleteTodo(int tno) throws DataAccessException;
	public int updateTodo(TodoVO todo) throws DataAccessException;
	public TodoVO selectOne(long tno) throws DataAccessException;
}
