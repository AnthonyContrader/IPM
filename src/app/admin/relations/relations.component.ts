import { Component, OnInit } from '@angular/core';
import { RelationService } from 'src/service/relation.service';
import { RelationDTO } from 'src/dto/relationdto';
import { ExamDTO } from 'src/dto/examdto';
import { ExamService } from 'src/service/exam.service';
import { StudentDTO } from 'src/dto/studentdto';
import { StudentService } from 'src/service/student.service';

@Component({
  selector: 'app-relations',
  templateUrl: './relations.component.html',
  styleUrls: ['./relations.component.css']
})
export class RelationsComponent implements OnInit {

  exams: ExamDTO[];
  students: StudentDTO[];
  relations: RelationDTO[];
  relationtoinsert: RelationDTO = new RelationDTO();

  constructor(private serviceRelation: RelationService, private serviceExam: ExamService,
     private serviceStudent: StudentService){
  }

  ngOnInit() {
    this.getRelations();
    this.getExams();
    this.getStudents();
  }

  getRelations() {
    this.serviceRelation.getAll().subscribe(relations => this.relations = relations);
  }

  getExams()
  {
    this.serviceExam.getAll().subscribe(exams => this.exams = exams);
  }

  getStudents()
  {
    this.serviceStudent.getAll().subscribe(students => this.students = students);
  }

  delete(relation: RelationDTO) 
  {
    this.serviceRelation.delete(relation.id).subscribe(() => this.getRelations());
  }

  update(relation: RelationDTO) 
  {
    this.serviceRelation.update(relation).subscribe(() => this.getRelations());
  }

  insert(relation: RelationDTO) 
  {
    if (relation.vote > 30)
    {
      this.alert();
    }
    else
    {
      this.serviceRelation.insert(relation).subscribe(() => this.getRelations());
    }

  }

  clear()
  {
    this.relationtoinsert = new RelationDTO();
  }

  alert() 
  {
    window.alert("Insert a vote less or equal to 30!");
  }

}