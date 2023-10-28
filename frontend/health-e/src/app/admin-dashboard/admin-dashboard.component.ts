import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { UserService } from '../services/user.service';

export interface DoctorInfo {
  uuid: string;
  license: string;
  status: string;
  hospital: string;
}

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  displayedColumns: string[] = ['uuid', 'license', 'hospital','status', 'action'];
  dataSource!: MatTableDataSource<DoctorInfo>;

  constructor(private userService: UserService,private _snackbar:MatSnackBar) { }

  ngOnInit(): void {
    this.fetchAllDoctors();
  }
  fetchAllDoctors() {
    this.userService.fetchAllDoctors().subscribe((response) => { 
      console.log(response);
      this.dataSource = response;
    })
  }
  updateStatus(doctorId: string,) {
    this.userService.updateDoctorUser(doctorId).subscribe((response) => {
      this._snackbar.open("Successfully Updated Status", "Close", {
        duration: 1500,
      });
    })
    this.fetchAllDoctors();
  }
}
