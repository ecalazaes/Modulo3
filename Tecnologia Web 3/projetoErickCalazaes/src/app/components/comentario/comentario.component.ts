import { Component, OnInit } from '@angular/core';
import { ComentarioService } from '../../service/comentario.service';
import { Comentario } from '../../interface/comentario';

@Component({
  selector: 'app-comentario',
  standalone: true,
  imports: [],
  templateUrl: './comentario.component.html',
  styleUrl: './comentario.component.css'
})
export class ComentarioComponent implements OnInit {

  comentarios: Comentario[] = [];

  constructor(private comentarioService: ComentarioService){}
  ngOnInit(): void {
    this.getComentarios();
  }

  getComentarios(): void{
    this.comentarioService.getComentarios().subscribe({
      next: (response) => {
        this.comentarios = response;
        console.log(response);
      },
      error: (error) => console.log(error),
    });
  }


}
