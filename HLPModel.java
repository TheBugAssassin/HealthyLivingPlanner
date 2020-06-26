package HealthyLivingPlanner;

import java.util.ArrayList;
import java.io.*;
import static java.lang.String.valueOf;

public class HLPModel {
    private ArrayList<User> user = new ArrayList<User>();
    private User currentUserLoggedIn;
    private String targetIntake;
    private String BMI;
    private String waterIntake;
    private double Breakfast;
    private double Lunch;
    private double Dinner;
    private double Light;
    private double Moderate;
    private double Intense;
    public HLPModel()
    {
        currentUserLoggedIn = new User();
        targetIntake = "";
        BMI = "";
        waterIntake = "";
        Breakfast = 0;
        Lunch = 0;
        Dinner = 0;
        Light = 0;
        Moderate = 0;
        Intense = 0 ;
    }
    
    public void setCurrentUserLoggedIn(User newUserLoggedIn) {
        currentUserLoggedIn = newUserLoggedIn;
        setWaterBMITargetIntake();
    }
    
    public ArrayList<User> getCurrentUser() {
        return user;
    }
    
    public String getTargetIntake() {
        return targetIntake;
    }
    
    public String getBMI() {
        return BMI;
    }
    
    public String getWaterIntake() {
        return waterIntake;
    }
    
    public void setWaterBMITargetIntake() {
        if (currentUserLoggedIn.getGender() == 'M' || currentUserLoggedIn.getGender() == 'm') {
            double round2 = Math.round(currentUserLoggedIn.getWeight() / (Math.pow(currentUserLoggedIn.getHeight() / 100, 2)) * 100);
            BMI = valueOf(round2 / 100);
            double tar = Math.round((1 / (round2 / 100) * 50000) * 100);
            tar = tar / 100;
            if (tar < 1200) {targetIntake = "1200 kCal";}
            else {
                targetIntake = valueOf(tar  + " kCal");
            }
            if (currentUserLoggedIn.getAge() < 30) { 
                round2 = Math.round(currentUserLoggedIn.getWeight() * 40 / 28.3 * 0.0295735 * 100);
            }
            else if (currentUserLoggedIn.getAge() >= 30 && currentUserLoggedIn.getAge() <= 55) {
                round2 = Math.round(currentUserLoggedIn.getWeight() * 35 / 28.3 * 0.0295735 * 100);
            }
            else {
                round2 = Math.round(currentUserLoggedIn.getWeight() * 30 / 28.3 * 0.0295735 * 100);
            }
            waterIntake = valueOf(round2 / 100) + " L";
            
        }
        else if (currentUserLoggedIn.getGender() == 'F' || currentUserLoggedIn.getGender() == 'f') {
            double round2 = Math.round(currentUserLoggedIn.getWeight() / (Math.pow(currentUserLoggedIn.getHeight() / 100, 2)) * 100);
            BMI = valueOf(round2 / 100);
            double tar = Math.round((1 / (round2 / 100) * 50000 * 0.8) * 100);
            tar = tar / 100;
            if (tar < 1200) {targetIntake = "1200 kCal";}
            else {
                targetIntake = valueOf(tar + " kCal");
            }
            if (currentUserLoggedIn.getAge() < 30) { 
                round2 = Math.round(currentUserLoggedIn.getWeight() * 40 / 28.3 * 0.0295735 * 100);
            }
            else if (currentUserLoggedIn.getAge() >= 30 && currentUserLoggedIn.getAge() <= 55) {
                round2 = Math.round(currentUserLoggedIn.getWeight() * 35 / 28.3 * 0.0295735 * 100);
            }
            else {
                round2 = Math.round(currentUserLoggedIn.getWeight() * 30 / 28.3 * 0.0295735 * 100);
            }
            waterIntake = valueOf(round2 / 100) + " L";
        }
    }
    
    public int getUserLength() {
        return user.size();
    }
    
    public void addUser(User addU)
    {
        user.add(addU); storePeople();
    }
    
    public void removeUserArray(int i) {
        user.remove(i);
    }
    
    public void deleteFileContents() {
        try {
            PrintWriter writer = new PrintWriter("User.txt");
            writer.print("");
            writer.close();
        }
        catch (FileNotFoundException e) {}
    }

    public void storePeople (){
        FileWriter fw = null;
        PrintWriter pw = null;

        String txtFile = "User.txt";
        String outputPerson = "";
        try{
            fw = new FileWriter(txtFile, true);
            pw = new PrintWriter(fw);
            for(int i = 0; i < user.size(); i++){
                String pas = user.get(i).getPassword();
                user.get(i).setPassword(encrypt(14, pas));
                outputPerson = user.get(i).toString();
                pw.println(outputPerson);
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.clear();
    }

    public void loadPeople() {
        String convertName = "";
        String convertPassword = "";
        double convertAge = 0;
        char convertGender;
        double convertHeight = 0;
        double convertWeight = 0;

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String[] stringUser;

        try {br = new BufferedReader(new FileReader("User.txt"));
            while ((line = br.readLine()) != null) {

                // Vital method
                stringUser = line.split(cvsSplitBy);

                convertName = stringUser[0];
                convertPassword = decrypt(14, stringUser[1]);
                convertAge = Double.parseDouble(stringUser[2]);
                convertGender = stringUser[3].charAt(0);
                convertHeight = Double.parseDouble(stringUser[4]);
                convertWeight = Double.parseDouble(stringUser[5]);
                User us = new User(convertName, convertPassword, convertAge, convertGender, convertHeight, convertWeight);
                user.add(us);
            }
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        } finally {
        if (br != null) {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        }
    }
    
    public int searchUserExists(String nm, String ps) {
        loadPeople();
        int k;
        for(k = 0; k < user.size(); k++){
            if(user.get(k).getName().equals(nm) && user.get(k).getPassword().equals(ps)) {
                return k;
            }
        }
        return -1;
    }
    
    public boolean searchNameExists(String nam) {
        int p;
        for(p = 0; p < user.size(); p++){
            if(user.get(p).getName().equals(nam)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean searchPasswordExists(String pa) {
        int j;
        for(j = 0; j < user.size(); j++){
            if(user.get(j).getPassword().equals(pa)) {
                return true;
            }
        }
        return false;
    }
    
    public User getUser(int arrayNumber) {
        return user.get(arrayNumber);
    }
    
    public void clearArray() {
        user.clear();
    }
    
    public double getBreakfastValue() {
        return Breakfast;
    }
    
    public double getLunchValue() {
        return Lunch;
    }
    
    public double getDinnerValue() {
        return Dinner;
    }

    public double getLightValue() {
        return Light;
    }
    
    public double getModerateValue() {
        return Moderate;
    }
    
    public double getIntenseValue() {
        return Intense;
    }
    
    public void setBreakfastValue(double breakfast) {
        Breakfast = breakfast;
    }
    
    public void setLunchValue(double lunch) {
        Lunch = lunch;
    }
    
    public void setDinnerValue(double dinner) {
        Dinner = dinner;
    }

    public void setLightValue(double light) {
        Light = light;
    }
    
    public void setModerateValue(double moderate) {
        Moderate = moderate;
    }
    
    public void setIntenseValue(double intense) {
        Intense = intense;
    }
    
    public void clearAll() {
        Breakfast = 0;
        Lunch = 0;
        Dinner = 0;
        Light = 0;
        Moderate = 0;
        Intense = 0 ;
    }
    
    public double findCalories() {
        return Breakfast + Lunch + Dinner;
    }
    
    public double findCaloriesBurned(double weigh) {
        return Math.round(((Light / 60) * 5 * weigh) + ((Moderate / 60) * 10 * weigh) + ((Intense / 60) * 15 * weigh));
    }
    
    public double setTotalEverything(double we) {
        return findCalories() - findCaloriesBurned(we);
    }
    
    public static String encrypt(int num, String word) {
           char let[]={'H','F','B','Z','E','C','G','A','J','I','O','L','Y','U','K','T','Q','X','S','P','N','V','W','R','M','D'};   
           char lowlet[]={'o','z','c','d','g','f','e','v','n','j','t','y','x','i','a','s','p','r','q','k','u','h','w','m','l','b'};
           char numb[] = {'2','8','0','5','3','7','9','6','1','4'};
           String thingFinal = "";
           for (int f = 0; f < word.length(); f++) {
              char chah = word.charAt(f);
              int i = 0;
              char lowchar;
              int ad = 0;
              if (Character.isDigit(chah) == true) {
                  do{lowchar = numb[i]; i = i + 1;} while (lowchar != chah);
                  ad = i + num;
                  while (ad > 10) {ad = ad - 10;}
                  thingFinal = thingFinal + (numb[ad - 1]);
              }
              if (Character.isLowerCase(chah) == true) {
                  do{lowchar = lowlet[i]; i = i + 1;} while (lowchar != chah);
                  ad = i + num;
                  while (ad > 26) {ad = ad - 26;}
                  thingFinal = thingFinal + (lowlet[ad - 1]);
              }
              if (Character.isUpperCase(chah) == true) {
                  do{lowchar = let[i]; i = i + 1;} while (lowchar != chah);
                  ad = i + num;
                  while (ad > 26) {ad = ad - 26;}
                  thingFinal = thingFinal + (let[ad - 1]);
              }
           }
           return thingFinal;
        }
      
      public static String decrypt(int num, String word) {
           char let[]={'H','F','B','Z','E','C','G','A','J','I','O','L','Y','U','K','T','Q','X','S','P','N','V','W','R','M','D'};   
           char lowlet[]={'o','z','c','d','g','f','e','v','n','j','t','y','x','i','a','s','p','r','q','k','u','h','w','m','l','b'};
           char numb[] = {'2','8','0','5','3','7','9','6','1','4'};
           String thingFinalD = "";
           for (int f = 0; f < word.length(); f++) {
              char chah = word.charAt(f);
              int i = 0;
              char lowchar;
              int ad = 0;
              if (Character.isDigit(chah) == true) {
                  do{lowchar = numb[i]; i = i + 1;} while (lowchar != chah);
                  ad = i - num;
                  while (ad <= 0) {ad = ad + 10;}
                  thingFinalD = thingFinalD + (numb[ad - 1]);
              }
              if (Character.isLowerCase(chah) == true) {
                  do{lowchar = lowlet[i]; i = i + 1;} while (lowchar != chah);
                  ad = i - num;
                  while (ad <= 0) {ad = ad + 26;}
                  thingFinalD = thingFinalD + (lowlet[ad - 1]);
              }
              if (Character.isUpperCase(chah) == true) {
                  do{lowchar = let[i]; i = i + 1;} while (lowchar != chah);
                  ad = i - num;
                  while (ad <= 0) {ad = ad + 26;}
                  thingFinalD = thingFinalD + (let[ad - 1]);
              }
           }
           return thingFinalD;
        }
}