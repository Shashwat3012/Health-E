package com.example.healthe.data.request;

public class UpdateDoctorRequest {
    private String requestId;
    private String status;

    public UpdateDoctorRequest(String requestId, String status) {
        this.requestId = requestId;
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getStatus() {
        return status;
    }
}
