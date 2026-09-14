package com.badminton.score.service;

import com.badminton.score.model.MatchScore;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    public void setTeamNames(MatchScore matchScore, String teamAName, String teamBName, String teamAColor, String teamBColor) {
        if (teamAName != null && !teamAName.trim().isEmpty()) {
            matchScore.setTeamAName(teamAName.trim());
        }

        if (teamBName != null && !teamBName.trim().isEmpty()) {
            matchScore.setTeamBName(teamBName.trim());
        }

        if (matchScore.getTeamAName().equals(matchScore.getTeamBName())) {
            matchScore.setTeamAName("Tim A");
            matchScore.setTeamBName("Tim B");
        }

        // set colors if provided (basic validation for hex-like values)
        if (teamAColor != null && !teamAColor.trim().isEmpty()) {
            matchScore.setTeamAColor(teamAColor.trim());
        }
        if (teamBColor != null && !teamBColor.trim().isEmpty()) {
            matchScore.setTeamBColor(teamBColor.trim());
        }

        matchScore.setStatusMessage("Permainan dimulai antara " + matchScore.getTeamAName() + " dan " + matchScore.getTeamBName() + ".");
    }

    public void addPoint(MatchScore matchScore, String team) {
        if (matchScore.isGameFinished()) {
            return;
        }

        if ("A".equalsIgnoreCase(team)) {
            matchScore.setTeamAScore(matchScore.getTeamAScore() + 1);
        } else if ("B".equalsIgnoreCase(team)) {
            matchScore.setTeamBScore(matchScore.getTeamBScore() + 1);
        }

        updateMatchStatus(matchScore);
    }

    public void subtractPoint(MatchScore matchScore, String team) {
        if (matchScore.isGameFinished()) {
            return;
        }

        if ("A".equalsIgnoreCase(team) && matchScore.getTeamAScore() > 0) {
            matchScore.setTeamAScore(matchScore.getTeamAScore() - 1);
        } else if ("B".equalsIgnoreCase(team) && matchScore.getTeamBScore() > 0) {
            matchScore.setTeamBScore(matchScore.getTeamBScore() - 1);
        }

        updateMatchStatus(matchScore);
    }

    public void resetMatch(MatchScore matchScore) {
        matchScore.reset();
    }

    public void updateMatchStatus(MatchScore matchScore) {
        int teamAScore = matchScore.getTeamAScore();
        int teamBScore = matchScore.getTeamBScore();

        if (teamAScore >= 21 || teamBScore >= 21) {
            if (Math.abs(teamAScore - teamBScore) >= 2) {
                matchScore.setGameFinished(true);
                String winner = teamAScore > teamBScore ? matchScore.getTeamAName() : matchScore.getTeamBName();
                matchScore.setWinner(winner);
                matchScore.setStatusMessage("Game selesai! Pemenangnya adalah " + winner + " dengan skor " + teamAScore + " - " + teamBScore + ".");
                return;
            }
        }

        if (teamAScore == 20 && teamBScore == 20) {
            matchScore.setGameFinished(false);
            matchScore.setWinner(null);
            matchScore.setStatusMessage("Deuce! Skor 20-20. Tim harus unggul 2 poin untuk menang.");
            return;
        }

        matchScore.setGameFinished(false);
        matchScore.setWinner(null);
        matchScore.setStatusMessage(matchScore.getTeamAName() + " " + teamAScore + " - " + teamBScore + " " + matchScore.getTeamBName() + ".");
    }
}
