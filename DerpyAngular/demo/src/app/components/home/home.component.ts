import { Component, OnInit } from '@angular/core';
import { GiphyService } from '../../Service/giphy.service';
import { Gif } from '../../model/gif.model';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  

  constructor(private gifService : GiphyService) { }

  getGif(){
    let resp : Observable<Object> = this.gifService.getAGif();
    resp.subscribe((data : any) => {
      console.log(data);
      let style = document.getElementById('display').style;
      style.setProperty("background-image", `url(${data.data.image_url})`);
      style.height = `${data.data.image_height}px`;
      style.width = `${data.data.image_width}px`;
    
      console.log(document.getElementById('display').style);
  
    });
    
  }


  ngOnInit() {
    this.getGif();
  }

}
