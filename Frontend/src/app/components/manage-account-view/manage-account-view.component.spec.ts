import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageAccountViewComponent } from './manage-account-view.component';

describe('ManageAccountViewComponent', () => {
  let component: ManageAccountViewComponent;
  let fixture: ComponentFixture<ManageAccountViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageAccountViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageAccountViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
