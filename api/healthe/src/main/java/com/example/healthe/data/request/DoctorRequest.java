package com.example.healthe.data.request;

public class DoctorRequest {

    private final String patientId;

    private final String reason;

    private final String doctorId;

    private final String date;

    private final String status;


    public DoctorRequest(String patientId, String reason, String doctorId, String date, String status) {
        this.patientId = patientId;
        this.reason = reason;
        this.doctorId = doctorId;
        this.date = date;
        this.status = status;
    }

    public String getpatientId() {
        return patientId;
    }

    public String getReason() {
        return reason;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
