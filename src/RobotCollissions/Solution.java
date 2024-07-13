package RobotCollissions;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().survivedRobotsHealths(new int[]{3,47}, new int[]{46,27}, "LR"));
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            robots.add(new Robot(i, positions[i], healths[i], directions.charAt(i)));
        }
        robots.sort(Comparator.comparingInt(Robot::getPosition));

        Stack<Robot> robotStack = new Stack<>();
        for (Robot robot : robots){
            robotCollision(robotStack, robot);
        }

        robots.clear();
        robots.addAll(robotStack);
        robots.sort(Comparator.comparingInt(Robot::getId));
        return robots.stream().map(r->r.health).toList();
    }

    private void robotCollision(Stack<Robot> robotStack, Robot robot){
        if (robotStack.isEmpty() || robotStack.peek().direction == robot.direction ||
                (robotStack.peek().direction=='L' && robot.direction=='R')){
            robotStack.push(robot);return;
        }
        Robot foe = robotStack.pop();
        if (foe.health > robot.health){
            foe.health--;
            if (foe.health > 0) robotStack.push(foe);
        }
        else if (foe.health < robot.health){
            robot.health--;
            if (robot.health > 0)robotCollision(robotStack, robot);
        }
    }

    private static class Robot{
        private final int id;
        private final int position;
        private int health;
        private final Character direction;

        public Robot(int id, int position, int health, Character direction) {
            this.id = id;
            this.position = position;
            this.health = health;
            this.direction = direction;
        }

        public int getId() {
            return id;
        }

        public int getPosition() {
            return position;
        }

    }
}
