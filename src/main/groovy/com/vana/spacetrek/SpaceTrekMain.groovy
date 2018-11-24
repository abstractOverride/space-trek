package com.vana.spacetrek

import com.vana.spacetrek.data.gamesetup.GameSetup
import com.vana.spacetrek.display.drawscreen.DrawScreen
import com.vana.spacetrek.display.drawscreen.impl.DrawScreenSpaceTrekGridMapImpl
import com.vana.spacetrek.spacemap.sector.data.SpaceSectorVO

import java.awt.*
import java.util.List

public class SpaceTrekMain {

    static void main(String[] args) {
        GameSetup gameSetup = new GameSetup()
        DrawScreen drawScreen
        drawScreen = new DrawScreenSpaceTrekGridMapImpl("Space Trek")
        drawScreen.updateSpaceSectorGridVO(gameSetup.gridVO)
        drawScreen.spaceSectorVOS.addAll(getSpaceSectorVOs())
        drawScreen.updateShips([gameSetup.playerSpaceShipVO])
        drawScreen.updateOutputText("Get ready to boldy go!")
        while(true) {
            drawScreen.repaint()
        }
    }

    private static List<SpaceSectorVO> getSpaceSectorVOs() {
        List<SpaceSectorVO> spaceSectorVOS = new ArrayList<>()

        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 10; y++) {
                SpaceSectorVO spaceSectorVO = new SpaceSectorVO(
                        x: x,
                        y: y,
                        height: 50,
                        width: 50,
                        name: "Sector $x, $y",
                        color: Color.BLACK
                )

                spaceSectorVOS.add(spaceSectorVO)
            }
        }

        return spaceSectorVOS
    }
}
