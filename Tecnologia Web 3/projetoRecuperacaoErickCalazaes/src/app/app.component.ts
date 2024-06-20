import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { initFlowbite } from 'flowbite';
import { DisciplinaComponent } from './components/disciplina/disciplina.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, DisciplinaComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'projetoRecuperacaoErickCalazaes';

  ngOnInit(): void {
    initFlowbite();
  }
}
