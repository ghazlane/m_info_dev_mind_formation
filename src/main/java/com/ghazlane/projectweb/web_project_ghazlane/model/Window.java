package com.ghazlane.projectweb.web_project_ghazlane.model;

import javax.persistence.*;

// Mark this class as a JPA entity
// You must give a different name for your table. H2 can’t call a table Window because it is a reserved word. So call it RWINDOW

@Entity
@Table(name = "RWINDOW")
public class Window {
    // Declare this field as the table ID. This ID must to be auto generated
    @Id
    @GeneratedValue
    private Long id;

    // This field must be not nullable
    @Column(nullable = false)
    private String name;

    // WindowStatus is also not nullable, and this field is an enumeration (you have to use @Enumerated). You have to add these informations
    @Column(nullable = false)
    @Enumerated
    private WindowStatus windowStatus;


    @ManyToOne
    private Room room;

    public Window() {
    }

    public Window(Room room) {
        this.room = room;
    }

    public Window(String name, WindowStatus status) {
        this.windowStatus = status;
        this.name = name;
    }



    public Window(Room room,String name, WindowStatus status) {
        this.windowStatus = status;
        this.name = name;
        this.room = room;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


}