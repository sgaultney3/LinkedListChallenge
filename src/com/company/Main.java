package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        // write your explanation here

        Album album = new Album("Special Mix", "Sam");
        album.addSong("Highway to Hell", 5.6);
        album.addSong("Bohemian Rhapsody", 7.8);
        album.addSong("Carry On My Wayward Son", 4.3);
        album.addSong("We are the Champions", 3.2);
        album.addSong("Bridge over Troubled Water", 4.5);
        album.addSong("Halo Theme Song", 60.56);
        album.addSong("Serenade", 15.46);
        albums.add(album);

        album = new Album("Mix Two", "Deb");  //this is a NEW album, not overwriting the previous
        album.addSong("Peggy Lee", 115.6);
        album.addSong("Swing Jazz", 13.56);
        album.addSong("Lindy Hop Song", 3.5);
        album.addSong("Athens stuff", 34.6);
        album.addSong("Forver and always", 7.53);
        album.addSong("Surfs UP", 1.34);
        album.addSong("Moana", 60.45);
        album.addSong("Pop", 4.67);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();   //this would be list and array list or vector* see below
        albums.get(0).addToPlayList("Highway to Hell", playList);
        albums.get(0).addToPlayList(1, playList);
        albums.get(0).addToPlayList("ChaCha", playList); //DNE
        albums.get(0).addToPlayList(7, playList);
        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(4, playList);
        albums.get(1).addToPlayList(18, playList); //DNE

        play(playList);


    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now Playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list.");
                        }
                    }

                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0) {
                        listIterator.remove(); //cant call twice because of how linked
                                               // list works without a .previous or .next
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in playlist\n" +
                "5 - print a list of actions\n" +
                "6 - delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> interator = playList.iterator();
        System.out.println("=========================");
        while (interator.hasNext()) {
            System.out.println(interator.next());
        }
        System.out.println("=========================");
    }
}

//LinkedList is only one of the ways to deal with data structures.

//Thanks to Javas extensive use of Interfaces, all the LinkedList structures could be changed to List and still work
