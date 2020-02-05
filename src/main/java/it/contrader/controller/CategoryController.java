package it.contrader.controller;

import java.util.List;
import it.contrader.dto.CategoryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CategoryService;

public class CategoryController implements Controller
{
	
	private static String sub_package = "category.";
	private CategoryService categoryService;
	
	public CategoryController() 
	{
		this.categoryService = new CategoryService();
	}
	
	public void doControl(Request request) 
	{
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		int id_cat;
		String name;
		
		switch (mode) 
		{
			case "READ":
				id_cat = Integer.parseInt(request.get("id_cat").toString());
				CategoryDTO categoryDTO = categoryService.read(id_cat);
				request.put("category", categoryDTO);
				MainDispatcher.getInstance().callView(sub_package + "CategoryRead", request);
				break;
				
			case "INSERT":
				name = request.get("name").toString();
				CategoryDTO categoryinsert = new CategoryDTO(name);
				categoryService.insert(categoryinsert);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "CategoryInsert", request);
				break;
				
			case "DELETE":
				id_cat = Integer.parseInt(request.get("id_cat").toString());
				categoryService.delete(id_cat);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "UserDelete", request);
				break;
				
			case "UPDATE":
				id_cat = Integer.parseInt(request.get("id_cat").toString());
				name = request.get("name").toString();
				CategoryDTO categorytoupdate = new CategoryDTO(name);
				categorytoupdate.setIdCat(id_cat);
				categoryService.update(categorytoupdate);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "CategoryUpate", request);
				break;
				
			case "CATEGORYLIST":
				List<CategoryDTO> categoriesDTO = categoryService.getAll();
				request.put("categories", categoriesDTO);
				MainDispatcher.getInstance().callView("User", request);
				break;
				
			case "GETCHOICE":
				switch (choice.toUpperCase()) 
				{
					case "L":
						MainDispatcher.getInstance().callView(sub_package + "CategoryRead", null);
						break;
					
					case "I":
						MainDispatcher.getInstance().callView(sub_package + "CategoryInsert", null);
						break;
						
					case "M":
						MainDispatcher.getInstance().callView(sub_package + "CategoryUpdate", null);
						break;
						
					case "C":
						MainDispatcher.getInstance().callView(sub_package + "UserDelete", null);
						break;
						
					case "E":
						MainDispatcher.getInstance().callView("Login", null);
						break;
						
					case "B":
						MainDispatcher.getInstance().callView("HomeAdmin", null);
						break;
						
					default:
						MainDispatcher.getInstance().callView("Login", null);
				}
			
			default:
				MainDispatcher.getInstance().callView("Login", null);
		}
	}
}