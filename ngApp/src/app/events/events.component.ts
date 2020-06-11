import { Component, OnInit } from '@angular/core';
import { EventService } from './../event.service';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})
export class EventsComponent implements OnInit {

  events = [];

  constructor(private event: EventService) { }

  ngOnInit(): void {
    this.loadEvents()
  }

  loadEvents(){
    this.event.getEvents()
      .subscribe(
        response => {
          this.events = response;
          console.log(response)
        },
        error => {
          console.log(error)
        }
      )
  }

}
