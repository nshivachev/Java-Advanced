package Advanced.MatricesEx;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damageDoneToHeigan = Double.parseDouble(scanner.nextLine());

        int playersLife = 18500;
        double heiganLife = 3000000;

        int playerPositionRow = 15 / 2;
        int playerPositionCol = 15 / 2;

        boolean isCloudSpellActive = false;

        String lastSpell = "";

        while (playersLife > 0 && heiganLife > 0) {

            heiganLife -= damageDoneToHeigan;

            if (isCloudSpellActive) {
                playersLife -= 3500;
                isCloudSpellActive = false;

                if (playersLife <= 0) {
                    break;
                }
            }

            if (heiganLife <= 0) {
                break;
            }

            String[] tokens = scanner.nextLine().split("\\s+");

            String spell = tokens[0];
            int spellRow = Integer.parseInt(tokens[1]);
            int spellCol = Integer.parseInt(tokens[2]);

            if (isHitArea(spellRow, spellCol, playerPositionRow, playerPositionCol)) {
                if (playerCanMove(spellRow, spellCol, playerPositionRow - 1, playerPositionCol)) {
                    playerPositionRow--;
                } else if (playerCanMove(spellRow, spellCol, playerPositionRow, playerPositionCol + 1)) {
                    playerPositionCol++;
                } else if (playerCanMove(spellRow, spellCol, playerPositionRow + 1, playerPositionCol)) {
                    playerPositionRow++;
                } else if (playerCanMove(spellRow, spellCol, playerPositionRow, playerPositionCol - 1)) {
                    playerPositionCol--;
                } else {
                    if (spell.equals("Cloud")) {
                        playersLife -= 3500;
                        lastSpell = "Plague Cloud";
                        isCloudSpellActive = true;
                    } else if (spell.equals("Eruption")) {
                        playersLife -= 6000;
                        lastSpell = spell;
                    } else {
                        throw new IllegalArgumentException("Invalid spell: " + spell);
                    }
                }
            }
        }

        if (heiganLife > 0) {
            System.out.printf("Heigan: %.2f%n", heiganLife);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playersLife > 0) {
            System.out.printf("Player: %d%n", playersLife);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + playerPositionRow + ", " + playerPositionCol);
    }

    public static boolean isHitArea (int spellRow, int spellCol, int playerPositionRow, int playerPositionCol) {
        for (int row = spellRow - 1; row <= spellRow + 1; row++) {
            for (int col = spellCol - 1; col <= spellCol + 1; col++) {
                if (row == playerPositionRow && col == playerPositionCol) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean playerCanMove (int spellRow, int spellCol, int playerPositionRow, int playerPositionCol) {
        return !isHitArea(spellRow, spellCol, playerPositionRow, playerPositionCol)
                && playerPositionRow >= 0 && playerPositionRow < 15
                && playerPositionCol >= 0 && playerPositionCol < 15;
    }
}
