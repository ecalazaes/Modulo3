import { Component, OnInit } from '@angular/core';
import { EmpresaService } from '../../service/empresa.service';
import { Empresa } from '../../interface/empresa/empresa';

@Component({
  selector: 'app-empresa',
  standalone: true,
  imports: [],
  templateUrl: './empresa.component.html',
  styleUrl: './empresa.component.css'
})
export class EmpresaComponent implements OnInit {

  empresas: Empresa[] = [];

  constructor (private empresaService: EmpresaService){}
  ngOnInit(): void {
    this.getEmpresas();
  }

  getEmpresas(): void{
    this.empresaService.getEmpresas().subscribe({
      next: (response)=> {
        this.empresas = response;
        console.log(response);
      },
      error: (error)=> console.log(error),
    });
  }
}
