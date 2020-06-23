package test.Models;

import java.sql.Timestamp;

//设备信息类
public class SensorInfo {

    private  String device;
    private  String tagid;
    private  String tlvtype;
    private  String tagtype;
    private  int antenna;
    private  int intensity;
    private  int entry;
    private  int staying;
    private  int alarm;

    private Timestamp  time;
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }

    public String getTlvtype() {
        return tlvtype;
    }

    public void setTlvtype(String tlvtype) {
        this.tlvtype = tlvtype;
    }

    public String getTagtype() {
        return tagtype;
    }

    public void setTagtype(String tagtype) {
        this.tagtype = tagtype;
    }

    public int getAntenna() {
        return antenna;
    }

    public void setAntenna(int antenna) {
        this.antenna = antenna;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public int getEntry() {
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    public int getStaying() {
        return staying;
    }

    public void setStaying(int staying) {
        this.staying = staying;
    }

    public int getAlarm() {
        return alarm;
    }

    public void setAlarm(int alarm) {
        this.alarm = alarm;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


}
