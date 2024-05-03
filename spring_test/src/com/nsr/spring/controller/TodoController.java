package com.nsr.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.nsr.spring.vo.TodoVO;
import com.nsr.spring.vo.pageRequestDTO;

public interface TodoController {
	public ModelAndView listTodos(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addTodo(
			@ModelAttribute("info") TodoVO todo, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeTodo(
			@ModelAttribute("tno") int tno, pageRequestDTO pageRequestDTO,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updateTodo(
			pageRequestDTO pageRequestDTO,
			@ModelAttribute("info") TodoVO todo, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView detailTodo(
			long tno, pageRequestDTO pageRequestDTO, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView list(
			pageRequestDTO pageRequestDTO,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}
