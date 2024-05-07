import { Subject, takeUntil } from 'rxjs';
import { EmpresaService } from './../../services/empresa.service';
import { Component, OnDestroy, OnInit, inject } from '@angular/core';
import { initFlowbite } from 'flowbite';

@Component({
  selector: 'app-empresas',
  standalone: true,
  imports: [],
  templateUrl: './empresas.component.html',
  styleUrl: './empresas.component.css'
})
export class EmpresasComponent implements OnInit, OnDestroy {

  EmpresaResponse: any;
  private readonly destroy$: Subject<void> = new Subject();

  private EmpresaService = inject(EmpresaService)

  ngOnInit(): void {
    initFlowbite();
    this.getEmpresas();
  }

  getEmpresas(): void {
    this.EmpresaService.getEmpresas().subscribe({
      next: (response:any) => {
        response && (this.EmpresaResponse = response);
        console.log(this.EmpresaResponse);
      },
      error: (error) => console.log(error),
    });
  }

  getEmpresasPorId(id: number): void {
    this.EmpresaService.getEmpresasPorId(id).pipe(takeUntil(this.destroy$)).subscribe({
      next: (response:any) => {
        response && (this.EmpresaResponse = response);
        console.log(this.EmpresaResponse);
      },
      error: (error) => console.log(error),
    });
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
