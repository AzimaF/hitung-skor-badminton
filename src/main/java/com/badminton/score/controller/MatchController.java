package com.badminton.score.controller;

import com.badminton.score.model.MatchScore;
import com.badminton.score.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("matchScore")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @ModelAttribute("matchScore")
    public MatchScore matchScore() {
        return new MatchScore();
    }

    @GetMapping("/")
    public String index(@ModelAttribute("matchScore") MatchScore matchScore, Model model) {
        matchService.updateMatchStatus(matchScore);
        model.addAttribute("matchScore", matchScore);
        return "index";
    }

    @PostMapping("/set-names")
    public String setNames(@ModelAttribute("matchScore") MatchScore matchScore,
                           @RequestParam String teamAName,
                           @RequestParam String teamBName,
                           @RequestParam(required = false) String teamAColor,
                           @RequestParam(required = false) String teamBColor) {
        matchService.setTeamNames(matchScore, teamAName, teamBName, teamAColor, teamBColor);
        return "redirect:/";
    }

    @PostMapping("/score/add/{team}")
    public String addScore(@ModelAttribute("matchScore") MatchScore matchScore,
                           @PathVariable String team) {
        matchService.addPoint(matchScore, team);
        return "redirect:/";
    }

    @PostMapping("/score/subtract/{team}")
    public String subtractScore(@ModelAttribute("matchScore") MatchScore matchScore,
                               @PathVariable String team) {
        matchService.subtractPoint(matchScore, team);
        return "redirect:/";
    }

    @PostMapping("/reset")
    public String reset(@ModelAttribute("matchScore") MatchScore matchScore) {
        matchService.resetMatch(matchScore);
        return "redirect:/";
    }
}
