package it.contrader.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FeedbackDTO
{
	private Long id;
	private int vote;
	private String review;
}
