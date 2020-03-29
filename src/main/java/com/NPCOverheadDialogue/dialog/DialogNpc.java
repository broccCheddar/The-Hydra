package com.NPCOverheadDialogue.dialog;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;

@Getter
public enum DialogNpc
{
    RELDO("Reldo", DialogCategories.LIBRARIAN),
    CLEANER("Cleaner", DialogCategories.CLEANER),
    ROD_FISHING_SPOT("Rod Fishing spot", DialogCategories.FISHING_SPOT),
    FISHING_SPOT("Fishing spot", DialogCategories.FISHING_SPOT),
    RAT("Rat", DialogCategories.RATS),
    GIANT_RAT("Giant rat", DialogCategories.RATS),
    RABBIT("Rabbit", DialogCategories.MID_SIZED_RODENTS),
    SQUIRREL("Squirrel", DialogCategories.MID_SIZED_RODENTS),
    GARGOYLE("Gargoyle", DialogCategories.SKELETONS),
    ;

    private final String npcName;
    private final DialogCategories[] dialogCategories;

    DialogNpc(final String npcName, DialogCategories... dialogCategories)
    {
        this.npcName = npcName;
        this.dialogCategories = dialogCategories;
    }

    private static final Map<String, DialogNpc> NAME_MAP;
    static
    {
        ImmutableMap.Builder<String, DialogNpc> builder = new ImmutableMap.Builder<>();
        for (final DialogNpc n : values())
        {
            builder.put(n.getNpcName().toUpperCase(), n);
        }
        NAME_MAP = builder.build();
    }

    public static boolean isDialogNpc(final String npcName)
    {
        return NAME_MAP.containsKey(npcName.toUpperCase());
    }

    @Nullable
    public static DialogNpc getDialogNpcsByNpcName(final String npcName)
    {
        return NAME_MAP.get(npcName.toUpperCase());
    }

    @Nullable
    public String[] getAmbientDialogs()
    {
        String[] dialogs = new String[0];
        for (final DialogCategories category : dialogCategories)
        {
            if (category.getAmbientDialogs() != null)
            {
                dialogs = ArrayUtils.addAll(dialogs, category.getAmbientDialogs());
            }
        }

        return dialogs.length > 0 ? dialogs : null;
    }

    @Nullable
    public static String[] getAmbientDialogsByNpcName(final String npcName)
    {
        final DialogNpc v = NAME_MAP.get(npcName.toUpperCase());

        if (v == null)
        {
            return null;
        }

        return v.getAmbientDialogs();
    }

    @Nullable
    public String[] getDamageDialogs()
    {
        String[] dialogs = new String[0];
        for (final DialogCategories category : dialogCategories)
        {
            if (category.getDamageDialogs() != null)
            {
                dialogs = ArrayUtils.addAll(dialogs, category.getDamageDialogs());
            }
        }

        return dialogs.length > 0 ? dialogs : null;
    }

    @Nullable
    public static String[] getDamageDialogsByNpcName(final String npcName)
    {
        final DialogNpc v = NAME_MAP.get(npcName.toUpperCase());

        if (v == null)
        {
            return null;
        }

        return v.getDamageDialogs();
    }

    @Nullable
    public String[] getDeathDialogs()
    {
        String[] dialogs = new String[0];
        for (final DialogCategories category : dialogCategories)
        {
            if (category.getDeathDialogs() != null)
            {
                dialogs = ArrayUtils.addAll(dialogs, category.getDeathDialogs());
            }
        }

        return dialogs.length > 0 ? dialogs : null;
    }

    @Nullable
    public static String[] getDeathDialogsByNpcName(final String npcName)
    {
        final DialogNpc v = NAME_MAP.get(npcName.toUpperCase());

        if (v == null)
        {
            return null;
        }

        return v.getDeathDialogs();
    }

    @Nullable
    public String[] getWalkingDialogs()
    {
        String[] dialogs = new String[0];
        for (final DialogCategories category : dialogCategories)
        {
            if (category.getWalkingDialogs() != null)
            {
                dialogs = ArrayUtils.addAll(dialogs, category.getWalkingDialogs());
            }
        }

        return dialogs.length > 0 ? dialogs : null;
    }

    @Nullable
    public static String[] getWalkingDialogsByNpcName(final String npcName)
    {
        final DialogNpc v = NAME_MAP.get(npcName.toUpperCase());

        if (v == null)
        {
            return null;
        }

        return v.getWalkingDialogs();
    }
}