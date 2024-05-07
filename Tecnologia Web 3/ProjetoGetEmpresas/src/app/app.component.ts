import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { initFlowbite } from 'flowbite';
import { EmpresasComponent } from './components/empresas/empresas.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, EmpresasComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  ngOnInit(): void {
    initFlowbite();
  }

  title = 'ProjetoGetEmpresas';
}
