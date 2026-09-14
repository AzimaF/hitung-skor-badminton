package com.badminton.score.model;

public class MatchScore {

    private String teamAName = "Tim A";
    private String teamBName = "Tim B";
    private int teamAScore = 0;
    private int teamBScore = 0;
    private boolean gameFinished = false;
    private String winner;
    private String statusMessage = "Permainan dimulai. Siap wasit!";
    // HEX colors for the team cards (default subtle backgrounds)
    private String teamAColor = "#f8fafc";
    private String teamBColor = "#f8fafc";

    public String getTeamAName() {
        return teamAName;
    }

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public void setTeamBName(String teamBName) {
        this.teamBName = teamBName;
    }

    public int getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public int getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getTeamAColor() {
        return teamAColor;
    }

    public void setTeamAColor(String teamAColor) {
        this.teamAColor = teamAColor;
    }

    public String getTeamBColor() {
        return teamBColor;
    }

    public void setTeamBColor(String teamBColor) {
        this.teamBColor = teamBColor;
    }

    public void reset() {
        this.teamAScore = 0;
        this.teamBScore = 0;
        this.gameFinished = false;
        this.winner = null;
        this.statusMessage = "Permainan dimulai. Siap wasit!";
        this.teamAColor = "#f8fafc";
        this.teamBColor = "#f8fafc";
    }
}

