package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.model.Relation;
import it.contrader.dto.RelationDTO;

@Component
public class RelationConverter extends AbstractConverter<Relation, RelationDTO>
{
	@Override
	public Relation toEntity(RelationDTO relationDTO) 
	{
		Relation relation = null;
		
		if (relationDTO != null)
			relation = new Relation(relationDTO.getId(), relationDTO.getStudent(), relationDTO.getExam(), relationDTO.getVote());
		
		return relation;
	}
	
	@Override
	public RelationDTO toDTO(Relation relation) 
	{
		RelationDTO relationDTO = null;
		
		if (relation != null)
			relationDTO = new RelationDTO(relation.getId(), relation.getStudent(), relation.getExam(), relation.getVote());
		
		return relationDTO;
	}
}