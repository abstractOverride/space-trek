package com.vana.spacetrek.spacemap.sector.data

import com.vana.spacetrek.data.ValueObject

class SpaceSectorGridVO extends ValueObject {
    int rows = 16
    int cols = 21
    int sectorHeight = 40
    int sectorWidth = 40

    SpaceSectorVO[][] grid


}
