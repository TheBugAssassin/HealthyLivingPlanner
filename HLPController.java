package HealthyLivingPlanner;

import javax.swing.*;
import java.awt.event.*;

public class HLPController extends JFrame implements ActionListener{
    private HLPView MAINView;
    private HLPModel MAINModel;
    private LaunchGUIView LGUIView;
    private RegisterGUIView RGUIView;
    private MainGUIView MGUIView;
    private JButton Enter;
    private JButton Register;
    private JMenuItem Information;
    private JMenuItem Logout;
    private JMenuItem Name;
    private JMenuItem Password;
    private JMenuItem Age;
    private JMenuItem Height;
    private JMenuItem Weight;
    private JMenuItem Breakfast;
    private JMenuItem Lunch;
    private JMenuItem Dinner;
    private JMenuItem Light;
    private JMenuItem Moderate;
    private JMenuItem Intense;
    private JButton Create;
    private JButton Cancel;
    private User currentUser;
    private int indexValue;
    public HLPController() {
        MAINView = new HLPView();
        MAINModel = new HLPModel();
        LGUIView = new LaunchGUIView();
        RGUIView = new RegisterGUIView();
        MGUIView = new MainGUIView();
        Enter = LGUIView.getEnter();
        Register = LGUIView.getRegister();
        Information = MGUIView.getInformationMenuItem();
        Logout = MGUIView.getLogoutMenuItem();
        Name = MGUIView.getNameMenuItem();
        Password = MGUIView.getPasswordMenuItem();
        Age = MGUIView.getAgeMenuItem();
        Height = MGUIView.getHeightMenuItem();
        Weight = MGUIView.getWeightMenuItem();
        Breakfast = MGUIView.getBreakfastMenuItem();
        Lunch = MGUIView.getLunchMenuItem();
        Dinner = MGUIView.getDinnerMenuItem();
        Light = MGUIView.getLightMenuItem();
        Moderate = MGUIView.getModerateMenuItem();
        Intense = MGUIView.getIntenseMenuItem();
        Create = RGUIView.getCreate();
        Cancel = RGUIView.getCancel();
        try {
            Enter.addActionListener(this);
            Register.addActionListener(this);
            Information.addActionListener(this);
            Logout.addActionListener(this);
            Name.addActionListener(this);
            Password.addActionListener(this);
            Age.addActionListener(this);
            Height.addActionListener(this);
            Weight.addActionListener(this);
            Breakfast.addActionListener(this);
            Lunch.addActionListener(this); 
            Dinner.addActionListener(this);
            Light.addActionListener(this);
            Moderate.addActionListener(this); 
            Intense.addActionListener(this);
            Create.addActionListener(this);
            Cancel.addActionListener(this);
        }
        catch (NullPointerException p) {}
    }
  
    public void actionPerformed(ActionEvent vev)
    {
        
        if(vev.getSource() == Enter) {
            LGUIView.setMessage("");
            LGUIView.setBackTextBoxNameDefaultLog();
            LGUIView.setBackTextBoxPasswordDefaultLog();
            String NameInputString = LGUIView.getNameLogInput();
            String PasswordInputString = LGUIView.getPasswordLogInput();
            indexValue = MAINModel.searchUserExists(NameInputString, PasswordInputString);
            if (indexValue > -1) {
                currentUser = MAINModel.getUser(indexValue);
                LGUIView.setNameLogInput("");
                LGUIView.setPasswordLogInput("");
                MGUIView.setVisible(true);
                LGUIView.setVisible(false);
                MAINModel.setCurrentUserLoggedIn(currentUser);
                MGUIView.setTargetIntake(MAINModel.getTargetIntake());
                MGUIView.setBMI(MAINModel.getBMI());
                MGUIView.setWaterIntake(MAINModel.getWaterIntake());
                MGUIView.setTotalIntake("0");
                MGUIView.setTotalCaloricIntake("0");
                MGUIView.setTotalExcersize("0");
                MGUIView.setBreakfast("0");
                MGUIView.setLunch("0");
                MGUIView.setDinner("0");
                MGUIView.setLight("0");
                MGUIView.setModerate("0");
                MGUIView.setIntense("0");
                MAINModel.clearAll();
            }
            else {
                LGUIView.setMessage("Invalid Credentials");
                if (MAINModel.searchNameExists(NameInputString) == false) {LGUIView.setBackTextBoxNameLog();}
                if (MAINModel.searchPasswordExists(PasswordInputString) == false) {LGUIView.setBackTextBoxPasswordLog();}
            }
            MAINModel.clearArray();
        }
        else if(vev.getSource() == Register) {
            LGUIView.setMessage("");
            LGUIView.setNameLogInput("");
            LGUIView.setPasswordLogInput("");
            LGUIView.setBackTextBoxNameDefaultLog();
            LGUIView.setBackTextBoxPasswordDefaultLog();
            RGUIView.setBoxInputName("Frank");
            RGUIView.setBoxInputPassword("Raco");
            RGUIView.setBoxInputAge("51");
            RGUIView.setBoxInputGender("M");
            RGUIView.setBoxInputHeight("165");
            RGUIView.setBoxInputWeight("95");
            RGUIView.setVisible(true);
            LGUIView.setVisible(false);
        }
        else if (vev.getSource() == Create) {
            RGUIView.setMessagee("");
            RGUIView.setBackTextBoxPasswordDefault();
            RGUIView.setBackTextBoxNameDefault();
            RGUIView.setBackTextBoxAgeDefault();
            RGUIView.setBackTextBoxGenderDefault();
            RGUIView.setBackTextBoxHeightDefault();
            RGUIView.setBackTextBoxWeightDefault();
            boolean check1 = false;
            boolean check2 = false;
            boolean check3 = false;
            boolean check4 = false;
            boolean check5 = false;
            boolean check6 = false;
            boolean checkFinal = false;
            String newName = RGUIView.getNameInput();
            if (newName.isEmpty() == false) {check1 = true;}
            else {RGUIView.setBackTextBoxName(); RGUIView.setMessagee("Name Field Empty");}
            String newPassword = RGUIView.getPasswordInput();
            if (checkPassword(newPassword) == true && newPassword.isEmpty() == false  && newPassword.length() >= 6 && newPassword.length() <= 12) {
                check2 = true;
            }
            else {RGUIView.setBackTextBoxPassword(); RGUIView.setMessagee("Password Must Consist Exclusively of Letters and/or Numbers (6 - 12 Characters Long)");}
            String newAge = RGUIView.getAgeInput();
            if (checkNumber(newAge) == true) {check3 = true;}
            else {RGUIView.setBackTextBoxAge(); RGUIView.setMessagee("Age Field Must be Positive Number");}
            String newGender = RGUIView.getGenderInput();
            if (checkGender(newGender) == true) {check4 = true;}
            else {RGUIView.setBackTextBoxGender(); RGUIView.setMessagee("Gender Field Must be 'm', 'f', 'M', or 'F'");}
            String newHeight = RGUIView.getHeightInput();
            if (checkNumber(newHeight) == true) {check5 = true;}
            else {RGUIView.setBackTextBoxHeight(); RGUIView.setMessagee("Height Field Must be Positive Number");}
            String newWeight = RGUIView.getWeightInput();
            if (checkNumber(newWeight) == true) {check6 = true;}
            else {RGUIView.setBackTextBoxWeight(); RGUIView.setMessagee("Weight Field Must be Positive Number");}
            checkFinal = check1 && check2 && check3 && check4 && check5 && check6;
            if (checkFinal == true) {
                LGUIView.setVisible(true);
                RGUIView.setVisible(false);
                double newA = Double.parseDouble(newAge);
                char newGen = newGender.charAt(0);
                double newH = Double.parseDouble(newHeight);
                double newW = Double.parseDouble(newWeight);
                User nU = new User(newName, newPassword, newA, newGen, newH, newW);
                MAINModel.addUser(nU);
                LGUIView.JMessage("Account Creation Successful");
            }
        }
        else if (vev.getSource() == Cancel) {
            RGUIView.setMessagee("");
            RGUIView.setBackTextBoxPasswordDefault();
            RGUIView.setBackTextBoxNameDefault();
            RGUIView.setBackTextBoxAgeDefault();
            RGUIView.setBackTextBoxGenderDefault();
            RGUIView.setBackTextBoxHeightDefault();
            RGUIView.setBackTextBoxWeightDefault();
            LGUIView.setVisible(true);
            RGUIView.setVisible(false);
        }
        else if (vev.getSource() == Information) {
            MGUIView.JMessage("Name,Password,Age,Gender,Height,Weight\n\n" + currentUser.toString());
            MGUIView.JMessage("BMI Chart\nUnderweight = <18.5\nHealthy Weight = 18.5 - 25\nOverweight = 25 - 30\nObese = >30");
        }
        else if (vev.getSource() == Logout) {
            LGUIView.setVisible(true);
            MGUIView.setVisible(false);
        }
        else if (vev.getSource() == Name) {
            String newNameCurrentUser;
            newNameCurrentUser = MGUIView.JInput("Change Name:\n(" + currentUser.getName() + ")");
            MAINModel.loadPeople();
            int indexValueTempN = MAINModel.getUserLength() - 1;
            MAINModel.deleteFileContents();
            MAINModel.removeUserArray(indexValue);
            currentUser.setName(newNameCurrentUser);
            String st = currentUser.getPassword();
            MAINModel.addUser(currentUser);
            currentUser.setPassword(st);
            indexValue = indexValueTempN;
        }
        else if (vev.getSource() == Password) {
            String newPasswordCurrentUser;
            newPasswordCurrentUser = MGUIView.JInput("Change Password:\n(" + currentUser.getPassword() + ")");
            if (checkPassword(newPasswordCurrentUser) == true && newPasswordCurrentUser.length() >= 6 && newPasswordCurrentUser.length() <= 12) {
                MAINModel.loadPeople();
                int indexValueTempP = MAINModel.getUserLength() - 1;
                MAINModel.deleteFileContents();
                MAINModel.removeUserArray(indexValue);
                currentUser.setPassword(newPasswordCurrentUser);
                MAINModel.addUser(currentUser);
                currentUser.setPassword(newPasswordCurrentUser);
                indexValue = indexValueTempP;
            }
            else {MGUIView.JMessage("Password Must Consist Exclusively of Letters and/or Numbers (6 - 12 Characters Long)");}
        }
        else if (vev.getSource() == Age) {
            String newAgeCurrentUser;
            newAgeCurrentUser = MGUIView.JInput("Change Age:\n(" + currentUser.getAge() + ")");
            if (checkNumber(newAgeCurrentUser) == true && newAgeCurrentUser.length() > 0) {
                double newAgeCurrentUserDouble = Double.parseDouble(newAgeCurrentUser);
                MAINModel.loadPeople();
                int indexValueTempA = MAINModel.getUserLength() - 1;
                MAINModel.deleteFileContents();
                MAINModel.removeUserArray(indexValue);
                currentUser.setAge(newAgeCurrentUserDouble);
                String st = currentUser.getPassword();
                MAINModel.addUser(currentUser);
                currentUser.setPassword(st);
                indexValue = indexValueTempA;
                MAINModel.setCurrentUserLoggedIn(currentUser);
                MGUIView.setTargetIntake(MAINModel.getTargetIntake());
                MGUIView.setBMI(MAINModel.getBMI());
                MGUIView.setWaterIntake(MAINModel.getWaterIntake());
                
            }
            else {MGUIView.JMessage("Age Field Must be Positive Number");}
        }
        else if (vev.getSource() == Height) {
            String newHeightCurrentUser;
            newHeightCurrentUser = MGUIView.JInput("Change Height (CM):\n(" + currentUser.getHeight() + ")");
            if (checkNumber(newHeightCurrentUser) == true && newHeightCurrentUser.length() > 0) {
                double newHeightCurrentUserDouble = Double.parseDouble(newHeightCurrentUser);
                MAINModel.loadPeople();
                int indexValueTempH = MAINModel.getUserLength() - 1;
                MAINModel.deleteFileContents();
                MAINModel.removeUserArray(indexValue);
                currentUser.setHeight(newHeightCurrentUserDouble);
                String st = currentUser.getPassword();
                MAINModel.addUser(currentUser);
                currentUser.setPassword(st);
                indexValue = indexValueTempH;
                MAINModel.setCurrentUserLoggedIn(currentUser);
                MGUIView.setTargetIntake(MAINModel.getTargetIntake());
                MGUIView.setBMI(MAINModel.getBMI());
                MGUIView.setWaterIntake(MAINModel.getWaterIntake());
            }
            else {MGUIView.JMessage("Height Field Must be Positive Number");}
        }
        else if (vev.getSource() == Weight) {
            String newWeightCurrentUser;
            newWeightCurrentUser = MGUIView.JInput("Change Weight (KG):\n(" + currentUser.getWeight() + ")");
            if (checkNumber(newWeightCurrentUser) == true && newWeightCurrentUser.length() > 0) {
                double newWeightCurrentUserDouble = Double.parseDouble(newWeightCurrentUser);
                MAINModel.loadPeople();
                int indexValueTempW = MAINModel.getUserLength() - 1;
                MAINModel.deleteFileContents();
                MAINModel.removeUserArray(indexValue);
                currentUser.setWeight(newWeightCurrentUserDouble);
                String st = currentUser.getPassword();
                MAINModel.addUser(currentUser);
                currentUser.setPassword(st);
                indexValue = indexValueTempW;
                MAINModel.setCurrentUserLoggedIn(currentUser);
                MGUIView.setTargetIntake(MAINModel.getTargetIntake());
                MGUIView.setBMI(MAINModel.getBMI());
                MGUIView.setWaterIntake(MAINModel.getWaterIntake());
                MGUIView.setTotalExcersize(MAINModel.findCaloriesBurned(currentUser.getWeight()) + " kCal");
                MGUIView.setTotalIntake(MAINModel.setTotalEverything(currentUser.getWeight()) + " kCal");
            }
            else {MGUIView.JMessage("Weight Field Must be Positive Number");}
        }
        else if (vev.getSource() == Breakfast) {
            String breakfastCalories = MGUIView.JInput("Breakfast Calorie Intake (kCal):");
            if (checkNumber(breakfastCalories) == true) {
                double numBreakfastCalories = Double.parseDouble(breakfastCalories);
                MAINModel.setBreakfastValue(numBreakfastCalories);
                MGUIView.setBreakfast(breakfastCalories + " kCal");
                MGUIView.setTotalCaloricIntake(MAINModel.findCalories() + " kCal");
                MGUIView.setTotalIntake(MAINModel.setTotalEverything(currentUser.getWeight()) + " kCal");
            }
            else {MGUIView.JMessage("Must be Positive Number");}
        }
        else if (vev.getSource() == Lunch) {
            String lunchCalories = MGUIView.JInput("Lunch Calorie Intake (kCal):");
            if (checkNumber(lunchCalories) == true) {
                double numLunchCalories = Double.parseDouble(lunchCalories);
                MAINModel.setLunchValue(numLunchCalories);
                MGUIView.setLunch(lunchCalories + " kCal");
                MGUIView.setTotalCaloricIntake(MAINModel.findCalories() + " kCal");
                MGUIView.setTotalIntake(MAINModel.setTotalEverything(currentUser.getWeight()) + " kCal");
            }
            else {MGUIView.JMessage("Must be Positive Number");}
        }
        else if (vev.getSource() == Dinner) {
            String dinnerCalories = MGUIView.JInput("Dinner Calorie Intake (kCal):");
            if (checkNumber(dinnerCalories) == true) {
                double numDinnerCalories = Double.parseDouble(dinnerCalories);
                MAINModel.setDinnerValue(numDinnerCalories);
                MGUIView.setDinner(dinnerCalories + " kCal");
                MGUIView.setTotalCaloricIntake(MAINModel.findCalories() + " kCal");
                MGUIView.setTotalIntake(MAINModel.setTotalEverything(currentUser.getWeight()) + " kCal");
            }
            else {MGUIView.JMessage("Must be Positive Number");}
        }
        else if (vev.getSource() == Light) {
            String lightDuration = MGUIView.JInput("Light Activity Duration (Min):");
            if (checkNumber(lightDuration) == true) {
                double numLightDuration = Double.parseDouble(lightDuration);
                MAINModel.setLightValue(numLightDuration);
                MGUIView.setLight(lightDuration + " Min");
                MGUIView.setTotalExcersize(MAINModel.findCaloriesBurned(currentUser.getWeight()) + " kCal");
                MGUIView.setTotalIntake(MAINModel.setTotalEverything(currentUser.getWeight()) + " kCal");
            }
            else {MGUIView.JMessage("Must be Positive Number");}
        }
        else if (vev.getSource() == Moderate) {
            String moderateDuration = MGUIView.JInput("Moderate Activity Duration (Min):");
            if (checkNumber(moderateDuration) == true) {
                double numModerateDuration = Double.parseDouble(moderateDuration);
                MAINModel.setModerateValue(numModerateDuration);
                MGUIView.setModerate(moderateDuration + " Min");
                MGUIView.setTotalExcersize(MAINModel.findCaloriesBurned(currentUser.getWeight()) + " kCal");
                MGUIView.setTotalIntake(MAINModel.setTotalEverything(currentUser.getWeight()) + " kCal");
            }
            else {MGUIView.JMessage("Must be Positive Number");}
        }
        else if (vev.getSource() == Intense) {
            String intenseDuration = MGUIView.JInput("Light Activity Duration (Min):");
            if (checkNumber(intenseDuration) == true) {
                double numIntenseDuration = Double.parseDouble(intenseDuration);
                MAINModel.setIntenseValue(numIntenseDuration);
                MGUIView.setIntense(intenseDuration + " Min");
                MGUIView.setTotalExcersize(MAINModel.findCaloriesBurned(currentUser.getWeight()) + " kCal");
                MGUIView.setTotalIntake(MAINModel.setTotalEverything(currentUser.getWeight()) + " kCal");
            }
            else {MGUIView.JMessage("Must be Positive Number");}
        }
    }
    
    public boolean checkPassword(String password) {
        boolean temp = true;
        for (int x = 0; x < password.length(); x++) {
            if (Character.isDigit(password.charAt(x)) || Character.isLetter(password.charAt(x))) {
                temp = temp && true;
            }
            else {temp = false;}
        }
        return temp;
    }
    
    public boolean checkNumber(String num) {
        try {
            double d = Double.parseDouble(num);
            if (d > 0) {return true;}
        }
        catch (NumberFormatException nfe) {return false;}
        return false;
    }
    
    public boolean checkGender(String gen) {
        if (gen.equals("M") || gen.equals("F") || gen.equals("m") || gen.equals("f")) {return true;}
        else {return false;}
    }
}