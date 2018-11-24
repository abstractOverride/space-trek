package com.vana.spacetrek.data

import com.vana.spacetrek.quest.data.QuestVO
import groovy.transform.CompileStatic

@CompileStatic
class MainQuests extends ArrayList<QuestVO> implements List<QuestVO> {
    QuestVO STARTING_QUEST

    MainQuests() {
        STARTING_QUEST = new QuestVO(
                name: "Starting Quest",
                desc: "A quest to learn how to create quests."
        )

        add(STARTING_QUEST)
    }

}
