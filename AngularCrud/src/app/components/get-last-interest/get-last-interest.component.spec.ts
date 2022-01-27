import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetLastInterestComponent } from './get-last-interest.component';

describe('GetLastInterestComponent', () => {
  let component: GetLastInterestComponent;
  let fixture: ComponentFixture<GetLastInterestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetLastInterestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetLastInterestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
