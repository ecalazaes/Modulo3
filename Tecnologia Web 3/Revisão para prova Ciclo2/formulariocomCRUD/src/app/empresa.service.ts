import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Empresa } from './empresa';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  constructor(private http: HttpClient) { }

  gravarEmpresa(empresa: Empresa): Observable<Empresa>{
    return this.http.post<Empresa>("http://academico3.rj.senac.br/empresa", empresa).pipe(
    );
  }

  atualizarEmpresa(empresa: Empresa, idEmpresa : number): Observable<Empresa>{
    return this.http.put<Empresa>("http://academico3.rj.senac.br/empresa/"+ idEmpresa, empresa).pipe(
    );
  }

  getEmpresaPorId(idEmpresa: number): Observable<Empresa>{
    return this.http.get<Empresa>("http://academico3.rj.senac.br/empresa/"+ idEmpresa).pipe(
    );
  }
}
