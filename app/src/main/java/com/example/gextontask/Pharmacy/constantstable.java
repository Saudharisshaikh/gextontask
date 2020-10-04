package com.example.gextontask.Pharmacy;

public class constantstable {

    public static String Table_name="Pharmacytable";
    public static String medicineId="medicineId";
    public static String medicinename="medicinename";
    public static String medicineformula="medicineformula";
    public static String medicinecompany="medicinecompany";

    public static String createTable="CREATE TABLE IF NOT EXISTS "+Table_name+" ("+medicineId+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            medicinename+" TEXT ,"+medicineformula+" TEXT ,"+medicinecompany+" TEXT)";

}
