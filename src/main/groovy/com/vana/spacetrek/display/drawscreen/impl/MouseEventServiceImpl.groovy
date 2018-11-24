package com.vana.spacetrek.display.drawscreen.impl

import com.vana.spacetrek.data.MouseVO
import com.vana.spacetrek.display.drawscreen.MouseEventService
import com.vana.spacetrek.spacemap.sector.data.SpaceSectorGridVO

import java.awt.event.MouseEvent

class MouseEventServiceImpl implements MouseEventService {

    @Override
    MouseVO mouseClicked(MouseEvent mouseEvent, SpaceSectorGridVO gridVO, MouseVO mouseVO) {
        MouseVO updatedMouseVO = calculateGridClickLocation(mouseEvent, gridVO)
        updatedMouseVO.clickedInd = isMouseInsideGrid(mouseVO.mouseClickedX, mouseVO.mouseClickedY, gridVO)

        if (updatedMouseVO.clickedInd && mouseVO.clickedInd) {
            if (updatedMouseVO.mouseClickedX == mouseVO.mouseClickedX && updatedMouseVO.mouseClickedY == mouseVO.mouseClickedY) {
                updatedMouseVO.clickedInd = false
            }
        } else if (!updatedMouseVO.clickedInd) {
            return mouseVO
        }

        return updatedMouseVO
    }

    @Override
    MouseVO mouseMoved(MouseEvent mouseEvent, SpaceSectorGridVO gridVO, MouseVO mouseVO) {
        mouseVO = calculateHoverClickLocation(mouseEvent, gridVO, mouseVO)
        mouseVO.hoverInd = isMouseInsideGrid(mouseVO.mouseHoverX, mouseVO.mouseHoverY, gridVO)

        return mouseVO
    }

    private boolean isMouseInsideGrid(int x, int y, SpaceSectorGridVO gridVO) {
        return x >= 0 && x <= gridVO.cols && y >= 0 && y <= gridVO.rows
    }

    private MouseVO calculateGridClickLocation(MouseEvent mouseEvent, SpaceSectorGridVO gridVO) {
        MouseVO mouseVO = new MouseVO()
        mouseVO.x = Math.floor((mouseEvent.x - 100) / gridVO.sectorWidth) * gridVO.sectorWidth + 101
        mouseVO.y = Math.floor((mouseEvent.y -  20) / gridVO.sectorHeight) * gridVO.sectorWidth + 21
        mouseVO.mouseClickedX = Math.floor((mouseEvent.x - 100) / gridVO.sectorWidth)
        mouseVO.mouseClickedX = Math.floor((mouseEvent.y - 20) / gridVO.sectorHeight)

        return mouseVO
    }

    private MouseVO calculateHoverClickLocation(MouseEvent mouseEvent, SpaceSectorGridVO gridVO, MouseVO mouseVO) {
        mouseVO.x = Math.floor((mouseEvent.x - 100) / gridVO.sectorWidth) * gridVO.sectorWidth + 101
        mouseVO.y = Math.floor((mouseEvent.y -  20) / gridVO.sectorHeight) * gridVO.sectorWidth + 21
        mouseVO.mouseHoverX = Math.floor((mouseEvent.x - 100) / gridVO.sectorWidth)
        mouseVO.mouseHoverY = Math.floor((mouseEvent.y - 20) / gridVO.sectorHeight)

        return mouseVO
    }




}
