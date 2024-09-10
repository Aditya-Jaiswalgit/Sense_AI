package com.example.senseai;

public class Course {
    private String title;
    private String description;
    private int videoResource; // Resource ID for video
    private String content; // Text content for the course

    public Course(String title, String description, int videoResource, String content) {
        this.title = title;
        this.description = description;
        this.videoResource = videoResource;
        this.content = content;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getVideoResource() { return videoResource; }
    public String getContent() { return content; }
}
