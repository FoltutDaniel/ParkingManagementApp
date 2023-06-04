import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParkingLogsViewComponent } from './parking-logs-view.component';

describe('ParkingLogsViewComponent', () => {
  let component: ParkingLogsViewComponent;
  let fixture: ComponentFixture<ParkingLogsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParkingLogsViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ParkingLogsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
