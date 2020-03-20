import { Component, OnInit, Input} from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { StudentDTO } from 'src/dto/studentdto';
import { StudentService } from 'src/service/student.service';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})

export class StudentDetailsComponent extends AbstractCrudComponent<StudentDTO> implements OnInit
{
  @Input() dto:StudentDTO;

  constructor(service: StudentService)
  {
    super(service);
  }

  ngOnInit()
  {
  }
}