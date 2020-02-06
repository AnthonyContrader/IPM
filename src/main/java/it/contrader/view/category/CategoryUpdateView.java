package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryUpdateView extends AbstractView
{
	private Request request;
	private int id_cat;
	private String name;
	private final String mode = "UPDATE";
	
	public CategoryUpdateView() 
	{
		
	}
	
	@Override
	public void showResults(Request request)
	{
		if (request != null) 
		{
			System.out.println("Change successful.\n");
			MainDispatcher.getInstance().callView("Category", null);
		}
	}
	
	@Override
	public void showOptions() 
	{
		try 
		{
			System.out.println("Insert category id:");
			id_cat = Integer.parseInt(getInput());
			System.out.println("Insert category name:");
			name = getInput();
		}
		catch (Exception e) 
		{
			
		}
	}
	
	@Override
	public void submit() 
	{
		request = new Request();
		request.put("id_cat", id_cat);
		request.put("name", name);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
	}
}