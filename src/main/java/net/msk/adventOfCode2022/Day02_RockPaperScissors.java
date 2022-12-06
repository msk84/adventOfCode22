package net.msk.adventOfCode2022;

import java.util.List;

public class Day02_RockPaperScissors {

    public enum RockPaperScissors {
        Rock(1),
        Paper(2),
        Scissors(3);

        public final int value;
        RockPaperScissors(final int value) {
            this.value = value;
        }
    }

    public enum GameResult {
        LOST(0),
        TIE(3),
        WON(6);

        public final int value;

        GameResult(final int value) {
            this.value = value;
        }
    }

    public static int calculateRPSGameResultListScore(final List<Pair<RockPaperScissors, GameResult>> gameList) {
        return gameList.stream()
                .mapToInt(i -> calculateRPSGameResultScore(i.key(), i.value()))
                .sum();
    }

    public static int calculateRPSGameResultScore(final RockPaperScissors opponentValue, final GameResult gameResult) {
        return calculateMyGameValue(opponentValue, gameResult).value + gameResult.value;
    }

    private static RockPaperScissors calculateMyGameValue(final RockPaperScissors opponentValue, final GameResult gameResult) {
        switch (opponentValue) {
            case Rock -> {
                return switch (gameResult) {
                    case TIE -> RockPaperScissors.Rock;
                    case WON -> RockPaperScissors.Paper;
                    case LOST -> RockPaperScissors.Scissors;
                };
            }
            case Paper -> {
                return switch (gameResult) {
                    case TIE -> RockPaperScissors.Paper;
                    case WON -> RockPaperScissors.Scissors;
                    case LOST -> RockPaperScissors.Rock;
                };
            }
            case Scissors -> {
                return switch (gameResult) {
                    case TIE -> RockPaperScissors.Scissors;
                    case WON -> RockPaperScissors.Rock;
                    case LOST -> RockPaperScissors.Paper;
                };
            }
        }
        return RockPaperScissors.Rock;
    }

    public static int calculateRPSGameListScore(final List<Pair<RockPaperScissors, RockPaperScissors>> gameList) {
        return gameList.stream()
                .mapToInt(i -> calculateRPSScore(i.key(), i.value()))
                .sum();
    }

    public static int calculateRPSScore(final RockPaperScissors opponentValue, final RockPaperScissors ownValue) {
        return calculateGameResult(opponentValue, ownValue).value + ownValue.value;
    }

    private static GameResult calculateGameResult(final RockPaperScissors opponentValue, final RockPaperScissors ownValue) {
        switch (ownValue) {
            case Rock -> {
                return switch (opponentValue) {
                    case Rock -> GameResult.TIE;
                    case Paper -> GameResult.LOST;
                    case Scissors -> GameResult.WON;
                };
            }
            case Paper -> {
                return switch (opponentValue) {
                    case Rock -> GameResult.WON;
                    case Paper -> GameResult.TIE;
                    case Scissors -> GameResult.LOST;
                };
            }
            case Scissors -> {
                return switch (opponentValue) {
                    case Rock -> GameResult.LOST;
                    case Paper -> GameResult.WON;
                    case Scissors -> GameResult.TIE;
                };
            }
        }
        return GameResult.TIE;
    }

}
