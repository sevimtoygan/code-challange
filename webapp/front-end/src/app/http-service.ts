import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment as env } from '../environments/environment';

@Injectable()
export class HttpService {

    private headers: HttpHeaders;

    constructor(private http: HttpClient) {
         this.headers = new HttpHeaders(
            {
                'Content-Type': 'application/json',
                Accept: 'application/json'
            }
        );
    }

    public get<T>(uri: string): Observable<any> {
        const url = `${env.baseUrl}` + uri;
        console.log('get : ' + url);
        return this.http.get<T>(url, { headers: this.headers }).pipe();
    }


    public post<T>(uri: string, o: any): Observable<any> {
        const url = `${env.baseUrl}` + uri;
        console.log('post : ' + url + '  ' + o);
        return this.http.post<T>(url, o, { headers: this.headers}).pipe();
    }

}
