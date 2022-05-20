package com.example.faceYourPace.controller;

import com.example.faceYourPace.domain.member.Member;
import com.example.faceYourPace.domain.music.Music;
import com.example.faceYourPace.domain.music.MusicForm;
import com.example.faceYourPace.repository.MusicRepository;
import com.example.faceYourPace.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MusicController {

    private final MusicService musicService;
    private final MusicRepository musicRepository;

    @GetMapping("/api/music/add")
    public String createForm(Model model) {
        model.addAttribute("form", new MusicForm());
        return "music 추가 form";
    }

    @PostMapping("/api/music/add")
    public String create(MusicForm form) { // music 추가

        Music music = new Music();
        music.setMusicName(form.getMusicName());
        music.setMusicStart(form.getMusicStart());
        music.setMusicEnd(form.getMusicEnd());
        music.setMusicRepeat(form.getMusicRepeat());
        music.setCreateDate(LocalDateTime.now());
        music.setMusicImg_url(form.getMusicImg_url());
        musicService.saveMusic(music);
        return "true";
    }
/*
    @GetMapping("/api/music/list")
    public String list(Model model) {
        List<Music> items = musicService.findMusics();
        model.addAttribute("items", items);
        return "음악리스트 출력";
    }

 */
    @GetMapping("/api/music/list")
    List<Music> getAll() { // 음악리스트 출력
        return musicRepository.findAll();
    }

    @GetMapping("api/music/{musicId}/edit")
    public String updateMusicForm(@PathVariable("musicName") Long musicId, Model model) {
        Music music = (Music) musicService.findOne(musicId);

        MusicForm form = new MusicForm();
        form.setId(music.getId());
        form.setMusicName(music.getMusicName());
        form.setMusicStart(music.getMusicStart());
        form.setMusicEnd(music.getMusicEnd());
        form.setMusicRepeat(music.getMusicRepeat());
        form.setMusicImg_url(music.getMusicImg_url());

        model.addAttribute("form", form);
        return "음악 설정 update";
    }

    @PostMapping("api/music/{musicId}/edit")
    public String updateMusic(@PathVariable Long musicId, @ModelAttribute("form") MusicForm form) {

        musicService.updateMusic(musicId, form.getMusicStart(), form.getMusicEnd(), form.getMusicRepeat());
        return "음악 설정 update";
    }
}





