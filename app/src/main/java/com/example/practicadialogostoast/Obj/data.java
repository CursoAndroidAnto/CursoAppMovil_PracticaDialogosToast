package com.example.practicadialogostoast.Obj;

import java.io.Serializable;

public class data implements Serializable{
    private String name;
    private String selectedRequest;
    private String selectedOffice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelectedRequest() {
        return selectedRequest;
    }

    public void setSelectedRequest(String selectedRequest) {
        this.selectedRequest = selectedRequest;
    }

    public String getSelectedOffice() {
        return selectedOffice;
    }

    public void setSelectedOffice(String selectedOffice) {
        this.selectedOffice = selectedOffice;
    }

    public data(String name, String selectedRequest, String selectedOffice) {
        this.name = name;
        this.selectedRequest = selectedRequest;
        this.selectedOffice = selectedOffice;
    }

    @Override
    public String toString() {
        return "data{" +
                "name='" + name + '\'' +
                ", selectedRequest='" + selectedRequest + '\'' +
                ", selectedOffice='" + selectedOffice + '\'' +
                '}';
    }
}
