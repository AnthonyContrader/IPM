import { Component, OnInit } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { StudentDTO } from 'src/dto/studentdto';
import { StudentService } from 'src/service/student.service';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})

export class StudentsComponent extends AbstractCrudComponent<StudentDTO> implements OnInit 
{
  constructor( service: StudentService,  filter: SearchService)
  {
    super(service);
  }

  ngOnInit() 
  {
    this.clear();
    this.close();
    this.getAll();
  }

  clear()
  {
    this.dto = new StudentDTO();
  }

  close()
  {
    this.selected = null;
  }
}