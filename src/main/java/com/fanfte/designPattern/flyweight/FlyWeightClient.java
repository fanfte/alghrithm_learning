package com.fanfte.designPattern.flyweight;

public class FlyWeightClient {
    public static void main(String[] args) {
        ReportManagerFactory f = new ReportManagerFactory();
        IReportManager emp1 = f.getEmployeeReportManager("emp1");
        System.out.println(emp1.createReport());
        IReportManager financial1 = f.getFinancialReportManager("financial1");
        System.out.println(financial1.createReport());
    }
}
