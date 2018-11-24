package com.vana.spacetrek.spacemap.sector.impl

import com.vana.spacetrek.data.MainQuests
import com.vana.spacetrek.spacemap.sector.SpaceSectorMap
import com.vana.spacetrek.spacemap.sector.data.SpaceSectorGridVO
import com.vana.spacetrek.spacemap.sector.data.SpaceSectorVO

class SpaceSectorMapImpl implements SpaceSectorMap {

    public SpaceSectorGridVO initializeGrid(SpaceSectorGridVO spaceSectorGridVO) {
        spaceSectorGridVO.grid = new SpaceSectorVO[spaceSectorGridVO.cols][spaceSectorGridVO.rows]

        int x = 0
        int y = 0

        for (SpaceSectorVO[] spaceSectorVOS : spaceSectorGridVO.grid) {
            for (SpaceSectorVO spaceSectorVO : spaceSectorVOS) {
                spaceSectorVO = new SpaceSectorVO(
                        x: x,
                        y: y,
                        name: "SECTOR: ($x, $y)",
                        desc: "This sector is unexplored"
                )

                if (x == 10 && y == 12) {
                    spaceSectorVO.questVO = new MainQuests().STARTING_QUEST
                    spaceSectorVO.questVO.questXCor = x
                    spaceSectorVO.questVO.questYCor = y
                }

                spaceSectorGridVO.grid[x][y] = spaceSectorVO
                y++
            }

            y = 0
            x++
        }

        return spaceSectorGridVO
    }

}
