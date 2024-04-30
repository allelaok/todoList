package com.nsr.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.nsr.spring.vo.TodoVO;

public interface TodoController {
	public ModelAndView listTodos(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addTodo(
			@ModelAttribute("info") TodoVO todo, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeTodo(
			@ModelAttribute("tno") int tno,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updateTodo(
			@ModelAttribute("info") TodoVO todo, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView detailTodo(
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
