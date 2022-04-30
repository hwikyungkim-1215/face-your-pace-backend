package com.example.faceYourPace.web.music;

import com.example.faceYourPace.domain.music.Music;
import com.example.faceYourPace.domain.music.Play;
import com.example.faceYourPace.domain.music.PlayService;
import com.example.faceYourPace.domain.music.MusicForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlayController {
    private final PlayService playService;

    @GetMapping("/api/music/add")
    public String createForm(Model model) {
        model.addAttribute("form", new MusicForm());
        return "items/createItemForm";
    }

    @PostMapping("/api/music/add")
    public String create(MusicForm form) { // 음악 추가

        Music music = new Music();
        music.setName(form.getName());
        music.setMusicName((form.getMusicName()));
        music.setMusicStart(form.getMusicStart());
        music.setMusicEnd(form.getMusicEnd());
        music.setMusicRepeat(form.getMusicRepeat());
        //music.setCreateDate(form.getCreateDate());

        playService.savePlay(music);
        return "redirect:/";
    }

    @GetMapping("/api/music/playlist")
    public String list(Model model) {
        List<Play> plays = playService.findPlays();
        model.addAttribute("plays", plays);
        return "items/itemList";
    }

    @GetMapping("items/{itemId}/edit")
    public String updateItemForm(@PathVariable("playId") Long playId, Model model) {
        Music play = (Music) playService.findOne(playId);

        MusicForm form = new MusicForm();
        form.setId(play.getId());
        form.setName(play.getName());
        form.setMusicName(play.getMusicName());
        form.setMusicStart(play.getMusicStart());
        form.setMusicEnd(play.getMusicEnd());
        form.setMusicRepeat(play.getMusicRepeat());
        //form.setCreateDate(play.getCreateDate());

        model.addAttribute("form", form);
        return "items/updateItemForm";
    }

    @PostMapping("items/{itemId}/edit")
    public String updatePlay(@PathVariable Long playId, @ModelAttribute("form") MusicForm form) {

        playService.updatePlay(playId, form.getName(), form.getCreateDate());

        return "redirect:/items";
    }
}





