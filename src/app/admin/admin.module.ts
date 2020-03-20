import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { UserDetailsComponent } from './users/user-details/user-details.component';
import { ExamsComponent } from './exams/exams.component';
import { StudentsComponent } from './students/students.component';
import { RelationsComponent } from './relations/relations.component';
import { ExamDetailsComponent } from './exams/exam-details/exam-details.component';
import { StudentDetailsComponent } from './students/student-details/student-details.component';
import { RelationDetailsComponent } from './relations/relation-details/relation-details.component';


/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent,
    UserDashboardComponent,
    UsersComponent,
    WorkInProgressComponent,
    UserDetailsComponent,
    ExamsComponent,
    StudentsComponent,
    RelationsComponent,
    ExamDetailsComponent,
    StudentDetailsComponent,
    RelationDetailsComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }