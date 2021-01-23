package com.moten.DemoA.type;

public class Subway {
    public String subwayTitle;      // 地铁路线名
    public String the_subway;       // 地铁具体路线
    public String subway_next;      // 下一站
    public String subway_time;      // 到达时间

    public Subway(String subwayTitle,String the_subway,String subway_next,String subway_time){
        this.subwayTitle=subwayTitle;
        this.the_subway=the_subway;
        this.subway_next=subway_next;
        this.subway_time=subway_time;
    };

    public String getSubwayTitle() {
        return subwayTitle;
    }

    public void setSubwayTitle(String subwayTitle) {
        this.subwayTitle = subwayTitle;
    }

    public String getThe_subway() {
        return the_subway;
    }

    public void setThe_subway(String the_subway) {
        this.the_subway = the_subway;
    }

    public String getSubway_next() {
        return subway_next;
    }

    public void setSubway_next(String subway_next) {
        this.subway_next = subway_next;
    }

    public String getSubway_time() {
        return subway_time;
    }

    public void setSubway_time(String subway_time) {
        this.subway_time = subway_time;
    }
}
