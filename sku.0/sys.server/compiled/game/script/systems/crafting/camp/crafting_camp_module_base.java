package script.systems.crafting.camp;

import script.dictionary;
import script.draft_schematic;
import script.library.craftinglib;
import script.obj_id;

public class crafting_camp_module_base extends script.systems.crafting.crafting_base
{
    public crafting_camp_module_base()
    {
    }
    public static final String VERSION = "v1.00.00";
    public void calcAndSetPrototypeProperties(obj_id prototype, draft_schematic.attribute[] itemAttributes, dictionary craftingValuesDictionary) throws InterruptedException
    {
        super.calcAndSetPrototypeProperties(prototype, itemAttributes, craftingValuesDictionary);
    }
    public void calcAndSetPrototypeProperties(obj_id prototype, draft_schematic.attribute[] itemAttributes) throws InterruptedException
    {
        debugServerConsoleMsg(null, "Beginning assembly-phase prototype property setting");
        for (int i = 0; i < itemAttributes.length; ++i)
        {
            if (itemAttributes[i] == null)
            {
                continue;
            }
            if (!calcAndSetPrototypeProperty(prototype, itemAttributes[i]))
            {
                setObjVar(prototype, craftinglib.COMPONENT_ATTRIBUTE_OBJVAR_NAME + "." + (itemAttributes[i].name).getAsciiId(), itemAttributes[i].currentValue);
            }
        }
    }
}
