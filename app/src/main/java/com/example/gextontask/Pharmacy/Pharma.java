package com.example.gextontask.Pharmacy;

public class Pharma {

    String Medicine_id;
    String Medicine_name;
    String Medicine_formula;
    String Medicine_company;

    public Pharma(String medicine_id, String medicine_name, String medicine_formula, String medicine_company) {
        Medicine_id = medicine_id;
        Medicine_name = medicine_name;
        Medicine_formula = medicine_formula;
        Medicine_company = medicine_company;
    }

    public Pharma() {
    }

    public String getMedicine_id() {
        return Medicine_id;
    }

    public void setMedicine_id(String medicine_id) {
        Medicine_id = medicine_id;
    }

    public String getMedicine_name() {
        return Medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        Medicine_name = medicine_name;
    }

    public String getMedicine_formula() {
        return Medicine_formula;
    }

    public void setMedicine_formula(String medicine_formula) {
        Medicine_formula = medicine_formula;
    }

    public String getMedicine_company() {
        return Medicine_company;
    }

    public void setMedicine_company(String medicine_company) {
        Medicine_company = medicine_company;
    }
}
