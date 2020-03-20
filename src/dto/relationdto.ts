import { StudentDTO } from './studentdto';
import { ExamDTO } from './examdto';

export class RelationDTO
{
    id: number;
    student: StudentDTO;
    exam: ExamDTO;
    vote: number;
}