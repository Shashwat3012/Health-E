import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable()
export class UserService {
    httpOptions: any;
    constructor(private http: HttpClient) {
        this.httpOptions = {
            headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Accept': '*/*' })
        };
    }

    register(user: any): Observable<any> {
        return this.http.post('http://localhost:8080/register', user, { ...this.httpOptions, responseType: 'text' })
    }

    login(user: any): Observable<any> {
        return this.http.post('http://localhost:8080/login', user, { ...this.httpOptions, responseType: 'text' })
    }

    submitPatientData(user: any): Observable<any> {
        return this.http.post('http://localhost:8080/savePatientData', user, { ...this.httpOptions, responseType: 'text' })
    }

    editPatientData(user: any): Observable<any> {
        return this.http.post('http://localhost:8080/editPatientData', user, { ...this.httpOptions, responseType: 'text' })
    }

    requestData(request: any): Observable<any> {
        return this.http.post('http://localhost:8080/requestPatientInfo', request, { ...this.httpOptions, responseType: 'text' })
    }

    fetchPatient(patientId: string): Observable<any> {
        let queryParams = new HttpParams().append("patientId", patientId);
        return this.http.get('http://localhost:8080/patientInfo', { ...this.httpOptions, params: queryParams })
    }

    fetchPatientRequests(patientId: string): Observable<any> {
        let queryParams = new HttpParams().append("patientId", patientId);
        return this.http.get('http://localhost:8080/getRequests', { ...this.httpOptions, params: queryParams })
    }

    updateRequestStatus(request: any): Observable<any> {
        return this.http.post('http://localhost:8080/updateRequestStatus', request, { ...this.httpOptions, responseType: 'text' })
    }

    fetchRequestsByDoctor(doctorId: string): Observable<any> {
        let queryParams = new HttpParams().append("doctorId", doctorId);
        return this.http.get('http://localhost:8080/getRequestsByDoctor', { ...this.httpOptions, params: queryParams })
    }

}