package application;

import entities.Artist;
import entities.Song;
import entities.User;

import java.util.*;

public class MusicLibrary {
    private Map<Integer, Song> songs = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Artist> artists = new HashMap<>();

    // Stores how many times a song has been played
    private Map<Integer, Integer> songPlayCounts = new HashMap<>();

    // store data for every user, how many times they have listened to every song
    private Map<Integer, Map<Integer, Integer>> userPlayHistory = new HashMap<>();

    /*
        Play a song for a user
     */
    public void playSong(int songId, int userId) throws Exception {
        if(!users.containsKey(userId)){
            throw new Exception("User is invalid!");
        }
        if(!songs.containsKey(songId)){
            throw new Exception("Invalid song!");
        }
        int songPlayCount = songPlayCounts.containsKey(songId) ? songPlayCounts.get(songId) : 0;
        songPlayCounts.put(songId, songPlayCount+1);
        Song song = songs.get(songId);
        User user = users.get(userId);
        song.markPlayed();

        System.out.println(user.getName() + " is listening to the song : "+song.getTitle()+ ", sung by "+artists.get(song.getArtistId()).getName());

        Map<Integer, Integer> userSongPlayCount = userPlayHistory.get(userId);
        int currentUserSongPlayCount = 0;
        if(null != userSongPlayCount){
            currentUserSongPlayCount = userSongPlayCount.containsKey(songId) ? userSongPlayCount.get(songId) : 0;
        }
        else{
            userSongPlayCount = new HashMap<>();
        }
        userSongPlayCount.put(songId, currentUserSongPlayCount + 1);
        userPlayHistory.put(userId, userSongPlayCount);
    }

    private List<Map.Entry<Integer, Integer>> getTopNByValue(Map<Integer, Integer> map, int n){

        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer> >(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return o1.getValue() - o2.getValue();
            }
        });

        return list.subList(0, Math.min(n, list.size()));
    }
    /*
        Print top 10 songs for a user
     */
    public void getTop10SongsForUser(int userId) throws Exception {
        if(!users.containsKey(userId)){
            throw new Exception("User is invalid!");
        }
        Map<Integer, Integer> userSongPlayCountMap = userPlayHistory.get(userId);

        List<Map.Entry<Integer, Integer>> usersTop10Songs = getTopNByValue(userSongPlayCountMap, 10);
        usersTop10Songs.forEach(entry -> {
            System.out.println("Song: "+songs.get(entry.getKey()).getTitle()+
                    ", played : "+ entry.getValue() +" times.");
        } );
    }

    /*
        Get the top 10 songs across all users
    */
    public void getTop10Songs(){
        List<Map.Entry<Integer, Integer>> top10Songs = getTopNByValue(songPlayCounts, 10);
        top10Songs.forEach(entry -> {
            System.out.println("Song: "+songs.get(entry.getKey()).getTitle()+
                    ", played : "+ entry.getValue() +" times.");
        } );
    }

    /*
        Get all songs by an artist
     */
    public void getSongsByArtist(int artistId) throws Exception {
        if(!artists.containsKey(artistId)){
            throw new Exception("Artist is invalid!");
        }

        songs.values().forEach(song -> {
            if(song.getArtistId() == artistId){
                System.out.println(song.getTitle());
            }
        });

    }

    /*
        Register an user
     */
    public User registerUser(String firstName, String lastName, String email, String phone,
                             String city, String locality,String state, int pinCode){
        User newUser = new User(firstName, lastName,
                new User.Address(city, locality, state, pinCode),
                new User.Contact(email, phone));
        users.put(newUser.getUserId(), newUser);
        return newUser;
    }

    /*
        Register an artist
     */
    public void registerArtist(String firstName, String lastName){
        Artist artist = new Artist(firstName, lastName);
        artists.put(artist.getArtistId(), artist);
    }

    /*
        Add a song to the Music Library
     */
    public void addSong(int artistId, String title, String genre, int releaseYear, String language) throws Exception {
        if(!artists.containsKey(artistId)){
            throw new Exception("Artist is invalid!");
        }
        Song song = new Song(artistId, title, genre, releaseYear, language);
        songs.put(song.getSongId(), song);
        artists.get(artistId).releaseSong(song);
    }

    public void printArtists(){
        artists.forEach((artistId, artist) ->{
            System.out.println(artistId + ". "+artist.getName());
        });
    }

}
