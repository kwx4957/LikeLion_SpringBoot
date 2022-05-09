package com.example.week9.model;

public class JobRequest {
    private String jobId;

    public JobRequest(String jobId) {
        this.jobId = jobId;
    }

    public JobRequest() {
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "JobRequest{" +
                "jobId='" + jobId + '\'' +
                '}';
    }
}
