package ru.job4j.design.dip;

public class Player {
    InternetVK internetVK;

    public Player() {
        this.internetVK = new InternetVK();
    }

    public void play() {
        internetVK.getApi();
    }


}

class InternetVK {
    public void getApi() {
        System.out.println("player plays music from VK music");
    }
}

class InternetSpotify {
    public void getApi() {
        System.out.println("player plays music from Spotify");
    }
}
