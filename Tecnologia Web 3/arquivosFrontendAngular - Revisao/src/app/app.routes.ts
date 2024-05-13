import { Routes } from '@angular/router';
import { HomeComponent } from './pages/homeArquivos/homeArquivos.component';
import { EmpresaComponent } from './components/empresa/empresa.component';
export const routes: Routes = [
    {
        path:'page',
        loadComponent : () => import('./components/comentario/comentario.component')
    },
    {
        path:'' ,component:HomeComponent
    },
    {
        path: 'empresa', component:EmpresaComponent
    },

];
