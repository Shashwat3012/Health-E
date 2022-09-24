package com.example.healthe.data.request;

public class DoctorRequest {

    private final int requestId;

    private final int UUID;

    private final String reason;

    private final int doctorId;

    private final String date;

    private final String status;


    public DoctorRequest(int requestId, int UUID, String reason, int doctorId, String date, String status) {
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

    public int getUUID() {
        return UUID;
    }

    public String getReason() {
        return reason;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
