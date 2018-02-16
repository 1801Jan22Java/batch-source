import { Gif } from '../models/gif.model';

@Injectable()
export class GiphyService {

    //Injecting the http object
    constructor(private http: HttpClient) {}

    public getAGif(id: number): Gif {

        let resp = this.http
        .get(`api.giphy.com/v1/gifs/random?api_key=5tXQ2JllpfmxWcBkXPQenB39ezqBa8TL&tag="derp animals"`)
        .catch(this.handleError);
        console.log(resp);

        return ;
    }

    private handleError(error: Response) {
        return Observable.throw(error.statusText);
    }
}