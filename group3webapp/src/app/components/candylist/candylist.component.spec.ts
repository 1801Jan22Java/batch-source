import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CandylistComponent } from './candylist.component';

describe('CandylistComponent', () => {
  let component: CandylistComponent;
  let fixture: ComponentFixture<CandylistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CandylistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CandylistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
