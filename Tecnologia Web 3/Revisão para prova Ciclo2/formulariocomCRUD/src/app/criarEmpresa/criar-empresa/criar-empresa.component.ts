import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { EmpresaService } from '../../empresa.service';
import { Empresa } from '../../empresa';

@Component({
  selector: 'app-criar-empresa',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './criar-empresa.component.html',
  styleUrl: './criar-empresa.component.css'
})
export class CriarEmpresaComponent {

  empresaForm = new FormGroup({
    empresa_nome: new FormControl('', Validators.required),
    empresa_cnpj: new FormControl('', Validators.required),
  });

  constructor(private empresaService: EmpresaService){}

  onSubmit() {
    console.log(this.empresaForm.value);
    this.empresaService.gravarEmpresa(<Empresa>this.empresaForm.value).subscribe({
      next:(response) =>{
        console.log(response);
      },
      error: (error) => console.log(error),
    })
  }
}
