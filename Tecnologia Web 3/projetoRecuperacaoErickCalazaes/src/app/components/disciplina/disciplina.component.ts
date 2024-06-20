import { DisciplinaService } from './../../service/disciplina.service';
import { Component, OnInit } from '@angular/core';
import { Disciplina } from '../../interface/disciplina';

@Component({
  selector: 'app-disciplina',
  standalone: true,
  imports: [],
  templateUrl: './disciplina.component.html',
  styleUrl: './disciplina.component.css'
})
export class DisciplinaComponent implements OnInit {

  disciplinas: Disciplina[] = [];

  constructor(private disciplinaService: DisciplinaService){}

  ngOnInit(): void {
    this.getDisciplinas();
  }

  getDisciplinas(): void{
    this.disciplinaService.getDisciplinas().subscribe({
      next: (response) => {
        this.disciplinas = response;
        console.log(response);
      },
      error: (error) => console.log(error),
    });
  }


}
