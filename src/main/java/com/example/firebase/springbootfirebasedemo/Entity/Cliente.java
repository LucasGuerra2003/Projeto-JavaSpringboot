package com.example.firebase.springbootfirebasedemo.Entity;

public class Cliente {
    private String ID;
    private String CPF;
    private String CEP;
    private String Tip;
    private String Valor;
    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }



    public String getTip() {
        return Tip;
    }

    public void setTip(String tip) {
        Tip = tip;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    private String End;

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

}
