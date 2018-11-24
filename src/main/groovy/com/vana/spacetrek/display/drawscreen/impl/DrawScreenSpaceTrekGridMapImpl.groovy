package com.vana.spacetrek.display.drawscreen.impl

import com.vana.spacetrek.data.MouseVO
import com.vana.spacetrek.display.drawscreen.DrawScreen
import com.vana.spacetrek.display.drawscreen.MouseEventService
import com.vana.spacetrek.spacemap.ship.data.SpaceShipVO
import com.vana.spacetrek.spacemap.sector.data.SpaceSectorGridVO
import com.vana.spacetrek.spacemap.sector.data.SpaceSectorVO

import java.awt.*
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener
import java.util.List

class DrawScreenSpaceTrekGridMapImpl extends AbstractDrawScreen implements DrawScreen, MouseListener, MouseMotionListener {
    SpaceSectorGridVO gridVO
    List<SpaceSectorVO> spaceSectorVOS = new ArrayList<>()
    List<SpaceShipVO> spaceShipVOS = new ArrayList<>()
    private String outputText = ""
    private String questText = ""
    MouseVO mouseVO = new MouseVO()
    MouseEventService mouseEventService = new MouseEventServiceImpl()

    DrawScreenSpaceTrekGridMapImpl(String title) {
        super(title)
        addMouseListener(this)
        addMouseMotionListener(this)
    }

    public void updateShips(List<SpaceShipVO> spaceShipVOS) {
        this.spaceShipVOS = spaceShipVOS
    }

    public void updateOutputText(String outputText) {
        this.outputText = outputText
    }

    public void updateSpaceSectorGridVO(SpaceSectorGridVO spaceSectorGridVO) {
        this.gridVO = spaceSectorGridVO
    }

    @Override
    void paint(Graphics g) {
        g.clearRect(0, 0, width, height)
        for (int x = 0; x <= gridVO.cols; x++) {
            g.drawLine(x * gridVO.sectorWidth + 100, 20, x * gridVO.sectorWidth + 100, (gridVO.rows + 1) * gridVO.sectorHeight - 20)
        }

        for (int y = 0; y <= gridVO.rows; y++) {
            g.drawLine(100, y * gridVO.sectorHeight + 20, (gridVO.cols + 2) * gridVO.sectorWidth + 20, y * gridVO.sectorHeight + 20)
        }

        if (mouseVO.clickedInd) {
            g.color = Color.RED
            g.fillRect(mouseVO.x, mouseVO.y, gridVO.sectorWidth - 1, gridVO.sectorHeight -  1)
        }

        if (mouseVO.hoverInd) {
            g.color = Color.GREEN
            g.fillRect(mouseVO.x, mouseVO.y, gridVO.sectorWidth - 1, gridVO.sectorHeight -  1)
        }

        for (SpaceShipVO spaceShipVO : spaceShipVOS) {
            g.setColor(spaceShipVO.color)
            g.fillRect(spaceShipVO.x * 40 + 100, spaceShipVO.y * 40 + 20, 40, 40)
        }

        g.setColor(Color.BLACK)
        g.drawString(outputText, 950, 20)
        g.drawString(questText, 950, 60)
    }

    @Override
    void mouseClicked(MouseEvent mouseEvent) {
        mouseVO = mouseEventService.mouseClicked(mouseEvent, gridVO, mouseVO)
        repaint()
    }

    @Override
    void mousePressed(MouseEvent e) {

    }

    @Override
    void mouseReleased(MouseEvent e) {

    }

    @Override
    void mouseEntered(MouseEvent e) {

    }

    @Override
    void mouseExited(MouseEvent e) {

    }

    @Override
    void mouseDragged(MouseEvent e) {

    }

    @Override
    void mouseMoved(MouseEvent mouseEvent) {
        mouseVO = mouseEventService.mouseMoved(mouseEvent, gridVO, mouseVO)
        repaint()
    }
}
