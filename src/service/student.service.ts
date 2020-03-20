import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { StudentDTO } from 'src/dto/studentdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class StudentService extends AbstractService<StudentDTO>
{
  students: StudentDTO[];

  constructor(http: HttpClient)
  {
    super(http);
    this.type='student';
  }
}