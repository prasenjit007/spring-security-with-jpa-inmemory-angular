import { Component, OnInit } from '@angular/core';
import { EventService } from './../event.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-special-events',
  templateUrl: './special-events.component.html',
  styleUrls: ['./special-events.component.scss']
})
export class SpecialEventsComponent implements OnInit {

  specialEvents = [];

  constructor(private event: EventService,
    private router: Router) { }

  ngOnInit(): void {
    this.loadSpecialEvents()
  }

  loadSpecialEvents(){
    this.event.getSpecialEvents()
      .subscribe(
        response => {
          this.specialEvents = response;
          console.log(response)
        },
        error => {
          if(error instanceof HttpErrorResponse){
            console.log(error)
            this.router.navigate(['/login'])
          }
          
        }
      )
  }
}
