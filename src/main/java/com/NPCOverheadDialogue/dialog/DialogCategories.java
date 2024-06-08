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
            new String[] {"Do you think I’m fragile?","watashi no kubi o kittemite","eodi hanbeon nal busweobwa","Do you think I’m bad?","geureomyeon nal churakshigyeobwa","watashi o moyashitemite","watashi o kuroi umi ni nagetemite","myeot beonigo dashi","Again and again","mouichido mouichido","I’m antifragile","I","watashi wa","naneun","dashi sarana","churakhamyeo chuneun chum","misu ya shippai o kakusanai","I am not afraid of storms","for I am learning how to sail my ship","naneun jeomjeom deo deo deo ganghaejyeo"}),
    ;

    private final String[] ambientDialogs;
    private final String[] damageDialogs;
    private final String[] deathDialogs;
    private final String[] walkingDialogs;
}
