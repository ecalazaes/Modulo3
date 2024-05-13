import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  constructor(private http: HttpClient) { }

  getEmpresas(): Observable<any>{
    return this.http.get(
      `http://academico3.rj.senac.br/empresa`,{}
    );
  }
}
