import { Gif } from '../model/gif.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { HttpResponse } from '@angular/common/http';

import 'rxjs/Rx';
@Injectable()
export class GiphyService {

    //Injecting the http object
    constructor(private http: HttpClient) {}

    public getAGif(): Observable<Object> {
        

        return this.http
        .get(`https://api.giphy.com/v1/gifs/random?api_key=5tXQ2JllpfmxWcBkXPQenB39ezqBa8TL&tag="derp animals"`);
        /*.subscribe((data : any) => {
           console.log(data);
            url = data.data.image_url;
            name = data.data.title;
        });*/
        

        
    }

    private handleError(error: Response) {
        return Observable.throw(error.statusText);
    }
}