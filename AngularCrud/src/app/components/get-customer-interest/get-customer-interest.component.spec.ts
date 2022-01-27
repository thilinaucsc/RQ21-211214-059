import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetCustomerInterestComponent } from './get-customer-interest.component';

describe('GetCustomerInterestComponent', () => {
  let component: GetCustomerInterestComponent;
  let fixture: ComponentFixture<GetCustomerInterestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetCustomerInterestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetCustomerInterestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
