package com.vana.spacetrek.data.gamesetup

import com.vana.spacetrek.spacemap.sector.SpaceSectorMap
import com.vana.spacetrek.spacemap.sector.data.SpaceSectorGridVO
import com.vana.spacetrek.spacemap.sector.impl.SpaceSectorMapImpl
import com.vana.spacetrek.spacemap.ship.data.PlayerSpaceShipVO

import java.awt.Color

class GameSetup {
    SpaceSectorMap sectorMap
    SpaceSectorGridVO gridVO
    PlayerSpaceShipVO playerSpaceShipVO


    GameSetup() {
        initializeGameSetup()
    }

    private void initializeGameSetup() {
        sectorMap = new SpaceSectorMapImpl()
        gridVO = sectorMap.initializeGrid(new SpaceSectorGridVO())
        playerSpaceShipVO = getPlayerShip()

    }

    private static PlayerSpaceShipVO getPlayerShip() {
        return new PlayerSpaceShipVO(
                name: "Enterprise",
                x: 14,
                y: 14,
                hitPoints: 100,
                color: Color.BLUE
        )
    }

}
