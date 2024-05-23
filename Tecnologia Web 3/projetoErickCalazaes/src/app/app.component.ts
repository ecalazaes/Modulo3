import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { initFlowbite } from 'flowbite';
import { ComentarioComponent } from './components/comentario/comentario.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ComentarioComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'projetoErickCalazaes';

  ngOnInit(): void {
    initFlowbite();
  }
}
