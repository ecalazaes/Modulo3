import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MatSlideToggle } from '@angular/material/slide-toggle';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { CdkDragDrop, DragDropModule } from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-empresas',
  standalone: true,
  imports: [RouterOutlet, MatSlideToggle, MatProgressSpinnerModule, DragDropModule],
  templateUrl: './empresas.component.html',
  styleUrl: './empresas.component.css'
})
export class EmpresasComponent {
todo: any;
drop($event: CdkDragDrop<any,any,any>) {
throw new Error('Method not implemented.');
}
done: any;

}
