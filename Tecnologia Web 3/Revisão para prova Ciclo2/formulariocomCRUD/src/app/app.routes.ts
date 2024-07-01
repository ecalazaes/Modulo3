import { Routes } from '@angular/router';
import { AtualizarEmpresaComponent } from './atualizarEmpresa/atualizar-empresa/atualizar-empresa.component';
import { CriarEmpresaComponent } from './criarEmpresa/criar-empresa/criar-empresa.component';

export const routes: Routes = [
  {
    path:'atualizarEmpresa',
    component: AtualizarEmpresaComponent
  },
  {
    path:'criaEmpresa',
    component: CriarEmpresaComponent
  }
];
