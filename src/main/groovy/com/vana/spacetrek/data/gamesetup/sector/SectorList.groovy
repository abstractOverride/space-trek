package com.vana.spacetrek.data.gamesetup.sector

import com.vana.spacetrek.spacemap.sector.data.SpaceSectorVO

class SectorList extends ArrayList<SpaceSectorVO> implements List<SpaceSectorVO> {

    SpaceSectorVO SECTOR_0_0
    SpaceSectorVO SECTOR_1_0
    SpaceSectorVO SECTOR_2_0
    SpaceSectorVO SECTOR_3_0
    SpaceSectorVO SECTOR_4_0
    SpaceSectorVO SECTOR_5_0
    SpaceSectorVO SECTOR_6_0
    SpaceSectorVO SECTOR_7_0
    SpaceSectorVO SECTOR_8_0
    SpaceSectorVO SECTOR_9_0
    SpaceSectorVO SECTOR_10_0

    SectorList() {
        SECTOR_0_0 = new SpaceSectorVO(x: 1, y: 1, name: "(0, 0)")
    }
}
