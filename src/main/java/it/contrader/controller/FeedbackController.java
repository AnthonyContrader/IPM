package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.FeedbackDTO;
import it.contrader.service.FeedbackService;

@Controller
@RequestMapping("/feedbacks")
public class FeedbackController 
{
	@Autowired
	private FeedbackService service;
	
	private void setAll(HttpServletRequest request) 
	{
		request.getSession().setAttribute("list", service.getAll());
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) 
	{
		service.delete(id);
		setAll(request);
		return "feedbacks";
	}
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) 
	{
		setAll(request);
		return "feedbacks";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) 
	{
		request.getSession().setAttribute("dto", service.read(id));
		return "updatefeedback";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) 
	{
		request.getSession().setAttribute("dto", service.read(id));
		return "readfeedback";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("vote") int vote, @RequestParam("review") String review)
	{
		FeedbackDTO dto = new FeedbackDTO();
		dto.setId(id);
		dto.setVote(vote);
		dto.setReview(review);
		service.update(dto);
		setAll(request);
		return "feedbacks";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("vote") int vote, @RequestParam("review") String review) 
	{
		FeedbackDTO dto = new FeedbackDTO();
		dto.setVote(vote);
		dto.setReview(review);
		service.insert(dto);
		setAll(request);
		return "feedbacks";
	}

}