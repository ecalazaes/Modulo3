import { NgModule } from '@angular/core';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { EmpresasComponent } from './components/empresas/empresas.component';

@NgModule({
  imports: [
    MatSlideToggleModule, EmpresasComponent
  ]
})
class AppModule { }