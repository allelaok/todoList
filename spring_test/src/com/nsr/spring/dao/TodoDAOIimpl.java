package com.nsr.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.nsr.spring.vo.TodoVO;

@Repository("todoDAO")
public class TodoDAOIimpl implements TodoDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllTodoList() throws DataAccessException {
		List<TodoVO> todosList = null;
		todosList = sqlSession.selectList("mapper.todo.selectAllTodos");
		return todosList;
	}

	@Override
	public int insertTodo(TodoVO todo) throws DataAccessException {
		System.out.println(todo);
		int result = sqlSession.insert("mapper.todo.insertTodo", todo);
		return result;
	}

	@Override
	public int deleteTodo(int tno) throws DataAccessException {
		int result = sqlSession.delete("mapper.todo.deleteTodo", tno);
		return result;
	}

	@Override
	public int updateTodo(TodoVO todo) throws DataAccessException {
		System.out.println(todo);
		int result = sqlSession.update("mapper.todo.updateTodo", todo);
		return result;
	}

	@Override
	public TodoVO selectOne(long tno) throws DataAccessException {
		TodoVO todo = null;
		todo = (TodoVO) sqlSession.selectOne("mapper.todo.selectOne", tno);
		System.out.println("DAO selcetOne " + todo);
		return todo;
	}

}
