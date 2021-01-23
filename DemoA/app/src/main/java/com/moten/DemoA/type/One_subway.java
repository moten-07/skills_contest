package com.moten.DemoA.type;

public class One_subway {
    public int lastimg;
    public int nextimg;
    public int thisimg;
    public String thisName;

    public One_subway(
            int lastimg,
            int nextimg,
            int thisimg,
            String thisName){
        this.lastimg=lastimg;
        this.nextimg=nextimg;
        this.thisimg=thisimg;
        this.thisName=thisName;
    }

    public int getLastimg() {
        return lastimg;
    }

    public void setLastimg(int lastimg) {
        this.lastimg = lastimg;
    }

    public int getNextimg() {
        return nextimg;
    }

    public void setNextimg(int nextimg) {
        this.nextimg = nextimg;
    }

    public int getThisimg() {
        return thisimg;
    }

    public void setThisimg(int thisimg) {
        this.thisimg = thisimg;
    }

    public String getThisName() {
        return thisName;
    }

    public void setThisName(String thisName) {
        this.thisName = thisName;
    }
}
