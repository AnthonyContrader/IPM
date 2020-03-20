import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { RelationDTO } from 'src/dto/relationdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class RelationService extends AbstractService<RelationDTO>
{
  relations: RelationDTO;
  
  constructor(http: HttpClient)
  { 
    super(http);
    this.type = 'relation';
  }
}
