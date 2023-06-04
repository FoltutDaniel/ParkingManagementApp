import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParkViewComponent } from './park-view.component';

describe('ParkViewComponent', () => {
  let component: ParkViewComponent;
  let fixture: ComponentFixture<ParkViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParkViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ParkViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
