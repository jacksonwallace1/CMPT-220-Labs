
public class Assignment7 {
    public static void main(String[] args) {

        //create a generic enemy and call its functions
        enemy enemy1 = new enemy(6, 2);
        enemy1.attack();

        //create a fire and an ice wizard and call all functions
        wizard fwizard = new wizard(5, 7);
        fwizard.attack();
        fwizard.damageType();

        wizard iwizard = new wizard(5, 7);
        iwizard.attack();
        iwizard.damageType();

        //create a goblin and call its functions
        goblin goblin1 = new goblin(7, 5);
        goblin1.attack();
    }
}
