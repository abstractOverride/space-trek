package com.vana.spacetrek.display.drawscreen

import com.vana.spacetrek.data.MouseVO
import com.vana.spacetrek.spacemap.sector.data.SpaceSectorGridVO

import java.awt.event.MouseEvent

interface MouseEventService {

    MouseVO mouseClicked(MouseEvent mouseEvent, SpaceSectorGridVO gridVO, MouseVO mouseVO)

    MouseVO mouseMoved(MouseEvent mouseEvent, SpaceSectorGridVO gridVO, MouseVO mouseVO)

}
