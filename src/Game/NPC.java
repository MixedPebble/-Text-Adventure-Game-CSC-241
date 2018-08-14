//prefers dirty

public class NPC extends Creature {

    public NPC(String n, String d, Room c, String p) {
        super(n, d, c, p);
    }

    public void stateChange(boolean a) {
        //NPC's prefer the room to be clean.
    }

    @Override
    public String toString() {
        return getName() + ", NPC, " + getDescription();
    }

    @Override
    public void angryReaction() {
        System.out.println(this.getName()+ " grumbled. ");
        PC.getInstance().alterRespect(-1);
        
    }

    @Override
    public void happyReaction() {
        System.out.println(this.getName()+ " smiled. ");
        PC.getInstance().alterRespect(1);
    }
}

