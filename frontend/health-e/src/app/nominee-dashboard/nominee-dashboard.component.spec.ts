import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NomineeDashboardComponent } from './nominee-dashboard.component';

describe('NomineeDashboardComponent', () => {
  let component: NomineeDashboardComponent;
  let fixture: ComponentFixture<NomineeDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NomineeDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NomineeDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
