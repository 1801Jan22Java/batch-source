import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipesubComponent } from './recipesub.component';

describe('RecipesubComponent', () => {
  let component: RecipesubComponent;
  let fixture: ComponentFixture<RecipesubComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipesubComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipesubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
