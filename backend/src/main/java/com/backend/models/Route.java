package com.backend.models;

public class Route {
    // Purpose: Represents a route in the database, storing information such as the image URL and route markings.
    // Interactions: Interacts with RouteRepository to persist and retrieve routes.

    private String name;
    
    private String grade;

    private User createdby;

    private String description;

    private String imageURL;

    // make something to store how the route is marked or descriped

    

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return User return the createdby
     */
    public User getCreatedby() {
        return createdby;
    }

    /**
     * @param createdby the createdby to set
     */
    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the imageURL
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * @param imageURL the imageURL to set
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}
