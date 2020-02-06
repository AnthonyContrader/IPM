package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryInsertView extends AbstractView
{
	private Request request;
	private String name;
	private final String mode = "INSERT";
	
	public CategoryInsertView() 
	{
		
	}
	
	@Override
	public void showResults(Request request) 
	{
		if (request != null) 
		{
			System.out.println("SUCCESFULL INSERTION.\n");
			MainDispatcher.getInstance().callView("Category", null);
		}
	}
	
	@Override
	public void showOptions() 
	{
		System.out.println("Insert Category name");
		name = getInput();
	}
	
	@Override
	public void submit()
	{
		request = new Request();
		request.put("name", name);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
	}
}