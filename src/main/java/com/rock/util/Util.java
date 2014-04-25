package com.rock.util;

/**
 * SciEngine: RockEngine Fork
 *
 * @author rockon999
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Util {

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static double calculateRotation(int mouseX, int mouseY, int objX, int objY) {
        float deltaX = mouseX - objX;
        float deltaY = mouseY - objY;
        double degrees = Math.toDegrees(Math.atan2(deltaY, deltaX));
        return ((360 + degrees) % 360) + 90;
    }
}
