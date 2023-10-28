import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { UserService } from '../services/user.service';

export interface RequestData {
  requestId: string;
  patientId: string;
  doctorId: string;
  reason: string;
  date: string;
  status: string;
}

@Component({
  selector: 'app-nominee-dashboard',
  templateUrl: './nominee-dashboard.component.html',
  styleUrls: ['./nominee-dashboard.component.css']
})
export class NomineeDashboardComponent implements OnInit {
  displayedColumns: string[] = ['requestId', 'doctorId', 'reason', 'date', 'status', 'action'];
  dataSource!: MatTableDataSource<RequestData>;
  patientId = "";
  constructor(private userService: UserService, private _snackbar: MatSnackBar) { }

  ngOnInit() {
    this.patientId = sessionStorage.getItem("userId") || "";
    this.fetchPatientRequests();
  }

  fetchPatientRequests() {
    this.userService.fetchPatientRequests(this.patientId).subscribe((response) => {
      console.log(response);
      this.dataSource = response;
    })
  }

  statusUpdate(status: string, id: string) {
    const request = {
      requestId: id,
      status: status
    }
    this.userService.updateRequestStatus(request).subscribe((response) => {
      this._snackbar.open("Successfully updated request", "Close", {
        duration: 1500,

      });
    })
  }

}
