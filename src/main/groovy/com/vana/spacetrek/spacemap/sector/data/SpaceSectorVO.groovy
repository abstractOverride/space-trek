package com.vana.spacetrek.spacemap.sector.data

import com.vana.spacetrek.data.ValueObject
import com.vana.spacetrek.quest.QuestLocation
import com.vana.spacetrek.quest.data.QuestVO

class SpaceSectorVO extends ValueObject implements QuestLocation {

    int width
    int height
    String desc

    QuestVO questVO

    @Override
    QuestVO getQuestVO() {
        return questVO
    }
}
