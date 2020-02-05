package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;

public class CategoryConverter
{
	public CategoryDTO toDTO (Category category)
	{
		CategoryDTO categoryDTO = new CategoryDTO (category.getIdCat(), category.getName());
		return categoryDTO;
	}
	
	public Category toEntity (CategoryDTO categoryDTO) 
	{
		Category category = new Category (categoryDTO.getIdCat(), categoryDTO.getName());
		return category;
	}
	
	public List<CategoryDTO> toDTOList(List<Category> categoryList)
	{
		List <CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
		
		for (Category category : categoryList) 
		{
			categoryDTOList.add(toDTO(category));
		}
		
		return categoryDTOList;
	}
}