package com.fanfte.designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {

    private Map<String, IReportManager> financialMap = new HashMap<String, IReportManager>();
    private Map<String, IReportManager> employeeMap = new HashMap<String, IReportManager>();

    public IReportManager getFinancialReportManager(String id) {
        IReportManager iReportManager = financialMap.get(id);
        if(iReportManager == null) {
            iReportManager = new FinancialReportManager(id);
            financialMap.put(id, iReportManager);
        }
        return iReportManager;
    }

    public IReportManager getEmployeeReportManager(String id) {
        IReportManager iReportManager = employeeMap.get(id);
        if(iReportManager == null) {
            iReportManager = new EmployeeReportManager(id);
            employeeMap.put(id, iReportManager);
        }
        return iReportManager;
    }
}
