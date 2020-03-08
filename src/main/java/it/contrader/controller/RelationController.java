package it.contrader.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import it.contrader.dto.RelationDTO;

@RestController
@RequestMapping("/relation")
@CrossOrigin(origins = "http://localhost:4200")
public class RelationController extends AbstractController<RelationDTO> {

}