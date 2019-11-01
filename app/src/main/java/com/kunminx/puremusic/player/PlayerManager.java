/*
 * Copyright 2018-2019 KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kunminx.puremusic.player;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.kunminx.player.IPlayController;
import com.kunminx.player.PlayerController;
import com.kunminx.player.PlayingInfoManager;
import com.kunminx.player.dto.ChangeMusic;
import com.kunminx.player.dto.PlayingMusic;
import com.kunminx.puremusic.data.bean.TestAlbum;

import java.util.List;

/**
 * Create by KunMinX at 19/10/31
 */
public class PlayerManager implements IPlayController<TestAlbum, TestAlbum.TestMusic> {

    private static PlayerManager sManager = new PlayerManager();

    private PlayerController<TestAlbum, TestAlbum.TestMusic> mController;

    private Context mContext;

    private PlayerManager() {
        mController = new PlayerController<>();
    }

    public static PlayerManager getInstance() {
        return sManager;
    }

    @Override
    public void init(Context context) {
        mController.init(context);
        mContext = context.getApplicationContext();
    }

    @Override
    public void resetAlbum(TestAlbum musicAlbum, int playIndex) {
        mController.resetAlbum(mContext, musicAlbum, playIndex);
    }

    @Override
    public void playAudio() {
        mController.playAudio(mContext);
    }

    @Override
    public void playAudio(int albumIndex) {
        mController.playAudio(mContext, albumIndex);
    }

    @Override
    public void playNext() {
        mController.playNext(mContext);
    }

    @Override
    public void playPrevious() {
        mController.playPrevious(mContext);
    }

    @Override
    public void playAgain() {
        mController.playAgain(mContext);
    }

    @Override
    public void pauseAudio() {
        mController.pauseAudio();
    }

    @Override
    public void resumeAudio() {
        mController.resumeAudio();
    }

    @Override
    public void clear() {
        mController.clear(mContext);
    }

    @Override
    public void changeMode() {
        mController.changeMode();
    }

    @Override
    public boolean isPlaying() {
        return mController.isPlaying();
    }

    @Override
    public boolean isPaused() {
        return mController.isPaused();
    }

    @Override
    public boolean isInited() {
        return mController.isInited();
    }

    @Override
    public void requestLastPlayingInfo() {
        mController.requestLastPlayingInfo();
    }

    @Override
    public void setSeek(int progress) {
        mController.setSeek(progress);
    }

    @Override
    public String getTrackTime(int progress) {
        return mController.getTrackTime(progress);
    }

    @Override
    public TestAlbum getAlbum() {
        return mController.getAlbum();
    }

    @Override
    public List<TestAlbum.TestMusic> getAlbumMusics() {
        return mController.getAlbumMusics();
    }

    @Override
    public void setChangingPlayingMusic(boolean changingPlayingMusic) {
        mController.setChangingPlayingMusic(mContext, changingPlayingMusic);
    }

    @Override
    public int getAlbumIndex() {
        return mController.getAlbumIndex();
    }

    public MutableLiveData<ChangeMusic> getChangeMusicLiveData() {
        return mController.getChangeMusicLiveData();
    }

    public MutableLiveData<PlayingMusic> getPlayingMusicLiveData() {
        return mController.getPlayingMusicLiveData();
    }

    public MutableLiveData<Boolean> getPauseLiveData() {
        return mController.getPauseLiveData();
    }

    @Override
    public MutableLiveData<Boolean> getStartService() {
        return mController.getStartForegroundService();
    }

    @Override
    public MutableLiveData<Enum> getPlayModeLiveData() {
        return mController.getPlayModeLiveData();
    }

    @Override
    public Enum getRepeatMode() {
        return mController.getRepeatMode();
    }

    @Override
    public void togglePlay() {
        mController.togglePlay(mContext);
    }

    @Override
    public TestAlbum.TestMusic getCurrentPlayingMusic() {
        return mController.getCurrentPlayingMusic();
    }
}