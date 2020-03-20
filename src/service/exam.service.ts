import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { ExamDTO } from 'src/dto/examdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
  })

  export class ExamService extends AbstractService<ExamDTO>{

    exams: ExamDTO[];
  
    constructor(http: HttpClient)
    {
      super(http);
      this.type='exam';
    }
  }