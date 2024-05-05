package com.nsr.spring.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nsr.spring.vo.TodoVO;
import com.nsr.spring.vo.PageRequestDTO;

public interface TodoController {
	public ModelAndView listTodos(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addTodo(
			@ModelAttribute("info") TodoVO todo, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeTodo(
			@ModelAttribute("tno") int tno, PageRequestDTO pageRequestDTO,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updateTodo(
			PageRequestDTO pageRequestDTO,
			@ModelAttribute("info") TodoVO todo, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView detailTodo(
			long tno, PageRequestDTO pageRequestDTO, BindingResult bindingResult, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView list(
			PageRequestDTO pageRequestDTO,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}
