package com.fdse.is.sys.sensor.service;

public interface HeaterService {
    boolean hotWater(int id);
    boolean warmWater(int id);
    boolean enoughWater(int id);
}
