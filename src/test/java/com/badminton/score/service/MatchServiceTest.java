package com.badminton.score.service;

import com.badminton.score.model.MatchScore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchServiceTest {

    private final MatchService matchService = new MatchService();

    @Test
    void shouldFinishGameWhenOneTeamReaches21WithTwoPointLead() {
        MatchScore matchScore = new MatchScore();
        matchScore.setTeamAName("Tim A");
        matchScore.setTeamBName("Tim B");

        for (int i = 0; i < 20; i++) {
            matchService.addPoint(matchScore, "A");
        }

        for (int i = 0; i < 18; i++) {
            matchService.addPoint(matchScore, "B");
        }

        matchService.addPoint(matchScore, "A");

        assertTrue(matchScore.isGameFinished());
        assertEquals("Tim A", matchScore.getWinner());
        assertTrue(matchScore.getStatusMessage().contains("Game selesai"));
    }

    @Test
    void shouldEnterDeuceAtTwentyAll() {
        MatchScore matchScore = new MatchScore();
        matchScore.setTeamAName("Tim A");
        matchScore.setTeamBName("Tim B");

        for (int i = 0; i < 20; i++) {
            matchService.addPoint(matchScore, "A");
            matchService.addPoint(matchScore, "B");
        }

        assertFalse(matchScore.isGameFinished());
        assertTrue(matchScore.getStatusMessage().contains("Deuce"));
    }

    @Test
    void shouldFinishAfterDeuceWhenLeadIsTwo() {
        MatchScore matchScore = new MatchScore();
        matchScore.setTeamAName("Tim A");
        matchScore.setTeamBName("Tim B");

        for (int i = 0; i < 20; i++) {
            matchService.addPoint(matchScore, "A");
            matchService.addPoint(matchScore, "B");
        }

        matchService.addPoint(matchScore, "A");
        matchService.addPoint(matchScore, "A");

        assertTrue(matchScore.isGameFinished());
        assertEquals("Tim A", matchScore.getWinner());
    }
}
