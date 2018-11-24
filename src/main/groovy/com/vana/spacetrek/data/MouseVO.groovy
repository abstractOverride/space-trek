package com.vana.spacetrek.data

import groovy.transform.CompileStatic

@CompileStatic
class MouseVO extends ValueObject {
    int mouseClickedX
    int mouseClickedY

    int mouseHoverX
    int mouseHoverY

    boolean clickedInd
    boolean hoverInd
}
