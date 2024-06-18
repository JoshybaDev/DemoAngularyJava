import { HttpClient } from "@angular/common/http";
import { enviroments } from "../../enviroments/environments";
import { Observable, catchError, map, of } from "rxjs";
import { Injectable } from "@angular/core";
import { ErroresService } from "./errores.service";
import { LoginResponse, loginRequest } from "../interfaces/login.interface";

@Injectable({providedIn:'root'})
export class AuthService{
    private baseUrl:string = enviroments.baseUrl;
    constructor(private http:HttpClient, private erroresService: ErroresService){}

    setLogin(login: loginRequest): Observable<LoginResponse> {
        return this.http.post<LoginResponse>(`${this.baseUrl}/login`, login)
            .pipe(map(data => data),
                catchError(this.erroresService._handleError)
            );
    }
}