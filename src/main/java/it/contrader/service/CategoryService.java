package it.contrader.service;

import java.util.List;
import it.contrader.converter.CategoryConverter;
import it.contrader.dao.CategoryDAO;
import it.contrader.dto.CategoryDTO;

public class CategoryService
{
	private CategoryDAO categoryDAO;
	private CategoryConverter categoryConverter;
	
	public CategoryService () 
	{
		this.categoryDAO = new CategoryDAO();
		this.categoryConverter = new CategoryConverter();
	}
	
	public List<CategoryDTO> getAll()
	{
		return categoryConverter.toDTOList(categoryDAO.getAll());
	}
	
	public CategoryDTO read (int id_cat) 
	{
		return categoryConverter.toDTO(categoryDAO.read(id_cat));
	}
	
	public boolean insert (CategoryDTO dto) 
	{
		return categoryDAO.insert(categoryConverter.toEntity(dto));
	}
	
	public boolean update(CategoryDTO dto) 
	{
		return categoryDAO.update(categoryConverter.toEntity(dto));
	}
	
	public boolean delete (int id_cat) 
	{
		return categoryDAO.delete(id_cat);
	}
}
