package com.company;

/**
 * Created by Sam on 3/26/2017.
 */
public class Song {

    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override       //Overrides the typical output of toString(), which is the package@numberReferencingMemoryLocation
    public String toString() {
        return this.title + ": " + this.duration;
    }
}
