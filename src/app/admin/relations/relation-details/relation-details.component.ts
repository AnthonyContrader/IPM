import { Component, OnInit, Input } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { RelationDTO } from 'src/dto/relationdto';
import { RelationService } from 'src/service/relation.service';

@Component({
  selector: 'app-relation-details',
  templateUrl: './relation-details.component.html',
  styleUrls: ['./relation-details.component.css']
})
export class RelationDetailsComponent extends AbstractCrudComponent<RelationDTO>  implements OnInit
{
  @Input() dto:RelationDTO;

  constructor(service: RelationService)
  {
    super(service);
  }

  ngOnInit()
  {
  }

}
