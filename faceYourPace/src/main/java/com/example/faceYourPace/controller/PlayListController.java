package com.example.faceYourPace.controller;

import com.example.faceYourPace.domain.PlayList;
import com.example.faceYourPace.domain.PlayListMusic;
import com.example.faceYourPace.domain.member.Member;
import com.example.faceYourPace.domain.member.MemberService;
import com.example.faceYourPace.domain.music.Music;
import com.example.faceYourPace.repository.PlayListRepository;
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

    private final PlayListRepository playListRepository;

    @GetMapping("/api/music/playlist/add")
    public String createForm(Model model) {

        List<Member> members = memberService.findMembers();
        List<Music> musics = musicService.findMusics();

        model.addAttribute("members", members);
        model.addAttribute("musics", musics);

        return "플레이리스트 form";
    }

    //@PostMapping("/api/music/playlist/add")
    public String playList(@RequestParam("userId") Long memberId,
                           @RequestParam("musicId") Long musicId) { // 플레이리스트 추가


        playListService.playList2(memberId, musicId);
        return "true";
    }


    @PostMapping("/api/playList/music/add")
    public String playListMusicAdd(@RequestParam("playListId") String playListId,
                              @RequestParam("musicId") String musicId) { // 플레이리스트에 음악추가

        Long playListId2 = Long.parseLong(playListId);
        Long musicId2 = Long.parseLong(musicId);

        //List<Member> members = memberService.findUserId(userId);
        List<PlayList> playLists = playListService.findById(playListId2);
        List<Music> musics = musicService.findById(musicId2);
/*
        for (PlayList playList : playLists) {
            for (Music music : musics){
                if (playList.getId().equals(playListId2) && music.getId().equals(musicId2)) {
                    //Long memberId = member.getId();
                    playListService.playList2(playList.getId(), music.getId());
                    //return member.getId();
                }
            }
        }

 */
        playListService.playList2(playListId2, musicId2);
        //playListService.playList(memberId, musicName);
        return "true";
    }

    @PostMapping("/api/music/playlist/add")
    public String playListAdd2(@RequestParam("userId") String userId,
                               @RequestParam("name") String name) { // 플레이리스트 추가(userId, 플레이리스트이름)

        List<Member> members = memberService.findUserId(userId);

        for (Member member : members) {
                if (member.getUserId().equals(userId))  {

                    playListService.playList(member.getId(), name);
                    //return member.getId();
                }
        }

        System.out.println("userId:" + userId);

        //playListService.playList(memberId, musicName);
        return "true";
    }


    @GetMapping("/api/mypage/playlist/{id}")
    List<PlayList> getUserIdAllDate(@PathVariable("id") Long id) { // userId의 플레이리스트 목록
        System.out.println(playListRepository.findById(id));
        return playListRepository.findById(id);
    }

    @GetMapping("/api/play/list")
    List<PlayList> getAll() { // 플레이리스트 출력 -> 왜 안됌?
        return playListRepository.findAll();
    }


    @PostMapping("/api/mypage/playlist/{playListId}/cancel") // 플레이리스트 삭제(수정하기)
    public String deletePlayList(@PathVariable("playListId") Long playListId) {
        playListService.deletePlayList(playListId);
        return "플레이리스트 삭제";
    }
}
