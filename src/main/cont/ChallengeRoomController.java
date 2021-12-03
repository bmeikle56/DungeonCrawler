

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ChallengeRoomController extends RoomController {

    @FXML
    private Button forward;
    @FXML
    private Button left;
    @FXML
    private Button right;
    @FXML
    private Button back;

    @FXML
    private Label challengeLabel;




    @FXML
    private Button fight1;
    @FXML
    private ImageView barb1;
    @FXML
    private Label deadLabel1;
    @FXML
    private ProgressBar barbBar1;
    @FXML
    private Label barbValue1;

    @FXML
    private Button fight2;
    @FXML
    private ImageView barb2;
    @FXML
    private Label deadLabel2;
    @FXML
    private ProgressBar barbBar2;
    @FXML
    private Label barbValue2;

    @FXML
    private Button fight3;
    @FXML
    private ImageView barb3;
    @FXML
    private Label deadLabel3;
    @FXML
    private ProgressBar barbBar3;
    @FXML
    private Label barbValue3;




    @FXML
    private Button challenge;
    @FXML
    private Label nameLabel;
    @FXML
    private Label coinAmount;
    @FXML
    private Label strength;
    @FXML
    private ProgressBar healthBar;
    @FXML
    private Label healthValue;



    @FXML
    private Rectangle rec1;
    @FXML
    private Rectangle rec2;
    @FXML
    private Rectangle rec3;
    @FXML
    private Rectangle rec4;
    @FXML
    private Rectangle rec5;





    @FXML
    private ImageView strength1;
    private boolean strength1Vis = false;
    @FXML
    private ImageView axe1;
    private boolean axe1Vis = false;
    @FXML
    private ImageView stick1;
    private boolean stick1Vis = false;
    @FXML
    private ImageView heal1;
    private boolean heal1Vis = false;
    @FXML
    private ImageView mace1;
    private boolean mace1Vis = false;
    @FXML
    private ImageView spoon1;
    private boolean spoon1Vis = false;
    @FXML
    private ImageView sword1;
    private boolean sword1Vis = false;
    @FXML
    private ImageView crossbow1;
    private boolean crossbow1Vis = false;
    @FXML
    private ImageView dagger1;
    private boolean dagger1Vis = false;







    @FXML
    private ImageView strength2;
    private boolean strength2Vis = false;
    @FXML
    private ImageView axe2;
    private boolean axe2Vis = false;
    @FXML
    private ImageView stick2;
    private boolean stick2Vis = false;
    @FXML
    private ImageView heal2;
    private boolean heal2Vis = false;
    @FXML
    private ImageView mace2;
    private boolean mace2Vis = false;
    @FXML
    private ImageView spoon2;
    private boolean spoon2Vis = false;
    @FXML
    private ImageView sword2;
    private boolean sword2Vis = false;
    @FXML
    private ImageView crossbow2;
    private boolean crossbow2Vis = false;
    @FXML
    private ImageView dagger2;
    private boolean dagger2Vis = false;







    @FXML
    private ImageView strength3;
    private boolean strength3Vis = false;
    @FXML
    private ImageView axe3;
    private boolean axe3Vis = false;
    @FXML
    private ImageView stick3;
    private boolean stick3Vis = false;
    @FXML
    private ImageView heal3;
    private boolean heal3Vis = false;
    @FXML
    private ImageView mace3;
    private boolean mace3Vis = false;
    @FXML
    private ImageView spoon3;
    private boolean spoon3Vis = false;
    @FXML
    private ImageView sword3;
    private boolean sword3Vis = false;
    @FXML
    private ImageView crossbow3;
    private boolean crossbow3Vis = false;
    @FXML
    private ImageView dagger3;
    private boolean dagger3Vis = false;







    @FXML
    private ImageView strength4;
    private boolean strength4Vis = false;
    @FXML
    private ImageView axe4;
    private boolean axe4Vis = false;
    @FXML
    private ImageView stick4;
    private boolean stick4Vis = false;
    @FXML
    private ImageView heal4;
    private boolean heal4Vis = false;
    @FXML
    private ImageView mace4;
    private boolean mace4Vis = false;
    @FXML
    private ImageView spoon4;
    private boolean spoon4Vis = false;
    @FXML
    private ImageView sword4;
    private boolean sword4Vis = false;
    @FXML
    private ImageView crossbow4;
    private boolean crossbow4Vis = false;
    @FXML
    private ImageView dagger4;
    private boolean dagger4Vis = false;



    @FXML
    private ImageView strength5;
    private boolean strength5Vis = false;
    @FXML
    private ImageView axe5;
    private boolean axe5Vis = false;
    @FXML
    private ImageView stick5;
    private boolean stick5Vis = false;
    @FXML
    private ImageView heal5;
    private boolean heal5Vis = false;
    @FXML
    private ImageView mace5;
    private boolean mace5Vis = false;
    @FXML
    private ImageView spoon5;
    private boolean spoon5Vis = false;
    @FXML
    private ImageView sword5;
    private boolean sword5Vis = false;
    @FXML
    private ImageView crossbow5;
    private boolean crossbow5Vis = false;
    @FXML
    private ImageView dagger5;
    private boolean dagger5Vis = false;


    public void setAllWhite() {
        rec1.setFill(Color.WHITE);
        rec2.setFill(Color.WHITE);
        rec3.setFill(Color.WHITE);
        rec4.setFill(Color.WHITE);
        rec5.setFill(Color.WHITE);
    }

    public void fillGray(int i) {
        if (i == 1) {
            rec1.setFill(Color.GRAY);
            rec2.setFill(Color.WHITE);
            rec3.setFill(Color.WHITE);
            rec4.setFill(Color.WHITE);
            rec5.setFill(Color.WHITE);
        } else if (i == 2) {
            rec2.setFill(Color.GRAY);
            rec1.setFill(Color.WHITE);
            rec3.setFill(Color.WHITE);
            rec4.setFill(Color.WHITE);
            rec5.setFill(Color.WHITE);
        } else if (i == 3) {
            rec3.setFill(Color.GRAY);
            rec2.setFill(Color.WHITE);
            rec1.setFill(Color.WHITE);
            rec4.setFill(Color.WHITE);
            rec5.setFill(Color.WHITE);
        } else if (i == 4) {
            rec4.setFill(Color.GRAY);
            rec2.setFill(Color.WHITE);
            rec3.setFill(Color.WHITE);
            rec1.setFill(Color.WHITE);
            rec5.setFill(Color.WHITE);
        } else if (i == 5) {
            rec5.setFill(Color.GRAY);
            rec2.setFill(Color.WHITE);
            rec3.setFill(Color.WHITE);
            rec4.setFill(Color.WHITE);
            rec1.setFill(Color.WHITE);
        } else {
            setAllWhite();
        }
    }

    public void checkSelectedWeapon(Weapon w, int i) {
        if (!Player.hasSelectedWeapon()) {
            Player.setSelectedWeaponIndex(i);
            Player.setWeapon(w);
            fillGray(i);
        } else {
            Player.setSelectedWeaponIndex(-1);
            Player.setWeapon(null);
            setAllWhite();
        }
        showStrength(Player.getStrength());
    }


    public void clickDagger1(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Dagger"), 1);
    }
    public void clickDagger2(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Dagger"), 2);
    }
    public void clickDagger3(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Dagger"), 3);
    }
    public void clickDagger4(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Dagger"), 4);
    }
    public void clickDagger5(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Dagger"), 5);
    }



    public void clickCrossbow1(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Crossbow"), 1);
    }
    public void clickCrossbow2(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Crossbow"), 2);
    }
    public void clickCrossbow3(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Crossbow"), 3);
    }
    public void clickCrossbow4(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Crossbow"), 4);
    }
    public void clickCrossbow5(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Crossbow"), 5);
    }




    public void clickSword1(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Sword"), 1);
    }
    public void clickSword2(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Sword"), 2);
    }
    public void clickSword3(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Sword"), 3);
    }
    public void clickSword4(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Sword"), 4);
    }
    public void clickSword5(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Sword"), 5);
    }


    public void clickStick1(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Stick"), 1);
    }
    public void clickStick2(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Stick"), 2);
    }
    public void clickStick3(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Stick"), 3);
    }
    public void clickStick4(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Stick"), 4);
    }
    public void clickStick5(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Stick"), 5);
    }



    public void clickSpoon1(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Spoon"), 1);
    }
    public void clickSpoon2(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Spoon"), 2);
    }
    public void clickSpoon3(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Spoon"), 3);
    }
    public void clickSpoon4(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Spoon"), 4);
    }
    public void clickSpoon5(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Spoon"), 5);
    }



    public void clickMace1(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Mace"), 1);
    }
    public void clickMace2(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Mace"), 2);
    }
    public void clickMace3(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Mace"), 3);
    }
    public void clickMace4(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Mace"), 4);
    }
    public void clickMace5(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Mace"), 5);
    }



    public void clickAxe1(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Axe"), 1);
    }
    public void clickAxe2(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Axe"), 2);
    }
    public void clickAxe3(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Axe"), 3);
    }
    public void clickAxe4(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Axe"), 4);
    }
    public void clickAxe5(MouseEvent mouseEvent) {
        checkSelectedWeapon(new Weapon("Axe"), 5);
    }

    public void clickHeal1(MouseEvent mouseEvent) {
        if (Player.getHealth() == 1) {
            throw new FullHealthException("You already have full health!");
        }
        Player.setHealth(1);
        heal1.setVisible(!heal1Vis);
        Inventory.remove(0);
        showInventory();
        showHealthBar(Player.getHealth());
        showHealthValue((int) (100 * Player.getHealth()));
    }
    public void clickHeal2(MouseEvent mouseEvent) {
        if (Player.getHealth() == 1) {
            throw new FullHealthException("You already have full health!");
        }
        Player.setHealth(1);
        heal2.setVisible(!heal2Vis);
        Inventory.remove(1);
        showInventory();
        showHealthBar(Player.getHealth());
        showHealthValue((int) (100 * Player.getHealth()));
    }
    public void clickHeal3(MouseEvent mouseEvent) {
        if (Player.getHealth() == 1) {
            throw new FullHealthException("You already have full health!");
        }
        Player.setHealth(1);
        heal3.setVisible(!heal3Vis);
        Inventory.remove(2);
        showInventory();
        showHealthBar(Player.getHealth());
        showHealthValue((int) (100 * Player.getHealth()));
    }
    public void clickHeal4(MouseEvent mouseEvent) {
        if (Player.getHealth() == 1) {
            throw new FullHealthException("You already have full health!");
        }
        Player.setHealth(1);
        heal4.setVisible(!heal4Vis);
        Inventory.remove(3);
        showInventory();
        showHealthBar(Player.getHealth());
        showHealthValue((int) (100 * Player.getHealth()));
    }
    public void clickHeal5(MouseEvent mouseEvent) {
        if (Player.getHealth() == 1) {
            throw new FullHealthException("You already have full health!");
        }
        Player.setHealth(1);
        heal5.setVisible(!heal5Vis);
        Inventory.remove(4);
        showInventory();
        showHealthBar(Player.getHealth());
        showHealthValue((int) (100 * Player.getHealth()));
    }



    public void clickStrength1(MouseEvent mouseEvent) {
        Player.setStrength(Player.getStrength() + Player.getStrength() * 0.1);
        strength1.setVisible(!strength1Vis);
        Inventory.remove(0);
        showInventory();
        showStrength(Player.getStrength());
    }
    public void clickStrength2(MouseEvent mouseEvent) {
        Player.setStrength(Player.getStrength() + Player.getStrength() * 0.1);
        strength2.setVisible(!strength2Vis);
        Inventory.remove(1);
        showInventory();
        showStrength(Player.getStrength());
    }
    public void clickStrength3(MouseEvent mouseEvent) {
        Player.setStrength(Player.getStrength() + Player.getStrength() * 0.1);
        strength3.setVisible(!strength3Vis);
        Inventory.remove(2);
        showInventory();
        showStrength(Player.getStrength());
    }
    public void clickStrength4(MouseEvent mouseEvent) {
        Player.setStrength(Player.getStrength() + Player.getStrength() * 0.1);
        strength4.setVisible(!strength4Vis);
        Inventory.remove(3);
        showInventory();
        showStrength(Player.getStrength());
    }
    public void clickStrength5(MouseEvent mouseEvent) {
        Player.setStrength(Player.getStrength() + Player.getStrength() * 0.1);
        strength5.setVisible(!strength5Vis);
        Inventory.remove(4);
        showInventory();
        showStrength(Player.getStrength());
    }


    public void showInventory() {
        ArrayList<String> inventory = new ArrayList<>(5);
        for (Lootable loot: Inventory.getItems()) {
            inventory.add(loot.getName());
        }

        if (inventory.get(0).equals("Sword")) {
            sword1Vis = true;
        } else if (inventory.get(0).equals("Axe")) {
            axe1Vis = true;
        } else if (inventory.get(0).equals("Stick")) {
            stick1Vis = true;
        } else if (inventory.get(0).equals("Crossbow")) {
            crossbow1Vis = true;
        } else if (inventory.get(0).equals("Spoon")) {
            spoon1Vis = true;
        } else if (inventory.get(0).equals("Dagger")) {
            dagger1Vis = true;
        } else if (inventory.get(0).equals("Health Potion")) {
            heal1Vis = true;
        } else if (inventory.get(0).equals("Strength Potion")) {
            strength1Vis = true;
        } else if (inventory.get(0).equals("Mace")) {
            mace1Vis = true;
        }

        if (inventory.size() > 1) {

            if (inventory.get(1).equals("Sword")) {
                sword2Vis = true;
            } else if (inventory.get(1).equals("Axe")) {
                axe2Vis = true;
            } else if (inventory.get(1).equals("Stick")) {
                stick2Vis = true;
            } else if (inventory.get(1).equals("Crossbow")) {
                crossbow2Vis = true;
            } else if (inventory.get(1).equals("Spoon")) {
                spoon2Vis = true;
            } else if (inventory.get(1).equals("Dagger")) {
                dagger2Vis = true;
            } else if (inventory.get(1).equals("Health Potion")) {
                heal2Vis = true;
            } else if (inventory.get(1).equals("Strength Potion")) {
                strength2Vis = true;
            } else if (inventory.get(1).equals("Mace")) {
                mace2Vis = true;
            }
        }

        if (inventory.size() > 2) {

            if (inventory.get(2).equals("Sword")) {
                sword3Vis = true;
            } else if (inventory.get(2).equals("Axe")) {
                axe3Vis = true;
            } else if (inventory.get(2).equals("Stick")) {
                stick3Vis = true;
            } else if (inventory.get(2).equals("Crossbow")) {
                crossbow3Vis = true;
            } else if (inventory.get(2).equals("Spoon")) {
                spoon3Vis = true;
            } else if (inventory.get(2).equals("Dagger")) {
                dagger3Vis = true;
            } else if (inventory.get(2).equals("Health Potion")) {
                heal3Vis = true;
            } else if (inventory.get(2).equals("Strength Potion")) {
                strength3Vis = true;
            } else if (inventory.get(2).equals("Mace")) {
                mace3Vis = true;
            }
        }

        if (inventory.size() > 3) {

            if (inventory.get(3).equals("Sword")) {
                sword4Vis = true;
            } else if (inventory.get(3).equals("Axe")) {
                axe4Vis = true;
            } else if (inventory.get(3).equals("Stick")) {
                stick4Vis = true;
            } else if (inventory.get(3).equals("Crossbow")) {
                crossbow4Vis = true;
            } else if (inventory.get(3).equals("Spoon")) {
                spoon4Vis = true;
            } else if (inventory.get(3).equals("Dagger")) {
                dagger4Vis = true;
            } else if (inventory.get(3).equals("Health Potion")) {
                heal4Vis = true;
            } else if (inventory.get(3).equals("Strength Potion")) {
                strength4Vis = true;
            } else if (inventory.get(3).equals("Mace")) {
                mace4Vis = true;
            }
        }

        if (inventory.size() > 4) {

            if (inventory.get(4).equals("Sword")) {
                sword5Vis = true;
            } else if (inventory.get(4).equals("Axe")) {
                axe5Vis = true;
            } else if (inventory.get(4).equals("Stick")) {
                stick5Vis = true;
            } else if (inventory.get(4).equals("Crossbow")) {
                crossbow5Vis = true;
            } else if (inventory.get(4).equals("Spoon")) {
                spoon5Vis = true;
            } else if (inventory.get(4).equals("Dagger")) {
                dagger5Vis = true;
            } else if (inventory.get(4).equals("Health Potion")) {
                heal5Vis = true;
            } else if (inventory.get(4).equals("Strength Potion")) {
                strength5Vis = true;
            } else if (inventory.get(4).equals("Mace")) {
                mace5Vis = true;
            }
        }
    }




    public void setProperVis() {
        dagger1.setVisible(dagger1Vis);
        crossbow1.setVisible(crossbow1Vis);
        sword1.setVisible(sword1Vis);
        spoon1.setVisible(spoon1Vis);
        mace1.setVisible(mace1Vis);
        heal1.setVisible(heal1Vis);
        stick1.setVisible(stick1Vis);
        axe1.setVisible(axe1Vis);
        strength1.setVisible(strength1Vis);


        dagger2.setVisible(dagger2Vis);
        crossbow2.setVisible(crossbow2Vis);
        sword2.setVisible(sword2Vis);
        spoon2.setVisible(spoon2Vis);
        mace2.setVisible(mace2Vis);
        heal2.setVisible(heal2Vis);
        stick2.setVisible(stick2Vis);
        axe2.setVisible(axe2Vis);
        strength2.setVisible(strength2Vis);


        dagger3.setVisible(dagger3Vis);
        crossbow3.setVisible(crossbow3Vis);
        sword3.setVisible(sword3Vis);
        spoon3.setVisible(spoon3Vis);
        mace3.setVisible(mace3Vis);
        heal3.setVisible(heal3Vis);
        stick3.setVisible(stick3Vis);
        axe3.setVisible(axe3Vis);
        strength3.setVisible(strength3Vis);



        dagger4.setVisible(dagger4Vis);
        crossbow4.setVisible(crossbow4Vis);
        sword4.setVisible(sword4Vis);
        spoon4.setVisible(spoon4Vis);
        mace4.setVisible(mace4Vis);
        heal4.setVisible(heal4Vis);
        stick4.setVisible(stick4Vis);
        axe4.setVisible(axe4Vis);
        strength4.setVisible(strength4Vis);




        dagger5.setVisible(dagger5Vis);
        crossbow5.setVisible(crossbow5Vis);
        sword5.setVisible(sword5Vis);
        spoon5.setVisible(spoon5Vis);
        mace5.setVisible(mace5Vis);
        heal5.setVisible(heal5Vis);
        stick5.setVisible(stick5Vis);
        axe5.setVisible(axe5Vis);
        strength5.setVisible(strength5Vis);
    }

    @Override
    public void clickForward(MouseEvent mouseEvent) throws IOException {
        Dungeon.setRow(Dungeon.getRow() - 1);
        super.clickForward(mouseEvent);
        setProperVis();
    }

    @Override
    public void clickRight(MouseEvent mouseEvent) throws IOException {
        Dungeon.setCol(Dungeon.getCol() + 1);
        super.clickRight(mouseEvent);
        setProperVis();
    }

    @Override
    public void clickBack(MouseEvent mouseEvent) throws IOException {
        Dungeon.setRow(Dungeon.getRow() + 1);
        super.clickBack(mouseEvent);
        setProperVis();
    }

    @Override
    public void clickLeft(MouseEvent mouseEvent) throws IOException {
        Dungeon.setCol(Dungeon.getCol() - 1);
        super.clickLeft(mouseEvent);
        setProperVis();
    }

    @Override
    public void showName(String name) {
        nameLabel.setText(name);
    }

    @Override
    public void showCoins(double coins) {
        coinAmount.setText("$" + (int) coins);
    }

    @Override
    public void showHealthBar(double health) {
        healthBar.setProgress(health);
    }


    public void showBarbBar1(double health) {
        barbBar1.setProgress(health);
    }
    public void showBarbBar2(double health) {
        barbBar2.setProgress(health);
    }
    public void showBarbBar3(double health) {
        barbBar3.setProgress(health);
    }

    public void showBarbValue1(int health) {
        barbValue1.setText(String.valueOf(health));
    }
    public void showBarbValue2(int health) {
        barbValue2.setText(String.valueOf(health));
    }
    public void showBarbValue3(int health) {
        barbValue3.setText(String.valueOf(health));
    }


    @Override
    public void showHealthValue(int health) {
        healthValue.setText(String.valueOf(health));
    }

    @Override
    public void showStrength(double str) {
        strength.setText("" + (int) (Player.round(Player.getStrength(), 2) * 100));
    }

    @Override
    public void checkLocation() {
        if (Dungeon.getRow() == 0) {
            forward.setVisible(false);
        } else {
            forward.setVisible(true);
        }

        if (Dungeon.getCol() == 12) {
            right.setVisible(false);
        } else {
            right.setVisible(true);
        }

        if (Dungeon.getRow() == 12) {
            back.setVisible(false);
        } else {
            back.setVisible(true);
        }

        if (Dungeon.getCol() == 0) {
            left.setVisible(false);
        } else {
            left.setVisible(true);
        }
    }

    @Override
    protected void checkMonsterStatus() {
        checkAllMonsterStatus();
    }

    private void checkAllMonsterStatus() {
        ChallengeRoom room = (ChallengeRoom) Dungeon.getRoom();
        Barbarian barb1 = room.getB1();
        Barbarian barb2 = room.getB2();
        Barbarian barb3 = room.getB3();
        if (barb1.isDead()) {
            fight1.setVisible(false);
            deadLabel1.setText("You killed the monster!");
            barbBar1.setVisible(false);
            barbValue1.setVisible(false);
            /*Image image = new Image(getClass().getResourceAsStream("monsterImgs/deadMinion.png"));
            minionMonster.setFitHeight(150);
            minionMonster.setFitWidth(200);
            minionMonster.setImage(image);*/
        }
        if (barb2.isDead()) {
            fight2.setVisible(false);
            deadLabel2.setText("You killed the monster!");
            barbBar2.setVisible(false);
            barbValue2.setVisible(false);
            /*Image image = new Image(getClass().getResourceAsStream("monsterImgs/deadMinion.png"));
            minionMonster.setFitHeight(150);
            minionMonster.setFitWidth(200);
            minionMonster.setImage(image);*/
        }
        if (barb3.isDead()) {
            fight3.setVisible(false);
            deadLabel3.setText("You killed the monster!");
            barbBar3.setVisible(false);
            barbValue3.setVisible(false);
            /*Image image = new Image(getClass().getResourceAsStream("monsterImgs/deadMinion.png"));
            minionMonster.setFitHeight(150);
            minionMonster.setFitWidth(200);
            minionMonster.setImage(image);*/
        }

        if (barb1.isDead() && barb2.isDead() && barb3.isDead()) {
            checkLocation();
            hideChallengeStuff();
            showDeadMonsterStuff();
        }
    }

    private void showDeadMonsterStuff() {
        barb1.setVisible(true);
        deadLabel1.setVisible(true);


        barb2.setVisible(true);
        deadLabel2.setVisible(true);

        barb3.setVisible(true);
        deadLabel3.setVisible(true);
    }

    private void setButtons(boolean b) {
        left.setVisible(b);
        right.setVisible(b);
        forward.setVisible(b);
        back.setVisible(b);
    }

    private void hideChallengeStuff() {
        challenge.setVisible(false);
        challengeLabel.setText("");
        challengeLabel.setVisible(false);
    }

    private void showMonsters() {
        fight1.setVisible(true);
        barb1.setVisible(true);
        deadLabel1.setVisible(true);
        barbBar1.setVisible(true);
        barbValue1.setVisible(true);

        fight2.setVisible(true);
        barb2.setVisible(true);
        deadLabel2.setVisible(true);
        barbBar2.setVisible(true);
        barbValue2.setVisible(true);

        fight3.setVisible(true);
        barb3.setVisible(true);
        deadLabel3.setVisible(true);
        barbBar3.setVisible(true);
        barbValue3.setVisible(true);
    }

    public void clickChallenge() {
        setButtons(false);
        hideChallengeStuff();
        showMonsters();
    }

    public void clickFight1(MouseEvent mouseEvent) throws IOException {
        Room room = Dungeon.getRoom();
        Barbarian barb = ((ChallengeRoom) room).getB1();
        Player.attack(barb);
        barb.attack();
        deadLabel1.setText("You got attacked!");

        if (Player.isDead()) {
            System.out.println("You died!");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Lose.fxml"));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }

        if (barb.isDead()) {
            fight1.setVisible(false);
            barbBar1.setVisible(false);
            barbValue1.setVisible(false);
            checkMonsterStatus();
            Image image = new Image(getClass().getResourceAsStream("monsterImgs/deadMinion.png"));
            /*minionMonster.setFitHeight(150);
            minionMonster.setFitWidth(200);
            minionMonster.setImage(image);*/

            areAllMonstersDead();
        }

        showHealthBar(Player.getHealth());
        showStrength(Player.getStrength());
        showHealthValue((int) (Player.round(Player.getHealth(), 2) * 100));
        showBarbBar1(barb.getHealth());
        showBarbValue1((int) (Player.round(barb.getHealth(), 2) * 100));
    }

    public void clickFight2(MouseEvent mouseEvent) throws IOException {
        Room room = Dungeon.getRoom();
        Barbarian barb = ((ChallengeRoom) room).getB2();
        Player.attack(barb);
        barb.attack();
        deadLabel2.setText("You got attacked!");

        if (Player.isDead()) {
            System.out.println("You died!");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Lose.fxml"));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }

        if (barb.isDead()) {
            fight2.setVisible(false);
            barbBar2.setVisible(false);
            barbValue2.setVisible(false);
            checkMonsterStatus();
            Image image = new Image(getClass().getResourceAsStream("monsterImgs/deadMinion.png"));
            /*minionMonster.setFitHeight(150);
            minionMonster.setFitWidth(200);
            minionMonster.setImage(image);*/

            areAllMonstersDead();
        }

        showHealthBar(Player.getHealth());
        showStrength(Player.getStrength());
        showHealthValue((int) (Player.round(Player.getHealth(), 2) * 100));
        showBarbBar2(barb.getHealth());
        showBarbValue2((int) (Player.round(barb.getHealth(), 2) * 100));
    }

    public void clickFight3(MouseEvent mouseEvent) throws IOException {
        Room room = Dungeon.getRoom();
        Barbarian barb = ((ChallengeRoom) room).getB3();
        Player.attack(barb);
        barb.attack();
        deadLabel3.setText("You got attacked!");

        if (Player.isDead()) {
            System.out.println("You died!");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Lose.fxml"));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }

        if (barb.isDead()) {
            fight3.setVisible(false);
            barbBar3.setVisible(false);
            barbValue3.setVisible(false);
            checkMonsterStatus();
            Image image = new Image(getClass().getResourceAsStream("monsterImgs/deadMinion.png"));
            /*minionMonster.setFitHeight(150);
            minionMonster.setFitWidth(200);
            minionMonster.setImage(image);*/

            areAllMonstersDead();
        }

        showHealthBar(Player.getHealth());
        showStrength(Player.getStrength());
        showHealthValue((int) (Player.round(Player.getHealth(), 2) * 100));
        showBarbBar3(barb.getHealth());
        showBarbValue3((int) (Player.round(barb.getHealth(), 2) * 100));
    }

    public void hideMonsters() {
        fight1.setVisible(false);
        barb1.setVisible(false);
        deadLabel1.setVisible(false);
        barbBar1.setVisible(false);
        barbValue1.setVisible(false);

        fight2.setVisible(false);
        barb2.setVisible(false);
        deadLabel2.setVisible(false);
        barbBar2.setVisible(false);
        barbValue2.setVisible(false);

        fight3.setVisible(false);
        barb3.setVisible(false);
        deadLabel3.setVisible(false);
        barbBar3.setVisible(false);
        barbValue3.setVisible(false);
    }

    public void areAllMonstersDead() {
        ChallengeRoom challengeRoom = (ChallengeRoom) Dungeon.getRoom();
        if (challengeRoom.getB1().isDead() && challengeRoom.getB2().isDead()
            && challengeRoom.getB3().isDead()) {
            setButtons(true);
            if (Inventory.size() < Inventory.MAX_SIZE) {
                Inventory.add(new Weapon("Mace"));
            }
            if (Inventory.size() < Inventory.MAX_SIZE) {
                Inventory.add(new Potion("Strength", "Add", 0.1 * Player.getHealth()));
            }
            if (Inventory.size() < Inventory.MAX_SIZE) {
                Inventory.add(new Potion("Health", "Add", 1.0 - Player.getHealth()));
            }
            showInventory();
            setProperVis();
            fillGray(Player.selectedWeaponIndex());
        }
    }
}
