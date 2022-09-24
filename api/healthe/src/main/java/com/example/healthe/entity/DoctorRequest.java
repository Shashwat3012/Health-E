package com.example.healthe.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor_request")
public class DoctorRequest {

    @Id
    @Column(name = "request_id")
    private String requestId;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "reason")
    private String reason;

    @Column(name = "doctor_id")
    private String doctorId;

    @Column(name = "date")
    private String date;

    @Column(name = "status")
    private String status;

    public DoctorRequest(){

    }

    public DoctorRequest(String requestId, String patientId, String reason, String doctorId, String date, String status) {
        this.requestId = requestId;
        this.patientId = patientId;
        this.reason = reason;
        this.doctorId = doctorId;
        this.date = date;
        this.status = status;
    }


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getpatientId() {
        return patientId;
    }

    public void setpatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "doctorRequest{" +
                "requestId=" + requestId +
                ", patientId=" + patientId +
                ", reason='" + reason + '\'' +
                ", doctorId=" + doctorId +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
