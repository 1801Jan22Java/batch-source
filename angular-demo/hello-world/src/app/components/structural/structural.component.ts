import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-structural',
  templateUrl: './structural.component.html',
  styleUrls: ['./structural.component.css']
})
export class StructuralComponent implements OnInit {

  title = 'Structural Directive';
  documentation = 'https://angular.io/guide/structural-directives';

  public flashcards = [
    {
      question: 'How are you?',
      answer: 'indoors'
    },
    {
      question: 'Is it raining?',
      answer: 'yes'
    },
    {
      question: 'How much wood could a woodchuck chuck if a woodchuck could chuck wood?',
      answer: '5'
    },
    {
      question: 'What is the meaning of life, the universe, and everything?',
      answer: '43'
    }

  ];

  ngOnInit() {
  }

}
