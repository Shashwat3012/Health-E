import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable()
export class UserService{
    httpOptions: any;
    constructor(private http: HttpClient){
        this.httpOptions = {
            headers: new HttpHeaders({'Content-Type': 'application/json', 'Accept': '*/*'})
        };
    }

    register(user:any):Observable<any>{
        return this.http.post('http://localhost:8080/register',user,{ ...this.httpOptions, responseType: 'text' })
    }

    login(user:any):Observable<any>{
        return this.http.post('http://localhost:8080/login',user,{ ...this.httpOptions, responseType: 'text' })
    }
}