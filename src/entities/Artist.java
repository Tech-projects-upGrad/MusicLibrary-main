package entities;

import java.util.*;

public class Artist {
    public static int counter = 1;
    private int artistId;
    private String firstName;
    private String lastName;
    private List<Song> releasedSongs;
    private Date registrationTimestamp;

    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationTimestamp = new Date();
        this.artistId = counter;
        counter++;

        releasedSongs = new ArrayList<>();
    }

    public int getArtistId() {
        return artistId;
    }

    public String getName() {
        return firstName+" "+lastName;
    }

    public Date getRegistrationTimestamp() {
        return registrationTimestamp;
    }

    public void releaseSong(Song song){
        releasedSongs.add(song);
    }
}
