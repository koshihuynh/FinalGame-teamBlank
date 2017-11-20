package edu.cpp.cs.cs141.final_prog_assignment;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI {
	private JFrame win;
	private GView gridView;
	GameEngine game;
	JMenuItem newGame;
	JMenuItem exit;
	JMenuItem howToPlay;
	JMenuItem save;
	JMenuItem load;
	Board board;

	public GUI(Board b, GameEngine g) {
		board = b;
		game = g;
		initializeWindow();
		addMenuItems();
	}

	private void addMenuItems() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		newGame = new JMenuItem("New Game");
		exit = new JMenuItem("Exit");
		howToPlay = new JMenuItem("How To Play");
		save = new JMenuItem("Save");
		load = new JMenuItem("Load");
		fileMenu.add(newGame);
		fileMenu.add(howToPlay);
		fileMenu.add(save);
		fileMenu.add(load);
		fileMenu.add(exit);
		menuBar.add(fileMenu);
		menuBar.setBounds(0, 0, win.getWidth(), 20);
		win.add(menuBar);
		win.setVisible(true);
	}

	private void initializeWindow() {
		win = new JFrame("CS141 FINAL PROJECT");
		gridView = new GView(board);
		gridView.setBounds(0, 20, 450, 490);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setMinimumSize(new Dimension(455, 500));
		win.add(gridView);
		win.setResizable(false);
		win.setLayout(null);
		win.addKeyListener(gridView);
	}

	public void repaint() {
		gridView.repaint();
	}

	public String getDirection() {
		return gridView.getDirection();
	}

	public void setBoard(Board board2) {
		board = board2;
	}
}
