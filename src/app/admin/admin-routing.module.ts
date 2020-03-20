import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { AuthGuard } from '../../guard/auth/auth.guard';
import { ExamsComponent } from './exams/exams.component';
import { StudentsComponent } from './students/students.component';
import { RelationsComponent } from './relations/relations.component';
import { ExamDetailsComponent } from './exams/exam-details/exam-details.component';
import { StudentDetailsComponent } from './students/student-details/student-details.component';


/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri
 * (qui sotto sono indentati). Si osservi il Guard "canActivate: [AuthGuard]" che protegge le routes
 * del'ADMIN dagli altri utenti.
 *
 * @author Vittorio Valent
 *
 * @see AdminLayoutComponent
 * @see AuthGuard
 * @see layout
 */
const routes: Routes = [
  {
    path: 'admin-dashboard', component: AdminLayoutComponent, canActivate: [AuthGuard], children: [
      { path: '', component: AdminDashboardComponent },
      { path: 'users', component: UsersComponent },
      { path: 'work-in-progress', component: WorkInProgressComponent },
      { path: 'students', component: StudentsComponent },
      { path: 'exams', component: ExamsComponent },
      { path: 'relations', component: RelationsComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})

export class AdminRoutingModule{}
