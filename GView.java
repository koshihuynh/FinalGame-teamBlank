package edu.cpp.cs.cs141.final_prog_assignment;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GView extends JPanel implements KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	Board board;
	String currentDirection = "wait";

	public GView(Board b) {
		board = b;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				g.drawImage(getImageAt(x, y), y * 50, x * 50, 50, 50, null);
			}
		}
	}

	public BufferedImage getImageAt(int x, int y) {
		try {
			if (board.at(x, y).getPlayerObj() != null && board.at(x, y).getPlayerObj().isNinja() == false) {
				return ImageIO.read(new File("images/spy.jpg"));
			} else if (board.at(x, y).getNinja()) {
				return ImageIO.read(new File("images/ninja.jpg"));
			} else if (board.at(x, y).getRoom()) {
				return ImageIO.read(new File("images/room.jpg"));
			} else if (board.at(x, y).getItemPresent() != null
					&& board.at(x, y).getItemPresent().getType().equals("R")) {
				return ImageIO.read(new File("images/radar.png"));
			} else if (board.at(x, y).getItemPresent() != null
					&& board.at(x, y).getItemPresent().getType().equals("I")) {
				return ImageIO.read(new File("images/shield.jpg"));
			} else if (board.at(x, y).getItemPresent() != null
					&& board.at(x, y).getItemPresent().getType().equals("A")) {
				return ImageIO.read(new File("images/ammo.png"));
			} else {
				return ImageIO.read(new File("images/tile.jpg"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'w'){
			currentDirection = "w";
		}else if(e.getKeyChar() == 'a'){
			currentDirection = "a";
		}else if(e.getKeyChar() == 's'){
			currentDirection = "s";
		}else if(e.getKeyChar() == 'd'){
			currentDirection = "d";
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public String getDirection() {
		return currentDirection;
	}

}
