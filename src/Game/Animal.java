public class Animal extends Creature {

    public Animal(String n, String d, Room c, String p) {
        super(n, d, c, p);
    }

    public void stateChange(boolean a) {
        //Animals prefer the room to be clean.
    }

    @Override
    public String toString() {
        return getName() + ", animal, " + getDescription();
    }
    @Override
    public void angryReaction(){
        System.out.println(this.getName()+" growled. ");
        PC.getInstance().alterRespect(-1);
        
        
    }
    @Override
    public void happyReaction(){
        System.out.println(this.getName()+" licked your face. ");
        PC.getInstance().alterRespect(1);
        
    }
}
