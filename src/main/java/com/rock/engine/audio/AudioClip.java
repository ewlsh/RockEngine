/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rock.engine.audio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author evan
 */
public class AudioClip {

    private AudioInputStream audioInputStream;
    private Clip clip;

    public AudioClip(InputStream inputStream) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        this.audioInputStream = AudioSystem.getAudioInputStream(inputStream);
        this.clip = AudioSystem.getClip();
        this.clip.open(audioInputStream);
        this.clip.start();
    }

    public AudioClip(File file) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        this.audioInputStream = AudioSystem.getAudioInputStream(file);
        this.clip = AudioSystem.getClip();
        this.clip.open(audioInputStream);
        this.clip.start();
    }

    public void play() {
        this.clip.start();
    }

    public boolean isPlaying() {
        return this.clip.isActive();
    }

    public void setFrame(int i) {
        this.clip.setFramePosition(i);
    }

    public int getPosition() {
        return this.clip.getFramePosition();
    }

    public int getLength() {
        return this.clip.getFrameLength();
    }

    public void stop() {
        this.clip.stop();
    }
}
