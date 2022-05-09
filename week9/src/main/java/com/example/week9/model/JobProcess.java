package com.example.week9.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Job")
public class JobProcess {
    private String id;
    private int status;
    private String msg;
    private String result;

    public JobProcess() {
    }

    public JobProcess(String id, int status, String msg, String result) {
        this.id = id;
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JobProcess{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
