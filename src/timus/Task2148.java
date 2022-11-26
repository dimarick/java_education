package timus;

import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=2148">see task</a>
 */
public class Task2148 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] roundData = in.nextLine().split(" ");
        String[] sherData = in.nextLine().split(" ");
        String[] enemyData = in.nextLine().split(" ");

        int roundX = Integer.parseInt(roundData[0]);
        int roundY = Integer.parseInt(roundData[1]);
        int roundRadius = Integer.parseInt(roundData[2]);
        double sherX = Integer.parseInt(sherData[0]);
        double sherY = Integer.parseInt(sherData[1]);
        double enemyX = Integer.parseInt(enemyData[0]);
        double enemyY = Integer.parseInt(enemyData[1]);

        double reflectionDirectionX = (sherX + enemyX) / 2 - roundX;
        double reflectionDirectionY = (sherY + enemyY) / 2 - roundY;

        double currentDistance = Math.sqrt(reflectionDirectionX * reflectionDirectionX + reflectionDirectionY * reflectionDirectionY);

        if (currentDistance <= roundRadius) {
            System.out.println("No way");

            return;
        }

        double scale = roundRadius / currentDistance;

        System.out.println((reflectionDirectionX * scale + roundX) + " " + (reflectionDirectionY * scale + roundY));
    }
}
