import { Component, OnInit } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { ExamDTO } from 'src/dto/examdto';
import { ExamService } from 'src/service/exam.service';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-exams',
  templateUrl: './exams.component.html',
  styleUrls: ['./exams.component.css']
})

export class ExamsComponent extends AbstractCrudComponent<ExamDTO> implements OnInit 
{
  constructor(service: ExamService, filter: SearchService)
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
    this.dto = new ExamDTO();
  }

  close()
  {
    this.selected = null;
  }
}
