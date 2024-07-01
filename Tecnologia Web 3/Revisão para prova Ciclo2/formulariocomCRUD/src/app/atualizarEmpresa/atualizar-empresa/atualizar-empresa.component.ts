import { Component } from '@angular/core';
import { FormControl, FormControlName, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { EmpresaService } from '../../empresa.service';
import { Empresa } from '../../empresa';

@Component({
  selector: 'app-atualizar-empresa',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './atualizar-empresa.component.html',
  styleUrl: './atualizar-empresa.component.css'
})
export class AtualizarEmpresaComponent {

  buscarEmpresa = new FormControl;

  empresaForm = new FormGroup({
    empresa_id: new FormControl(0, Validators.required),
    empresa_nome: new FormControl('', Validators.required),
    empresa_cnpj: new FormControl('', Validators.required),
  });

  constructor(private empresaService: EmpresaService){}

  onSubmit() {
    console.log(this.empresaForm.value);
    this.empresaService.atualizarEmpresa(<Empresa>this.empresaForm.value, <number>this.empresaForm.value.empresa_id).subscribe({
      next:(response) =>{
        console.log(response);
      },
      error: (error) => console.log(error),
    })
  }

  getEmpresaPorId(){
    this.empresaService.getEmpresaPorId(this.buscarEmpresa.value).subscribe({
      next: (response) =>{
        console.log(response);
        this.empresaForm.patchValue(
          {
            empresa_id: response.empresa_id,
            empresa_nome:response.empresa_nome,
            empresa_cnpj:response.empresa_cnpj
          }
        )
      },
      error: (error) => console.log(error),
    })
  }

}
