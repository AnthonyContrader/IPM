package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.dto.CategoryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryReadView extends AbstractView
{
	private int id_cat;
	private Request request;
	private final String mode = "READ";
	
	public CategoryReadView() 
	{
		
	}
	
	@Override
	public void showResults (Request request)
	{
		if (request != null)
		{
			CategoryDTO category = (CategoryDTO) request.get("category");
			System.out.println(category);
			MainDispatcher.getInstance().callView("Category", null);
		}
	}
	
	@Override
	public void showOptions()
	{
		System.out.println("Enter the category ID:");
		id_cat = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() 
	{
		request = new Request();
		request.put("id_cat", id_cat);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
	}
}