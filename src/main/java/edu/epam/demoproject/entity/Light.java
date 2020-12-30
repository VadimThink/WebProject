package edu.epam.demoproject.entity;

public class Light {

    boolean isOn;

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        this.isOn = on;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Light{");
        sb.append("isOn=").append(isOn);
        sb.append('}');
        return sb.toString();
    }

}
