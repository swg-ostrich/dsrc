package script.space.load_test;

import script.dictionary;
import script.library.load_test;
import script.obj_id;

public class load_test_player extends script.base_script
{
    public load_test_player()
    {
    }
    public int OnRemovingFromWorld(obj_id self) throws InterruptedException
    {
        destroyAiShips(self);
        return SCRIPT_CONTINUE;
    }
    public void destroyAiShips(obj_id self) throws InterruptedException
    {
        dictionary d = self.getScriptDictionary();
        if (d != null)
        {
            obj_id[] aiShips = d.getObjIdArray(load_test.VAR_AI_SHIPS);
            if (aiShips != null)
            {
                for (int i = 0; i < aiShips.length; ++i)
                {
                    if (isIdValid(aiShips[i]) && aiShips[i].isLoaded())
                    {
                        destroyObject(aiShips[i]);
                    }
                }
                d.remove(load_test.VAR_AI_SHIPS);
            }
        }
    }
}
