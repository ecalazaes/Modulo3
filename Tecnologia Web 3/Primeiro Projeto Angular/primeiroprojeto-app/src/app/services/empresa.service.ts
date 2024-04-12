import { HttpClient } from "@angular/common/http";
import { environment } from "../environments/environments";
import { Observable } from "rxjs";
import { Empresa } from "../models/Empresa";

export class EmpresaService {
    url:string = environment.apiServer + 'api/CursoTipo';
  
    constructor(private https: HttpClient) { }
  
    ObterTodos(): Observable<Empresa[]>
    {
      return this.https.get<Empresa[]>(this.url);
    }
  }