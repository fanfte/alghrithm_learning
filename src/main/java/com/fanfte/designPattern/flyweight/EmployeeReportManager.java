package com.fanfte.designPattern.flyweight;

public class EmployeeReportManager implements IReportManager {

    private String id = null;

    public EmployeeReportManager(String id) {
        this.id = id;
    }

    @Override
    public String createReport() {
        return "employee report manager " + id;
    }
}
