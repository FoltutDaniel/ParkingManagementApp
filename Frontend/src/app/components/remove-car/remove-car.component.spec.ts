import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveCarComponent } from './remove-car.component';

describe('RemoveCarComponent', () => {
  let component: RemoveCarComponent;
  let fixture: ComponentFixture<RemoveCarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RemoveCarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RemoveCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
