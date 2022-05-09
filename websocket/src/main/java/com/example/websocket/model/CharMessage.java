package com.example.websocket.model;

public class CharMessage {
    private String roomId;
    private String sender;
    private String message;
    private String time;

    @Override
    public String toString() {
        return "CharMessage{" +
                "roomId='" + roomId + '\'' +
                ", sender='" + sender + '\'' +
                ", message='" + message + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public CharMessage(String roomId, String sender, String message, String time) {
        this.roomId = roomId;
        this.sender = sender;
        this.message = message;
        this.time = time;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
