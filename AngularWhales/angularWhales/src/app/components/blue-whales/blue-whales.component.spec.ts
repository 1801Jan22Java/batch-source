import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlueWhalesComponent } from './blue-whales.component';

describe('BlueWhalesComponent', () => {
  let component: BlueWhalesComponent;
  let fixture: ComponentFixture<BlueWhalesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlueWhalesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlueWhalesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
