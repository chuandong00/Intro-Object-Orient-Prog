import java.util.Scanner;

public class Playlist {
    public static void addPlaylistInfo(Scanner scan) {
        int numSongs;
        String playlistName = "";
        System.out.print("Enter number of songs in playlist: ");
        numSongs = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter a playlist name: ");
        playlistName += scan.nextLine();
        System.out.println("Playlist created successfully. Here are the details: ");
        System.out.println("Number of Songs: " + numSongs);
        System.out.println("Name: " + playlistName);
    }
    public static int[] genreTally(String[] genreArray, String[] genres) {
        System.out.println("The following types of genres are in your playlist:");
        int[] result = new int[genres.length];
        for (int i = 0; i < genres.length; i++) {
            for (int j = 0; j < genreArray.length; j++) {
                if (genreArray[j].equals(genres[i])) {
                    result[i] += 1;
                }
            }
            System.out.println(genres[i] + " " + result[i]);
        }
        return result;
    }
    public static void playlistScores(String[] playlist1, String[] playlist2, String[] genres) {
        int[] result1 = genreTally(playlist1, genres);
        int[] result2 = genreTally(playlist2, genres);
        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < genres.length; i++) {
            score1 += result1[i] * i;
            score2 += result2[i] * i;
        }
        if (score1 > score2) {
            System.out.println("The first playlist is likely to have more listeners than the second.");
        } else if (score1 < score2) {
            System.out.println("The second playlist is likely to have more listeners than the first.");
        } else {
            System.out.println("The two playlists are predicted to perform equally well.");
        }
    }
    public static void main(String[] args) {
        String[] genres = {"Rap", "Pop", "Classical", "Hip Hop", "Rock", "Lo Fi"};
        String[] playlist1 = {"Rap", "Rock", "Rock", "Pop", "Pop", "Hip Hop", "Hip Hop"};
        String[] playlist2 = {"Pop", "Classical", "Classical", "Hip Hop", "Rock", "Classical", "Rap"};
        Scanner scan = new Scanner(System.in);
        addPlaylistInfo(scan);
        addPlaylistInfo(scan);
        genreTally(playlist1, genres);
        genreTally(playlist2, genres);
        playlistScores(playlist1, playlist2, genres);
    }
}
