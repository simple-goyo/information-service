package com.fdse.is.sys.sensor.model;

/**
 * @ClassName Heater
 * @Description TODO
 * @Author LiuJing
 * @Date 2018/9/149:54
 * @Version 1.0
 **/
public class Heater {

    private int id;
    private int temperature;
    private boolean isEnough;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isEnough() {
        return isEnough;
    }

    public void setEnough(boolean enough) {
        isEnough = enough;
    }
}
