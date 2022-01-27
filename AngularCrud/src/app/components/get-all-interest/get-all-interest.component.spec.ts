import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllInterestComponent } from './get-all-interest.component';

describe('GetAllInterestComponent', () => {
  let component: GetAllInterestComponent;
  let fixture: ComponentFixture<GetAllInterestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllInterestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllInterestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
