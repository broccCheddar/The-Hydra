package com.NPCOverheadDialogue.dialog;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DialogCategories
{
    LIBRARIAN(
            new String[]{"I am a librarian", "shhhhhh", "I have always imagined that paradise will be a kind of Library"},
            null,
            null,
            null),
    STORE_CLERK(
            new String[]{"Come check out my wares!", "I have the best prices around", "Buying all junk", "Bank sale"},
            null,
            null,
            null),
    CLEANER(
            null,
            null,
            null,
            new String[] {"*Sweep* *Sweep*", "Time for a break!", "I just swept there!"}),
    FISHING_SPOT(
            new String[]{"*blub* *blub*", "*splash*"},
            null,
            null,
            null),
    RATS(
            new String[]{"*scamper* *scamper*"},
            new String[]{"hiss"},
            new String[]{"hissssssssssssss"},
            null),
    MID_SIZED_RODENTS(
            new String[]{"*nibble* *nibble*"},
            new String[]{"squeak!"},
            new String[]{"squeeaak..."},
            null),
    SKELETONS(
            null,
            null,
            new String[]{"*crumbles*"},
            null
    )
    ;

    private final String[] ambientDialogs;
    private final String[] damageDialogs;
    private final String[] deathDialogs;
    private final String[] walkingDialogs;
}