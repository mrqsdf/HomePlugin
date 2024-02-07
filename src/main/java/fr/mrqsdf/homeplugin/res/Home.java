package fr.mrqsdf.homeplugin.res;

import java.io.Serializable;

public class Home implements Serializable {

    public double x;
    public double y;
    public double z;
    public String world;
    public String name;
    public String owner;

    public Home(String name, double x, double y, double z, String world, String owner){
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.world = world;
        this.owner = owner;
    }

}
