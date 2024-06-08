package com.NPCOverheadDialogue.dialog;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DialogCategories
{
    HYDRA(
            null,
            null,
            null,
            new String[] {"*sweep* *sweep*", "Time for a break!", "I just swept there!", "*whistles*"}),
    ;

    private final String[] ambientDialogs;
    private final String[] damageDialogs;
    private final String[] deathDialogs;
    private final String[] walkingDialogs;
}
