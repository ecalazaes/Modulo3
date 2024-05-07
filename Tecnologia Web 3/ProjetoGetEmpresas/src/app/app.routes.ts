import { Routes } from '@angular/router';
import { EmpresasComponent } from './components/empresas/empresas.component';

export const routes: Routes = [
  {
    path:'',
    redirectTo:'empresa',
    pathMatch:'full'
  },
  {
    path: 'empresa',
    component: EmpresasComponent
  }
];
