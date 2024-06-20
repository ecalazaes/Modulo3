import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DisciplinaService {

  constructor(private http: HttpClient) { }

  getDisciplinas(): Observable<any>{
    return this.http.get(
      `http://academico3.rj.senac.br/disciplina`, {}
    );
  }
}
