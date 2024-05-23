import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComentarioService  {

  constructor(private http: HttpClient) { }

  getComentarios(): Observable<any>{
    return this.http.get(
      `http://academico3.rj.senac.br/comentario`,{}
    );
  }
}
