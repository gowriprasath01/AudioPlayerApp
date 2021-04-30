package com.example.audioplayer;

public class AudioModel {
  private String Audio_name;
  private String Audio_artist;
  private String Audio_duration;
  private String Audio_path;

    public AudioModel(String audio_name, String audio_artist, String audio_duration, String audio_path) {
        Audio_name = audio_name;
        Audio_artist = audio_artist;
        Audio_duration = audio_duration;
        Audio_path = audio_path;
    }

    public AudioModel() {
    }

    public String getAudio_name() {
        return Audio_name;
    }

    public void setAudio_name(String audio_name) {
        Audio_name = audio_name;
    }

    public String getAudio_artist() {
        return Audio_artist;
    }

    public void setAudio_artist(String audio_artist) {
        Audio_artist = audio_artist;
    }

    public String getAudio_duration() {
        return Audio_duration;
    }

    public void setAudio_duration(String audio_duration) {
        Audio_duration = audio_duration;
    }

    public String getAudio_path() {
        return Audio_path;
    }

    public void setAudio_path(String audio_path) {
        Audio_path = audio_path;
    }
}


