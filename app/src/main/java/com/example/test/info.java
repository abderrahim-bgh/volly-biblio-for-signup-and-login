package com.example.test;

public class info {
    String titel1, titel2;

    public info(String titel1, String titel2) {
        this.titel1 = titel1;
        this.titel2 = titel2;
    }
  public info(){}
    public String getTitel1() {
        return titel1;
    }

    public void setTitel1(String titel1) {
        this.titel1 = titel1;
    }

    public String getTitel2() {
        return titel2;
    }

    public void setTitel2(String titel2) {
        this.titel2 = titel2;
    }
}
