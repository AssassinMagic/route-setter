package com.backend.models;
import jakarta.persistence.*;
import java.util.Set;

import org.hibernate.annotations.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "route")
public class Route {
    // Purpose: Represents a route in the database, storing information such as the image URL and route markings.
    // Interactions: Interacts with RouteRepository to persist and retrieve routes.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    private String imageUrl;

    // JSON or string representing the coordinates of holds on the image
    @Lob
    private String routeData;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createBy;
    private LocalDateTime createdAt;
    private Boolean isActive = true;
    private String grade;
    private String gradeConsensus;

    private String routeType; // boulder, lead

    private String location;
    private Double routeLength;

    @ElementCollection
    private List<String> tags = new ArrayList<>();

    private Integer likesCount = 0;
    private Integer dislikesCount = 0;
    private Integer commentCount = 0;
    private Integer favoritesCount = 0;
    private Integer viewsCount = 0;

    // consider if the 3 lists below are nessasary
    @ElementCollection
    private List<Long> likesList = new ArrayList<>();

    @ElementCollection
    private List<Long> dislikeList = new ArrayList<>();

    @ElementCollection
    private List<Long> favoriteList = new ArrayList<>();

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    // make something to store how the route is marked or descriped



    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * @return String return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl the imageUrl to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return String return the routeData
     */
    public String getRouteData() {
        return routeData;
    }

    /**
     * @param routeData the routeData to set
     */
    public void setRouteData(String routeData) {
        this.routeData = routeData;
    }

    /**
     * @return User return the createBy
     */
    public User getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy the createBy to set
     */
    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    /**
     * @return LocalDateTime return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return Boolean return the isActive
     */
    public Boolean isIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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
     * @return String return the gradeConsensus
     */
    public String getGradeConsensus() {
        return gradeConsensus;
    }

    /**
     * @param gradeConsensus the gradeConsensus to set
     */
    public void setGradeConsensus(String gradeConsensus) {
        this.gradeConsensus = gradeConsensus;
    }

    /**
     * @return String return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return Double return the routeLength
     */
    public Double getRouteLength() {
        return routeLength;
    }

    /**
     * @param routeLength the routeLength to set
     */
    public void setRouteLength(Double routeLength) {
        this.routeLength = routeLength;
    }

    /**
     * @return List<String> return the tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * @return Integer return the likesCount
     */
    public Integer getLikesCount() {
        return likesCount;
    }

    /**
     * @param likesCount the likesCount to set
     */
    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    /**
     * @return Integer return the dislikesCount
     */
    public Integer getDislikesCount() {
        return dislikesCount;
    }

    /**
     * @param dislikesCount the dislikesCount to set
     */
    public void setDislikesCount(Integer dislikesCount) {
        this.dislikesCount = dislikesCount;
    }

    /**
     * @return Integer return the commentCount
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * @param commentCount the commentCount to set
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * @return Integer return the favoritesCount
     */
    public Integer getFavoritesCount() {
        return favoritesCount;
    }

    /**
     * @param favoritesCount the favoritesCount to set
     */
    public void setFavoritesCount(Integer favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    /**
     * @return Integer return the viewsCount
     */
    public Integer getViewsCount() {
        return viewsCount;
    }

    /**
     * @param viewsCount the viewsCount to set
     */
    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    /**
     * @return List<Long> return the likesList
     */
    public List<Long> getLikesList() {
        return likesList;
    }

    /**
     * @param likesList the likesList to set
     */
    public void setLikesList(List<Long> likesList) {
        this.likesList = likesList;
    }

    /**
     * @return List<Long> return the dislikeList
     */
    public List<Long> getDislikeList() {
        return dislikeList;
    }

    /**
     * @param dislikeList the dislikeList to set
     */
    public void setDislikeList(List<Long> dislikeList) {
        this.dislikeList = dislikeList;
    }

    /**
     * @return List<Long> return the favoriteList
     */
    public List<Long> getFavoriteList() {
        return favoriteList;
    }

    /**
     * @param favoriteList the favoriteList to set
     */
    public void setFavoriteList(List<Long> favoriteList) {
        this.favoriteList = favoriteList;
    }

    /**
     * @return List<Comment> return the comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
