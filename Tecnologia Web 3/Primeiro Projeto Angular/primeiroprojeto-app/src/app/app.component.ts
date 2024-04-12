import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EmpresasComponent } from './components/empresas/empresas.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [EmpresasComponent, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'primeiroprojeto-app';
}
