import { Injectable } from '@angular/core';
import { enviroments } from '../../enviroments/environments';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ErroresService } from './errores.service';
import { Rol } from '../interfaces/roles.interface';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RolesService {
  private baseUrl: string = enviroments.baseUrl;
  constructor(private http: HttpClient, private erroresService: ErroresService) { }

  httpOptions = {
    headers: new HttpHeaders({ "Authorization": `Bearer ${sessionStorage.getItem('token')}` })
  };

  getRoles(): Observable<Rol[]> {
    return this.http.get<Rol[]>(`${this.baseUrl}/roles`);
  }
}
