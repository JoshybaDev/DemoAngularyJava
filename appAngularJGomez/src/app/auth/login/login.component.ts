import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../core/services/auth.service';
import { Router } from '@angular/router';
import { LoginResponse } from '../../core/interfaces/login.interface';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, NgIf],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  constructor(private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private sanitizer: DomSanitizer
  ) { }

  public mensajeShowStatus: Boolean = false;
  public mensajeShowData: SafeHtml = "";

  formlogin = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(6)]],
  });


  onSubmit(form: FormGroup) {
    if (form.valid) {
      // TODO: Use EventEmitter with form value
      //console.warn("Data ====> ", this.formUserNew.value);
      this.authService.setLogin({
        username: this.formlogin.get('email').value.toString() || '',
        password: this.formlogin.get('password').value.toString() || '',
      }).subscribe({
        next: (response: LoginResponse) => {
          if (response.code == 200) {
            sessionStorage.setItem('token', response.accessToken);
            sessionStorage.setItem('name', response.name);
            sessionStorage.setItem('rol', response.rol);
            sessionStorage.setItem('iperfil', response.iperfil);
            this.router.navigate([response.redirect]);
          } else {
            this.mensajeShowStatus = true
            this.mensajeShowData = this.sanitizer.bypassSecurityTrustHtml(this.MensajeSuccesError(response.msg, false));
            setTimeout(() => { this.mensajeShowStatus = false }, 3000);
          }

        },
        error: (error) => {
          console.log("Error ====> ", error);
        }
      });
    }
  }

  MensajeSuccesError(mensaje: string, succes: Boolean = true) {
    let tipo: string = succes == true ? 'success' : 'danger';
    return `
    <div class="alert alert-${tipo} alert-dismissible fade show" role="alert">
    ${mensaje}
    <button class="btn-close" type="button" data-dismiss="alert" aria-label="Close"></button>
    </div>
    `;
  }
}

/*
localStorage.setItem('currentUser', JSON.stringify({ token: token, name: name }));
var currentUser = JSON.parse(localStorage.getItem('currentUser'));
var token = currentUser.token; // Tu token

sessionStorage.setItem('token', token);
var storedToken = sessionStorage.getItem('token');
sessionStorage.removeItem('location');
*/
