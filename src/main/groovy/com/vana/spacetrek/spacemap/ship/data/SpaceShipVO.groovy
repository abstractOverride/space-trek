package com.vana.spacetrek.spacemap.ship.data

import com.vana.spacetrek.data.ValueObject

import java.awt.Color

class SpaceShipVO extends ValueObject {
    String name

    int x
    int y
    int hitPoints

    Color color
}
