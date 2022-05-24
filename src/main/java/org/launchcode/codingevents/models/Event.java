package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message="Location is required")
    @NotNull(message="Location is required")
    private String location;

    @AssertTrue(message = "This event must have attendees register.")
    private boolean shouldRegister = true;

    @NotNull(message = "At least one attendee is required.")
    @Min(value=1, message = "At least one attendee is required.")
    private Integer numOfAttendees;


    @NotNull(message = "Must have # of food courses between 1 and 3")
    @Min(value = 1, message = "Must have # of food courses between 1 and 3")
    @Max(value = 3, message = "Must have # of food courses between 1 and 3")
    private Integer numOfFoodCourses;


    public Event(String name, String description, String contactEmail, String location, Integer numOfAttendees) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.numOfAttendees = numOfAttendees;
        this.id = nextId;
        nextId++;
    }

    public Event(){}

    public boolean isShouldRegister() {
        return shouldRegister;
    }

    public void setShouldRegister(boolean shouldRegister) {
        this.shouldRegister = shouldRegister;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Integer getNumOfAttendees() {
        return numOfAttendees;
    }

    public void setNumOfAttendees(Integer numOfAttendees) {
        this.numOfAttendees = numOfAttendees;
    }

    public Integer getNumOfFoodCourses() {
        return numOfFoodCourses;
    }

    public void setNumOfFoodCourses(Integer numOfFoodCourses) {
        this.numOfFoodCourses = numOfFoodCourses;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
