package com.example.healthe.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor_request")
public class doctorRequest {

    @Id
    @Column(name = "request_id")
    private  int requestId;

    @Column(name = "uuid")
    private int UUID;

    @Column(name = "reason")
    private String reason;

    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "date")
    private String date;

    @Column(name = "status")
    private String status;


    public doctorRequest(int requestId, int UUID, String reason, int doctorId, String date, String status) {
        this.requestId = requestId;
        this.UUID = UUID;
        this.reason = reason;
        this.doctorId = doctorId;
        this.date = date;
        this.status = status;
    }


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getUUID() {
        return UUID;
    }

    public void setUUID(int UUID) {
        this.UUID = UUID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
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
                ", UUID=" + UUID +
                ", reason='" + reason + '\'' +
                ", doctorId=" + doctorId +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
