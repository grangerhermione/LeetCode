package design;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

/*
 * https://leetcode.com/problems/design-snake-game/
 * 
 * Design Snake Game:
 * Design a Snake game that is played on a device with screen size = width x height. 
 * Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, 
its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear 
until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied 
by the snake.
 */
public class DesignSnakeGame {

	int rows;
	int cols;
	Deque<Point> snake;
	Set<Point> body; // Used to check if it bites itself
	int[][] food;
	int score;
	/** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	public DesignSnakeGame(int width, int height, int[][] food) {
		this.rows = height;
		this.cols = width;
		this.food = food;
		this.score = 0;

		this.snake = new LinkedList<>();
		snake.addFirst(new Point(0, 0));
		this.body = new HashSet<>();
		this.body.add(new Point(0, 0));
	}

	/** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
	public int move(String direction) {
		Point head = snake.peekFirst();
		Point next;
		if ("U".equals(direction)) {
			next = new Point(head.r-1, head.c);
		} else if ("D".equals(direction)) {
			next = new Point(head.r+1, head.c);
		} else if ("L".equals(direction)) {
			next = new Point(head.r, head.c-1);
		} else {
			next = new Point(head.r, head.c+1);
		}
		// Check if out of bound
		if (next.r < 0 || next.r == rows || next.c < 0 || next.c == cols) {
			return -1;
		}
		// Check if it bites itself
		// NOTE: If next is equal to last point, it's considered as valid
		if (!next.equals(snake.peekLast()) && body.contains(next)) {
			return -1;
		}

		snake.addFirst(next);
		body.add(next);
		// Check if it reaches food
		if (score < food.length && next.r == food[score][0] && next.c == food[score][1]) {
			score++;
		} else {
			Point last = snake.removeLast();
			if (!next.equals(last)) {
				body.remove(last);
			}
		}
		return score;
	}


	class Point {
		private int r;
		private int c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public boolean equals(Object o) {
			if (o instanceof Point) {
				Point p = (Point)o;
				return this.r == p.r && this.c == p.c;
			}
			return false;
		}

		public int hashCode() {
			return Objects.hash(r, c);
		}
	}
}
