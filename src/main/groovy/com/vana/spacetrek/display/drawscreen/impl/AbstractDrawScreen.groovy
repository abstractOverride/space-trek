package com.vana.spacetrek.display.drawscreen.impl

import com.vana.spacetrek.display.drawscreen.DrawScreen

import javax.swing.JFrame
import javax.swing.JPanel
import java.awt.Graphics

abstract class AbstractDrawScreen extends JPanel implements DrawScreen {
    private JFrame frame
    private String title
    int width = 1200
    int height = 800

    AbstractDrawScreen(String title) {
        this.title = title
        initializeScreen()
        repaint()
    }

    protected void initializeScreen() {
        frame = new JFrame(title: title)
        frame.getContentPane().add(this)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setSize(width, height)
        frame.setVisible(true)
    }

    public abstract void paint(Graphics g)
}
