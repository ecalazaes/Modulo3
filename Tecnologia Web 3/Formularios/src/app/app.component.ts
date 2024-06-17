import { EmpresaService } from './empresa.service';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { Empresa } from './empresa';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'formularios';

  empresaForm = new FormGroup({
    empresa_nome: new FormControl('', Validators.required),
    empresa_cnpj: new FormControl('', Validators.required),
  });

  constructor(private empresaService: EmpresaService){}

  onSubmit(){
    console.log(this.empresaForm.value);
    this.empresaService.gravarEmpresa(<Empresa>this.empresaForm.value).subscribe({
      next:(response) => {
        console.log(response);
      },
      error: (error) => console.log(error),
    })
  }
}
