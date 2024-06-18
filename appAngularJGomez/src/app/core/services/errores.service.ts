import { HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class ErroresService {

    public _handleError(error: HttpErrorResponse) {
        //console.log(error);
        let errorMessage = 'No se obtuvo respuesta del servidor de autenticación. Verifica tu conexión a red Interna.';
        if (error.error.data?.userMessage) errorMessage = error.error.data.userMessage;
        else if (error.error.data?.errorCode) errorMessage = error.error.data.message;
        return throwError(() => new Error(errorMessage));
    }

    public _alertError() {
        return throwError(() => [
            {
                msg: 'No se obtuvo respuesta del servidor de autenticación. Verifica tu conexión a red Interna.'
            }
        ]);
    }

}
