import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipesubmissionComponent } from './recipesubmission.component';

describe('RecipesubmissionComponent', () => {
  let component: RecipesubmissionComponent;
  let fixture: ComponentFixture<RecipesubmissionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipesubmissionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipesubmissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
