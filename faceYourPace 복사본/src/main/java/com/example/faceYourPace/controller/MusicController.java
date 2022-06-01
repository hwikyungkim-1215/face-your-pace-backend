package com.example.faceYourPace.controller;

import com.example.faceYourPace.cmd.DownloadPython;
import com.example.faceYourPace.cmd.MusicFunctionPython;
import com.example.faceYourPace.domain.member.Member;
import com.example.faceYourPace.domain.music.Music;
import com.example.faceYourPace.domain.music.MusicForm;
import com.example.faceYourPace.repository.MemberRepository;
import com.example.faceYourPace.repository.MusicRepository;
import com.example.faceYourPace.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MusicController {

    public final MusicService musicService;
    public final MusicRepository musicRepository;
    public final MemberRepository memberRepository;
    public Member member;

    @GetMapping("/api/music/add")
    public String createForm(Model model) {
        model.addAttribute("form", new MusicForm());
        return "music 추가 form";
    }

    @PostMapping("/api/music/add") // 메인 홈에서 다운
    public String create(@RequestParam("music_url") String music_url, MusicForm form) { // music 추가

        Music music = new Music();
        music.setMusic_url(form.getMusic_url());

        // 음악 다운
        System.out.println(music_url);
        String r = DownloadPython.create(music_url); // 음악 다운로드(mp3)

        System.out.println("downloadPython 완료");

        String[] strArr = r.split("$");
        String title = strArr[0];
        String length = strArr[1];
        String img_url = strArr[2];

        music.setMusicImg_url(img_url);
        music.setLength(length);
        music.setTitle(title);

        musicService.saveMusic(music);
        System.out.println("음악 테이블에 저장 완료");

        return "true";
    }

    @PostMapping("/api/music/config") // 안씀
    public String createConfig(@RequestParam("musicName") String musicName) { // music 추가 // 수정하기(update로 구현하기)

        Music music = musicRepository.findMusicName(musicName);
        //Music music = new Music();
        //music.setMusicName(form.getMusicName());
        //music.setMusicStart(form.getMusicStart());
        //music.setMusicEnd(form.getMusicEnd());
        //music.setMusicRepeat(form.getMusicRepeat());
        music.setCreateDate(LocalDateTime.now());
        musicService.saveMusic(music);

        // 음악 변환 후 저장
        //MusicFunctionPython.create(audio_path, save_path, music.getMusicStart(), music.getMusicEnd(), bpm);
        System.out.println("music 설정값 적용 완료");
        return "true";
    }


    @GetMapping("/api/music/list") // music table 전체 출력
    List<Music> getAll() { // 음악리스트 출력
        return musicRepository.findAll();
    }


    @PostMapping("/api/music/{musicId}/edit") // config 페이지 연동
    public String updateMusic(@PathVariable Long musicId, @ModelAttribute("form") MusicForm form) {

        musicService.updateMusic(musicId, form.getMusicStart(), form.getMusicEnd(), form.getMusicRepeat(), form.getTarget_bpm());
        System.out.println("음악 설정 update");

        String bpm;
        if(member.getTarget_pace() == null){ // 타겟 bpm이 없을 경우
            bpm = "0";
        }
        else{
            bpm = member.getTarget_pace();
        }
        Music music = musicRepository.findOne(musicId);
        // 음악 변환 후 저장
        String audio_path = "'/home/ubuntu/face-your-pace-function/fyp_download/result/" + music.getTitle() + ".mp3'"; // 원본 음악 저장된 위치
        String save_path = "'/home/ubuntu/face-your-pace-function/fyp_download/result/" + music.getTitle() + ".wav'"; // 변환된 음원 저장할 위치

        MusicFunctionPython.create(audio_path, save_path, music.getMusicStart(), music.getMusicEnd(), bpm);
        System.out.println("music 설정값 적용 완료");

        return "true";
    }

    @GetMapping("api/music/edit") // 안씀
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

}





