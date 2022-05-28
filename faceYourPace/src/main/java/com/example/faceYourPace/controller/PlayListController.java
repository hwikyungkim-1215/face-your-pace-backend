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


        playListService.playList(memberId, musicId);
        return "true";
    }



    @PostMapping("/api/music/playlist/add")
    public String playListAdd2(@RequestParam("userId") String userId,
                              @RequestParam("musicName") String musicName) { // 플레이리스트 추가

        List<Member> members = memberService.findUserId(userId);
        List<Music> musics = musicService.findMusicName(musicName);

        for (Member member : members) {
            for (Music music : musics){
                if (member.getUserId().equals(userId) && (music.getMusicName().equals(musicName)))  {

                    //Long memberId = member.getId();
                    playListService.playList(member.getId(), music.getId());
                    //return member.getId();
                }
            }
        }

        System.out.println("userId:" + userId);
        System.out.println("musicName:"+ musicName);

        //playListService.playList(memberId, musicName);
        return "true";
    }
/*
    //테스트 입니다.
    @RequestMapping(value="/api/music/playlist/add", method= {RequestMethod.POST})
    public String playListAdd(Model model, @RequestParam(value="userId", required = false) String userId,
                            @RequestParam(value="musicName", required=false) String musicName) throws Exception {

        playListService.playList(userId, musicName);
        return "true";
    }

    @GetMapping("/api/mypage/playlist/{userId}")
    public String playListList(@ModelAttribute("playListSearch") PlayListSearch playListSearch, Model model) {
        List<PlayList> playLists = playListService.findPlayLists(playListSearch);
        model.addAttribute("playlists", playLists);
        // userId의 플레이리스트 목록
        return "true";
    }

 */
/*
    @GetMapping("/api/mypage/playlist/{userId}")
    List<PlayList> getUserIdAllDate(@PathVariable("userId") String userId) { // userId의 플레이리스트 목록
        return playListRepository.findByUserId(userId);
    }

 */

    @GetMapping("/api/mypage/playlist/{memberId}")
    List<PlayList> getUserIdAllDate(@PathVariable("memberId") Long memberId) { // userId의 플레이리스트 목록
        return playListRepository.findById(memberId);
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
