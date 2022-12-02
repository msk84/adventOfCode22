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

    private enum OwnGameResult {
        LOST(0),
        TIE(3),
        WON(6);

        public final int value;

        OwnGameResult(final int value) {
            this.value = value;
        }
    }

    public static int calculateRPSGameListScore(final List<Pair<RockPaperScissors, RockPaperScissors>> gameList) {
        return gameList.stream()
                .mapToInt(i -> calculateRPSScore(i.key(), i.value()))
                .sum();
    }

    public static int calculateRPSScore(final RockPaperScissors opponentValue, final RockPaperScissors ownValue) {
        return calculateGameResult(opponentValue, ownValue).value + ownValue.value;
    }

    private static OwnGameResult calculateGameResult(final RockPaperScissors opponentValue, final RockPaperScissors ownValue) {
        switch (ownValue) {
            case Rock -> {
                return switch (opponentValue) {
                    case Rock -> OwnGameResult.TIE;
                    case Paper -> OwnGameResult.LOST;
                    case Scissors -> OwnGameResult.WON;
                };
            }
            case Paper -> {
                return switch (opponentValue) {
                    case Rock -> OwnGameResult.WON;
                    case Paper -> OwnGameResult.TIE;
                    case Scissors -> OwnGameResult.LOST;
                };
            }
            case Scissors -> {
                return switch (opponentValue) {
                    case Rock -> OwnGameResult.LOST;
                    case Paper -> OwnGameResult.WON;
                    case Scissors -> OwnGameResult.TIE;
                };
            }
        }
        return OwnGameResult.TIE;
    }

}
