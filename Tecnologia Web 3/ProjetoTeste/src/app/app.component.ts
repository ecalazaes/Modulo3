import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BuscaComponent } from './components/busca/busca.component';
import { TabelaComponent } from './components/tabela/tabela.component';
import { initFlowbite } from 'flowbite';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, BuscaComponent, TabelaComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  title = 'ProjetoGetAPI';

  ngOnInit(): void {
    initFlowbite();
  }
}
