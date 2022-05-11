package com.example.faceYourPace.controller;

import com.example.faceYourPace.domain.PlayList;
import com.example.faceYourPace.domain.member.Member;
import com.example.faceYourPace.domain.member.MemberService;
import com.example.faceYourPace.domain.music.Music;
import com.example.faceYourPace.repository.PlayListSearch;
import com.example.faceYourPace.service.MusicService;
import com.example.faceYourPace.service.PlayListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PlayListController {

    private final PlayListService playListService;
    private final MemberService memberService;
    private final MusicService musicService;

    @GetMapping("/playList")
    public String createForm(Model model) {

        List<Member> members = memberService.findMembers();
        List<Music> musics = musicService.findMusics();

        model.addAttribute("members", members);
        model.addAttribute("musics", musics);

        return "플레이리스트 form";
    }

    @PostMapping("/api/music/playlist/add")
    public String playList(@RequestParam("memberId") Long memberId,
                        @RequestParam("musicId") Long musicId) { // 플레이리스트 추가

        playListService.playList(memberId, musicId);
        return "true";
    }

    @GetMapping("/api/mypage/playlist")
    public String playListList(@ModelAttribute("playListSearch") PlayListSearch playListSearch, Model model) {
        List<PlayList> playLists = playListService.findPlayLists(playListSearch);
        model.addAttribute("playlists", playLists);
        // userId의 플레이리스트 목록
        return "true";
    }


    @PostMapping("/api/mypage/playlist/{playListId}/cancel") // 플레이리스트 삭제(수정하기)
    public String deletePlayList(@PathVariable("playListId") Long playListId) {
        playListService.deletePlayList(playListId);
        return "플레이리스트 삭제";
    }
}
