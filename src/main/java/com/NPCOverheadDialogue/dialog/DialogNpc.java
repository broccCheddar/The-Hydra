package com.NPCOverheadDialogue.dialog;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;

@Getter
public enum DialogNpc
{
    HYDRA("Alchemical Hydra", -1 ,DialogCategories.HYDRA),
    ;

    private final String npcName;
    private final int npcID;
    private final DialogCategories[] dialogCategories;

    DialogNpc(final String npcName, final int npcID, DialogCategories... dialogCategories)
    {
        this.npcName = npcName;
        this.npcID = npcID;
        this.dialogCategories = dialogCategories;
    }

    private static final Map<String, DialogNpc> NAME_MAP;
    static
    {
        ImmutableMap.Builder<String, DialogNpc> builder = new ImmutableMap.Builder<>();
        for (final DialogNpc n : values())
        {
            String d;
            if(n.getNpcID() != -1){
                d = Integer.toString(n.getNpcID());
            }
            else{
                d = n.getNpcName().toUpperCase();
            }
            builder.put(d, n);
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
    public static DialogNpc getDialogNpcsByNpcID(final int npcID) {
        //log.info("ID being checked is " + npcID);
        return NAME_MAP.get(Integer.toString(npcID));
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
