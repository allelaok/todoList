package com.nsr.spring.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.nsr.spring.vo.TodoVO;
import com.nsr.spring.vo.pageRequestDTO;

public interface TodoDAO {
	public List selectAllTodoList() throws DataAccessException;
	public int insertTodo(TodoVO todo) throws DataAccessException;
	public int deleteTodo(int tno) throws DataAccessException;
	public int updateTodo(TodoVO todo) throws DataAccessException;
	public TodoVO selectOne(long tno) throws DataAccessException;
	public List selectList(pageRequestDTO pageRequestDTO) throws DataAccessException;
	public int getCount(pageRequestDTO pageRequestDTO) throws DataAccessException;
}
