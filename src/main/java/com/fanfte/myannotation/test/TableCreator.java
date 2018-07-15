package com.fanfte.myannotation.test;

import com.fanfte.myannotation.annotation.Constraints;
import com.fanfte.myannotation.annotation.DBTable;
import com.fanfte.myannotation.annotation.SQLInteger;
import com.fanfte.myannotation.annotation.SQLString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/5/23
 **/
public class TableCreator {

    public static String generateCreateSqlCommand(String[] classes) throws ClassNotFoundException {
        StringBuffer createCommand = null;
        for(String s : classes) {
            Class<?> aClass = Class.forName(s);
//            aClass.get
            DBTable dbTable = aClass.getAnnotation(DBTable.class);
            if(dbTable == null) {
                System.out.println("No DBTable annotation on this class...");
                continue;
            }
            String tableName = dbTable.name();
            if(tableName.length() < 1) {
                tableName = aClass.getSimpleName().toLowerCase();
            }
            List<String> columnDefs = new ArrayList<>();
            Field[] declaredFields = aClass.getDeclaredFields();
            createCommand = new StringBuffer("create table `" + tableName + "` ( \n");
            for(Field f : declaredFields) {
                String columnName = null;
                Annotation[] anns = f.getDeclaredAnnotations();
                if(anns.length < 1) {
                    continue;
                }
                if(anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if(sInt.name().length() < 1) {
                        columnName = f.getName().toLowerCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add("`" + columnName + "` INT"  + getConstraints(sInt.constraints()));
                }
                if(anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    if(sString.name().length() < 1) {
                        columnName = f.getName().toLowerCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add("`" + columnName + "` VARCHAR(" + sString.value() + ")"
                        + getConstraints(sString.constraints()));
                }
//                StringBuilder createCommand = new StringBuilder("create table `" + tableName + "` ( \n");
            }
            for(String column : columnDefs) {
                createCommand.append("    " + column + ",\n");
            }
        }
        return createCommand.substring(0, createCommand.length() - 2) + "\n);";
    }

    private static String getConstraints(Constraints constraints) {
        String result = "";
        if(!constraints.allowNull()) {
            result += "NOT NULL";
        }
        if(constraints.primaryKey()) {
            result += " PRIMARY KEY ";
        }
        if(constraints.unique()) {
            result += " UNIQUE ";
        }
        return result;
    }

    public static void main(String[] args) {
        String[] classes = new String[] {"com.fanfte.myannotation.test.Member"};
        try {
            String sqlCommand = generateCreateSqlCommand(classes);
            System.out.println(sqlCommand);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
